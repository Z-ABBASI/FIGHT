package com.example.loginandlandingpage;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert
    void insert(User... Users);

    @Update
    void update(User... Users);

    @Delete
    void delete(User Users);

    @Query("SELECT * FROM " + AppDataBase.USER_TABLE + " WHERE username = :username")
    User getUserByUsername(String username);

    @Query("SELECT * FROM " + AppDataBase.USER_TABLE + " WHERE UserID = :UserID")
    User getUserByID(int UserID);

    @Query("SELECT * FROM " + AppDataBase.USER_TABLE)
    List<User> getUsers();

    @Query("SELECT * FROM " + AppDataBase.USER_TABLE + " WHERE username like :username AND password like :password")
    User getUserByLogin(String username, String password);
}
