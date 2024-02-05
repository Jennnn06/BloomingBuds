package com.bloomingbuds;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class OrderHistoryAdapter extends RecyclerView.Adapter<OrderHistoryAdapter.OrderViewHolder> {
    private Context context;
    private Cursor cursor;

    public OrderHistoryAdapter(Context context, Cursor cursor) {
        this.context = context;
        this.cursor = cursor;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_orderhistoryitems, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        if (cursor.moveToPosition(position)) {
            // Extract the data from the cursor
            int orderId = cursor.getInt(cursor.getColumnIndexOrThrow("orderID"));
            String flowerName = cursor.getString(cursor.getColumnIndexOrThrow("flowerName"));
            float price = cursor.getFloat(cursor.getColumnIndexOrThrow("price"));
            int quantity = cursor.getInt(cursor.getColumnIndexOrThrow("quantity"));
            float totalPrice = price * quantity;

            // Set the data to the views in the ViewHolder
            holder.orderIdTextView.setText("Order ID: " + orderId);
            holder.flowerNameTextView.setText("Flower Name: " + flowerName);
            holder.priceTextView.setText("Price: " + price);
            holder.quantityTextView.setText("Quantity: " + quantity);
            holder.totalPriceTextView.setText("Total Price: " + totalPrice);
        }
    }

    @Override
    public int getItemCount() {
        return cursor != null ? cursor.getCount() : 0;
    }

    public void changeCursor(Cursor newCursor) {
        if (cursor != null) {
            cursor.close();
        }
        cursor = newCursor;
        notifyDataSetChanged();
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView orderIdTextView, flowerIdTextView, flowerNameTextView, priceTextView, quantityTextView, totalPriceTextView;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            orderIdTextView = itemView.findViewById(R.id.orderId);
            flowerNameTextView = itemView.findViewById(R.id.orderName);
            priceTextView = itemView.findViewById(R.id.orderPrice);
            quantityTextView = itemView.findViewById(R.id.orderQuantity);
            totalPriceTextView = itemView.findViewById(R.id.orderTotalPrice);
        }
    }
}
