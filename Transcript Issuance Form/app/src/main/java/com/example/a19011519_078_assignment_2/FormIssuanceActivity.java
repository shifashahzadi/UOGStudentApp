package com.example.a19011519_078_assignment_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormIssuanceActivity extends AppCompatActivity {

    EditText name, father_name, roll_no,degree,reg_no,contact,cgpa, stu_sign;
    Button insert,update,delete,view;
    DBHelper2 DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_issuance);

        name = findViewById(R.id.et_name);
        father_name = findViewById(R.id.et_f_name);
        roll_no = findViewById(R.id.et_roll_no);
        degree = findViewById(R.id.et_degree);
        reg_no = findViewById(R.id.et_reg_no);
        contact = findViewById(R.id.et_contact);
        cgpa =  findViewById(R.id.et_cgpa);
        stu_sign =  findViewById(R.id.et_stu_sign);


        insert = findViewById(R.id.btnInsert);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);


        DB = new DBHelper2(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Sname = name.getText().toString();
                String Fname = father_name.getText().toString();
                String Rollno = roll_no.getText().toString();
                String Deg = degree.getText().toString();
                String Reg = reg_no.getText().toString();
                String Cont = contact.getText().toString();
                String CGPA = cgpa.getText().toString();
                String Stusign = stu_sign.getText().toString();

                Boolean checkinsertdata = DB.insertUserData(Sname,Fname,Rollno,Deg,Reg,Cont,CGPA,Stusign);
                if (checkinsertdata == true)
                    Toast.makeText(FormIssuanceActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(FormIssuanceActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Sname = name.getText().toString();
                String Fname = father_name.getText().toString();
                String Rollno = roll_no.getText().toString();
                String Deg = degree.getText().toString();
                String Reg = reg_no.getText().toString();
                String Cont = contact.getText().toString();
                String CGPA = cgpa.getText().toString();
                String Stusign = stu_sign.getText().toString();

                Boolean checkupdatedata = DB.updateUserData(Sname,Fname,Rollno,Deg,Reg,Cont,CGPA,Stusign);
                if (checkupdatedata == true)
                    Toast.makeText(FormIssuanceActivity.this, " Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(FormIssuanceActivity.this, " Entry Not Updated", Toast.LENGTH_SHORT).show();

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Sname = name.getText().toString();


                Boolean checkdeletedata = DB.deleteUserData(Sname);
                if (checkdeletedata == true)
                    Toast.makeText(FormIssuanceActivity.this, " Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(FormIssuanceActivity.this, " Entry Not Deleted", Toast.LENGTH_SHORT).show();

            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB.getUserData();
                if(res.getCount()==0)
                {
                    Toast.makeText(FormIssuanceActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext())
                {
                    buffer.append("Name :"+res.getString(0)+"\n");
                    buffer.append("Father Name :"+res.getString(1)+"\n");
                    buffer.append("Roll Number :"+res.getString(2)+"\n");
                    buffer.append("Degree :"+res.getString(3)+"\n");
                    buffer.append("Registration Number :"+res.getString(4)+"\n");
                    buffer.append("Contact :"+res.getString(5)+"\n");
                    buffer.append("CGPA :"+res.getString(6)+"\n");
                    buffer.append("Student Signature :"+res.getString(7)+"\n\n");

                }

                AlertDialog.Builder builder = new AlertDialog.Builder(FormIssuanceActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Transcript Issuance Form");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }

    public void onClickGetData(View view) {

        startActivity(new Intent(getApplicationContext(), GetData.class));
    }
}