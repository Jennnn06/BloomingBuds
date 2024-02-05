package com.bloomingbuds;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class SQLClass extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "bloomingbuds.db";
    private static final int DATABASE_VERSION = 1;

    // Table and column names for Users table
    private static final String TABLE_USERS = "Users";
    private static final String COLUMN_USER_ID = "userID";
    private static final String COLUMN_USER = "user";
    private static final String COLUMN_PASSWORD = "pass";


    public SQLClass(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create Users table
        String createUsersTable = "CREATE TABLE " + TABLE_USERS + "("
                + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_USER + " VARCHAR(255),"
                + COLUMN_PASSWORD + " VARCHAR(255)"
                + ")";
        db.execSQL(createUsersTable);

        // Create Flowers table
        String createFlowersTable = "CREATE TABLE Flowers (" +
                "flowerID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "flowerName TEXT, " +
                "price REAL, " +
                "quantity INTEGER)";
        db.execSQL(createFlowersTable);

        // Create Cart table
        String createCartTable = "CREATE TABLE Cart (" +
                "cartID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "flowerID INTEGER, " +
                "flowerName TEXT, " +
                "price REAL, " +
                "quantity INTEGER, " +
                "totalPrice REAL)";
        db.execSQL(createCartTable);


        // Create Order table
        String createOrderTableQuery = "CREATE TABLE Orders (" +
                "orderID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "flowerName TEXT, " +
                "price REAL, " +
                "quantity INTEGER, " +
                "totalPrice REAL)";
        db.execSQL(createOrderTableQuery);

        // Insert flowers into the database
        insertFlowers(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database upgrades if needed
    }




    public void insertCart(String flowerName, float price, int quantity, float priceTotal){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("flowerName", flowerName); // Update column name if necessary
        values.put("price", price);
        values.put("quantity", quantity);

        long newRowId = db.insert("Cart", null, values); // Update table name if necessary
        db.close();

        if (newRowId != -1) {
            // Insertion successful
            Toast.makeText(context, "Added to cart", Toast.LENGTH_SHORT).show();
        } else {
            // Insertion failed
            Toast.makeText(context, "Failed to add to cart", Toast.LENGTH_SHORT).show();
        }

    }

    //insert user and flowers into database
    public void insertUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER, username);
        values.put(COLUMN_PASSWORD, password);

        db.insert(TABLE_USERS, null, values);
        db.close();
    }

    //create flowers database
    private void insertFlowers(SQLiteDatabase db) {
        // Flower 1: Aconitum degenii
        insertFlower(db, "Aconitum degenii", 100.00f, 1);

        // Flower 2: Bachelors Button
        insertFlower(db, "Bachelors Button", 150.00f, 1);

        // Flower 3: Calla Lily
        insertFlower(db, "Calla Lily", 125.00f, 1);

        // Flower 4: Adenium Obesum
        insertFlower(db, "Adenium Obesum", 100.00f, 1);

        // Flower 5: Echinacea
        insertFlower(db, "Echinacea", 110.00f, 1);

        // Flower 6: Purpurea
        insertFlower(db, "Purpurea", 180.00f, 1);

        // Flower 7: Geranium
        insertFlower(db, "Geranium", 120.00f, 1);

        // Flower 8: Hibiscus
        insertFlower(db, "Hibiscus", 200.00f, 1);

        // Flower 9: Ice Plant
        insertFlower(db, "Ice Plant", 100.00f, 1);

        // Flower 10: Jabarosa
        insertFlower(db, "Jabarosa", 50.00f, 1);
    }

    // Insert a flower into the database
    private void insertFlower(SQLiteDatabase db, String flowerName, float price, int quantity) {
        ContentValues values = new ContentValues();
        values.put("flowerName", flowerName);
        values.put("price", price);
        values.put("quantity", quantity);
        db.insert("Flowers", null, values);
    }

    //end of inserting


    //validate if my user and pass matches any credentials in user
    public boolean validateUser(String username, String password) {
        SQLiteDatabase db = getReadableDatabase();
        String selection = "user = ? AND pass = ?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query("Users", null, selection, selectionArgs, null, null, null);
        boolean isValid = cursor.moveToFirst();
        cursor.close();
        return isValid;
    }


    // Get all flower names from the database
    public Cursor getFlowerNames() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {"flowerName", "price", "quantity"};
        return db.query("Flowers", projection, null, null, null, null, null);
    }

    public Cursor getCartItems() {
        SQLiteDatabase db = this.getReadableDatabase();

        // Select query to retrieve cart items from the "Cart" table
        String selectQuery = "SELECT * FROM Cart";

        // Execute the query and return the resulting cursor
        return db.rawQuery(selectQuery, null);
    }

    public Cursor getAllOrders() {
        SQLiteDatabase db = this.getReadableDatabase();

        // Select query to retrieve cart items from the "Cart" table
        String selectQuery = "SELECT * FROM Orders";

        // Execute the query and return the resulting cursor
        return db.rawQuery(selectQuery, null);
    }

}
