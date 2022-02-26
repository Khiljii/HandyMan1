package com.example.handyman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class paymentMethod extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);
        Button b1 = (Button) findViewById(R.id.next);
        RadioButton r1 =(RadioButton)findViewById(R.id.jazzcash);
        RadioButton r2 =(RadioButton)findViewById(R.id.easypaisa);
        RadioButton r3 =(RadioButton)findViewById(R.id.bank);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(r3.isChecked())
                {
                    startActivity(new Intent(paymentMethod.this,Bill.class));
                }
                else
                {
                    startActivity(new Intent(paymentMethod.this,jazzcash.class));
                }
            }
        });
    }
}