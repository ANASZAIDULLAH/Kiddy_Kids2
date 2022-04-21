package com.example.kiddy_kids;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.kiddy_kids.Database.OrderContract;

public class CartAdapter extends CursorAdapter {
    public CartAdapter(Context context, Cursor cursor) {
        super(context, cursor);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.cartlist,parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView jeansname,price, quantity;

        jeansname =view.findViewById(R.id.ProductNameinOrderSummary);
        price = view.findViewById(R.id.priceinOrderSummary);
        quantity= view.findViewById(R.id.quantityinOrderSummary);

        int productname = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME);
        int productprice = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);
        int productquantity = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_QUANTITY);

        String nameofproduct = cursor.getString(productname);
        String priceofproduct = cursor.getString(productprice);
        String quantityofproduct = cursor.getString(productquantity);



        jeansname.setText(nameofproduct);
        price.setText(priceofproduct);
        quantity.setText(quantityofproduct);






    }
}
