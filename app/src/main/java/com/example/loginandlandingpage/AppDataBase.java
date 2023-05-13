package com.example.loginandlandingpage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.sql.Array;
import java.util.List;

@Database(entities = {User.class},version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public static final String DATABASE_NAME = "User.db";
    public static final String USER_TABLE = "user_table";

    private static volatile AppDataBase instance;
    private static final Object LOCK = new Object();

    public void predefinedUsers(){
        if(instance.UserDAO().getUsers().size()==0){
            UserDAO().insert(new User("testuser1", "testuser1", false));
            UserDAO().insert(new User("admin2","admin2",true));
        }
    }

    public abstract UserDAO UserDAO();

    public static AppDataBase getInstance(Context context){
        if(instance==null){
            synchronized(LOCK){
                if(instance==null){
                    instance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class,DATABASE_NAME).allowMainThreadQueries().build();
                }
            }
        }
        return instance;
    }
}
