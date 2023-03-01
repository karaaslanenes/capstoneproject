package com.example.capstoneproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragmnet_doctor,container,false);
        Toolbar doctortoolbar=(Toolbar) v.findViewById(R.id.doctortoolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(doctortoolbar);


        doctorDetailText_view = (TextView) v.findViewById(R.id.DoctorInfotextView);
        doctorDetailText_view.setText("Name :" + allDoctorArrayList.get(currentIndex).getDoctor_name() + " /" + "Speciality :" + allDoctorArrayList.get(currentIndex).getDoctor_speciality() + " /" + "Exp:" + allDoctorArrayList.get(currentIndex).getDoctor_experiences() + " /" + "Phone:" + allDoctorArrayList.get(currentIndex).getDoctor_phone() + " /" + "Conslt_fee :" + allDoctorArrayList.get(currentIndex).getConsultant_fee());

        nextDoctorButton = (Button) v.findViewById(R.id.DoctorNextButton);
        nextDoctorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = (currentIndex + 1) % allDoctorArrayList.size();
                doctorDetailText_view.setText("Name :" + allDoctorArrayList.get(currentIndex).getDoctor_name() + " /" + "Speciality :" + allDoctorArrayList.get(currentIndex).getDoctor_speciality() + " /" + "Exp:" + allDoctorArrayList.get(currentIndex).getDoctor_experiences() + " /" + "Phone:" + allDoctorArrayList.get(currentIndex).getDoctor_phone() + " /" + "Conslt_fee :" + allDoctorArrayList.get(currentIndex).getConsultant_fee());


            }
        });

        previousDoctorButton = (Button) v.findViewById(R.id.DoctorPreviousregisterbutton);
        previousDoctorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = (currentIndex + (allDoctorArrayList.size()- 1)) % allDoctorArrayList.size();
                doctorDetailText_view.setText("Name :" + allDoctorArrayList.get(currentIndex).getDoctor_name() + " /" + "Speciality :" + allDoctorArrayList.get(currentIndex).getDoctor_speciality() + " /" + "Exp:" + allDoctorArrayList.get(currentIndex).getDoctor_experiences() + " /" + "Phone:" + allDoctorArrayList.get(currentIndex).getDoctor_phone() + " /" + "Conslt_fee :" +allDoctorArrayList.get(currentIndex).getConsultant_fee());
            }
        });
        updateDetailsButton = (Button) v.findViewById(R.id.DocotorUpdateRegisterbutton);
        updateDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DoctorActivity.class);
                intent.putExtra( EXTRA_DOCTOR_NAME, allDoctorArrayList.get(currentIndex).getDoctor_name());
                getActivity().startActivity(intent);

            }
        });
        booking=(Button) v.findViewById(R.id.docotorBookingbutton);
        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),AppointmnetActivity.class);
                intent.putExtra( EXTRA_DOCTOR_NAME, allDoctorArrayList.get(currentIndex).getDoctor_name());
                getActivity().startActivity(intent);
            }
        });
        return v;



    }
    protected void fillBillingsArrayList() {
        allDoctorArrayList = db.allDoctorRecords();
    }


    }
