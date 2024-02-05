package com.bloomingbuds;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ItemActivity extends AppCompatActivity {

    private String flowerName;
    private String flowerPrice;
    private int quantity;

    private SQLClass sqlClass;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        getSupportActionBar().hide();

        //back button
        Button back = findViewById(R.id.itm_backbutton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ItemActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });

        //get flower data
        flowerName = getIntent().getStringExtra("flowerName");
        flowerPrice = getIntent().getStringExtra("flowerPrice");
        String flowerPicture = getIntent().getStringExtra("flowerPic");

        // Update the text in the ItemActivity based on the flower name and price
        TextView itemNameTextView = findViewById(R.id.itemName);
        itemNameTextView.setText(flowerName);

        TextView itemPriceTextView = findViewById(R.id.itemPrice);
        itemPriceTextView.setText("P: "+ flowerPrice);

        if(flowerPicture.equals("one")){
            ImageView itemImage1 = findViewById(R.id.itemImage);
            itemImage1.setImageResource(R.drawable.f1_aconitum_degenii);
            Drawable drawable = getResources().getDrawable(R.drawable.f1_aconitum_degenii);
            itemImage1.setImageDrawable(drawable);
        }
        else if (flowerPicture.equals("two")){
            ImageView itemImage1 = findViewById(R.id.itemImage);
            itemImage1.setImageResource(R.drawable.f2_bachelors_button);
            Drawable drawable = getResources().getDrawable(R.drawable.f2_bachelors_button);
            itemImage1.setImageDrawable(drawable);
        }
        else if (flowerPicture.equals("three")) {
            ImageView itemImage1 = findViewById(R.id.itemImage);
            itemImage1.setImageResource(R.drawable.f3_callalily);
            Drawable drawable = getResources().getDrawable(R.drawable.f3_callalily);
            itemImage1.setImageDrawable(drawable);
        }
        else if (flowerPicture.equals("four")) {
            ImageView itemImage1 = findViewById(R.id.itemImage);
            itemImage1.setImageResource(R.drawable.f4_adenium_obesum);
            Drawable drawable = getResources().getDrawable(R.drawable.f4_adenium_obesum);
            itemImage1.setImageDrawable(drawable);
        }
        else if (flowerPicture.equals("five")) {
            ImageView itemImage1 = findViewById(R.id.itemImage);
            itemImage1.setImageResource(R.drawable.f5_echinacea);
            Drawable drawable = getResources().getDrawable(R.drawable.f5_echinacea);
            itemImage1.setImageDrawable(drawable);
        }
        else if (flowerPicture.equals("six")) {
            ImageView itemImage1 = findViewById(R.id.itemImage);
            itemImage1.setImageResource(R.drawable.f6_purpurea);
            Drawable drawable = getResources().getDrawable(R.drawable.f6_purpurea);
            itemImage1.setImageDrawable(drawable);
        }
        else if (flowerPicture.equals("seven")) {
            ImageView itemImage1 = findViewById(R.id.itemImage);
            itemImage1.setImageResource(R.drawable.f7_geranium);
            Drawable drawable = getResources().getDrawable(R.drawable.f7_geranium);
            itemImage1.setImageDrawable(drawable);
        }
        else if (flowerPicture.equals("eight")) {
            ImageView itemImage1 = findViewById(R.id.itemImage);
            itemImage1.setImageResource(R.drawable.f8_hibiscus);
            Drawable drawable = getResources().getDrawable(R.drawable.f8_hibiscus);
            itemImage1.setImageDrawable(drawable);
        }
        else if (flowerPicture.equals("nine")) {
            ImageView itemImage1 = findViewById(R.id.itemImage);
            itemImage1.setImageResource(R.drawable.f9_ice_plant);
            Drawable drawable = getResources().getDrawable(R.drawable.f9_ice_plant);
            itemImage1.setImageDrawable(drawable);
        }
        else if(flowerPicture.equals("ten")){
            ImageView itemImage1 = findViewById(R.id.itemImage);
            itemImage1.setImageResource(R.drawable.f10_jaborosa);
            Drawable drawable = getResources().getDrawable(R.drawable.f10_jaborosa);
            itemImage1.setImageDrawable(drawable);
        }


        //Quantities
        // Initialize views
        TextView quantityNumber = findViewById(R.id.quantityNumber);
        ImageButton plusButton = findViewById(R.id.plusButton);
        ImageButton minusButton = findViewById(R.id.minusButton);

        // Set initial quantity value
        quantityNumber.setText(String.valueOf(quantity));

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Increment the quantity value
                quantity++;

                // Update the TextView with the new quantity
                quantityNumber.setText(String.valueOf(quantity));
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Decrement the quantity value only if it's greater than 0
                if (quantity > 0) {
                    quantity--;
                }

                // Update the TextView with the new quantity
                quantityNumber.setText(String.valueOf(quantity));
            }
        });


        sqlClass = new SQLClass(this);


        Button addToCartButton = findViewById(R.id.AddCartButton);
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the flower details
                flowerName = getIntent().getStringExtra("flowerName");
                String flowerPrice = getIntent().getStringExtra("flowerPrice");
                float price = Float.parseFloat(flowerPrice);
                int quantity = Integer.parseInt(quantityNumber.getText().toString());

                float priceTotal = price * quantity;

                sqlClass.insertCart(flowerName, price, quantity, priceTotal);

                Intent intent = new Intent(ItemActivity.this, DashboardActivity.class);
                startActivity(intent);

            }
        });



    }

}
