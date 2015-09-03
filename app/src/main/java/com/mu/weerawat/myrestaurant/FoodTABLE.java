package com.mu.weerawat.myrestaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Weerawat on 9/3/2015.
 */
public class FoodTABLE {



        // Explicit
        private MyOpenhelper objMyOpenhelper ;
        private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

        public static final String FOOD_TABLE = "foodTable";
        public static final String COLUMN_ID_FOOD = "_id";
        public static final String COLUMN_FOOD = "Food";
        public static final String COLUMN_SOURCE = "Source";
        public static final String COLUMN_PRICE = "Price";

        public FoodTABLE(Context context) {

            objMyOpenhelper = new MyOpenhelper(context);
            writeSqLiteDatabase = objMyOpenhelper.getWritableDatabase();
            readSqLiteDatabase = objMyOpenhelper.getReadableDatabase();


        }    // Constructor

        public long addFood(String strFood, String strSource, String strPrice) {

            ContentValues objContentValues = new ContentValues();
            objContentValues.put(COLUMN_FOOD, strFood);
            objContentValues.put(COLUMN_SOURCE, strSource);
            objContentValues.put(COLUMN_PRICE, strPrice);


            return writeSqLiteDatabase.insert(FOOD_TABLE, null, objContentValues);
        }
}   // Main Class

