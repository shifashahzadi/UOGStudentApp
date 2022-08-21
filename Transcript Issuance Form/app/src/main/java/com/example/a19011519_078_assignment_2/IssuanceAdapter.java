package com.example.a19011519_078_assignment_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class IssuanceAdapter extends RecyclerView.Adapter<IssuanceAdapter.myViewHolder> {

    ArrayList<IssuanceFormModel> dataHolder;

    public IssuanceAdapter(ArrayList<IssuanceFormModel> dataHolder) {
        this.dataHolder = dataHolder;
    }

    @NonNull
    @Override
    // convert xml to view
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.issuance_adapter,parent,false);
        return new myViewHolder(view);
    }

    @Override
    //set data in arraylist through references
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.sname.setText(dataHolder.get(position).getName());
        holder.fname.setText(dataHolder.get(position).getFather_Name());
        holder.rollno.setText(dataHolder.get(position).getRoll_Number());
        holder.degree.setText(dataHolder.get(position).getDegree());
        holder.regno.setText(dataHolder.get(position).getReg_No());
        holder.contact.setText(dataHolder.get(position).getContact());
        holder.cgpa.setText(dataHolder.get(position).getCGPA_Obt());
        holder.stu_sign.setText(dataHolder.get(position).getStu_Sign());

    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder
    {
        TextView sname,fname,rollno, degree, regno, contact, cgpa, stu_sign;
        public myViewHolder(@NonNull View itemView)
        {
            super(itemView);
            sname=(TextView)itemView.findViewById(R.id.studentame);
            fname=(TextView)itemView.findViewById(R.id.fathername);
            rollno=(TextView)itemView.findViewById(R.id.rollnumber);
            degree=(TextView)itemView.findViewById(R.id.degree);
            regno=(TextView)itemView.findViewById(R.id.registrationno);
            contact=(TextView)itemView.findViewById(R.id.contact);
            cgpa=(TextView)itemView.findViewById(R.id.cgpa);
            stu_sign=(TextView)itemView.findViewById(R.id.stusign);

        }
    }




}
