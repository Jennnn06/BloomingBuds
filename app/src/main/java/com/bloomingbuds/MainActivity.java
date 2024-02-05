package com.bloomingbuds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase userDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        //refer to other class to creating table
        SQLClass sqlClass = new SQLClass(this);
        userDatabase = sqlClass.getReadableDatabase();

        Button next = findViewById(R.id.btn_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean hasUserData = checkIfUserDataExists();

                //kung may data, proceed sa login, kung wala, sa register form
                if(hasUserData){
                    Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(loginIntent);
                }
                else{
                    Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
                    startActivity(registerIntent);
                }
            }
        });

    }

    private boolean checkIfUserDataExists(){
        String query = "SELECT COUNT(*) FROM Users";
        Cursor cursor = userDatabase.rawQuery(query, null);

        int count = 0;
        if (cursor != null && cursor.moveToFirst()){
            count = cursor.getInt(0);
            cursor.close();
        }

        return count > 0;
    }

}