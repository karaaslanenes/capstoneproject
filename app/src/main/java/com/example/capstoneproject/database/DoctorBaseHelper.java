package com.example.capstoneproject.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.capstoneproject.DoctorDetails;
import com.example.capstoneproject.database.DoctorDbSchema.DoctorTable;

import java.util.ArrayList;

public class DoctorBaseHelper extends SQLiteOpenHelper {
    public static final int VERSION=1;
    public static final String DATABASE_NAME="doctor.db";
    public DoctorBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + DoctorTable.NAME + "(" +
                DoctorTable.Cols.DOCTOR_NAME + " TEXT , " +
                DoctorTable.Cols.DOCTOR_SPECIALITY+ " TEXT, " +
                DoctorTable.Cols.DOCTOR_EXPERIENCES + " TEXT, " +
                DoctorTable.Cols.DOCTOR_PHONE + " TEXT, " +
                DoctorTable.Cols.CONSULTANT_FEE+" TEXT)"
        );


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    private static ContentValues getContentValues(DoctorDetails doctorDetails){
        ContentValues values = new ContentValues();
//        values.put(BillingTable.Cols.CLIENT_ID, bill.getClient_id());
        values.put( DoctorTable.Cols.DOCTOR_NAME,doctorDetails.getDoctor_name());
        values.put(DoctorTable.Cols.DOCTOR_SPECIALITY, doctorDetails.getDoctor_speciality());
        values.put(DoctorTable.Cols.DOCTOR_EXPERIENCES, doctorDetails.getDoctor_experiences());
        values.put(DoctorTable.Cols.DOCTOR_PHONE, doctorDetails.getDoctor_phone());
        values.put(DoctorTable.Cols.CONSULTANT_FEE, doctorDetails.getConsultant_fee());
        return values;
    }

    public boolean addDoctor(DoctorDetails doctorDetails){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = getContentValues(doctorDetails);
        long insert = db.insert(DoctorTable.NAME, null, values);
        db.close();
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean upDateDoctor(DoctorDetails doctorDetails){
        SQLiteDatabase db = this.getWritableDatabase();

        String doctor_name = String.valueOf(doctorDetails.getDoctor_name());
        ContentValues values = getContentValues(doctorDetails);
        int update = db.update(DoctorTable.NAME, values, DoctorTable.Cols.DOCTOR_NAME + " =?", new String[]{doctor_name});
        db.close();
        if (update > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteDoctor(String doctor_name){
        SQLiteDatabase db = this.getWritableDatabase();

        int delete = db.delete(DoctorTable.NAME, DoctorTable.Cols.DOCTOR_NAME + " =?", new String[]{doctor_name});
        db.close();
        if (delete > 0) {
            return true;
        } else {
            return false;
        }
    }

}
