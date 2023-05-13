package com.example.loginandlandingpage;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.ArrayList;

@Database(entities = {Hero.class},version = 1)
public abstract class HeroesDataBase extends RoomDatabase {
    public static final String DATABASE_NAME = "Hero.db";
    public static final String HERO_TABLE = "hero_table";

    private static volatile HeroesDataBase instance;
    private static final Object LOCK = new Object();

    public void predefinedHeroes(){
        if(instance.HeroDAO().getHeroes().size()==0){
            HeroDAO().insert(new Hero("Dragon","Fire Breathing","Fire",100));
            HeroDAO().insert(new Hero("Wizard","Magic","Magic",100));
            HeroDAO().insert(new Hero("Warrior","Sword Fighting","Metal",100));
            HeroDAO().insert(new Hero("Clown","Chainsaw","Metal",100));
            HeroDAO().insert(new Hero("Mad Scientist","Science","Science",100));

        }
    }

    public abstract HeroDAO HeroDAO();

    public static HeroesDataBase getInstance(Context context){
        if(instance==null){
            synchronized(LOCK){
                if(instance==null){
                    instance = Room.databaseBuilder(context.getApplicationContext(), HeroesDataBase.class,DATABASE_NAME).allowMainThreadQueries().build();
                }
            }
        }
        return instance;
    }
}
