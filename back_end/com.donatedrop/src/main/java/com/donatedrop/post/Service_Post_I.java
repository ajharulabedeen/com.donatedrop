package com.donatedrop.post;

import net.bytebuddy.implementation.bytecode.collection.ArrayAccess;

import javax.xml.stream.events.Comment;
import java.util.List;
import java.util.Map;

public interface Service_Post_I {
    public Map<String, String> savePost(Post post);

    public Map<String, String> updatePost(Post post);

    public Post findPostByUserIDNoComment(String userID, String postID);

    public Post findOnePostByID(String id);

    public Map<String, String> deletePost(String userID, String postID);

    public Post findPostWithComments(String postID);

    public Map<String, String> saveComment(PostComment postComment, String postID);

    public PostComment findOneComment(String postID, String userID, String commentID);

    public Map<String, String> updatePostComment(PostComment postComment, String postID);

    public Map<String, String> deletePostComment(String postID, PostComment postCommentOld);

    //-----Search and all posts by an user.
    public List<Post> getAllPostsByAnUser(PostSearch postSearch);

    public String countAllPostsByAnUser(PostSearch postSearch);

    public List<Post> getAllPostsByAnUserWithinDate(PostSearch postSearch);

    public String countAllPostsByAnUserWithinDate(PostSearch postSearch);

    public String countCommentsOfAPost(String postID);

    public List<CommentWithUserInfo> getCommentWithUserInfo(String postID);
}
