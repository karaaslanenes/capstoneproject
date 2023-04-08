package com.example.capstoneproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class DoctorViewActivity extends AppCompatActivity {


    FragmentManager fm;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_view);

        fm = getSupportFragmentManager();
        fragment = fm.findFragmentById(R.id.fragmnet_doctorview);

        if (fragment == null) {
            fragment = new DoctorViewFragment();
            fm.beginTransaction().add(R.id.fragmnet_doctorview, fragment).commit();
        }
    }
}
