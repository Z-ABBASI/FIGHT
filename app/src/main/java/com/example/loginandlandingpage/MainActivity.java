package com.example.loginandlandingpage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginandlandingpage.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    Button createAccount;
    Button login;
    ActivityMainBinding binding;
    public static final String MAKING_ACCOUNT = "MAKING ACCOUNT";
    public static final String LOGGING_IN = "LOGGING IN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        createAccount = binding.INITIALMAKEACCOUNT;
        login = binding.INITIALLOGIN;

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = LoginActivity.getIntent(getApplicationContext());
                intent.putExtra(MAKING_ACCOUNT,true);
                intent.putExtra(LOGGING_IN,false);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = LoginActivity.getIntent(getApplicationContext());
                intent.putExtra(MAKING_ACCOUNT,false);
                intent.putExtra(LOGGING_IN,true);
                startActivity(intent);
            }
        });
    }

    public static Intent getIntent(Context context){
        return new Intent(context,MainActivity.class);
    }
}
