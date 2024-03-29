package com.InstagramApi.InstagramAPI.Repositories;

import com.InstagramApi.InstagramAPI.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel getUserByUserName(String userName);
}
