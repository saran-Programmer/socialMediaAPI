package com.InstagramApi.InstagramAPI.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
public class PostModel {
    @Id
    @GeneratedValue
    @Getter @Setter
    private long id;
    @Getter @Setter
    private String Title;
    @Getter @Setter
    private String userName;
    @Getter @Setter
    private LocalDateTime PostedTime;
    @Getter @Setter
    private int numberOfLike;

    public PostModel(){}

    public PostModel(long id, String title, String userName, LocalDateTime postedTime) {
        this.id = id;
        Title = title;
        this.userName = userName;
        PostedTime = postedTime;
    }

    @Override
    public String toString() {
        return "PostModel{" +
                "id=" + id +
                ", Title='" + Title + '\'' +
                ", userName='" + userName + '\'' +
                ", PostedTime=" + PostedTime +
                '}';
    }
}
