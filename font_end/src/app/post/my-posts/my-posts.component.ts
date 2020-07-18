import {Component, OnInit} from '@angular/core';
import {BasicService} from '../../profile/basic/basic.service';
import {PostServiceService} from '../post-service.service';
import {Post} from '../post.model';
import {PostSearch} from '../post-search.model';

@Component({
  selector: 'app-my-posts',
  templateUrl: './my-posts.component.html',
  styleUrls: ['./my-posts.component.scss']
})
export class MyPostsComponent implements OnInit {

  bloods = new Array();
  blood_Group: string;
  quantity: string;
  bloodNeedDate: string;
  patientGender: string;
  relationWithPatient: string;
  hospitalName: string;
  hospitalAddress: string;
  donationLocation: string;
  contactInfo: string;
  patientDescription: string;
  patientRemarks: string;
  anyNotes: string;

  constructor(private basicService: BasicService, private postService: PostServiceService) {
  }

  ngOnInit() {
    window.dispatchEvent(new Event('resize'));
    document.body.className = 'hold-transition skin-blue sidebar-mini';

    this.getAllPostsByAnUser();
    this.bloods = this.basicService.getBloodGroup();
    console.log(this.bloods);
  }

  public save() {
    this.postService.save(this.getPost()).subscribe((res: Response) => {
      console.log(res);
    });
  }

  public getAllPostsByAnUser() {
    var postSearch = new PostSearch();
    postSearch.dateType = 'demoData';
    postSearch.startDate = 'demoData';
    postSearch.endDate = 'demoData';
    postSearch.start = '1';
    postSearch.max = '10';
    postSearch.key = '\'%%\'';
    postSearch.column = 'location';
    postSearch.userID = '14294';
    postSearch.orderBy = 'location';
    postSearch.orderType = 'ASC';
    this.postService.getAllPostsByAnUser(postSearch).subscribe((res: Response) => {
      console.log(res);
    });
  }


  public getPost() {
    var p = new Post();
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

}
