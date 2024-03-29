package com.InstagramApi.InstagramAPI.DAO;

import com.InstagramApi.InstagramAPI.Models.UserModel;
import com.InstagramApi.InstagramAPI.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserDAO {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ValidatedRequest validatedRequest;

    public UserModel getUserByUserName(String userName) {
        return userRepository.getUserByUserName(userName);
    }

    public boolean createUserAccount(UserModel userModel) {
        userModel.setAccountCreatedTime(LocalDateTime.now());
        boolean isValidRequest = validatedRequest.isValidUserRequest(userModel);
        if(!isValidRequest){
            return false;
        }
        userRepository.save(userModel);
        return true;
    }

    public void deleteUserAccount(UserModel user) {
        userRepository.delete(user);
    }

    public void updateUserAccount(UserModel user, UserModel userModel) {
        userModel.setId(user.getId());
        userModel.setAccountCreatedTime(user.getAccountCreatedTime());
        boolean isValidRequest = validatedRequest.isValidUserRequest(userModel);
        userRepository.save(userModel);
    }
}
