package com.example.kiddy_kids;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String TAG = "DatabaseHelper";


    public DatabaseHelper(@Nullable Context context) {

            super(context, "package.db", null, 1 );

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table if not exists package (price int, item Text, age int) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop Table if exists package");
        onCreate(db);
    }
public void insertData(DAta dAta){
    SQLiteDatabase MyDB = this.getWritableDatabase();
    ContentValues contentValues = new ContentValues();
    contentValues.put("price",dAta.getPrice());
    contentValues.put("items",dAta.getItems());
    contentValues.put("age",dAta.getAge());
    long Package = MyDB.insert("package", null, contentValues);
    Log.e(TAG, "insertData:"+Package);

}


}
