package com.bloomingbuds;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private EditText userEditText;
    private EditText passEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        //findview by id edittext
        userEditText = findViewById(R.id.txt_userLogin);
        passEditText = findViewById(R.id.txt_passLogin);


        TextView register = findViewById(R.id.btn_signup);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        //onclick login button
        Button btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userEditText.getText().toString();
                String password = passEditText.getText().toString();
                loginUser(username, password);
            }
        });
    }

    private void loginUser(String username, String password){
        SQLClass sqlClass = new SQLClass(this);
        boolean isValid = sqlClass.validateUser(username, password);
        if(isValid){
            Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
            startActivity(intent);
        }
        else{
            showPasswordIncorrect();
        }
    }

    //Incorrect pass based on database
    private void showPasswordIncorrect() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Password Incorrect");
        builder.setMessage("The entered password is incorrect. Please try again.");
        builder.setPositiveButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
