package com.example.capstoneproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class AppointmnetActivity extends AppCompatActivity {
    Fragment fragment;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointmnet);

        fragmentManager = getSupportFragmentManager();
        fragment = fragmentManager.findFragmentById(R.id.appointmentactivity_fragment);

        if (fragment == null) {
            fragment=new AppointmentActivityFragmnet();
            fragmentManager.beginTransaction().add(R.id.appointmentactivity_fragment, fragment).commit();
        }

    }


}