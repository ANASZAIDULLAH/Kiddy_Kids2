package com.example.kiddy_kids;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Clothesfb extends AppCompatActivity {
List<Model> modelList;
RecyclerView recyclerView;
OrderAdapter  mAdpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothesfb);

        modelList = new ArrayList<>();
        modelList.add(new Model("Baby Jeans",getString(R.string.Babyjeans),R.drawable.pents));
        modelList.add(new Model("BabyGloves",getString(R.string.BabyGloves),R.drawable.gloves));
        modelList.add(new Model("Baby Caps",getString(R.string.BabyCap),R.drawable.download));
        modelList.add(new Model("Baby Socks",getString(R.string.BabySocks),R.drawable.socks));
        modelList.add(new Model("Baby Suits",getString(R.string.Dress),R.drawable.suits));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));


        // adapter
        mAdpater = new OrderAdapter(this, modelList);
        recyclerView.setAdapter(mAdpater);
    }
}