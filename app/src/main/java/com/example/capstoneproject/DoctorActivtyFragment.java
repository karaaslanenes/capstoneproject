package com.example.capstoneproject;

import android.widget.Button;
import android.widget.EditText;

import com.example.capstoneproject.database.DoctorBaseHelper;

import java.util.ArrayList;

public class DoctorActivtyFragment {
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

}
