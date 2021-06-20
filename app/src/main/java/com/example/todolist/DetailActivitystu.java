package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivitystu extends AppCompatActivity {

    TextView tvid,tvname,tvemail,tvcontact,tvaddress,tvfather;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailstu);


        //Initializing Views
        tvid = findViewById(R.id.txtid);
        tvname = findViewById(R.id.txtname);
        tvfather = findViewById(R.id.txtfather);
        tvemail = findViewById(R.id.txtemail);
        tvcontact = findViewById(R.id.txcontact);
        tvaddress = findViewById(R.id.txtaddress);

        Intent intent =getIntent();
        position = intent.getExtras().getInt("position");

        tvid.setText("ID: "+ MainActivitystu.employeestuArrayList.get(position).getId());
        tvname.setText("Name: "+ MainActivitystu.employeestuArrayList.get(position).getName());
        tvfather.setText("Father Name: "+ MainActivitystu.employeestuArrayList.get(position).getFather());
        tvemail.setText("Email: "+ MainActivitystu.employeestuArrayList.get(position).getEmail());
        tvcontact.setText("Contact: "+ MainActivitystu.employeestuArrayList.get(position).getContact());
        tvaddress.setText("Address: "+ MainActivitystu.employeestuArrayList.get(position).getAddress());





    }
}
