package com.mu.weerawat.myrestaurant;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Weerawat on 9/3/2015.
 */
public class MyOpenhelper extends SQLiteOpenHelper{

    //Explicit
    private static final String DATABASE_NAME = "Restaurant.db";
    private static final int DATABASE_VERSION = 1 ;
    private static final String CREATE_USER_TABLE = "create table userTABLE (_id integer primary key, User text, Password text, Name text);" ;
    private static final String CREATE_FOOD_TABLE = "create table foodTABLE (_id integer primary key, Food text, Source text, Price text);";


    public MyOpenhelper(Context context ) {
        super(context,DATABASE_NAME, null,DATABASE_VERSION);
    } // Constructor

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_FOOD_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
} //MAIN Class
