package com.example.loginapp.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "user")
public class User implements Serializable {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int userId;
    private String userFullName;
    private String userNickName;
    private String userUsername;
    private String userPassword;

    public User(String userFullName, String userNickName, String userUsername, String userPassword){
        this.setUserFullName(userFullName);
        this.setUserNickName(userNickName);
        this.setUserUsername(userUsername);
        this.setUserPassword(userPassword);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", fullname='" + userFullName + '\'' +
                ", nickname='" + userNickName + '\'' +
                ", username='" + userUsername + '\'' +
                ", password='" + userPassword + '\'' +
                '}';
    }

}
