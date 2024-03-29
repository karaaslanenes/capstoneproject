package com.example.capstoneproject;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.capstoneproject.database.DoctorBaseHelper;


import java.util.ArrayList;
import java.util.Calendar;

public class AppointmentActivityFragmnet extends Fragment {
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    private Button dateButton;
    private Button timeButton;
    private Button backbutton;
    private Button bookingApp;
    private Button doctorUpdateButton;
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


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmnet_appoitnment, container, false);


        doctorNameEditText = (EditText) v.findViewById(R.id.APPDoctorNameeditText);
        doctorNameEditText.setText(allDoctorArrayList.get(currentIndex).getDoctor_name());

        doctorSpecialityEditText = (EditText) v.findViewById(R.id.APPDoctorSpecialityeditText);
        doctorSpecialityEditText.setText(allDoctorArrayList.get(currentIndex).getDoctor_speciality());

        doctorExperienceEditText = (EditText) v.findViewById(R.id.APPDoctorExperinceeditText);
        doctorExperienceEditText.setText(allDoctorArrayList.get(currentIndex).getDoctor_experiences());

        doctorPhoneEditText = (EditText) v.findViewById(R.id.APPDocotorPhoneeditText);
        doctorPhoneEditText.setText(allDoctorArrayList.get(currentIndex).getDoctor_phone());

        consultancyFeeEditText = (EditText) v.findViewById(R.id.APPDoctorFeeeditText);
        consultancyFeeEditText.setText(allDoctorArrayList.get(currentIndex).getConsultant_fee());

        bookingApp=(Button) v.findViewById(R.id.APPBookbutton);
        bookingApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Your appointment with "+allDoctorArrayList.get(currentIndex).getDoctor_name()+ " has been scheduled ",Toast.LENGTH_SHORT).show();
            }
        });

        backbutton=(Button) v.findViewById(R.id.APPbACKebutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),MainActivity.class));
            }
        });


        dateButton=(Button) v.findViewById(R.id.AppDatebutton);
        timeButton=(Button) v.findViewById(R.id.AppSelectTimebutton);
        innitDatePicker();
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });

        innitTimePicker();
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show();
            }
        });
        return v;
    }

    private void innitDatePicker(){

        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1=i1+1;
                dateButton.setText(i2+"/"+i1+"/"+i);
            }
        };
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DAY_OF_MONTH);

        int design= AlertDialog.THEME_HOLO_LIGHT;
        datePickerDialog=new DatePickerDialog(getActivity(),design,dateSetListener,year,month,day);
        datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis()+86400000);

    }
    private void innitTimePicker(){
        TimePickerDialog.OnTimeSetListener timeSetListener=new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {

                timeButton.setText(i+":"+i1);
            }
        };

        Calendar calendar=Calendar.getInstance();
        int hours=calendar.get(Calendar.HOUR);
        int mins=calendar.get(Calendar.MINUTE);


        int design= AlertDialog.THEME_HOLO_LIGHT;
        timePickerDialog=new TimePickerDialog(getActivity(),design,timeSetListener,hours,mins,true);

    }
    protected void fillBillingsArrayList() {
        allDoctorArrayList = db.allDoctorRecords();
    }




}
