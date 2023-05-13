package com.example.loginandlandingpage;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = HeroesDataBase.HERO_TABLE)
public class Hero {
    @PrimaryKey(autoGenerate = true)
    private int HeroID;
    private String Name;
    private String Ability;
    private String Type;
    private int MaxHealth;
    private int Health;

    public Hero() {

    }

    public Hero(String name, String ability, String type, int maxHealth) {
        Name = name;
        Ability = ability;
        Type = type;
        MaxHealth = maxHealth;
        Health = maxHealth;
    }

    public int getHeroID() {
        return HeroID;
    }

    public void setHeroID(int heroID) {
        HeroID = heroID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAbility() {
        return Ability;
    }

    public void setAbility(String ability) {
        Ability = ability;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getMaxHealth() {
        return MaxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        MaxHealth = maxHealth;
    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }
}
