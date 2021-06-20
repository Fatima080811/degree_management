package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

public class Network extends BroadcastReceiver {

    MainActivityl ad;
    dbhelperm1 db;
    @Override
    public void onReceive(Context context, Intent intent) {
        if(checkNetworkConnection(context)){

            Cursor res = db.getdata();
            while (res.moveToNext()) {
                String name = res.getString(0);
                String roll = res.getString(1);
                String email = res.getString(2);
                String department = res.getString(3);
                String pass = res.getString(4);
           ad.uploaddata(name,roll,email,department,pass);
            }

        }
    }



    public boolean checkNetworkConnection(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo =connectivityManager.getActiveNetworkInfo();
        return (networkInfo!=null && networkInfo.isConnected());
    }



}
