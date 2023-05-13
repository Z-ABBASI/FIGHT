package com.example.loginandlandingpage;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface HeroDAO {
    @Insert
    void insert(Hero... Heroes);

    @Update
    void update(Hero... Heroes);

    @Query("SELECT * FROM " + HeroesDataBase.HERO_TABLE)
    List<Hero> getHeroes();
}
