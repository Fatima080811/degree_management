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

public class Edit_Activitystu extends AppCompatActivity {

    EditText edId,edName,edContact,edEmail,edAddress,edFather;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_stu);

        edId = findViewById(R.id.ed_id);
        edName = findViewById(R.id.ed_name);
        edFather = findViewById(R.id.ed_father);
        edContact = findViewById(R.id.ed_contact);
        edEmail = findViewById(R.id.ed_email);
        edAddress = findViewById(R.id.ed_address);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");


        edId.setText(MainActivitystu.employeestuArrayList.get(position).getId());
        edName.setText(MainActivitystu.employeestuArrayList.get(position).getName());
        edFather.setText(MainActivitystu.employeestuArrayList.get(position).getFather());
        edEmail.setText(MainActivitystu.employeestuArrayList.get(position).getEmail());
        edContact.setText(MainActivitystu.employeestuArrayList.get(position).getContact());
        edAddress.setText(MainActivitystu.employeestuArrayList.get(position).getAddress());




    }

    public void btn_updateData(View view) {

        final String name = edName.getText().toString();
        final String father = edFather.getText().toString();
        final String email = edEmail.getText().toString();
        final String contact = edContact.getText().toString();
        final String address = edAddress.getText().toString();
        final String id = edId.getText().toString();





        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Updating....");
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.POST, "https://sheri333.000webhostapp.com/studentupdate.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(Edit_Activitystu.this, response, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), MainActivitystu.class));
                        finish();
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Edit_Activitystu.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();

                params.put("id",id);
                params.put("name",name);
                params.put("father",father);
                params.put("email",email);
                params.put("contact",contact);
                params.put("address",address);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(Edit_Activitystu.this);
        requestQueue.add(request);





    }
}
