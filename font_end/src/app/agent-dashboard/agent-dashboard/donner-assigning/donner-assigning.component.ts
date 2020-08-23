import {Component, OnInit} from '@angular/core';
import {RequestSearchDonnerAssing} from '../model/request-search-donner-assign.model';
import {DonnerAssingShow} from '../model/donner-assing-show.model';
import {DonnerAssignService} from './donner-assign.service';
import {throttleTime} from 'rxjs/operators';
import {Post} from '../../../post/post.model';
import {PostServiceService} from '../../../post/post-service.service';
import {BasicService} from '../../../profile/basic/basic.service';

@Component({
  selector: 'app-donner-assigning',
  templateUrl: './donner-assigning.component.html',
  styleUrls: ['./donner-assigning.component.scss']
})
export class DonnerAssigningComponent implements OnInit {

  searchKey: string;
  searchByColumn = 'name';
  total = 0;
  startAssigments = 0;
  perPage = 10;
  pageNumber = 0;
  statusType: string;
  assignmentStatus: string;

  deleteId: string;

  bloods = new Array();
  donnerAssingmentAll: Array<DonnerAssingShow>;
  startAssingments: number;


  quantity: string;
  anyNotes: string;
  contactInfo: string;
  blood_Group: string;
  hospitalName: string;
  bloodNeedDate: string;
  patientGender: string;
  patientRemarks: string;
  hospitalAddress: string;
  searchWithinDate: boolean;
  donationLocation: string;
  patientDescription: string;
  relationWithPatient: string;

  postIDSave: string;
  showPostCheck = false;

  constructor(private donnerAssignService: DonnerAssignService,
              private  postService: PostServiceService,
              private basicService: BasicService) {
  }

  ngOnInit() {
    this.searchKey = '';
    this.statusType = '0';
    this.assignmentStatus = '0';
    this.startAssingments = 0;
    this.getAssingments();
    this.bloods = this.basicService.getBloodGroup();
  }

  public getAssingments(): void {
    const donnerAssingSearch = new RequestSearchDonnerAssing();
    donnerAssingSearch.start = this.startAssigments;
    donnerAssingSearch.max = this.perPage;
    donnerAssingSearch.column = this.searchByColumn;
    donnerAssingSearch.key = '%' + this.searchKey + '%';
    donnerAssingSearch.statusType = this.assignmentStatus;
    this.donnerAssingmentAll = new Array<DonnerAssingShow>();

    console.log(donnerAssingSearch);

    this.donnerAssignService.getAssingments(donnerAssingSearch).subscribe(donnerAssignment => {
      this.donnerAssingmentAll = donnerAssignment;
      console.log(this.donnerAssingmentAll);
    });
  }

  deleteAssignment(): void {
    this.donnerAssignService.delete(this.deleteId).subscribe(res => {
      if (res.STATUS === 'OK') {
        this.getAssingments();
      }
    });
  }

  public getPost(): Post {
    var p = new Post();
    p.status = 'ACTIVE';
    p.bloodType = this.blood_Group;
    p.quantity = this.quantity;
    p.needDate = this.bloodNeedDate;
    p.patientGender = this.patientGender;
    p.relation = this.relationWithPatient;
    p.hospitalName = this.hospitalName;
    p.hospitalAddress = this.hospitalAddress;
    p.location = this.donationLocation;
    p.contactInfo = this.contactInfo;
    p.patientDescription = this.patientDescription;
    p.remarks = this.patientRemarks;
    p.notes = this.anyNotes;
    return p;
  }

  public save(): void {
    this.postService.save(this.getPost()).subscribe(res => {
      console.log(res);
      if (res['STATUS'] === 'OK') {
        console.log('OK STATUS!');
        this.postIDSave = res.ID;
        console.log('Post Save DonnerAssign : ' + this.postIDSave);
        this.pos
      }
    });
  }

}



