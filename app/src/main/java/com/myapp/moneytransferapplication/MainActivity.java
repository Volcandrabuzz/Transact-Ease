package com.myapp.moneytransferapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {
    Button btn;
    Button btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btnViewAllCustomers);
        btn2=findViewById(R.id.btnTransactionTrackRecord);
        btn.setOnClickListener(view -> {

        //    deleteDatabase();


            Intent intent=new Intent(MainActivity.this,listprep.class);
            startActivity(intent);

        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,transaction_track.class);
                startActivity(intent);
            }
        });
    }

//    DatabaseHelper databaseHelper=new DatabaseHelper(this);
//
//
//    private void deleteDatabase() {
//        if (databaseHelper != null) {
//            SQLiteDatabase db = databaseHelper.getWritableDatabase();
//            databaseHelper.onUpgrade(db, 0, 0);
//            db.close();
//        }
//    }

}