package com.example.kiddy_kids;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kiddy_kids.Database.OrderContract;

public class CLothesInfo extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    ImageView imageView;
    ImageButton plusquantity, minusquantity;
    TextView quantitynumber, jeansname, Jeansprice;

    Button addtocart;
    int quantity;
    public Uri mCurrentcartUri;
    boolean hasAllrequiredValues = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes_info);

        imageView = findViewById(R.id.imageViewInfo);
        plusquantity = findViewById(R.id.addquantity);
        minusquantity = findViewById(R.id.subquantity);
        quantitynumber = findViewById(R.id.quantity);
        jeansname = findViewById(R.id.productNameinInfo);
        Jeansprice = findViewById(R.id.PrductPrice);
        addtocart = findViewById(R.id.addtocart);



        jeansname.setText("BabyJeans");
        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CLothesInfo.this,CartSummary.class);
                startActivity(intent);


                SaveCart();
            }
        });

        plusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int baseprice = 5;
                quantity++;
                displayQuantity();
                int pantsprice = baseprice * quantity;

                String setnewprice = String.valueOf(pantsprice);
                Jeansprice.setText(setnewprice);

            }
        });

        minusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int baseprice = 5;
                if (quantity == 0){
                    Toast.makeText(CLothesInfo.this,"Cant decrease quantity<0", Toast.LENGTH_SHORT).show();

                } else
                {
                    quantity--;
                    displayQuantity();
                    int pantsprice = baseprice * quantity;

                    String setnewprice = String.valueOf(pantsprice);
                    Jeansprice.setText(setnewprice);
                }
            }
        });
    }

    private boolean SaveCart() {

        String name = jeansname.getText().toString();
        String price = Jeansprice.getText().toString();
        String quantity = quantitynumber.getText().toString();

        ContentValues values = new ContentValues();
        values.put(OrderContract.OrderEntry.COLUMN_NAME, name);
        values.put(OrderContract.OrderEntry.COLUMN_PRICE, price);
        values.put(OrderContract.OrderEntry.COLUMN_QUANTITY, quantity);

        if (mCurrentcartUri == null) {
            Uri newUri = getContentResolver().insert(OrderContract.OrderEntry.CONTENT_URI, values);
            if (newUri==null) {
                Toast.makeText(this, "Failed to add to Cart", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Success  adding to Cart", Toast.LENGTH_SHORT).show();

            }
        }
        hasAllrequiredValues = true;
        return hasAllrequiredValues;
    }

    private void displayQuantity() {

        quantitynumber.setText(String.valueOf(quantity));
    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        String[] projection = {OrderContract.OrderEntry._ID,
                OrderContract.OrderEntry.COLUMN_NAME,
                OrderContract.OrderEntry.COLUMN_PRICE,
                OrderContract.OrderEntry.COLUMN_QUANTITY,};

        return new CursorLoader(this,mCurrentcartUri,
                projection,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor cursor) {
        if (cursor == null || cursor.getCount() < 1) {
            return;
        }

        if (cursor.moveToFirst()) {

            int name = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME);
            int price = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);
            int quantity = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_QUANTITY);

            String nameofproduct = cursor.getString(name);
            String priceofproduct = cursor.getString(price);
            String quantityofproduct = cursor.getString(quantity);

            jeansname.setText(nameofproduct);
            Jeansprice.setText(priceofproduct);
            quantitynumber.setText(quantityofproduct);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

        jeansname.setText("");
        Jeansprice.setText("");
        quantitynumber.setText("");
    }
}