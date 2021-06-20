package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class clearance extends AppCompatActivity {
    EditText roll,name,department,mail,passing,cgpa,contact,address;
    ImageButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clearance);

        roll = findViewById(R.id.edt_roll);
        name = findViewById(R.id.edt_name);
        department = findViewById(R.id.edt_department);
        mail =findViewById(R.id.edt_mail);
        passing =findViewById(R.id.edt_pass);
        contact =findViewById(R.id.edt_cnmb);
        cgpa =findViewById(R.id.edt_cgpa);
        address =findViewById(R.id.edt_address);
        btn = findViewById(R.id.bt22);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertclr();
                String temp1 = roll.getText().toString();
                String temp2 = name.getText().toString();
                String temp3 = department.getText().toString();
                String temp4 = mail.getText().toString();
                String temp5 = passing.getText().toString();
                String temp6 = contact.getText().toString();
                String temp7 = cgpa.getText().toString();
                String temp8 = address.getText().toString();

                Intent ad = new Intent(clearance.this,MainActivity2.class);
                ad.putExtra("ROLL",temp1);
                ad.putExtra("NAME",temp2);
                ad.putExtra("DEPARTMENT",temp3);
                ad.putExtra("MAIL",temp4);
                ad.putExtra("PASSING",temp5);
                ad.putExtra("CONTACT",temp6);
                ad.putExtra("CGPA",temp7);
                ad.putExtra("ADDRESS",temp8);
                startActivity(ad);
            }
        });

    }

    private void insertclr() {

        final String name1 = name.getText().toString().trim();
        final String roll1 = roll.getText().toString().trim();
        final String email1 = mail.getText().toString().trim();
        final String address1 = address.getText().toString().trim();
        final String department1 = department.getText().toString().trim();
        final String contact1 = contact.getText().toString().trim();
        final String cgpa1 = cgpa.getText().toString().trim();
        final String passing1 = passing.getText().toString().trim();

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");

        if (name1.isEmpty()) {
            Toast.makeText(this, "Enter Name", Toast.LENGTH_SHORT).show();
            return;
        } else if (roll1.isEmpty()) {
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
            return;
        } else if (email1.isEmpty()) {
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
            return;
        } else if (passing1.isEmpty()) {
            Toast.makeText(this, "Enter Passing Year", Toast.LENGTH_SHORT).show();
            return;
        } else if (department1.isEmpty()) {
            Toast.makeText(this, "Enter Department", Toast.LENGTH_SHORT).show();
            return;
        } else {
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, "https://sheri333.000webhostapp.com/clearenceadd.php",

                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            if (response.equalsIgnoreCase("Data Inserted")) {
                                Toast.makeText(clearance.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            } else {
                                Toast.makeText(clearance.this, response, Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(clearance.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            ) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String, String> params = new HashMap<String, String>();

                    params.put("name", name1);
                    params.put("roll", roll1);
                    params.put("email", email1);
                    params.put("address", address1);
                    params.put("department", department1);
                    params.put("contact", contact1);
                    params.put("cgpa", cgpa1);
                    params.put("passing", passing1);


                    return params;
                }
            };


            RequestQueue requestQueue = Volley.newRequestQueue(clearance.this);
            requestQueue.add(request);

        }


    }


    }