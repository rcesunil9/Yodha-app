package com.yodha.gadvasu.Activity;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import com.airbnb.lottie.LottieAnimationView;
import com.yodha.gadvasu.ApiResponsedata.Animallistdetails.AnimallistdetdataResponse;
import com.yodha.gadvasu.ApiResponsedata.Animallistdetails.DataItem;
import com.yodha.gadvasu.ApiResponsedata.ApiInterface;
import com.yodha.gadvasu.Otherdatacls.Sharepredata;
import com.yodha.gadvasu.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MaterpedgriwdataActivity extends BaseActivity {
    LottieAnimationView animationView;
    NestedScrollView scrollView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materpedgriwdata);
        Toolbar TBtoolabar = findViewById(R.id.TBtoolrepdutanal);
        animationView = findViewById(R.id.animationView);
        scrollView1 = findViewById(R.id.scrollView1);

        setSupportActionBar(TBtoolabar);
        TBtoolabar.setNavigationOnClickListener(view -> finish());

        String userid = sharepreference.getData(Sharepredata.USERID);
        if (userid != null) {
            getanimalList(userid);
        }
    }

    @SuppressLint("SetTextI18n")
    public void init(List<DataItem> mlistdata) {
        TableLayout stk = findViewById(R.id.table_main);
        TableRow tbrow0 = new TableRow(this);
        tbrow0.setGravity(Gravity.CENTER);
        tbrow0.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f));
        tbrow0.setBackgroundResource(R.drawable.cellborder);

        TextView tv0 = new TextView(this);
        tv0.setText(" Animal_ID ");
        tv0.setTextColor(Color.BLACK);
        tv0.setTextSize(16);
        tv0.setPadding(4, 4, 4, 4);
        tv0.setGravity(Gravity.CENTER);
        tv0.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv0);

        TextView tv1 = new TextView(this);
        tv1.setText("    Sire_ID    ");
        tv1.setTextColor(Color.BLACK);
        tv1.setTextSize(16);
        tv1.setPadding(4, 4, 4, 4);
        tv1.setGravity(Gravity.CENTER);
        tv1.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv1);

        TextView tv2 = new TextView(this);
        tv2.setText("    Dam_ID    ");
        tv2.setTextColor(Color.BLACK);
        tv2.setTextSize(16);
        tv2.setGravity(Gravity.CENTER);
        tv2.setPadding(4, 4, 4, 4);
        tv2.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv2);

        TextView tv3 = new TextView(this);
        tv3.setText(" Animal_Sex ");
        tv3.setTextColor(Color.BLACK);
        tv3.setTextSize(16);
        tv3.setGravity(Gravity.CENTER);
        tv3.setPadding(4, 4, 4, 4);
        tv3.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv3);



        stk.addView(tbrow0);
        for (int i = 0; i < mlistdata.size(); i++) {
            TableRow tbrow = new TableRow(this);
            tbrow0.setGravity(Gravity.CENTER);
            tbrow0.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f));
            tbrow0.setBackgroundResource(R.drawable.cellborder);

            TextView t1v = new TextView(this);
            t1v.setText( mlistdata.get(i).getAnimalId() );
            t1v.setGravity(Gravity.CENTER);
            t1v.setTextColor(Color.BLACK);
            t1v.setTextSize(16);
            t1v.setPadding(8, 8, 8, 8);
            t1v.setBackgroundResource(R.drawable.cellborder);
            tbrow.addView(t1v);

            TextView t2v = new TextView(this);
            t2v.setText( mlistdata.get(i).getSireNo() );
            t2v.setGravity(Gravity.CENTER);
            t2v.setTextColor(Color.BLACK);
            t2v.setTextSize(16);
            t2v.setPadding(8, 8, 8, 8);
            t2v.setBackgroundResource(R.drawable.cellborder);
            tbrow.addView(t2v);

            TextView t3v = new TextView(this);
            t3v.setText( mlistdata.get(i).getDamNum() );
            t3v.setGravity(Gravity.CENTER);
            t3v.setTextColor(Color.BLACK);
            t3v.setTextSize(16);
            t3v.setPadding(8, 8, 8, 8);
            t3v.setBackgroundResource(R.drawable.cellborder);
            tbrow.addView(t3v);

            TextView t4v = new TextView(this);
            if (mlistdata.get(i).getSex() == 0) {
                t4v.setText(" Female ");
            } else if(mlistdata.get(i).getSex() == 1) {
                t4v.setText(" Male ");
            }else{
                t4v.setText(" Others ");
            }

            t4v.setTextColor(Color.BLACK);
            t4v.setTextSize(16);
            t4v.setPadding(8, 8, 8, 8);
            t4v.setBackgroundResource(R.drawable.cellborder);
            t4v.setGravity(Gravity.CENTER);
            tbrow.addView(t4v);


            stk.addView(tbrow);
        }

    }


    private void getanimalList(String userid) {
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

                        if (response.body().getData().size() == 0) {
                            scrollView1.setVisibility(View.GONE);
                            animationView.setVisibility(View.VISIBLE);
                        } else {
                            scrollView1.setVisibility(View.VISIBLE);
                            animationView.setVisibility(View.GONE);
                            init(response.body().getData());
                        }

                    } else {
                        Toast.makeText(MaterpedgriwdataActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        scrollView1.setVisibility(View.GONE);
                        animationView.setVisibility(View.VISIBLE);
                    }
                } else if (response.code() == 401) {
                    hideLoading();
                    Toast.makeText(MaterpedgriwdataActivity.this, "Something went wrong try after sometimes! ", Toast.LENGTH_SHORT).show();
                } else {
                    hideLoading();

                    Toast.makeText(MaterpedgriwdataActivity.this, "Error1*", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<AnimallistdetdataResponse> call, @NonNull Throwable t) {
                hideLoading();
                Toast.makeText(MaterpedgriwdataActivity.this, "Try after sometimes!" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }

}