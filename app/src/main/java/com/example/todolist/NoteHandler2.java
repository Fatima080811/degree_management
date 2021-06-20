package com.example.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NoteHandler2 extends DatabaseHelper2 {

    public NoteHandler2(Context context) {
        super(context);
    }

    //CRUD  C create, R read, U update, D delete

    public boolean create(Note2 note2) {

        ContentValues values = new ContentValues();

        values.put("roll", note2.getRoll());
        values.put("name", note2.getName());
        values.put("department", note2.getDepartment());
        values.put("pass", note2.getPass());
        values.put("mail",note2.getMail());
        values.put("cgpa",note2.getCgpa());
        values.put("contact",note2.getContact());
        values.put("address",note2.getAddress());

        SQLiteDatabase db = this.getWritableDatabase();

        boolean isSuccessfull = db.insert("Note2", null, values) > 0;
        db.close();

        return isSuccessfull;
    }

    public ArrayList<Note2> readNotes() {
        ArrayList<Note2> note2s = new ArrayList<>();

        String sqlQuery = "SELECT * FROM Note2 ORDER BY id ASC";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(sqlQuery, null);

        if (cursor.moveToFirst()) {
            do {

                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
                String roll = cursor.getString(cursor.getColumnIndex("roll"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String department = cursor.getString(cursor.getColumnIndex("department"));
                String pass = cursor.getString(cursor.getColumnIndex("pass"));
                String mail = cursor.getString(cursor.getColumnIndex("mail"));
                String cgpa = cursor.getString(cursor.getColumnIndex("cgpa"));
                String contact = cursor.getString(cursor.getColumnIndex("contact"));
                String address = cursor.getString(cursor.getColumnIndex("address"));

                Note2 note2 = new Note2(roll,name,department,pass,mail,cgpa,contact,address);
                note2.setId(id);
                note2s.add(note2);
            } while (cursor.moveToNext());

            cursor.close();
            db.close();
        }
        return note2s;
    }

    public Note2 readSingleNote(int id) {
        Note2 note2 = null;
        String sqlQuery = "SELECT * FROM Note2 WHERE id=" + id;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sqlQuery, null);

        if (cursor.moveToFirst()) {
            int noteId = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
            String roll = cursor.getString(cursor.getColumnIndex("roll"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String department = cursor.getString(cursor.getColumnIndex("department"));
            String pass = cursor.getString(cursor.getColumnIndex("pass"));
            String mail = cursor.getString(cursor.getColumnIndex("mail"));
            String cgpa = cursor.getString(cursor.getColumnIndex("cgpa"));
            String contact = cursor.getString(cursor.getColumnIndex("contact"));
            String address = cursor.getString(cursor.getColumnIndex("address"));

            note2 = new Note2(roll,name,department,pass,mail,cgpa,contact,address);
            note2.setId(noteId);
        }
        cursor.close();
        db.close();
        return note2;
    }

    public boolean update(Note2 note2) {

        ContentValues values = new ContentValues();
        values.put("roll", note2.getRoll());
        values.put("name", note2.getName());
        values.put("department", note2.getDepartment());
        values.put("pass", note2.getPass());
        values.put("mail", note2.getMail());
        values.put("cgpa", note2.getCgpa());
        values.put("contact", note2.getContact());
        values.put("address", note2.getAddress());

        SQLiteDatabase db = this.getWritableDatabase();
        boolean isSuccessfull = db.update("Note2", values, "id='" + note2.getId() + "'", null) > 0;
        db.close();
        return isSuccessfull;
    }

    public boolean delete(int id) {
        boolean isDeleted;
        SQLiteDatabase db = this.getWritableDatabase();
        isDeleted = db.delete("Note2", "id='" + id + "'", null) > 0;
        db.close();
        return isDeleted;
    }

}
