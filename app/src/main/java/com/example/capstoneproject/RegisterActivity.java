package com.example.capstoneproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class RegisterActivity extends AppCompatActivity {
    private EditText regUserNameEditText, regPasswordEditText, regConfirmPassEditText, regEmailEditText;
    private Button registrationButton;
    private TextView regHaveAnAccountTetView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        regUserNameEditText = (EditText) findViewById(R.id.editTextRegistrationUsername);
        regPasswordEditText = (EditText) findViewById(R.id.editTextRegistrationPassword);
        regConfirmPassEditText = (EditText) findViewById(R.id.editTextRegistrationConfirmPassword);
        regEmailEditText = (EditText) findViewById(R.id.editTextRegistrationEmail);
        registrationButton = (Button) findViewById(R.id.Registerbutton);
        regHaveAnAccountTetView = (TextView) findViewById(R.id.HaveAnAccounttextView);

        regHaveAnAccountTetView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String regUserName = regUserNameEditText.getText().toString();
                String regEmail = regEmailEditText.getText().toString();
                String regPassword = regPasswordEditText.getText().toString();
                String regConfirmPassword = regConfirmPassEditText.getText().toString();

                if (regUserName.length() == 0 || regEmail.length() == 0 || regPassword.length() == 0 || regConfirmPassword.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill all the filed", Toast.LENGTH_SHORT).show();
                } else {
                    if (regPassword.compareTo(regConfirmPassword) == 0) {
                        if (isValid(regPassword)) {


                            Toast.makeText(getApplicationContext(), "Registered  Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, LoginActivty.class));
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Password must contain at least 8 characters including letter ,digits and special characters", Toast.LENGTH_SHORT).show();
                        }


                    } else {
                        Toast.makeText(getApplicationContext(), "Password and Confirm Password did not  match", Toast.LENGTH_SHORT).show();
                    }


                }

            }
        });


    }

    public static boolean isValid(String pswrd) {
        int flag1 = 0, flag2 = 0, flag3 = 0;
        if (pswrd.length() < 8) {
            return false;
        } else {
            for (int i = 0; i < pswrd.length(); i++) {
                if (Character.isLetter(pswrd.charAt(i))) {
                    flag1 = 1;
                }
            }
            for (int j = 0; j < pswrd.length(); j++) {
                if (Character.isDigit(pswrd.charAt(j))) {
                    flag2 = 1;
                }
            }
            for (int k = 0; k < pswrd.length(); k++) {
                char chr = pswrd.charAt(k);
                if (chr >= 33 && chr <= 47 || chr >= 58 && chr <= 64) {
                    flag3 = 1;
                }

            }
            if(flag1==1&&flag2==1&&flag3==1)
                return true;
            return false;


        }

    }
}


