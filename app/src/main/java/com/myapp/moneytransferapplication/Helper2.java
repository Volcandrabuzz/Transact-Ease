package com.myapp.moneytransferapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class Helper2 extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ta.db";
    private static final String TABLE_NAME = "customer";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_BALANCE = "balance";

    public Helper2(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase database) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_NAME + " TEXT," +
                COLUMN_EMAIL + " TEXT," +
                COLUMN_BALANCE + " REAL)";

        database.execSQL(query);

    }



    @Override
    public  void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        database.execSQL(query);
        onCreate(database);
    }

    public void enterCustomer(String name, String email, double balance) {

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_BALANCE, balance);


        database.insert(TABLE_NAME,null,values);
    }

    public ArrayList<Customer2> callAllCustomers() {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<Customer2> customer2 = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                Customer2 model2=new Customer2();
                model2.name = cursor.getString(0);
                model2.email = cursor.getString(1);
                model2.balance = cursor.getDouble(2);

                customer2.add(model2);
            } while (cursor.moveToNext());
        }

        cursor.close();
        database.close();

        return customer2;
    }


    public void updateBalance(String name, double newBalance) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_BALANCE, newBalance);

        String selection = COLUMN_NAME + " = ?";
        String[] selectionArgs = { name };

        db.update(TABLE_NAME, values, selection, selectionArgs);

        db.close();
    }








}
