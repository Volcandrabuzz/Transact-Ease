package com.myapp.moneytransferapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter2 extends ArrayAdapter<Customer2> {
    private final LayoutInflater inflate;

    public Adapter2(Context context, ArrayList<Customer2> customer2) {
        super(context, 0, customer2);
        inflate = LayoutInflater.from(context);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflate.inflate(R.layout.activity_list_item2, parent, false);
        }

        Customer2 customer2 = getItem(position);


        if (customer2 != null) {
            TextView nameView = view.findViewById(R.id.textViewName2);
            TextView emailView = view.findViewById(R.id.textViewEmail2);
            TextView balanceView = view.findViewById(R.id.textViewBalance2);


            nameView.setText("Name: " + customer2.callName());
            emailView.setText("Email: " + customer2.callEmail());
            balanceView.setText("Balance: " + customer2.callBalance());


        }
        return view;



    }
}

