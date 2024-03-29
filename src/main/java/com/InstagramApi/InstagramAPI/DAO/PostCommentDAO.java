package com.InstagramApi.InstagramAPI.DAO;

import com.InstagramApi.InstagramAPI.Models.PostCommentModel;
import com.InstagramApi.InstagramAPI.Models.PostCommentRequestModel;
import com.InstagramApi.InstagramAPI.Repositories.PostCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostCommentDAO {

    @Autowired
    private PostCommentRepository postCommentRepository;

    public void commentPost(PostCommentModel postCommentModel) {
        postCommentRepository.save(postCommentModel);
    }

    public List<PostCommentModel> getAllComment(PostCommentRequestModel postCommentRequestModel) {
        return postCommentRepository.getCommentById(postCommentRequestModel.getPostId());
    }
}
