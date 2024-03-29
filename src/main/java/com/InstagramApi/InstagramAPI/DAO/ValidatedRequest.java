package com.InstagramApi.InstagramAPI.DAO;

import com.InstagramApi.InstagramAPI.Models.PostModel;
import com.InstagramApi.InstagramAPI.Models.UserModel;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ValidatedRequest {
    private boolean isValidNameUserName(String userName){
        userName = userName.replaceAll(" ", "");
        int length = userName.length();
        return !userName.equals("") && userName.length() <= 20;
    }

    private boolean isValidName(String name){
        name = name.replaceAll(" ", "");
        return !name.equals("") && name.length() <= 10;
    }

    private boolean isValidDate(LocalDateTime localDateTime){
        return localDateTime.isEqual(LocalDateTime.now());
    }

    public boolean isValidUserRequest(UserModel userModel){
        return this.isValidDate(userModel.getAccountCreatedTime())
                && this.isValidNameUserName(userModel.getUserName())
                && this.isValidName(userModel.getFirstName())
                && this.isValidName(userModel.getLastName());
    }

    // Post Validation

    private boolean isValidTitle(String title){
        title = title.replaceAll(" ", "");
        return !title.equals("") && title.length() <= 50;
    }

    public boolean isValidPost(PostModel postModel){
        return isValidTitle(postModel.getTitle()) && isValidDate(postModel.getPostedTime());
    }

    //Comment Validation
    private boolean isValidComment(String comment){
        comment = comment.replaceAll(" ", "");
        return !comment.equals("") && comment.length() <= 100;
    }
}
