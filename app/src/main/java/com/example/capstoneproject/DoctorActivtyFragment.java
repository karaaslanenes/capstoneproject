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


public class DoctorActivtyFragment extends Fragment {
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

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_doctoractivty, container, false);

        doctorNameEditText = (EditText) v.findViewById(R.id.DoctorInfoUDNameeditText);
        doctorNameEditText.setText(allDoctorArrayList.get(currentIndex).getDoctor_name());

        doctorSpecialityEditText = (EditText) v.findViewById(R.id.DoctorInfoUDSpecialityeditText);
        doctorSpecialityEditText.setText(allDoctorArrayList.get(currentIndex).getDoctor_speciality());

        doctorExperienceEditText = (EditText) v.findViewById(R.id.DoctorInfoUDExperinceeditText);
        doctorExperienceEditText.setText(allDoctorArrayList.get(currentIndex).getDoctor_experiences());

        doctorPhoneEditText = (EditText) v.findViewById(R.id.DocotorInfoUDPhoneeditText);
        doctorPhoneEditText.setText(allDoctorArrayList.get(currentIndex).getDoctor_phone());

        consultancyFeeEditText = (EditText) v.findViewById(R.id.DoctorInfoUDFeeeditText);
        consultancyFeeEditText.setText(allDoctorArrayList.get(currentIndex).getConsultant_fee());
        doctorUpdateButton=(Button) v.findViewById(R.id.Updatebutton);
        doctorUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DoctorDetails updatedDoctor = new DoctorDetails(doctorNameEditText.getText().toString(), doctorSpecialityEditText.getText().toString(),
                        doctorExperienceEditText.getText().toString(),
                        doctorPhoneEditText.getText().toString(),consultancyFeeEditText.getText().toString());

                boolean success = db.upDateDoctor(updatedDoctor);
                if (success) {
                    Toast.makeText(getActivity(), "Update Success: "+success, Toast.LENGTH_SHORT).show();
                    //TODO: go back to mainActivity
                } else {
                    Toast.makeText(getActivity(), "Update no Success: "+success, Toast.LENGTH_SHORT).show();
                }
            }
        });
        doctoreSearchButton=(Button) v.findViewById(R.id.searchButton);
        doctoreSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DoctorDetails researhers = db.searchDoctor(doctorNameEditText.getText().toString());
                if (researhers != null){
                    doctorNameEditText.setText(researhers.getDoctor_name());
                    doctorSpecialityEditText.setText(researhers.getDoctor_speciality());
                    doctorExperienceEditText.setText(researhers.getDoctor_experiences());
                    doctorPhoneEditText.setText(researhers.getDoctor_phone());
                    consultancyFeeEditText.setText(researhers.getConsultant_fee());
                } else {
                    doctorSpecialityEditText.setText("Doctor not found");
                    doctorExperienceEditText.setText("");
                    doctorPhoneEditText.setText("");
                    consultancyFeeEditText.setText("");
                }
            }

        });

        doctorDeleteButton=(Button) v.findViewById(R.id.deletebutton);
        doctorDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean success = db.deleteDoctor(doctorNameEditText.getText().toString());
                if (success) {
                    Toast.makeText(getActivity(), "Success: "+success, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    getActivity().startActivity(intent);
                } else {
                    Toast.makeText(getActivity(), "Success: "+success, Toast.LENGTH_SHORT).show();
                }

            }
        });

        return v;


    }
    protected void fillBillingsArrayList() {
        allDoctorArrayList = db.allDoctorRecords();
    }


}