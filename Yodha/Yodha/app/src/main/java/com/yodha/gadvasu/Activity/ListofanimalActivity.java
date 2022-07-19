package com.yodha.gadvasu.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.yodha.gadvasu.Adapter.ListofanimalAdapter;
import com.yodha.gadvasu.ApiResponsedata.AnimalIDdata.AnimalidResponse;
import com.yodha.gadvasu.ApiResponsedata.Animallistdetails.AnimallistdetdataResponse;
import com.yodha.gadvasu.ApiResponsedata.ApiInterface;
import com.yodha.gadvasu.Otherdatacls.Sharepredata;
import com.yodha.gadvasu.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListofanimalActivity extends BaseActivity {
    RecyclerView RLlistofanimal;
    ListofanimalAdapter listofanimalAdapter;
    LottieAnimationView animationView;
    TextView TVanimaliddelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listofanimal);
        Toolbar TBtoolabar = findViewById(R.id.TBtoollistofanimal);
        RLlistofanimal = findViewById(R.id.RLlistofanimal);
        animationView = findViewById(R.id.animationView);
        TVanimaliddelete = findViewById(R.id.TVanimaliddelete);
        setSupportActionBar(TBtoolabar);

        TBtoolabar.setNavigationOnClickListener(view -> finish());

        String userid = sharepreference.getData(Sharepredata.USERID);
        String username = sharepreference.getData(Sharepredata.USERNAME);
        if (userid != null) {
            getanimalList(userid,username);
        }

        TVanimaliddelete.setOnClickListener(view -> {
            Intent intent = new Intent(ListofanimalActivity.this,MaterpedgriwdataActivity.class);
            startActivity(intent);
            finish();
        });

    }



    private void getanimalList(String userid,String username) {
        showLoading();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface api = retrofit.create(ApiInterface.class);


        Call<AnimallistdetdataResponse> call = api.getanimallistdata(userid);


        call.enqueue(new Callback<AnimallistdetdataResponse>() {
            @Override
            public void onResponse(@NonNull Call<AnimallistdetdataResponse> call, @NonNull Response<AnimallistdetdataResponse> response) {

                if (response.code() == 200) {
                    hideLoading();
                    assert response.body() != null;
                    if (response.body().isStatus()) {

                        if(response.body().getData().size() == 0){
                            RLlistofanimal.setVisibility(View.GONE);
                            animationView.setVisibility(View.VISIBLE);
                        }else {
                            RLlistofanimal.setVisibility(View.VISIBLE);
                            animationView.setVisibility(View.GONE);
                            listofanimalAdapter = new ListofanimalAdapter(new ListofanimalActivity(),ListofanimalActivity.this, response.body().getData(), userid, username);
                            RLlistofanimal.setAdapter(listofanimalAdapter);
                        }

                    } else {
                        animationView.setVisibility(View.VISIBLE);
                        Toast.makeText(ListofanimalActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }
                } else if (response.code() == 401) {
                    hideLoading();
                    Toast.makeText(ListofanimalActivity.this, "Something went wrong try after sometimes!", Toast.LENGTH_SHORT).show();
                } else {
                    hideLoading();
                    animationView.setVisibility(View.VISIBLE);
                    Toast.makeText(ListofanimalActivity.this, "Error1*", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<AnimallistdetdataResponse> call, @NonNull Throwable t) {
                hideLoading();
                Toast.makeText(ListofanimalActivity.this, "Exception" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }
}