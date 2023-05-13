package com.example.loginandlandingpage;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = VillainsDataBase.VILLAIN_TABLE)
public class Villain {
    @PrimaryKey(autoGenerate = true)
    private int VillainID;
    private String Name;
    private String Ability;
    private String Type;
    private int Health;
    private int MaxHealth;

    public Villain() {

    }

    public Villain(String name, String abilities, String type, int maxHealth) {
        Name = name;
        Ability = abilities;
        Type = type;
        Health = maxHealth;
        MaxHealth = maxHealth;
    }

    public int getVillainID() {
        return VillainID;
    }

    public void setVillainID(int villainID) {
        VillainID = villainID;
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

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }

    public int getMaxHealth() {
        return MaxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        MaxHealth = maxHealth;
    }
}
