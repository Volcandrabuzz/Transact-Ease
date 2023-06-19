package com.myapp.moneytransferapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomerAdapter extends ArrayAdapter<Customer> {
    private final LayoutInflater inflater;

    public CustomerAdapter(listprep context, ArrayList<Customer> customers) {
        super((Context) context, 0, customers);
        inflater = LayoutInflater.from((Context) context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.activity_list_item, parent, false);
        }

        Customer customer = getItem(position);
        if (customer != null) {
            TextView nameTextView = view.findViewById(R.id.textViewName);
            TextView emailTextView = view.findViewById(R.id.textViewEmail);
            TextView balanceTextView = view.findViewById(R.id.textViewBalance);

            nameTextView.setText("Name: " + customer.getName());
            emailTextView.setText("Email: " + customer.getEmail());
            balanceTextView.setText("Balance: " + customer.getBalance());
        }

        return view;
    }
}

