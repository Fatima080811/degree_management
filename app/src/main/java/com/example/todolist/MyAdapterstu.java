package com.example.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MyAdapterstu extends ArrayAdapter<Employeestu> {

    Context context;
    List<Employeestu> arrayListEmployeestu;


    public MyAdapterstu(@NonNull Context context, List<Employeestu> arrayListEmployeestu) {
        super(context, R.layout.custom_list_itemstu, arrayListEmployeestu);

        this.context = context;
        this.arrayListEmployeestu = arrayListEmployeestu;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_itemstu,null,true);

        TextView tvID = view.findViewById(R.id.txt_id);
        TextView tvName = view.findViewById(R.id.txt_name);

        tvID.setText(arrayListEmployeestu.get(position).getId());
        tvName.setText(arrayListEmployeestu.get(position).getName());

        return view;
    }
}
