package com.myapp.moneytransferapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class transaction extends AppCompatActivity {


    TextView textSender;
    TextView textReceiver;
    EditText editAmount;
    Button buttonSendMoney;

    TextView title;

     String senderName;
     String receiverName;
     double senderbalance;
     double receiverbalance;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        title=findViewById(R.id.Title);
        textSender = findViewById(R.id.Sender);
        textReceiver = findViewById(R.id.Receiver);
        editAmount = findViewById(R.id.editAmount);
        buttonSendMoney = findViewById(R.id.SendMoney);

        senderName = getIntent().getStringExtra("sender name");
        receiverName = getIntent().getStringExtra("receiver name");
        senderbalance = getIntent().getDoubleExtra("sender-balance", 0.00);
        receiverbalance = getIntent().getDoubleExtra("receiver-balance", 0.00);

        textSender.setText("Sender: " + senderName);
        textReceiver.setText("Receiver: " + receiverName);

        buttonSendMoney.setOnClickListener(v -> {
            String amount = editAmount.getText().toString();
            double total=Double.parseDouble(amount);
            if(total>0){
                Intent intent=new Intent(transaction.this,tickscreen.class);
                startActivity(intent);


                DatabaseHelper db=new DatabaseHelper(getApplicationContext());
                db.updateCustomerBalance(senderName,(senderbalance-total));
                db.close();

                Helper2 helper2=new Helper2(getApplicationContext());
                helper2 .updateBalance(receiverName,(receiverbalance+total));
                helper2.close();
            }

            else if(total==0) {
                Toast.makeText(transaction.this,"Payment Must be Atleast Rs.1",Toast.LENGTH_LONG).show();

            }
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Start the target activity after the delay
                    Intent intent = new Intent(transaction.this, MainActivity.class);
                    startActivity(intent);
                }
            }, 6000);





        });
    }
}
