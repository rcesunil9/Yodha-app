package com.yodha.gadvasu.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.yodha.gadvasu.ApiResponsedata.ApiInterface;
import com.yodha.gadvasu.ApiResponsedata.Logindata.LoginResponse;
import com.yodha.gadvasu.MainActivity;
import com.yodha.gadvasu.Otherdatacls.Sharepredata;
import com.yodha.gadvasu.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends BaseActivity {
    TextView TVsignup, TVlogin;
    TextInputEditText ETmobile;
    TextInputLayout TILemaillogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TVsignup = findViewById(R.id.TVsignup);
        TVlogin = findViewById(R.id.TVlogin);
        ETmobile = findViewById(R.id.ETmobile);
        TILemaillogin = findViewById(R.id.TILemaillogin);



        TVsignup.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(intent);
            finish();
        });

        TVlogin.setOnClickListener(view -> {
            String usermobile = String.valueOf(ETmobile.getText());

            if (TextUtils.isEmpty(usermobile)) {
                 Toast.makeText(LoginActivity.this, "Mobile Number is  Required", Toast.LENGTH_SHORT).show();
                return;
            }
            if(usermobile.length() < 10){
                Toast.makeText(LoginActivity.this, "Mobile Number is  Not Correct!", Toast.LENGTH_SHORT).show();
                return;
            }
            else {
                Toast.makeText(LoginActivity.this, usermobile, Toast.LENGTH_SHORT).show();
               Login(usermobile);
            }
        });


    }


    private void Login(String mobile) {
        showLoading();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface api = retrofit.create(ApiInterface.class);
        //RequestBody Rmobile = RequestBody.create(MediaType.parse("text/plain"), mobile);

        Call<LoginResponse> call = api.getLogin(mobile);


        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {

                if (response.code() == 200) {
                    hideLoading();
                    assert response.body() != null;
                    if(response.body().isStatus()) {
                        sharepreference.setData(Sharepredata.USERNAME, response.body().getData().getName());
                        sharepreference.setData(Sharepredata.USEREMAIL, response.body().getData().getEmail());
                        sharepreference.setData(Sharepredata.USERMOBILE, String.valueOf(response.body().getData().getMobile()));
                        sharepreference.setData(Sharepredata.COMPLETE_PROFILE,String.valueOf(response.body().getData().getProfileCompleted()));
                        sharepreference.setData(Sharepredata.USERID,String.valueOf(response.body().getData().getId()));
                        sharepreference.setData(Sharepredata.GENDER,String.valueOf(response.body().getData().getGender()));
                        sharepreference.setData(Sharepredata.EDUCATION,response.body().getData().getEducation());
                        sharepreference.setData(Sharepredata.FARMNAME,response.body().getData().getFarmName());
                        sharepreference.setData(Sharepredata.FARMSIZE,String.valueOf(response.body().getData().getFarmSize()));
                        sharepreference.setData(Sharepredata.STREET,String.valueOf(response.body().getData().getStreet()));
                        sharepreference.setData(Sharepredata.CITY,response.body().getData().getTown());
                        sharepreference.setData(Sharepredata.DISTRIC,response.body().getData().getDistrict());
                        sharepreference.setData(Sharepredata.STATE,response.body().getData().getState());
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("mobile",mobile);
                        intent.putExtra("name",response.body().getData().getName());
                        intent.putExtra("email",response.body().getData().getEmail());
                        startActivity(intent);
                    } else {
                        hideLoading();
                        Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                        startActivity(intent);
                        // Toast.makeText(LoginActivity.this, "Something Went Wrong! Try After Sometimes.", Toast.LENGTH_SHORT).show();
                    }
                    finish();
                } else if (response.code() == 401) {
                    hideLoading();
                    Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_SHORT).show();
                } else {
                    hideLoading();
                    Toast.makeText(LoginActivity.this, "Error1*", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                hideLoading();
                Toast.makeText(LoginActivity.this, "Exception" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }


        }