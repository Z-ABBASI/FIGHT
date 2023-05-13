package com.example.loginandlandingpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.loginandlandingpage.databinding.ActivityAdminBinding;

public class Admin extends AppCompatActivity {
    Button UserSettings;
    Button TroubleShoot;
    Button Permissions;
    ActivityAdminBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        binding = ActivityAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        UserSettings = binding.USERSETTINGS;
        TroubleShoot = binding.TROUBLESHOOT;
        Permissions = binding.PERMISSIONS;

        UserSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Admin.this, "NOT IMPLEMENTED", Toast.LENGTH_SHORT).show();
            }
        });

        TroubleShoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Admin.this, "NOT IMPLEMENTED", Toast.LENGTH_SHORT).show();
            }
        });

        Permissions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Admin.this, "NOT IMPLEMENTED", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static Intent getIntent(Context context){
        return new Intent(context, Admin.class);
    }
}