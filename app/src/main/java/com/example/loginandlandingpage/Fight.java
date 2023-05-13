package com.example.loginandlandingpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginandlandingpage.databinding.ActivityFightBinding;

import java.util.List;
import java.util.Random;

public class Fight extends AppCompatActivity {
    TextView fight;
    ActivityFightBinding binding;

    List<Hero> heroes;
    HeroesDataBase HeroDAO;

    List<Villain> villains;
    VillainsDataBase VillainDAO;

    LinearLayout heroSelection;
    LinearLayout aftermath;

    Hero hero;
    Villain villain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFightBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fight = binding.FIGHTTEXT;

        HeroDAO = HeroesDataBase.getInstance(this);
        HeroDAO.predefinedHeroes();

        heroes = HeroDAO.HeroDAO().getHeroes();

        VillainDAO = VillainsDataBase.getInstance(this);
        VillainDAO.predefinedVillains();

        villains = VillainDAO.VillainDAO().getVillains();

        Random index = new Random();
        villain = villains.get(index.nextInt(villains.size()));

        heroSelection = binding.HEROSELECTION;
        aftermath = binding.AFTERMATH;

        for(Hero protagonist : heroes){
            Button button = new Button(this);
            button.setText(protagonist.getName());
            heroSelection.addView(button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    hero = protagonist;
                    FIGHT();
                }
            });
        }
    }

    public void FIGHT(){
        while(hero.getHealth()>0&&villain.getHealth()>0){
            Random damage = new Random();
            fight.append(hero.getName() + "(" + hero.getHealth() + ") attacked " + villain.getName() + "(" + villain.getHealth() + ") with " + hero.getAbility() + "\n");
            villain.setHealth(villain.getHealth()-damage.nextInt(100));
            fight.append(villain.getName() + " Health: " + villain.getHealth() + "\n");
            if(!(hero.getHealth()>0)&&!(villain.getHealth()>0)){
                break;
            }
            fight.append(villain.getName() + "(" + villain.getHealth() + ") attacked " + hero.getName() + "(" + hero.getHealth() + ") with " + hero.getAbility() + "\n");
            hero.setHealth(hero.getHealth()-damage.nextInt(100));
            fight.append(hero.getName() + " Health: " + hero.getHealth() + "\n");
        }
        if(villain.getHealth()<=0){
            Toast.makeText(this, "VICTORY", Toast.LENGTH_SHORT).show();
        }
        if(hero.getHealth()<=0){
            Toast.makeText(this, "VILLAIN WINS", Toast.LENGTH_SHORT).show();
        }
        hero.setHealth(hero.getMaxHealth());
        villain.setHealth(villain.getMaxHealth());
        Button replay = new Button(this);
        Button mainMenu = new Button(this);
        String replayText = "FIGHT";
        String mainMenuText = "EXIT";
        replay.setText(replayText);
        mainMenu.setText(mainMenuText);
        aftermath.addView(replay);
        aftermath.addView(mainMenu);
        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent(getApplicationContext());
                startActivity(intent);
            }
        });
        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = LandingPage.getIntent(getApplicationContext());
                startActivity(intent);
            }
        });
    }

    public static Intent getIntent(Context context){
        return new Intent(context, Fight.class);
    }
}