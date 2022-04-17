package com.example.kiddy_kids;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<data> {

    public ListAdapter(Context context,ArrayList<data> userArrayList){

        super(context, R.layout.list_item,userArrayList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
     data data = getItem(position);

     if (convertView == null){

         convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

     }

        ImageView imageView = convertView.findViewById(R.id.portfolio);
        TextView packages = convertView.findViewById(R.id.packages);
        TextView description = convertView.findViewById(R.id.des);
        TextView price = convertView.findViewById(R.id.price);


        imageView.setImageResource(data.imageid);
        packages.setText(data.name);
        description.setText(data.description);
        price.setText(data.price);




        return super.getView(position, convertView, parent);
    }
}
