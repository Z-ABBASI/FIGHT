package com.example.loginandlandingpage;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface VillainDAO {
    @Insert
    void insert(Villain... Villains);

    @Update
    void update(Villain... Villains);

    @Query("SELECT * FROM " + VillainsDataBase.VILLAIN_TABLE)
    List<Villain> getVillains();
}
