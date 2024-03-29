package com.InstagramApi.InstagramAPI.Controller;

import com.InstagramApi.InstagramAPI.DAO.PostCommentDAO;
import com.InstagramApi.InstagramAPI.DAO.PostDAO;
import com.InstagramApi.InstagramAPI.DAO.UserDAO;
import com.InstagramApi.InstagramAPI.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppMainController {

    // DAO Initialization
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PostDAO postDAO;

    @Autowired
    private PostCommentDAO postCommentDAO;

    //API Account EndPoints

    // To get a User`s account using userName
    @GetMapping(value = "/account")
    public ResponseEntity<ResponseModel> getUser(@PathVariable String userName){
        UserModel user = userDAO.getUserByUserName(userName);
        if(user == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel("User Not Found", HttpStatus.NOT_FOUND));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel(user.toString(), HttpStatus.OK));
    }

    // To Create a new user account
    @PostMapping(value = "/account")
    public ResponseEntity<ResponseModel> createUser(@RequestBody UserModel userModel){
        UserModel user = userDAO.getUserByUserName(userModel.getUserName());
        if(user != null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseModel("UserName not available", HttpStatus.CONFLICT));
        }
        boolean isCreated = userDAO.createUserAccount(userModel);
        if(!isCreated){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseModel("Provide a valid Request", HttpStatus.BAD_REQUEST));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseModel("Account Created", HttpStatus.CREATED));
    }

    // To Update Existing account
    @PatchMapping(value = "/account")
    public ResponseEntity<ResponseModel> updateUser(@RequestBody UserModel userModel){
        UserModel user = userDAO.getUserByUserName(userModel.getUserName());
        if(user == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel("User Not Found", HttpStatus.NOT_FOUND));
        }
        userDAO.updateUserAccount(user, userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseModel("Account Updated", HttpStatus.OK));
    }

    // To delete user account
    @DeleteMapping(value = "/account")
    public ResponseEntity<ResponseModel> deleteUser(@PathVariable String userName){
        UserModel user = userDAO.getUserByUserName(userName);
        if(user == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel("User Not Found", HttpStatus.NOT_FOUND));
        }
        userDAO.deleteUserAccount(user);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel("Deleted Successfully", HttpStatus.OK));

    }

    // Post API End Points

    //Get Post By UserName
    @GetMapping(value = "/post")
    public ResponseEntity<ResponseModel> getPost(@RequestBody PostRequestModelUserName postRequestModelUserName){
        UserModel user = userDAO.getUserByUserName(postRequestModelUserName.getUserName());
        if(user == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel("User Not Found", HttpStatus.NOT_FOUND));
        }
        List<PostModel> userPost = postDAO.getPostByUserName(postRequestModelUserName);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel(userPost.toString(), HttpStatus.OK));
    }

    //Get Post By id
    @GetMapping(value = "/post/{id}")
    public ResponseEntity<ResponseModel> getPostById(@PathVariable long id){
        PostModel post = postDAO.getPostById(id);
        if(post == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel("Post Not Found", HttpStatus.NOT_FOUND));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel(post.toString(), HttpStatus.OK));
    }


    // To Add Post For a User`s Account
    @PostMapping(value = "/post")
    public ResponseEntity<ResponseModel> addPost(@RequestBody PostModel postModel){
        boolean isPosted = postDAO.addPost(postModel);
        if(!isPosted){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseModel("Provide a valid request", HttpStatus.BAD_REQUEST));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel("Post add successfully", HttpStatus.OK));
    }

    // Like a Post
    @PostMapping(value = "/post/like")
    public ResponseEntity<ResponseModel> addLike(@RequestBody PostLikeRequestModel postLikeRequestModel){
        PostModel post = postDAO.getPostById(postLikeRequestModel.getId());
        if(post == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel("Post Not Found", HttpStatus.NOT_FOUND));
        }
        postDAO.addLikeToPost(post);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel("Liked Post Successfully", HttpStatus.OK));
    }

    // Unlike a post
    @DeleteMapping(value = "/post/like")
    public ResponseEntity<ResponseModel> removeLike(@RequestBody PostLikeRequestModel postLikeRequestModel) {
            PostModel post = postDAO.getPostById(postLikeRequestModel.getId());
            if (post == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel("Post Not Found", HttpStatus.NOT_FOUND));
            }
            postDAO.removeLikeFromPost(post);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel("Liked Post Successfully", HttpStatus.OK));
    }
    // Post Comment Section
    @GetMapping(value = "post/comment")
    public ResponseEntity getComment(@RequestBody PostCommentRequestModel postCommentRequestModel){
        PostModel post = postDAO.getPostById(postCommentRequestModel.getPostId());
        if(post == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel("Post Not Found", HttpStatus.NOT_FOUND));
        }
        List<PostCommentModel> comments = postCommentDAO.getAllComment(postCommentRequestModel);
        return ResponseEntity.status(HttpStatus.OK).body(comments);

    }

    @PostMapping(value = "/post/comment")
    public ResponseEntity<ResponseModel> addComment(@RequestBody PostCommentModel postCommentModel){
        PostModel post = postDAO.getPostById(postCommentModel.getPostId());
        if(post == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel("Post Not Found", HttpStatus.NOT_FOUND));
        }
        postCommentDAO.commentPost(postCommentModel);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel("Commented Post", HttpStatus.OK));
    }

}
