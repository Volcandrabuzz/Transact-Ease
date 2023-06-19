package com.myapp.moneytransferapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


    public class listprep2 extends AppCompatActivity {
        ArrayList<Customer2> listcontacts;
        double amount;
        Helper2 Helper2 = new Helper2(this);

        String senderName;
        double senderbalance;
        double receiverbalance;

        String receivername;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list_prep2);


            ListView viewlist = findViewById(R.id.list2);

            listcontacts = Helper2.callAllCustomers();
        //    genDatabase();
            listcontacts=Helper2.callAllCustomers();
            Adapter2 adapter2 = new Adapter2(this, listcontacts);
            viewlist.setAdapter(adapter2);

            if (getIntent()!=null) {
                senderName = getIntent().getStringExtra("name");
                senderbalance= getIntent().getDoubleExtra("balance", 0.00);


            }
            if (getIntent()!=null) {
                amount= getIntent().getDoubleExtra("amount", 0.00);


            }



            viewlist.setOnItemClickListener((parent, view, position, id) -> {
                Customer2 Custo = listcontacts.get(position);
                Intent next = new Intent(listprep2.this, transaction.class);
                receivername=Custo.callName();
                receiverbalance=Custo.callBalance();

                next.putExtra("receiver name",receivername);
                next.putExtra("receiver-balance",receiverbalance);
                next.putExtra("sender name",senderName);
                next.putExtra("sender-balance",senderbalance);


                startActivity(next);
            });
        }

//        private void genDatabase() {
//            Helper2.enterCustomer("Anna", "anna12@example.com", 1000.00-amount);
//            Helper2.enterCustomer("Billy", "billy13@example.com", 1500.00-amount);
//            Helper2.enterCustomer("Cherry", "cherry14@example.com", 2000.00-amount);
//            Helper2.enterCustomer("Daniel", "daniel15@example.com", 1500.00-amount);
//            Helper2.enterCustomer("Emily", "emily16@example.com", 1000.00-amount);
//            Helper2.enterCustomer("Fin", "fin17@example.com", 1500.00-amount);
//            Helper2.enterCustomer("George", "george18@example.com", 2000.00-amount);
//            Helper2.enterCustomer("Harry", "harry19@example.com", 1500.00-amount);
//            Helper2.enterCustomer("Insha", "insha20@example.com", 1000.00-amount);
//            Helper2.enterCustomer("Jackie", "jackie21@example.com", 1500.00-amount);
//        }

    }
