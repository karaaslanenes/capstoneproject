package com.example.capstoneproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class DoctorActivity extends AppCompatActivity {
   Fragment fragment;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        fragmentManager = getSupportFragmentManager();
        fragment = fragmentManager.findFragmentById(R.id.doctoractivity_fragment);
        if (fragment == null) {
            fragment=new DoctorActivtyFragment();
            fragmentManager.beginTransaction().add(R.id.doctoractivity_fragment, fragment).commit();
        }

    }


}