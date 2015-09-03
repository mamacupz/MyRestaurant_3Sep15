package com.mu.weerawat.myrestaurant;

import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    // Explicit
    private UserTABLE objUserTABLE;
    private FoodTABLE objFoodTABLE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create & Connect Database
        creatAndConnectdDatabase();

        //Tester Add Value

        testerAddValue();

        //Delete All Data
        deleteAllData();

        // Synchronize JSON to SQLite
        synJSONtoSQLite();


    }   //onCreate

    private void synJSONtoSQLite() {

        //Change Policy
        StrictMode.ThreadPolicy objPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(objPolicy);

        int intTime = 0;
        while (intTime <= 1) {

            InputStream objInputStream = null;
            String strJSON = null;
            String strUserURL = "http://www.swiftcodingthai.com/3sep/php_get_data_master.php";
            String strFoodURL = "http://www.swiftcodingthai.com/3sep/php_get_data_food.php";

            HttpPost objHttpPost = null;

            //1. Create InputStream
            try {

                HttpClient objHttpClient = new DefaultHttpClient();
                if (intTime != 1) {
                    objHttpPost = new HttpPost(strUserURL);


                } else {

                    objHttpPost = new HttpPost(strFoodURL);
                }
                
                HttpResponse obHttpResponse = objHttpClient.execute(objHttpPost);
                HttpEntity objHttpEntity = obHttpResponse.getEntity();
                objInputStream = objHttpEntity.getContent();

            } catch (Exception e) {
                Log.d("Rest", "Input ==>" + e.toString());
            }
            //2. Create strJSON

            //3. Update to SQLite

            intTime += 1;
        }   // while


    }   // synJSONtoSQLite

    private void deleteAllData() {
        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase("Restaurant.db",MODE_PRIVATE, null);
        objSqLiteDatabase.delete("userTABLE", null, null);
        objSqLiteDatabase.delete("foodTABLE", null, null);

    }

    private void testerAddValue() {
        objUserTABLE.addNewUser("testUser", "12345", "weerawat");
        objFoodTABLE.addFood("ผัดกระเพรา", "testSource", "200");
    }

    private void creatAndConnectdDatabase() {
        objUserTABLE = new UserTABLE(this);
        objFoodTABLE = new FoodTABLE(this);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
} // Main Class
