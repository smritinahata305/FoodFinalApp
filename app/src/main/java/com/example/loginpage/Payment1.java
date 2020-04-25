package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Payment1 extends AppCompatActivity {

    Button cash,upi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment1);

        cash = findViewById(R.id.btn_payment_cash);
        upi = findViewById(R.id.btn_payment_upi);

        cash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(Payment1.this, activitypostpay.class);
                startActivity(i);
            }
        });

        upi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go to upi screen
                Intent j = new Intent(Payment1.this, Payment.class);
                startActivity(j);

            }
        });
    }
}
