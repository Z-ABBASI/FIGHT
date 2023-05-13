package com.example.loginandlandingpage;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.ArrayList;

@Database(entities = {Villain.class},version = 1)
public abstract class VillainsDataBase extends RoomDatabase {
    public static final String DATABASE_NAME = "Villain.db";
    public static final String VILLAIN_TABLE = "villain_table";

    private static volatile VillainsDataBase instance;
    private static final Object LOCK = new Object();

    public void predefinedVillains(){
        if(instance.VillainDAO().getVillains().size()==0){
            VillainDAO().insert(new Villain("Warrior","Sword","Ice",100));
            VillainDAO().insert(new Villain("Unicorn","Magic","Magic",100));
            VillainDAO().insert(new Villain("Demon","Fire","Fire",100));
        }
    }

    public abstract VillainDAO VillainDAO();

    public static VillainsDataBase getInstance(Context context){
        if(instance==null){
            synchronized(LOCK){
                if(instance==null){
                    instance = Room.databaseBuilder(context.getApplicationContext(), VillainsDataBase.class,DATABASE_NAME).allowMainThreadQueries().build();
                }
            }
        }
        return instance;
    }
}
