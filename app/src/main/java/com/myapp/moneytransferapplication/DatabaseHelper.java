package com.myapp.moneytransferapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "my.db";
    private static final String TABLE_NAME = "customer";
    private static final String COLUMN_ID = "id1";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_BALANCE = "balance";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_NAME + " TEXT," +
                COLUMN_EMAIL + " TEXT," +
                COLUMN_BALANCE + " REAL)";

        db.execSQL(query);

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        onCreate(db);
    }

    public void insertCustomer(String name, String email, double balance) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_BALANCE, balance);


        db.insert(TABLE_NAME,null,values);
    }

    public ArrayList<Customer> getAllCustomers() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<Customer> customers = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                Customer model=new Customer();
                model.id=cursor.getInt(0);
                model.name = cursor.getString(1);
                model.email = cursor.getString(2);
                model.balance = cursor.getDouble(3);

                customers.add(model);
            } while (cursor.moveToNext());
        }

        cursor.close();

        return customers;
    }
    public void updateCustomerBalance(String name, double newBalance) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_BALANCE, newBalance);

        String selection = COLUMN_NAME + " = ?";
        String[] selectionArgs = { name };

        db.update(TABLE_NAME, values, selection, selectionArgs);

        db.close();
    }








    }
