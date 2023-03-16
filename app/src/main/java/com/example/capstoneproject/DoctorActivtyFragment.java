package com.example.capstoneproject;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;



import java.util.ArrayList;

import com.example.capstoneproject.database.DoctorBaseHelper;


public class DoctorActivtyFragment extends Fragment{
    private Button doctorUpdateButton;
    private Button doctoreSearchButton;
    private Button doctorDeleteButton;
    private Button doctorViewButton;

    private EditText doctorNameEditText;
    private EditText doctorSpecialityEditText;
    private EditText doctorExperienceEditText;
    private EditText doctorPhoneEditText;
    private EditText consultancyFeeEditText;
    private static final String EXTRA_DOCTOR_NAME = "com.example.projectsecondpart.doctor_name";
    private static final String EXTRA_DOCTOR_SPECIALITY = "com.example.projectsecondpart.doctor_speciality";
    private static final String EXTRA_DOCTOR_EXPERIENCE = "com.example.projectsecondpart.doctor_experiences";
    private static final String EXTRA_DOCTOR_PHONE = "com.example.projectsecondpart.doctor_phone";
    private static final String EXTRA_CONSULTANCY_FEE = "com.example.projectsecondpart.consultant_feegrade_assignment3";

    int currentIndex = 0;

    private ArrayList<DoctorDetails> allDoctorArrayList;

    DoctorBaseHelper db;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DoctorBaseHelper(getActivity());
        fillBillingsArrayList();


    }
}
