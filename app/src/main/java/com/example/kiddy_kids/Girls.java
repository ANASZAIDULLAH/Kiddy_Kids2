package com.example.kiddy_kids;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Girls extends AppCompatActivity {
    CardView one, too, three, four, five, six;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girls);


        one = (CardView) findViewById(R.id.g1);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),onegirl.class);
                startActivity(intent);
            }
        });

        too = (CardView) findViewById(R.id.g2);
        too.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),twogirl.class);
                startActivity(intent);
            }
        });

        three = (CardView) findViewById(R.id.g3);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),threegirl.class);
                startActivity(intent);
            }
        });

        four = (CardView) findViewById(R.id.g4);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),fourgirl.class);
                startActivity(intent);
            }
        });

        five = (CardView) findViewById(R.id.g5);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),fivegirl.class);
                startActivity(intent);
            }
        });

        six = (CardView) findViewById(R.id.g6);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),sixgirl.class);
                startActivity(intent);
            }
        });
    }
}