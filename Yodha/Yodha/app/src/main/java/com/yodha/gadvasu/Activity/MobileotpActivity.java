package com.yodha.gadvasu.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.yodha.gadvasu.ApiResponsedata.ApiInterface;
import com.yodha.gadvasu.ApiResponsedata.Otpverification.OtpsendResponse;
import com.yodha.gadvasu.ApiResponsedata.Otpverification.OtpverifiedResponse;
import com.yodha.gadvasu.MainActivity;
import com.yodha.gadvasu.Otherdatacls.Sharepredata;
import com.yodha.gadvasu.R;

import java.util.Objects;

import in.aabhasjindal.otptextview.OtpTextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MobileotpActivity extends BaseActivity {
    private OtpTextView otpView;
    TextView TVverify, TVsetmobile;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobileotp);
        otpView = findViewById(R.id.otp_view);
        TVverify = findViewById(R.id.TVverify);
        TVsetmobile = findViewById(R.id.TVsetmobile);


        String mobilenum = getIntent().getStringExtra("mobile");
        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");

        if (mobilenum != null) {
            TVsetmobile.setText("+91" + mobilenum);
            sendotp(mobilenum, name, email);
        }

        otpView.setOnClickListener(view -> {

        });


        TVverify.setOnClickListener(view -> {
            String otp = Objects.requireNonNull(otpView.getOTP());
            Toast.makeText(MobileotpActivity.this, otp, Toast.LENGTH_SHORT).show();
            if (TextUtils.isEmpty(otp)) {
                Toast.makeText(MobileotpActivity.this, "Please enter OTP", Toast.LENGTH_SHORT).show();
            } else {
                sendotp(mobilenum, otp);
            }
        });


    }


    private void sendotp(String mobile, String name, String email) {
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
                        Toast.makeText(MobileotpActivity.this, "Mobile OTP send Successful !", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MobileotpActivity.this, "Something Went Wrong! Try After Sometimes.", Toast.LENGTH_SHORT).show();
                    }
                } else if (response.code() == 401) {
                    hideLoading();
                    Toast.makeText(MobileotpActivity.this, "Error", Toast.LENGTH_SHORT).show();
                } else {
                    hideLoading();
                    Toast.makeText(MobileotpActivity.this, "Error1*", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<OtpsendResponse> call, @NonNull Throwable t) {
                hideLoading();
                Toast.makeText(MobileotpActivity.this, "Exception" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void sendotp(String mobile, String otp) {
        showLoading();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface api = retrofit.create(ApiInterface.class);


        Call<OtpverifiedResponse> call = api.Verifyotp(mobile, otp);


        call.enqueue(new Callback<OtpverifiedResponse>() {
            @Override
            public void onResponse(@NonNull Call<OtpverifiedResponse> call, @NonNull Response<OtpverifiedResponse> response) {

                if (response.code() == 200) {
                    hideLoading();
                    assert response.body() != null;
                    if (response.body().isStatus()) {
                        sharepreference.setData(Sharepredata.USERID, String.valueOf(response.body().getData().getId()));
                        sharepreference.setData(Sharepredata.USERNAME, response.body().getData().getName());
                        sharepreference.setData(Sharepredata.USEREMAIL, response.body().getData().getEmail());
                        sharepreference.setData(Sharepredata.USERMOBILE, response.body().getData().getMobile());

                        Intent intent;
                        if (response.body().getData().getProfileCompleted() == 1) {
                            intent = new Intent(MobileotpActivity.this, MainActivity.class);
                            sharepreference.setBooleanData(Sharepredata.HAS_LOGIN,true);
                        } else {
                            intent = new Intent(MobileotpActivity.this, ComptprofileActivity.class);
                        }
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(MobileotpActivity.this, "Something Went Wrong! Try After Sometimes.", Toast.LENGTH_SHORT).show();
                    }
                } else if (response.code() == 401) {
                    hideLoading();
                    Toast.makeText(MobileotpActivity.this, "Error", Toast.LENGTH_SHORT).show();
                } else {
                    hideLoading();
                    Toast.makeText(MobileotpActivity.this, "Error1*", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<OtpverifiedResponse> call, @NonNull Throwable t) {
                hideLoading();
                Toast.makeText(MobileotpActivity.this, "Exception" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }


}