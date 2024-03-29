package com.InstagramApi.InstagramAPI.Repositories;

import com.InstagramApi.InstagramAPI.Models.PostCommentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostCommentRepository extends JpaRepository<PostCommentModel, Long> {
    List<PostCommentModel> getCommentById(Long postId);
}
