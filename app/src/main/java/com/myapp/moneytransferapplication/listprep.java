package com.myapp.moneytransferapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class    listprep extends AppCompatActivity {
    ArrayList<Customer> arrcontacts;
    double amount;

    DatabaseHelper databaseHelper=new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listprep);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);

        ListView listView = findViewById(R.id.listView);
        //generateDatabase();
        arrcontacts= databaseHelper.getAllCustomers();
        CustomerAdapter adapter= new CustomerAdapter(this, arrcontacts);
        listView.setAdapter(adapter);

        if (getIntent()!=null) {
            amount= getIntent().getDoubleExtra("amount", 0.00);


        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //    deleteDatabase();

                Customer selectedCustomer = arrcontacts.get(position);
                Intent intent = new Intent(listprep.this, listprep2.class);
                String Sender=selectedCustomer.getName();
                double Balance=selectedCustomer.getBalance();

                intent.putExtra("name",Sender);
                intent.putExtra("balance",Balance);

                Toast.makeText(listprep.this, "Selected: " + Sender, Toast.LENGTH_SHORT).show();
                startActivity(intent);


            }
        });
    }



//    private void generateDatabase() {
//        databaseHelper.insertCustomer("John", "john.doe@example.com", 1000.00+amount);
//        databaseHelper.insertCustomer("Jane", "jane.smith@example.com", 2000.00+amount);
//        databaseHelper.insertCustomer("David", "david.johnson@example.com", 1500.00+amount);
//        databaseHelper.insertCustomer("Chauhan", "chauhan1632@example.com", 1100.00+amount);
//        databaseHelper.insertCustomer("Sushi", "sushi_i_m@example.com", 1200.00+amount);
//        databaseHelper.insertCustomer("Cheel", "cheel69@example.com", 1300.00+amount);
//        databaseHelper.insertCustomer("Preyanshu", "preyanshu@example.com", 1400.00+amount);
//        databaseHelper.insertCustomer("Verma", "verma_100@example.com", 1500.00+amount);
//        databaseHelper.insertCustomer("Harshal", "harshal_000@example.com", 1600.00+amount);
//        databaseHelper.insertCustomer("Pranav", "pranav_24@example.com", 1700.00+amount);
//
//    }
//    Helper2 Helper2 = new Helper2(this);
//    private void deleteDatabase() {
//        if (Helper2 != null) {
//            SQLiteDatabase database = Helper2.getWritableDatabase();
//            Helper2.onUpgrade(database, 0, 0);
//            database.close();
//        }
//    }


}

