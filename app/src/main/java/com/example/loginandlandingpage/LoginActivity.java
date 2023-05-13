package com.example.loginandlandingpage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.loginandlandingpage.databinding.ActivityLoginBinding;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;

    EditText Username;
    EditText Password;
    EditText ConfirmPassword;

    Button submit;
    AppDataBase UserDAO;

    List<User> UserList;

    private boolean createAccount;
    private boolean login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Username = binding.USERNAME;
        Password = binding.PASSWORD;
        ConfirmPassword = binding.CONFIRMPASSWORD;
        submit = binding.SUBMIT;

        UserDAO = AppDataBase.getInstance(this);
        UserDAO.predefinedUsers();
        addUsers();

        createAccount = getIntent().getBooleanExtra(MainActivity.MAKING_ACCOUNT,false);
        login = getIntent().getBooleanExtra(MainActivity.LOGGING_IN,true);

        if(createAccount){
            ConfirmPassword.setVisibility(View.VISIBLE);
        }else{
            ConfirmPassword.setVisibility(View.INVISIBLE);
        }

        if(login){
            submit.setText("LOGIN");
        }else{
            submit.setText("CREATE ACCOUNT");
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(login){
                    Login();
                }else{
                    addUser();
                }
            }
        });
    }

    private void Login(){
        String username = Username.getText().toString();
        String password = Password.getText().toString();
        User user = UserDAO.UserDAO().getUserByLogin(username,password);
        if(user != null){
            for(User u : UserList){
                if(u.getUsername().equals(username)&&u.getPassword().equals(password)){
                    Intent intent = LandingPage.getIntent(getApplicationContext());
                    intent.putExtra("USER-ID",u.getUserID());
                    startActivity(intent);
                    return;
                }
            }
            Toast.makeText(getApplicationContext(),"Error finding user",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),"Wrong login information",Toast.LENGTH_SHORT).show();
        }
    }

    private void addUsers(){
        UserList = UserDAO.UserDAO().getUsers();
        if(!UserList.isEmpty()){
            StringBuilder sb = new StringBuilder();
            for(User u : UserList){
                sb.append(u.toString());
            }
        }

    }

    private void addUser(){
        UserDAO.UserDAO().insert(new User(Username.getText().toString(),Password.getText().toString(),false));
        Intent intent = LandingPage.getIntent(getApplicationContext());
        startActivity(intent);
    }

    public static Intent getIntent(Context context){
        return new Intent(context,LoginActivity.class);
    }
}
