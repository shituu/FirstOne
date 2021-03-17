package com.desigggggnn.firstone.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.desigggggnn.firstone.R;

public class RegisterActivity extends AppCompatActivity {

    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        btnSignUp = findViewById(R.id.btn_signUp);
//        btnSignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(RegisterActivity.this,HomeActivity.class);
//                startActivity(intent);
//
//            }
//        });


    }
}