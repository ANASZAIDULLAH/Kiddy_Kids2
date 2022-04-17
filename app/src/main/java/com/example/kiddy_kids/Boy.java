package com.example.kiddy_kids;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Boy extends AppCompatActivity {

    CardView one, too, three, four, five, six;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boy);


        one = (CardView) findViewById(R.id.c1);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),FirstB.class);
                startActivity(intent);
            }
        });

        too = (CardView) findViewById(R.id.c2);
        too.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Twoyear.class);
                startActivity(intent);
            }
        });

        three = (CardView) findViewById(R.id.c3);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Threeyear.class);
                startActivity(intent);
            }
        });

        four = (CardView) findViewById(R.id.c4);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Fouryear.class);
                startActivity(intent);
            }
        });

        five = (CardView) findViewById(R.id.c5);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Fiveyear.class);
                startActivity(intent);
            }
        });

        six = (CardView) findViewById(R.id.c6);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),sixyear.class);
                startActivity(intent);
            }
        });

    }

}