package com.yodha.gadvasu.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.textfield.TextInputEditText;
import com.yodha.gadvasu.ApiResponsedata.ApiInterface;
import com.yodha.gadvasu.ApiResponsedata.Otpverification.OtpsendResponse;
import com.yodha.gadvasu.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignupActivity extends BaseActivity {
    TextInputEditText ETnamesignup, ETemailsignup, ETmobile;
    TextView TVsignup, TVlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ETnamesignup = findViewById(R.id.ETnamesignup);
        ETemailsignup = findViewById(R.id.ETemailsignup);
        ETmobile = findViewById(R.id.ETmobile);
        TVsignup = findViewById(R.id.TVsignup);
        TVlogin = findViewById(R.id.TVlogin);

        TVsignup.setOnClickListener(view -> {
            String username = String.valueOf(ETnamesignup.getText());
            String useemail = String.valueOf(ETemailsignup.getText());
            String usermobile = String.valueOf(ETmobile.getText());
            if (TextUtils.isEmpty(username)) {
                Toast.makeText(SignupActivity.this, "UserName is Required", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(useemail)) {
                Toast.makeText(SignupActivity.this, "Email is Required", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(useemail).matches()) {
                Toast.makeText(SignupActivity.this, "Enter valid Email address !", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(usermobile)) {
                Toast.makeText(SignupActivity.this, "Mobile Number is  Required", Toast.LENGTH_SHORT).show();
                return;
            }
            Signup(username, useemail, usermobile);
        });

        TVlogin.setOnClickListener(view -> {
            Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });

    }


    private void Signup(String name, String email, String mobile) {
        showLoading();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface api = retrofit.create(ApiInterface.class);

        Call<OtpsendResponse> call = api.getotp(name, email, mobile);


        call.enqueue(new Callback<OtpsendResponse>() {
            @Override
            public void onResponse(@NonNull Call<OtpsendResponse> call, @NonNull Response<OtpsendResponse> response) {

                if (response.code() == 200) {
                    hideLoading();
                    assert response.body() != null;
                    if (response.body().isStatus()) {
                        Intent intent = new Intent(SignupActivity.this, MobileotpActivity.class);
                        intent.putExtra("mobile",mobile);
                        intent.putExtra("name",name);
                        intent.putExtra("email",email);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(SignupActivity.this, "Something Went Wrong! Try After Sometimes.", Toast.LENGTH_SHORT).show();
                    }
                } else if (response.code() == 401) {
                    hideLoading();
                    Toast.makeText(SignupActivity.this, "Error", Toast.LENGTH_SHORT).show();
                } else {
                    hideLoading();
                    Toast.makeText(SignupActivity.this, "Error1*", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<OtpsendResponse> call, @NonNull Throwable t) {
                hideLoading();
                Toast.makeText(SignupActivity.this, "Exception" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }
}