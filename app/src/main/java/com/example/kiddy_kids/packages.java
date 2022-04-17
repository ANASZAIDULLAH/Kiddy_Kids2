package com.example.kiddy_kids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.kiddy_kids.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class packages extends AppCompatActivity {
    ActivityMainBinding binding;
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());


        int[] imageId = {R.drawable.packagepic,R.drawable.packagepic,R.drawable.packagepic,R.drawable.packagepic,R.drawable.packagepic,
                R.drawable.packagepic,R.drawable.packagepic,R.drawable.packagepic,R.drawable.packagepic };
        String[] name = {"Package 1","Package 2", "Package 3","Package 4","Package 5","Package 6",
                "Package 7","Package 8","Package 9",};
        String[] description = {"pack of different things","pack of different things","pack of different things",
                "pack of different things","pack of different things","pack of different things",
                "pack of different things","pack of different things","pack of different things",};

        String[] price = {"3000","4000","5000","6000","7000","8000","9000","10000","11000","12000"};


        ArrayList<data> userArrayList = new ArrayList<>();

        for(int i =0;i<imageId.length;i++){

            data data = new data(name[i],description[i],price[i],imageId[i]);
            userArrayList.add(data);
        }

        ListAdapter listAdapter = new ListAdapter(packages.this,userArrayList);
        listView.setAdapter(listAdapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(packages.this,Package1.class);
                intent.putExtra("name",name[position]);
                intent.putExtra("description",description[position]);
                intent.putExtra("price",price[position]);
                intent.putExtra("imageid",imageId[position]);
                startActivity(intent);
            }
        });

    }
}