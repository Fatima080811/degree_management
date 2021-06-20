package com.example.todolist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ImageButton imageButton;
    ArrayList<Note2> note2s;
    RecyclerView recyclerView;
    NoteAdapter2 noteAdapter2;
clearance c1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageButton = findViewById(R.id.img_add);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity2.this,clearance.class);
                startActivity(intent3);
            }
        });
        String roll;
        String name;
        String department;
        String mail;
        String pass;
        String cgpa;
        String contact;
        String address;

        roll = getIntent().getStringExtra("ROLL");
        name =  getIntent().getStringExtra("NAME");
        department = getIntent().getStringExtra("DEPARTMENT");
        mail = getIntent().getStringExtra("MAIL");
        pass = getIntent().getStringExtra("PASSING");
        cgpa = getIntent().getStringExtra("CGPA");
        contact = getIntent().getStringExtra("CONTACT");
        address = getIntent().getStringExtra("ADDRESS");


    Note2 note2 = new Note2(roll, name, department, pass, mail, cgpa, contact, address);

    boolean isInserted = new NoteHandler2(MainActivity2.this).create(note2);

        recyclerView = findViewById(R.id.recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity2.this));
        ItemTouchHelper.SimpleCallback itemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                new NoteHandler2(MainActivity2.this).delete(note2s.get(viewHolder.getAdapterPosition()).getId());
                note2s.remove(viewHolder.getAdapterPosition());
                noteAdapter2.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        loadNotes();

    }


    public ArrayList<Note2> readNotes() {
        ArrayList<Note2> note2s = new NoteHandler2(this).readNotes();
        return note2s;
    }

    public void loadNotes() {

        note2s = readNotes();

        noteAdapter2 = new NoteAdapter2(note2s, this, new NoteAdapter2.ItemClicked() {
            @Override
            public void onClick(int postion, View view) {

            }
        });

        recyclerView.setAdapter(noteAdapter2);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            loadNotes();
        }
    }
}