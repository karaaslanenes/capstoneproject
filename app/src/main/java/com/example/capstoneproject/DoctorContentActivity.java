package com.example.capstoneproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class DoctorContentActivity extends AppCompatActivity {
    private TextView contentTextView;
    private Button callWebServiceButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_doctor_content);
        // get the view of textviw
        contentTextView=(TextView) findViewById(R.id.contentdoctor_textView);
        // get the callwebservice button
        callWebServiceButton=(Button) findViewById(R.id.calldoctorwebservicesbutton);
        callWebServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // consuming android web services
                String uri="https://jsonplaceholder.typicode.com/todos/198";
                new AsyncHttpClient().get(uri, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        String strResponse=new String (responseBody);
                        contentTextView.setText(strResponse);
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        contentTextView.setText("error in calling web services");
                    }
                });
            }
        });
    }


}
