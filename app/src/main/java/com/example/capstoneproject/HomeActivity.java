package com.example.capstoneproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HomeActivity extends AppCompatActivity {

private CardView logOut;
    private CardView findDocs;
    private CardView bookings;
    private CardView startMusic;
    private CardView  stopMusic;
    private CardView articles;
    private CardView webService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);//to avoid from having null pointer exception

        //to show users name on the screen
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefers", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "").toString();

        Toast.makeText(getApplicationContext(), "Welcome  " + username, Toast.LENGTH_SHORT).show();

         logOut=(CardView) findViewById(R.id.cardViewReturn3);
//         try {
//             logOut.setOnClickListener(new View.OnClickListener() {
//                 @Override
//                 public void onClick(View view) {
//
//                     // to clear the local memory
//                     SharedPreferences.Editor editor=sharedPreferences.edit();
//                     editor.clear();
//                     editor.apply();
//                     startActivity(new Intent(HomeActivity.this, LoginActivity2.class));
//                 }
//             });
//         }catch ( NullPointerException e){
//
//         }

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // to clear the local memory
                SharedPreferences.Editor editor=sharedPreferences.edit();
               editor.clear();
               editor.apply();
                startActivity(new Intent(HomeActivity.this, LoginActivty.class));
            }
        });
        findDocs=(CardView) findViewById(R.id.cardViewFindDoctor);
        findDocs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,MainActivity.class));
            }
        });
    bookings=(CardView) findViewById(R.id.cardViewOrderDetails);
    bookings.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(HomeActivity.this,DoctorContentActivity.class));
        }
    });
    startMusic=(CardView) findViewById(R.id.cardViewStartMusic);
    startMusic.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            startService(new Intent(HomeActivity.this,DoctorService.class));

        }
    });


        stopMusic=(CardView) findViewById(R.id.cardViewStopMusic);
        stopMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent(HomeActivity.this,DoctorService.class));
            }
        });

        articles=(CardView) findViewById(R.id.cardViewArticles);
        articles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.icm-mhi.org/en/prevention/adopt-healthy-lifestyle"));
                startActivity(intent);

            }
        });



   }
}