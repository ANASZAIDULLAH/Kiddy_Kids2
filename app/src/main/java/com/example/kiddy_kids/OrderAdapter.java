package com.example.kiddy_kids;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    List<Model> modelList;
   Context context;


    public OrderAdapter(Context context, List<Model> modelList) {
        this.context=context;
        this.modelList=modelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.listitem, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {

        String nameofproducts = modelList.get(position).getProductname();
        String descriptionofproducts= modelList.get(position).getProductdetail();
        int images=modelList.get(position).getProductpic();

        holder.mProductName.setText(nameofproducts);
        holder.mProductDescription.setText(descriptionofproducts);
        holder.imageView.setImageResource(images);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }










    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        TextView mProductName, mProductDescription;
        ImageView imageView;


        public ViewHolder(View itemView) {
            super(itemView);
            mProductName= itemView.findViewById(R.id.ProductName);
            mProductDescription=itemView.findViewById(R.id.description);
            imageView = itemView.findViewById(R.id.ProductImage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            int position = getAdapterPosition();

            if (position ==0)
            {
                Intent intent = new Intent(context, CLothesInfo.class);
                context.startActivity(intent);
            }
        }
    }
}
