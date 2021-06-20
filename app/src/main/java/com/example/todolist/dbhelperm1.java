package com.example.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbhelperm1 extends SQLiteOpenHelper {
    public dbhelperm1( Context context) {
        super(context, "Userdatas.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table Userdetailst(name TEXT primary key,roll TEXT,email TEXT, department TEXT, pass TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists Userdetailst");
    }
    public Boolean inseruserdata(String name,String roll,String email,String department,String pass){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("roll",roll);
        contentValues.put("email",email);
        contentValues.put("department",department);
        contentValues.put("pass",pass);
        long result = db.insert("Userdetailst",null,contentValues);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }

    public  void deletedata(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Userdetailst",null,null);
        db.close();
    }


    public Cursor getdata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from Userdetailst",null);
        return cursor;
    }
}


