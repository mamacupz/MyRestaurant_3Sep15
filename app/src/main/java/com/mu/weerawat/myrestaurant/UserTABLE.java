package com.mu.weerawat.myrestaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Weerawat on 9/3/2015.
 */
public class UserTABLE {

    // Explicit
    private MyOpenhelper objMyOpenhelper ;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String USER_TABLE = "userTable";
    public static final String COLUMN_ID_USER = "_id";
    public static final String COLUMN_USER = "User";
    public static final String COLUMN_PASSWORD = "Password";
    public static final String COLUMN_NAME = "Name";

    public UserTABLE(Context context) {

        objMyOpenhelper = new MyOpenhelper(context);
        writeSqLiteDatabase = objMyOpenhelper.getWritableDatabase();
        readSqLiteDatabase = objMyOpenhelper.getReadableDatabase();


    }    // Constructor

    public long addNewUser(String strUser, String strPassword, String strName) {
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_USER,strUser);
        objContentValues.put(COLUMN_PASSWORD,strPassword);
        objContentValues.put(COLUMN_NAME,strName);
        return writeSqLiteDatabase.insert(USER_TABLE, null,objContentValues);
    }

}   // Main Class
