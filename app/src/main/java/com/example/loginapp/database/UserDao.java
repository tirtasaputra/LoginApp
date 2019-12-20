package com.example.loginapp.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    LiveData<List<User>> loadAllUser();


    @Query("SELECT * FROM user")
    List<User> loadAlls();

    @Insert
    void insertUser(User user);

    @Delete
    void deleteUser(User user);

    @Query("SELECT * FROM User where userUsername = :username and userPassword = :password")
    User getUser(String username, String password);

}
