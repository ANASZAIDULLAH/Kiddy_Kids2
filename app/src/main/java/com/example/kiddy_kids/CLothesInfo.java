package com.example.kiddy_kids;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CLothesInfo extends AppCompatActivity {

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



        jeansname.setText("BabyJeans");

        plusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity++;
                displayQuantity();

            }
        });

        minusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quantity == 0){
                    Toast.makeText(CLothesInfo.this,"Cant decrease quantity<0", Toast.LENGTH_SHORT).show();

                } else
                {
                    quantity--;
                    displayQuantity();
                }
            }
        });
    }

    private void displayQuantity() {

        quantitynumber.setText(String.valueOf(quantity));
    }
}