package com.example.kiddy_kids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText mTextUsername;
    EditText mTextPassword;
    EditText mconfirmpass;
    Button signup;
    Button signin;
   DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextUsername = (EditText) findViewById(R.id.username);
        mTextPassword = (EditText) findViewById(R.id.password);
        mconfirmpass =(EditText) findViewById(R.id.confirmp);
        signup = (Button) findViewById(R.id.sign);
        signin = (Button) findViewById(R.id.log);
       DB = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString();
                String pass = mTextPassword.getText().toString();
                String repss =mconfirmpass.getText().toString();

                if (user.equals("") || pass.equals("") || repss.equals(""))
                    Toast.makeText(MainActivity.this,"Please enter all the fields",Toast.LENGTH_SHORT).show();
                else {
                    if (pass.equals(repss)){
                        Boolean checkuser = DB.checkusername(user);
                        if (checkuser==false){
                            Boolean insert = DB.insertData(user,pass);
                            if (insert==true){
                                Toast.makeText(MainActivity.this, "Registered Successfully",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),HomePage.class);
                            startActivity(intent);
                            }
                            else {
                                Toast.makeText(MainActivity.this,"Registeration Failed",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(MainActivity.this,"User Already Entered",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Password not matched",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            }
        });

    }
}