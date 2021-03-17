package com.desigggggnn.firstone.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.desigggggnn.firstone.R;
import com.desigggggnn.firstone.model.LoginResponse;
import com.desigggggnn.firstone.network.ApiInterface;
import com.desigggggnn.firstone.network.RetrofitClient;

public class LoginActivity extends AppCompatActivity {

    EditText editTextEmail, editTextPassword;
    TextView textView;
    Button btn_signIn;
    ApiInterface apiInterface;
    CardView cardView;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        textView = findViewById(R.id.txt_signUp);
        editTextEmail = findViewById(R.id.edt_mobile);
        editTextPassword = findViewById(R.id.edt_password);
        btn_signIn = findViewById(R.id.btn_signIn);
        cardView = findViewById(R.id.cardView1);
        //apiInterface = ApiUtils.getApiInterface();

        btn_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                String device_id = " ";
                int type = 4;
                String social_key = " ";

               // validate form
                if (validateLogin(email, password)) {
                    //do login
                    doLogin(email, password,device_id,type,social_key);
                }

            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
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


    private boolean validateLogin(String email, String password) {
        if(email==null || email.trim().length()==0 ){
            Toast.makeText(this, "Email is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (editTextEmail.getText().toString().trim().matches(emailPattern)){
              if (password == null || password.trim().length() == 0) {
                Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
                return false;
            }
            } else{
                Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
            }


        return true;
    }

    private void doLogin(final String email, final String password, final String device_id,final int type,final String social_key) {
        Retrofit retrofit = RetrofitClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<LoginResponse> call = apiInterface.userLogin(email, password, device_id, type,social_key);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                LoginResponse obj = response.body();
                if(obj.getMessage().equals("User Data Found")) {

                    Log.e("api","==="+obj.getMessage());
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });



    }
}