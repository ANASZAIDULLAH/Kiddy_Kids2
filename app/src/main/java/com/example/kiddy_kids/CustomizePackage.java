package com.example.kiddy_kids;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CustomizePackage extends AppCompatActivity {

   private EditText text1, text, text3;
    private CardView submit;
   private DatabaseHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize_package);

        DB = new DatabaseHelper(getApplicationContext());

        text1= (EditText) findViewById(R.id.text1);
        text = (EditText) findViewById(R.id.text2);
        text3 =(EditText) findViewById(R.id.text3);
        submit = (CardView) findViewById(R.id.submit);


submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String getprice = text1.getText().toString();
        String getitems = text.getText().toString();
        String getage = text3.getText().toString();
        DB.insertData(new DAta(getprice,getitems,getage));

        Toast.makeText(CustomizePackage.this,"Your Request has been submit",Toast.LENGTH_SHORT).show();
    }
});




}
    }
