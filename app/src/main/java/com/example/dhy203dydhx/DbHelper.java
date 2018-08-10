package com.example.dhy203dydhx;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context,String name,CursorFactory factory,int version)
    {
        super(context,name,factory,version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL("create table if not exists tb_people" +
                "(_id integer primary key autoincrement," +
                "name varchar(20)," +
                "phone varchar(12)," +
                "mobile varchar(12)," +
                "email varchar(30))");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
    }
}

