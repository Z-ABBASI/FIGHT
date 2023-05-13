package com.example.loginandlandingpage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginandlandingpage.databinding.LandingPageBinding;

public class LandingPage extends AppCompatActivity {
    LandingPageBinding binding;
    Button fight;
    Button heroes;
    Button store;
    Button admin;
    Button logout;

    private User user;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = LandingPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fight = binding.FIGHT;
        heroes = binding.HEROESINVENTORY;
        store = binding.STORE;
        admin = binding.ADMIN;
        logout = binding.LOGOUT;

        int id = getIntent().getIntExtra("USER-ID",0);
        user = AppDataBase.getInstance(this).UserDAO().getUserByID(id);
        System.out.println(user);
        if(user != null && user.isAdmin()){
            admin.setVisibility(View.VISIBLE);
        }else{
            admin.setVisibility(View.INVISIBLE);
        }

        fight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = Fight.getIntent(getApplicationContext());
                startActivity(intent);
            }
        });

        heroes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LandingPage.this, "NOT IMPLEMENTED", Toast.LENGTH_SHORT).show();
            }
        });

        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LandingPage.this, "NOT IMPLEMENTED", Toast.LENGTH_SHORT).show();
            }
        });

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = Admin.getIntent(getApplicationContext());
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logout();
            }
        });
    }

    private void Logout(){
        Intent intent = MainActivity.getIntent(getApplicationContext());
        startActivity(intent);
    }
    public static Intent getIntent(Context context){
        return new Intent(context,LandingPage.class);
    }
}