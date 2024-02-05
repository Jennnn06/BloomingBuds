package com.bloomingbuds;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CartActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    private RecyclerView cartRecyclerView;
    private CartAdapter cartAdapter;
    private SQLClass dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        getSupportActionBar().hide();

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_cart);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.nav_cart:
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

        cartRecyclerView = findViewById(R.id.cartRecyclerView);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        cartAdapter = new CartAdapter(this, null); // Pass null as the initial cursor
        cartRecyclerView.setAdapter(cartAdapter);

        // Inside the onCreate method after setting up the RecyclerView
        SQLClass dbHelper = new SQLClass(this);
        Cursor cursor = dbHelper.getCartItems();
        cartAdapter.changeCursor(cursor); // Update the cursor in the adapter

    }

    @Override
    protected void onResume() {
        super.onResume();
        dbHelper = new SQLClass(this);
        Cursor cursor = dbHelper.getCartItems();
        cartAdapter.changeCursor(cursor); // Update the cursor in the adapter
    }



}
