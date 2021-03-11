package com.desigggggnn.firstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        textView = findViewById(R.id.txt_signUp);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });


//        textView = findViewById(R.id.txt_jajpal);
//
//        String text = "Jajpal Singh Jajji";
//        SpannableString ss = new SpannableString(text);
//
//        ForegroundColorSpan fcsOrange = new ForegroundColorSpan(Color.RED);
//        ForegroundColorSpan fcsGreen = new ForegroundColorSpan(Color.GREEN);
//
//        ss.setSpan(fcsOrange,1,12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        ss.setSpan(fcsGreen,13,17, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//
//        textView.setText(ss);

    }
}