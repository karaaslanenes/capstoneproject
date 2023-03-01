package com.example.capstoneproject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.capstoneproject.database.DoctorBaseHelper;

import java.util.ArrayList;

public class DoctorFragment extends Fragment {

    private TextView doctorDetailText_view;
    private Button nextDoctorButton;
    private Button previousDoctorButton;
    private Button updateDetailsButton;
    private Button booking;
    private int  currentIndex=0;
    public static final String TAG="Health Project";
    public static final String KEY_INDEX="index";
    public static final String EXTRA_DOCTOR_NAME = "com.example.projectv2.doctor_name";

    private ArrayList<DoctorDetails> allDoctorArrayList;
    DoctorBaseHelper db;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
        db = new DoctorBaseHelper(getActivity());

        db.addDoctor(new DoctorDetails("ELLY BROWN","FAMILY DOCTOR","10 YRS","5432134545","150$"));
        db.addDoctor(new DoctorDetails("MARRY JANE","FAMILY DOCTOR","6 YRS","5456789098","150$"));
        db.addDoctor(new DoctorDetails("SAAD ELKELAM","SURGEON","15 YRS","5472194545","250$"));
        db.addDoctor(new DoctorDetails("ISABELLE DUBOIS","DENTIST","6 YRS","543214545","125$"));
        db.addDoctor( new DoctorDetails("YANNICK TREMBLAY","DERMATOLOGY","9YRS","5672134545","140$"));
        db.addDoctor(new DoctorDetails("SUZAN MCALLY","DIETITIAN","3 YRS","4389345678","100$"));
        db.addDoctor(new DoctorDetails("YUNG MI","DENTIST","5 YRS","543214534","150$"));

    }
}
