package com.example.todolist;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoteAdapter2 extends RecyclerView.Adapter<NoteAdapter2.NoteHolder> {

    ArrayList<Note2> note2s;
    Context context;
    ItemClicked itemClicked;
    ViewGroup parent;
    private int lastSelectedPosition = -1;

    public NoteAdapter2(ArrayList<Note2> arrayList, Context context, ItemClicked itemClicked){
        note2s = arrayList;
        this.context = context;
        this.itemClicked = itemClicked;

    }
    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.note_holder2,parent,false);
        this.parent = parent;

        return new NoteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        if (position == lastSelectedPosition){
            holder.roll.setTextColor(Color.parseColor("#000000"));
        }else {
            holder.roll.setTextColor(Color.parseColor("#FFFFFF"));
        }
        holder.roll.setText(note2s.get(position).getRoll());
        holder.name.setText(note2s.get(position).getName());
        holder.department.setText(note2s.get(position).getDepartment());
        holder.pass.setText(note2s.get(position).getPass());
        holder.mail.setText(note2s.get(position).getMail());
        holder.cgpa.setText(note2s.get(position).getCgpa());
        holder.contact.setText(note2s.get(position).getContact());
        holder.address.setText(note2s.get(position).getAddress());

    }

    @Override
    public int getItemCount() {
        return note2s.size();
    }

    class NoteHolder extends RecyclerView.ViewHolder{

        TextView roll;
        TextView name;
        TextView department;
        TextView pass;
        TextView mail;
        TextView cgpa;
        TextView contact;
        TextView address;
        ImageView imgEdit;
        public NoteHolder(@NonNull final View itemView) {
            super(itemView);

            roll = itemView.findViewById(R.id.txt_note_roll);
            name = itemView.findViewById(R.id.txt_note_name);
            department = itemView.findViewById(R.id.txt_note_department);
            pass = itemView.findViewById(R.id.txt_note_pass);
            mail = itemView.findViewById(R.id.txt_note_mail);
            cgpa = itemView.findViewById(R.id.txt_note_cgpa);
            contact = itemView.findViewById(R.id.txt_note_contact);
            address = itemView.findViewById(R.id.txt_note_address);

            itemView.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @Override
                public void onClick(View view) {
                    roll.setTextColor(Color.parseColor("#000000"));
                    lastSelectedPosition = getAdapterPosition();

                    if (department.getMaxLines() == 1){
                        department.setMaxLines(Integer.MAX_VALUE);
                    }else {
                        department.setMaxLines(1);
                    }
                    notifyDataSetChanged();
                    TransitionManager.beginDelayedTransition(parent);
                }
            });

        }
    }

    interface ItemClicked{
        void onClick(int postion, View view);
    }
}
