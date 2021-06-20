package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView tvid,tvname,tvemail, tvpassing, tvdepartment,tvroll;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        //Initializing Views
        tvid = findViewById(R.id.txtid);
        tvname = findViewById(R.id.txtname);
        tvemail = findViewById(R.id.txtemail);
        tvroll = findViewById(R.id.txtRoll);
        tvpassing = findViewById(R.id.txcontact);
        tvdepartment = findViewById(R.id.txtaddress);

        Intent intent =getIntent();
        position = intent.getExtras().getInt("position");

        tvid.setText("ID: "+ MainActivityl.employeeArrayList.get(position).getId());
        tvname.setText("Name: "+ MainActivityl.employeeArrayList.get(position).getName());
        tvroll.setText("Roll: "+ MainActivityl.employeeArrayList.get(position).getRoll());
        tvemail.setText("Email: "+ MainActivityl.employeeArrayList.get(position).getEmail());
        tvpassing.setText("Passing: "+ MainActivityl.employeeArrayList.get(position).getPassing());
        tvdepartment.setText("Department: "+ MainActivityl.employeeArrayList.get(position).getDepartment());





    }
}
