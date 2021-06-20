package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class Add_Data_Activity extends AppCompatActivity {

    EditText txtName,txtEmail, txtPass, txtDepartment,txtRoll;
    Button btn_insert;
dbhelperm1 db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__data_);

        txtName     = findViewById(R.id.edtName);
        txtEmail    = findViewById(R.id.edtEmail);
        txtPass = findViewById(R.id.edtContact);
        txtDepartment = findViewById(R.id.edtAddress);
        txtRoll = findViewById(R.id.edtRoll);
        btn_insert = findViewById(R.id.btnInsert);
        db = new dbhelperm1(this);
        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
if(checkNetworkConnection()){
                insertData();
            }
            else{



    final String name = txtName.getText().toString();
    final String roll = txtRoll.getText().toString();
    final String email = txtEmail.getText().toString();
    final String department = txtDepartment.getText().toString();
    final String pass = txtPass.getText().toString();
     db.inseruserdata(name,roll,email,department,pass);

}

            }
        });
    }

    private void insertData() {

        final String name = txtName.getText().toString().trim();
        final String roll = txtRoll.getText().toString().trim();
        final String email = txtEmail.getText().toString().trim();
        final String passing = txtPass.getText().toString().trim();
        final String department = txtDepartment.getText().toString().trim();

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");

        if(name.isEmpty()){
            Toast.makeText(this, "Enter Name", Toast.LENGTH_SHORT).show();
            return;
        }

        else if(roll.isEmpty()){
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(email.isEmpty()){
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(passing.isEmpty()){
            Toast.makeText(this, "Enter Passing Year", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(department.isEmpty()){
            Toast.makeText(this, "Enter Department", Toast.LENGTH_SHORT).show();
            return;
        }

        else{
                progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, "https://sheri333.000webhostapp.com/insert.php",

                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            if(response.equalsIgnoreCase("Data Inserted")){
                                Toast.makeText(Add_Data_Activity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                            else{
                                Toast.makeText(Add_Data_Activity.this, response, Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Add_Data_Activity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String> params = new HashMap<String,String>();

                    params.put("name",name);
                    params.put("roll",roll);
                    params.put("email",email);
                    params.put("passing",passing);
                    params.put("department",department);



                    return params;
                }
            };


            RequestQueue requestQueue = Volley.newRequestQueue(Add_Data_Activity.this);
            requestQueue.add(request);

        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
    public boolean checkNetworkConnection(){
        ConnectivityManager connectivityManager = (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo =connectivityManager.getActiveNetworkInfo();
        return (networkInfo!=null && networkInfo.isConnected());
    }


}
