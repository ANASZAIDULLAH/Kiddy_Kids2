package com.example.kiddy_kids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.kiddy_kids.databinding.ActivityMainBinding;

public class Package1 extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();

        if(intent!=null){
            String name = intent.getStringExtra("name");
            String description = intent.getStringExtra("description");
            String price = intent.getStringExtra("price");
            int imageid = intent.getIntExtra("imageid",R.drawable.packagepic);
        }
    }
}