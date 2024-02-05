package com.bloomingbuds;

import android.app.Application;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    SQLClass sqlClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().hide();

        //Navigation
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        return true;

                    case R.id.nav_cart:
                        startActivity(new Intent(getApplicationContext(), CartActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.nav_orderHistory:
                        startActivity(new Intent(getApplicationContext(), OrderHistoryActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.nav_settings:
                        startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
        //



        //initialize card view flowers
        CardView flower1 = findViewById(R.id.flower1);
        CardView flower2 = findViewById(R.id.flower2);
        CardView flower3 = findViewById(R.id.flower3);
        CardView flower4 = findViewById(R.id.flower4);
        CardView flower5 = findViewById(R.id.flower5);
        CardView flower6 = findViewById(R.id.flower6);
        CardView flower7 = findViewById(R.id.flower7);
        CardView flower8 = findViewById(R.id.flower8);
        CardView flower9 = findViewById(R.id.flower9);
        CardView flower10 = findViewById(R.id.flower10);

        // Initialize SQLClass
        sqlClass = new SQLClass(this);

        flower1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = sqlClass.getFlowerNames();
                StringBuffer buffer = new StringBuffer();

                if (res.moveToPosition(0)) {
                    String flowerPic = "one";
                    String flowerName = res.getString(0);
                    String flowerPrice = res.getString(1);
                    String flowerQuantity = res.getString(2);

                    // Create an intent to start the other activity
                    Intent intent = new Intent(DashboardActivity.this, ItemActivity.class);

                    // Pass the data as extras to the intent
                    intent.putExtra("flowerPic", flowerPic);
                    intent.putExtra("flowerName", flowerName);
                    intent.putExtra("flowerPrice", flowerPrice);
                    intent.putExtra("flowerQuantity", flowerQuantity);

                    // Start the other activity
                    startActivity(intent);
                }

            }
        });

        flower2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = sqlClass.getFlowerNames();
                StringBuffer buffer = new StringBuffer();

                if (res.moveToPosition(1)) {
                    String flowerPic = "two";
                    String flowerName = res.getString(0);
                    String flowerPrice = res.getString(1);
                    String flowerQuantity = res.getString(2);

                    // Create an intent to start the other activity
                    Intent intent = new Intent(DashboardActivity.this, ItemActivity.class);

                    // Pass the data as extras to the intent
                    intent.putExtra("flowerPic", flowerPic);
                    intent.putExtra("flowerName", flowerName);
                    intent.putExtra("flowerPrice", flowerPrice);
                    intent.putExtra("flowerQuantity", flowerQuantity);

                    // Start the other activity
                    startActivity(intent);
                }

            }
        });

        flower3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = sqlClass.getFlowerNames();
                StringBuffer buffer = new StringBuffer();

                if (res.moveToPosition(2)) {
                    String flowerPic = "three";
                    String flowerName = res.getString(0);
                    String flowerPrice = res.getString(1);
                    String flowerQuantity = res.getString(2);

                    // Create an intent to start the other activity
                    Intent intent = new Intent(DashboardActivity.this, ItemActivity.class);

                    // Pass the data as extras to the intent
                    intent.putExtra("flowerPic", flowerPic);
                    intent.putExtra("flowerName", flowerName);
                    intent.putExtra("flowerPrice", flowerPrice);
                    intent.putExtra("flowerQuantity", flowerQuantity);

                    // Start the other activity
                    startActivity(intent);
                }

            }
        });

        flower4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = sqlClass.getFlowerNames();
                StringBuffer buffer = new StringBuffer();

                if (res.moveToPosition(3)) {
                    String flowerPic = "four";
                    String flowerName = res.getString(0);
                    String flowerPrice = res.getString(1);
                    String flowerQuantity = res.getString(2);

                    // Create an intent to start the other activity
                    Intent intent = new Intent(DashboardActivity.this, ItemActivity.class);

                    // Pass the data as extras to the intent
                    intent.putExtra("flowerPic", flowerPic);
                    intent.putExtra("flowerName", flowerName);
                    intent.putExtra("flowerPrice", flowerPrice);
                    intent.putExtra("flowerQuantity", flowerQuantity);

                    // Start the other activity
                    startActivity(intent);
                }

            }
        });

        flower5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = sqlClass.getFlowerNames();
                StringBuffer buffer = new StringBuffer();

                if (res.moveToPosition(4)) {
                    String flowerPic = "five";
                    String flowerName = res.getString(0);
                    String flowerPrice = res.getString(1);
                    String flowerQuantity = res.getString(2);

                    // Create an intent to start the other activity
                    Intent intent = new Intent(DashboardActivity.this, ItemActivity.class);

                    // Pass the data as extras to the intent
                    intent.putExtra("flowerPic", flowerPic);
                    intent.putExtra("flowerName", flowerName);
                    intent.putExtra("flowerPrice", flowerPrice);
                    intent.putExtra("flowerQuantity", flowerQuantity);

                    // Start the other activity
                    startActivity(intent);
                }

            }
        });

        flower6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = sqlClass.getFlowerNames();
                StringBuffer buffer = new StringBuffer();

                if (res.moveToPosition(5)) {
                    String flowerPic = "six";
                    String flowerName = res.getString(0);
                    String flowerPrice = res.getString(1);
                    String flowerQuantity = res.getString(2);

                    // Create an intent to start the other activity
                    Intent intent = new Intent(DashboardActivity.this, ItemActivity.class);

                    // Pass the data as extras to the intent
                    intent.putExtra("flowerPic", flowerPic);
                    intent.putExtra("flowerName", flowerName);
                    intent.putExtra("flowerPrice", flowerPrice);
                    intent.putExtra("flowerQuantity", flowerQuantity);

                    // Start the other activity
                    startActivity(intent);
                }

            }
        });

        flower7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = sqlClass.getFlowerNames();
                StringBuffer buffer = new StringBuffer();

                if (res.moveToPosition(6)) {
                    String flowerPic = "seven";
                    String flowerName = res.getString(0);
                    String flowerPrice = res.getString(1);
                    String flowerQuantity = res.getString(2);

                    // Create an intent to start the other activity
                    Intent intent = new Intent(DashboardActivity.this, ItemActivity.class);

                    // Pass the data as extras to the intent
                    intent.putExtra("flowerPic", flowerPic);
                    intent.putExtra("flowerName", flowerName);
                    intent.putExtra("flowerPrice", flowerPrice);
                    intent.putExtra("flowerQuantity", flowerQuantity);

                    // Start the other activity
                    startActivity(intent);
                }

            }
        });

        flower8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = sqlClass.getFlowerNames();
                StringBuffer buffer = new StringBuffer();

                if (res.moveToPosition(7)) {
                    String flowerPic = "eight";
                    String flowerName = res.getString(0);
                    String flowerPrice = res.getString(1);
                    String flowerQuantity = res.getString(2);

                    // Create an intent to start the other activity
                    Intent intent = new Intent(DashboardActivity.this, ItemActivity.class);

                    // Pass the data as extras to the intent
                    intent.putExtra("flowerPic", flowerPic);
                    intent.putExtra("flowerName", flowerName);
                    intent.putExtra("flowerPrice", flowerPrice);
                    intent.putExtra("flowerQuantity", flowerQuantity);

                    // Start the other activity
                    startActivity(intent);
                }

            }
        });

        flower9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = sqlClass.getFlowerNames();
                StringBuffer buffer = new StringBuffer();

                if (res.moveToPosition(8)) {
                    String flowerPic = "nine";
                    String flowerName = res.getString(0);
                    String flowerPrice = res.getString(1);
                    String flowerQuantity = res.getString(2);

                    // Create an intent to start the other activity
                    Intent intent = new Intent(DashboardActivity.this, ItemActivity.class);

                    // Pass the data as extras to the intent
                    intent.putExtra("flowerPic", flowerPic);
                    intent.putExtra("flowerName", flowerName);
                    intent.putExtra("flowerPrice", flowerPrice);
                    intent.putExtra("flowerQuantity", flowerQuantity);

                    // Start the other activity
                    startActivity(intent);
                }

            }
        });

        flower10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = sqlClass.getFlowerNames();
                StringBuffer buffer = new StringBuffer();

                if (res.moveToPosition(9)) {
                    String flowerPic = "ten";
                    String flowerName = res.getString(0);
                    String flowerPrice = res.getString(1);
                    String flowerQuantity = res.getString(2);

                    // Create an intent to start the other activity
                    Intent intent = new Intent(DashboardActivity.this, ItemActivity.class);

                    // Pass the data as extras to the intent
                    intent.putExtra("flowerPic", flowerPic);
                    intent.putExtra("flowerName", flowerName);
                    intent.putExtra("flowerPrice", flowerPrice);
                    intent.putExtra("flowerQuantity", flowerQuantity);

                    // Start the other activity
                    startActivity(intent);
                }

            }
        });

    }

}