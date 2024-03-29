package com.InstagramApi.InstagramAPI.DAO;

import com.InstagramApi.InstagramAPI.Models.PostModel;
import com.InstagramApi.InstagramAPI.Models.PostRequestModelUserName;
import com.InstagramApi.InstagramAPI.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostDAO {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ValidatedRequest validatedRequest;

    public boolean addPost(PostModel postModel) {
        postModel.setPostedTime(LocalDateTime.now());
        boolean isValidPost = validatedRequest.isValidPost(postModel);
        if(!isValidPost){
            return false;
        }
        postRepository.save(postModel);
        return true;
    }

    public PostModel getPostById(Long id){
        return postRepository.getPostById(id);
    }

    public List<PostModel> getPostByUserName(PostRequestModelUserName postRequestModelUserName) {
        return postRepository.getPostByUserName(postRequestModelUserName.getUserName());
    }

    public void addLikeToPost(PostModel post) {
        int currentLikes = post.getNumberOfLike();
        post.setNumberOfLike(++currentLikes);
        postRepository.save(post);
    }

    public void removeLikeFromPost(PostModel post) {
        int currentLikes = post.getNumberOfLike();
        if(currentLikes == 0){
            return;
        }
        post.setNumberOfLike(++currentLikes);
        postRepository.save(post);
    }
}
