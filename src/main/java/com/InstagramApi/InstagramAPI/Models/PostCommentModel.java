package com.InstagramApi.InstagramAPI.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
public class PostCommentModel {
    @Id
    @GeneratedValue
    @Getter @Setter
    private long Id;
    @Getter @Setter
    private String message;
    @Getter @Setter
    private long postId;
    @Getter @Setter
    private int numberOfLikes;
    @Getter @Setter
    private LocalDateTime timeStamp = LocalDateTime.now();

    public PostCommentModel(){}

    public PostCommentModel(String message, long postId, int numberOfLikes) {
        this.message = message;
        this.postId = postId;
        this.numberOfLikes = numberOfLikes;
    }
}
