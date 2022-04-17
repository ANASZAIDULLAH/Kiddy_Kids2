package com.example.kiddy_kids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;
    Button mButtonRegister;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mTextUsername = (EditText) findViewById(R.id.username);
        mTextPassword = (EditText) findViewById(R.id.password);
        mButtonLogin = (Button) findViewById(R.id.login);
        mButtonRegister = (Button) findViewById(R.id.log);
        DB = new DBHelper(this);

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String user = mTextUsername.getText().toString();
            String pass = mTextPassword.getText().toString();

            if (user.equals("") || pass.equals(""))
                Toast.makeText(LoginActivity.this,"Please Enter all the Fields",Toast.LENGTH_SHORT).show();
            else {
                Boolean checkuserpass = DB.checkusernamepassword(user,pass);
                if (checkuserpass==true){
                    Toast.makeText(LoginActivity.this,"Sign in Successfully",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),HomePage.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoginActivity.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
                }
            }
            }
        });

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(registerIntent);
            }
        });


    }
}