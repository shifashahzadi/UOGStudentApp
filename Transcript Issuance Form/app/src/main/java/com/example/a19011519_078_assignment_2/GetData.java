package com.example.a19011519_078_assignment_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

public class GetData extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<IssuanceFormModel> dataHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);

        recyclerView = findViewById(R.id.receive);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Cursor cursor = new DBHelper2(this).getUserData();
        dataHolder = new ArrayList<>();

        //feed data from cursor to dataHolder

        while (cursor.moveToNext()){
            IssuanceFormModel obj = new IssuanceFormModel(cursor.getString(0),
                    cursor.getString(1), cursor.getString(2),
                    cursor.getString(3), cursor.getString(4),
                    cursor.getString(5), cursor.getString(6),
                    cursor.getString(7));

            dataHolder.add(obj);
        }
        IssuanceAdapter adaptor = new IssuanceAdapter(dataHolder);
        recyclerView.setAdapter(adaptor);

    }
}