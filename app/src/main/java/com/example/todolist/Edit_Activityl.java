package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

public class Edit_Activityl extends AppCompatActivity {

    EditText edId,edName, edPassing,edEmail,edRoll, edDepartment;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_l);

        edId = findViewById(R.id.ed_id);
        edName = findViewById(R.id.ed_name);
        edPassing = findViewById(R.id.ed_contact);
        edRoll = findViewById(R.id.ed_roll);
        edEmail = findViewById(R.id.ed_email);
        edDepartment = findViewById(R.id.ed_address);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");


        edId.setText(MainActivityl.employeeArrayList.get(position).getId());
        edName.setText(MainActivityl.employeeArrayList.get(position).getName());
        edRoll.setText(MainActivityl.employeeArrayList.get(position).getRoll());
        edEmail.setText(MainActivityl.employeeArrayList.get(position).getEmail());
        edPassing.setText(MainActivityl.employeeArrayList.get(position).getPassing());
        edDepartment.setText(MainActivityl.employeeArrayList.get(position).getDepartment());




    }

    public void btn_updateData(View view) {

        final String name = edName.getText().toString();
        final String roll = edRoll.getText().toString();
        final String email = edEmail.getText().toString();
        final String passing = edPassing.getText().toString();
        final String department = edDepartment.getText().toString();
        final String id = edId.getText().toString();





        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Updating....");
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.POST, "https://sheri333.000webhostapp.com/regupadate.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(Edit_Activityl.this, response, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), MainActivityl.class));
                        finish();
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Edit_Activityl.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();

                params.put("id",id);
                params.put("name",name);
                params.put("roll",roll);
                params.put("email",email);
                params.put("passing",passing);
                params.put("department",department);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(Edit_Activityl.this);
        requestQueue.add(request);





    }
}
