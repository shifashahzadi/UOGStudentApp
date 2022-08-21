package com.example.a19011519_078_assignment_2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper2 extends SQLiteOpenHelper {
    public DBHelper2(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table UserDetails (Name TEXT primary key, FatherName TEXT, RollNumber TEXT, Degree TEXT," +
                "RegNo TEXT,  Contact TEXT, CGPAObt TEXT, StuSign TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
        DB.execSQL("drop table if exists UserDetails");
    }


    public boolean insertUserData(String SName, String FName,
                                  String RollNo,
                                  String Deg,
                                  String RegNo,
                                  String ContactNo,
                                  String CGPA,
                                  String StuSign){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("Name", SName);
        contentValues.put("FatherName", FName);
        contentValues.put("RollNumber", RollNo);
        contentValues.put("Degree", Deg);
        contentValues.put("RegNo", RegNo);
        contentValues.put("Contact", ContactNo);
        contentValues.put("CGPAObt", CGPA);
        contentValues.put("StuSign", StuSign);
        long result = MyDB.insert("UserDetails", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Boolean updateUserData(String SName, String FName,
                                  String RollNo,
                                  String Deg,
                                  String RegNo,
                                  String ContactNo,
                                  String CGPA,
                                  String StuSign) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("FatherName", FName);
        contentValues.put("RollNumber", RollNo);
        contentValues.put("Degree", Deg);
        contentValues.put("RegNo", RegNo);
        contentValues.put("Contact", ContactNo);
        contentValues.put("CGPAObt", CGPA);
        contentValues.put("StuSign", StuSign);

        Cursor cursor = DB.rawQuery("Select * from UserDetails where Name = ?", new String[]{SName});
        if (cursor.getCount() > 0) {
            long result = DB.update("UserDetails", contentValues, "Name=?", new String[]{SName});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }


    public Boolean deleteUserData(String SName) {
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("Select * from UserDetails where Name = ?", new String[]{SName});
        if (cursor.getCount() > 0) {
            long result = DB.delete("UserDetails",  "Name=?", new String[]{SName});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor getUserData() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from UserDetails ", null);
        return cursor;
    }
}