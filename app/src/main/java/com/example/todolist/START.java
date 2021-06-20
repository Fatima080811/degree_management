package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class START extends AppCompatActivity {
Button re1,re2,re3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_t_a_r_t);
        re2= findViewById(R.id.r2);
        re1 = findViewById(R.id.r1);
        re3 = findViewById(R.id.r3);
        re2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent1 = new Intent(START.this,MainActivity2.class);
            startActivity(intent1);
        }
    });

    re1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
 Intent go = new Intent(START.this,MainActivityl.class);
 startActivity(go);
        }
    });

    re3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent stu = new Intent(START.this,MainActivitystu.class);
            startActivity(stu);
        }
    });


    }
}