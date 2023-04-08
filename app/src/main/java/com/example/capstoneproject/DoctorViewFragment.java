package com.example.capstoneproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.capstoneproject.database.DoctorBaseHelper;
import com.example.projectv2.database.DoctorBaseHelper;

import java.util.ArrayList;

public class DoctorViewFragment extends Fragment {


    private TextView allList_text_view;
   DoctorBaseHelper db;
    ArrayList<DoctorDetails> arrayListDoctors;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DoctorBaseHelper(getActivity());
       arrayListDoctors = db.allDoctorRecords();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmnet_doctor_view, container, false);

        allList_text_view= (TextView) view.findViewById(R.id.allDoctor_text_view);
        allList_text_view.setText(arrayListDoctors.toString());

        return view;
    }

}
