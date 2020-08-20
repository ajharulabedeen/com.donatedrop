import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {AuthService} from '../../auth/auth.service';
import {Post} from '../post.model';
import {PostDetailsService} from './post-details.service';
import {PostcommentWithUserInfo} from './postcomment-with-user-info.model';
import {CommentSave} from './comment-save.model';

@Component({
  selector: 'app-post-details',
  templateUrl: './post-details.component.html',
  styleUrls: ['./post-details.component.scss']
})
export class PostDetailsComponent implements OnInit {

  public postID: string;
  public needDate: string;
  public bloodType: string;
  public quantity: string;
  public patientGender: string;
  public relation: string;
  public hospitalName: string;
  public hospitalAddress: string;
  public location: string;
  public contactInfo: string;
  public patientDescription: string;

  postBasic: Post;
  postCommentWithUserInfo: Array<PostcommentWithUserInfo>;

  public postIdDetails: string;

  public commentContentSave: string;
  public postIDSave: string;

  constructor(private activeRoute: ActivatedRoute,
              private http: HttpClient,
              private authService: AuthService,
              private postDetailsService: PostDetailsService) {
  }

  ngOnInit() {
    this.postIdDetails = this.activeRoute.snapshot.params['post_id'];
    console.log('postID for Details: ' + this.postIdDetails);
    // this.getOneNews(this.id);
    this.findOnePostByIDNoComment();
    this.getCommentWithUserInfo();
  }

  public findOnePostByIDNoComment(): void {
    this.postDetailsService.findOnePostByIDNoComment(this.postIdDetails).subscribe(post => {
      this.postBasic = post;
      console.log(this.postBasic);
    });
  }

  getCommentWithUserInfo(): void {
    this.postDetailsService.getCommentWithUserInfo(this.postIdDetails).subscribe(postComments => {
      this.postCommentWithUserInfo = postComments;
      console.log(this.postCommentWithUserInfo);
    });
  }

  saveComment(): void {
    const commentSave = new CommentSave();
    commentSave.commentContent = this.commentContentSave;
    commentSave.postID = this.postBasic.postID;
    this.postDetailsService.saveComment(commentSave).subscribe(res => {
      if (res.STATUS === 'OK') {
        this.getCommentWithUserInfo();
      }
    });
  }

}
