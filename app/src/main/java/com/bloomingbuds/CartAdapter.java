package com.bloomingbuds;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private Context context;
    private Cursor cursor;

    SQLClass sqlClass;

    public CartAdapter(Context context, Cursor cursor) {
        this.context = context;
        this.cursor = cursor;
        sqlClass = new SQLClass(context);
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_cartitem, parent, false);
        return new CartViewHolder(view);
    }

    public void changeCursor(Cursor newCursor) {
        if (cursor != null) {
            cursor.close();
        }
        cursor = newCursor;
        notifyDataSetChanged();
    }

    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        if (!cursor.moveToPosition(position)) {
            return;
        }

        // Extract data from the cursor
        String flowerName = cursor.getString(cursor.getColumnIndex("flowerName")); // Update column name if necessary
        float price = cursor.getFloat(cursor.getColumnIndex("price")); // Update column name if necessary
        int quantity = cursor.getInt(cursor.getColumnIndex("quantity")); // Update column name if necessary
        float totalPrice = quantity * price;

        // Set the data to the views in the ViewHolder
        holder.flowerNameTextView.setText("Name: " + flowerName);
        holder.priceTextView.setText("Price: " + price);
        holder.quantityTextView.setText("Quantity: " + quantity);
        holder.totalPriceTextView.setText("Total Price: " + totalPrice);

        holder.checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Insert data into orders table
                insertOrderItem(flowerName, price, quantity, totalPrice);

                // Delete item from cart
                int cartID = cursor.getInt(cursor.getColumnIndex("cartID"));
                deleteCartItem(cartID);

                // Update the RecyclerView
                cursor = sqlClass.getCartItems();
                notifyDataSetChanged();

                // Show a toast message
                Toast.makeText(context, "Checkout completed", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        TextView flowerNameTextView, priceTextView, quantityTextView, totalPriceTextView;
        Button checkoutButton;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            flowerNameTextView = itemView.findViewById(R.id.flowerCartName);
            priceTextView = itemView.findViewById(R.id.flowerCartPrice);
            quantityTextView = itemView.findViewById(R.id.flowerCartQuantity);
            totalPriceTextView = itemView.findViewById(R.id.flowerTotalPrice);
            checkoutButton = itemView.findViewById(R.id.flowerCartCheckout);
        }
    }

    // Helper method to delete a cart item
    private void deleteCartItem(int cartID) {
        SQLiteDatabase db = sqlClass.getWritableDatabase();
        db.delete("Cart", "cartID = ?", new String[]{String.valueOf(cartID)});
    }

    // Helper method to insert an order item
    private void insertOrderItem(String flowerName, float price, int quantity, float totalPrice) {
        SQLiteDatabase db = sqlClass.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("flowerName", flowerName);
        values.put("price", price);
        values.put("quantity", quantity);
        values.put("totalPrice", totalPrice);
        db.insert("Orders", null, values);
    }
}
