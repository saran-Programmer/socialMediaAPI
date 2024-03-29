package com.InstagramApi.InstagramAPI.Repositories;

import com.InstagramApi.InstagramAPI.Models.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostModel, Long> {
    PostModel getPostById(long id);
    List<PostModel> getPostByUserName(String userName);
}
