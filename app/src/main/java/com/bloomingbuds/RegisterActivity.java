package com.bloomingbuds;

import static com.bloomingbuds.R.id.txt_registerLogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private EditText userEditText;
    private EditText passEditText;
    private EditText confirmEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();


        //findview by id
        userEditText = findViewById(R.id.txt_userRegister);
        passEditText = findViewById(R.id.txt_passRegister);
        confirmEditText = findViewById(R.id.txt_confirmPass);


        //login
        TextView login = findViewById(txt_registerLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


        //Register button clicked
        Button register = findViewById(R.id.btn_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userEditText.getText().toString();
                String password = passEditText.getText().toString();
                String confirmPassword = confirmEditText.getText().toString();

                registerUser(username, password, confirmPassword);

            }
        });
    }

    private void registerUser(String username, String password, String confirmPassword){
        if(password.equals(confirmPassword)){
            SQLClass sqlClass = new SQLClass(this);
            sqlClass.insertUser(username, password);

            Intent intent = new Intent(RegisterActivity.this, DashboardActivity.class);
            startActivity(intent);
            finish();
        }
        else{
            showPasswordMismatchAlert();
        }
    }

    private void showPasswordMismatchAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Password Mismatch");
        builder.setMessage("The entered passwords do not match. Please try again.");
        builder.setPositiveButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
