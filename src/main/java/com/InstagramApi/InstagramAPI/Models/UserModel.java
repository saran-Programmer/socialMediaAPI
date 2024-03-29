package com.InstagramApi.InstagramAPI.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class UserModel {
    @Id
    @GeneratedValue
    @Getter @Setter
    private long id;
    @Getter @Setter
    private String userName;
    @Getter @Setter
    private Boolean isPrivate = false;
    @Getter @Setter
    private String firstName;
    @Getter @Setter
    private String lastName;

    @Getter @Setter
    private LocalDateTime accountCreatedTime;

    public UserModel(){}

    public UserModel(long id, String userName, Boolean isPrivate, String firstName, String lastName, LocalDateTime time) {
        this.userName = userName;
        this.isPrivate = isPrivate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountCreatedTime = time;
    }


    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", isPrivate=" + isPrivate +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accountCreatedTime"+accountCreatedTime+
                '}';
    }
}
