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
import com.yodha.gadvasu.ApiResponsedata.ApiInterface;
import com.yodha.gadvasu.ApiResponsedata.Reproductiondetails.DataItem;
import com.yodha.gadvasu.ApiResponsedata.Reproductiondetails.ReproductionDetailsResponse;
import com.yodha.gadvasu.Otherdatacls.Sharepredata;
import com.yodha.gadvasu.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ReproductionAnalaysisActivity extends BaseActivity {

  LottieAnimationView animationView;
  NestedScrollView scrollView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproduction_analaysis);
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
        tv1.setText(" 1st AI Straw no ");
        tv1.setTextColor(Color.BLACK);
        tv1.setTextSize(16);
        tv1.setPadding(4, 4, 4, 4);
        tv1.setGravity(Gravity.CENTER);
        tv1.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv1);

        TextView tv2 = new TextView(this);
        tv2.setText(" 1st AI Breed ");
        tv2.setTextColor(Color.BLACK);
        tv2.setTextSize(16);
        tv2.setGravity(Gravity.CENTER);
        tv2.setPadding(4, 4, 4, 4);
        tv2.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv2);

        TextView tv3 = new TextView(this);
        tv3.setText(" Date 1st AI ");
        tv3.setTextColor(Color.BLACK);
        tv3.setTextSize(16);
        tv3.setGravity(Gravity.CENTER);
        tv3.setPadding(4, 4, 4, 4);
        tv3.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv3);

        TextView tv4 = new TextView(this);
        tv4.setText(" Animal Again in heat(Y/N) ");
        tv4.setTextColor(Color.BLACK);
        tv4.setTextSize(16);
        tv4.setGravity(Gravity.CENTER);
        tv4.setPadding(4, 4, 4, 4);
        tv4.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv4);

        TextView tv5 = new TextView(this);
        tv5.setText(" 2nd AI Straw no ");
        tv5.setTextColor(Color.BLACK);
        tv5.setTextSize(16);
        tv5.setGravity(Gravity.CENTER);
        tv5.setPadding(4, 4, 4, 4);
        tv5.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv5);

        TextView tv6 = new TextView(this);
        tv6.setText(" 2nd AI Breed ");
        tv6.setTextColor(Color.BLACK);
        tv6.setTextSize(16);
        tv6.setGravity(Gravity.CENTER);
        tv6.setPadding(4, 4, 4, 4);
        tv6.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv6);

        TextView tv7 = new TextView(this);
        tv7.setText(" Date 2nd AI ");
        tv7.setTextColor(Color.BLACK);
        tv7.setTextSize(16);
        tv7.setGravity(Gravity.CENTER);
        tv7.setPadding(4, 4, 4, 4);
        tv7.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv7);

        TextView tv8 = new TextView(this);
        tv8.setText(" Animal Again in heat(Y/N) ");
        tv8.setTextColor(Color.BLACK);
        tv8.setTextSize(16);
        tv8.setGravity(Gravity.CENTER);
        tv8.setPadding(4, 4, 4, 4);
        tv8.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv8);

        TextView tv9 = new TextView(this);
        tv9.setText(" 3rd AI Straw no ");
        tv9.setTextColor(Color.BLACK);
        tv9.setTextSize(16);
        tv9.setGravity(Gravity.CENTER);
        tv9.setPadding(4, 4, 4, 4);
        tv9.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv9);

        TextView tv10 = new TextView(this);
        tv10.setText(" 3rd AI Breed ");
        tv10.setTextColor(Color.BLACK);
        tv10.setTextSize(16);
        tv10.setGravity(Gravity.CENTER);
        tv10.setPadding(4, 4, 4, 4);
        tv10.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv10);

        TextView tv11 = new TextView(this);
        tv11.setText(" Date 3rd AI ");
        tv11.setTextColor(Color.BLACK);
        tv11.setTextSize(16);
        tv11.setPadding(4, 4, 4, 4);
        tv11.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv11);

        TextView tv12 = new TextView(this);
        tv12.setText(" Animal Again in heat(Y/N) ");
        tv12.setTextColor(Color.BLACK);
        tv12.setTextSize(16);
        tv12.setPadding(4, 4, 4, 4);
        tv12.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv12);

        TextView tv13 = new TextView(this);
        tv13.setText(" 4th AI Straw no ");
        tv13.setTextColor(Color.BLACK);
        tv13.setTextSize(16);
        tv13.setPadding(4, 4, 4, 4);
        tv13.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv13);

        TextView tv14 = new TextView(this);
        tv14.setText(" 4th AI Breed ");
        tv14.setTextColor(Color.BLACK);
        tv14.setTextSize(16);
        tv14.setPadding(4, 4, 4, 4);
        tv14.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv14);

        TextView tv15 = new TextView(this);
        tv15.setText(" Date 4th AI ");
        tv15.setTextColor(Color.BLACK);
        tv15.setTextSize(16);
        tv15.setPadding(4, 4, 4, 4);
        tv15.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv15);

        TextView tv16 = new TextView(this);
        tv16.setText(" Animal Again in heat(Y/N) ");
        tv16.setTextColor(Color.BLACK);
        tv16.setTextSize(16);
        tv16.setPadding(4, 4, 4, 4);
        tv16.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv16);


        TextView tv117 = new TextView(this);
        tv117.setText(" 5th AI Straw no ");
        tv117.setTextColor(Color.BLACK);
        tv117.setTextSize(16);
        tv117.setPadding(4, 4, 4, 4);
        tv117.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv117);

        TextView tv18 = new TextView(this);
        tv18.setText(" 5th AI Breed ");
        tv18.setTextColor(Color.BLACK);
        tv18.setTextSize(16);
        tv18.setPadding(4, 4, 4, 4);
        tv18.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv18);

        TextView tv19 = new TextView(this);
        tv19.setText(" Date 5th AI ");
        tv19.setTextColor(Color.BLACK);
        tv19.setTextSize(16);
        tv19.setPadding(4, 4, 4, 4);
        tv19.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv19);

        TextView tv20 = new TextView(this);
        tv20.setText(" Animal Again in heat(Y/N) ");
        tv20.setTextColor(Color.BLACK);
        tv20.setTextSize(16);
        tv20.setBackgroundResource(R.drawable.cellborder);
        tv20.setPadding(4, 4, 4, 4);
        tbrow0.addView(tv20);


        TextView tv21 = new TextView(this);
        tv21.setText(" Any conception ");
        tv21.setTextColor(Color.BLACK);
        tv21.setTextSize(16);
        tv21.setPadding(4, 4, 4, 4);
        tv21.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv21);

        TextView tv22 = new TextView(this);
        tv22.setText(" Pregnancy checked on Date ");
        tv22.setTextColor(Color.BLACK);
        tv22.setTextSize(16);
        tv22.setPadding(4, 4, 4, 4);
        tv22.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv22);

        TextView tv23 = new TextView(this);
        tv23.setText(" Expected calving Date ");
        tv23.setTextColor(Color.BLACK);
        tv23.setTextSize(16);
        tv23.setPadding(4, 4, 4, 4);
        tv23.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv23);


        TextView tv24 = new TextView(this);
        tv24.setText(" Actual Date of calving ");
        tv24.setTextColor(Color.BLACK);
        tv24.setTextSize(16);
        tv24.setPadding(8, 8, 8, 8);
        tv24.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv24);

        stk.addView(tbrow0);
        for (int i = 0; i < mlistdata.size(); i++) {
            TableRow tbrow = new TableRow(this);
            tbrow0.setGravity(Gravity.CENTER);
            tbrow0.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f));
            tbrow0.setBackgroundResource(R.drawable.cellborder);

            TextView t1v = new TextView(this);
            t1v.setText(mlistdata.get(i).getAnimalId());
            t1v.setGravity(Gravity.CENTER);
            t1v.setTextColor(Color.BLACK);
            t1v.setTextSize(16);
            t1v.setPadding(8, 8, 8, 8);
            t1v.setBackgroundResource(R.drawable.cellborder);
            tbrow.addView(t1v);

            TextView t2v = new TextView(this);
            t2v.setText(mlistdata.get(i).getFirstAlStrawno());
            t2v.setGravity(Gravity.CENTER);
            t2v.setTextColor(Color.BLACK);
            t2v.setTextSize(16);
            t2v.setPadding(8, 8, 8, 8);
            t2v.setBackgroundResource(R.drawable.cellborder);
            tbrow.addView(t2v);

            TextView t3v = new TextView(this);
            t3v.setText(mlistdata.get(i).getFirstAlBreed());
            t3v.setGravity(Gravity.CENTER);
            t3v.setTextColor(Color.BLACK);
            t3v.setTextSize(16);
            t3v.setPadding(8, 8, 8, 8);
            t3v.setBackgroundResource(R.drawable.cellborder);
            tbrow.addView(t3v);

            TextView t4v = new TextView(this);
            t4v.setText(" "+mlistdata.get(i).getFirstAlDate()+" ");
            t4v.setTextColor(Color.BLACK);
            t4v.setTextSize(16);
            t4v.setPadding(8, 8, 8, 8);
            t4v.setBackgroundResource(R.drawable.cellborder);
            t4v.setGravity(Gravity.CENTER);
            tbrow.addView(t4v);

            TextView t5v = new TextView(this);
            if (mlistdata.get(i).getFirstAnimalHeat() == 1) {
                t5v.setText(" No ");
            } else {
                t5v.setText(" Yes ");
            }
            t5v.setTextColor(Color.BLACK);
            t5v.setTextSize(16);
            t5v.setPadding(8, 8, 8, 8);
            t5v.setBackgroundResource(R.drawable.cellborder);
            t5v.setGravity(Gravity.CENTER);
            tbrow.addView(t5v);

            TextView t6v = new TextView(this);
            t6v.setText(mlistdata.get(i).getSecondAlStrawno());
            t6v.setTextColor(Color.BLACK);
            t6v.setTextSize(16);
            t6v.setPadding(8, 8, 8, 8);
            t6v.setBackgroundResource(R.drawable.cellborder);
            t6v.setGravity(Gravity.CENTER);
            tbrow.addView(t6v);

            TextView t7v = new TextView(this);
            t7v.setText(mlistdata.get(i).getSecondAlBreed());
            t7v.setTextColor(Color.BLACK);
            t7v.setTextSize(16);
            t7v.setPadding(8, 8, 8, 8);
            t7v.setBackgroundResource(R.drawable.cellborder);
            t7v.setGravity(Gravity.CENTER);
            tbrow.addView(t7v);

            TextView t8v = new TextView(this);
            t8v.setText(" "+mlistdata.get(i).getSecondAlDate()+" ");
            t8v.setTextColor(Color.BLACK);
            t8v.setTextSize(16);
            t8v.setPadding(8, 8, 8, 8);
            t8v.setBackgroundResource(R.drawable.cellborder);
            t8v.setGravity(Gravity.CENTER);
            tbrow.addView(t8v);

            TextView t9v = new TextView(this);

            if (mlistdata.get(i).getSecondAnimalHeat() == 1) {
                t9v.setText(" No ");
            } else {
                t9v.setText(" Yes ");
            }
            t9v.setTextColor(Color.BLACK);
            t9v.setTextSize(16);
            t9v.setPadding(8, 8, 8, 8);
            t9v.setBackgroundResource(R.drawable.cellborder);
            t9v.setGravity(Gravity.CENTER);
            tbrow.addView(t9v);

            TextView t10v = new TextView(this);
            t10v.setText(mlistdata.get(i).getThirdAlStrawno());
            t10v.setTextColor(Color.BLACK);
            t10v.setTextSize(16);
            t10v.setPadding(8, 8, 8, 8);
            t10v.setBackgroundResource(R.drawable.cellborder);
            t10v.setGravity(Gravity.CENTER);
            tbrow.addView(t10v);

            TextView t11v = new TextView(this);
            t11v.setText(mlistdata.get(i).getThirdAlBreed());
            t11v.setTextColor(Color.BLACK);
            t11v.setTextSize(16);
            t11v.setPadding(8, 8, 8, 8);
            t11v.setBackgroundResource(R.drawable.cellborder);
            t11v.setGravity(Gravity.CENTER);
            tbrow.addView(t11v);

            TextView t12v = new TextView(this);
            t12v.setText(" "+mlistdata.get(i).getThirdAlDate()+" ");
            t12v.setTextColor(Color.BLACK);
            t12v.setTextSize(16);
            t12v.setPadding(8, 8, 8, 8);
            t12v.setBackgroundResource(R.drawable.cellborder);
            t12v.setGravity(Gravity.CENTER);
            tbrow.addView(t12v);


            TextView t13v = new TextView(this);

            if (mlistdata.get(i).getThirdAnimalHeat() == 1) {
                t13v.setText(" No ");
            } else {
                t13v.setText(" Yes ");
            }
            t13v.setTextColor(Color.BLACK);
            t13v.setTextSize(16);
            t13v.setPadding(8, 8, 8, 8);
            t13v.setBackgroundResource(R.drawable.cellborder);
            t13v.setGravity(Gravity.CENTER);
            tbrow.addView(t13v);

            TextView t14v = new TextView(this);
            t14v.setText(mlistdata.get(i).getFourthAlStrawno());
            t14v.setTextColor(Color.BLACK);
            t14v.setTextSize(16);
            t14v.setPadding(8, 8, 8, 8);
            t14v.setBackgroundResource(R.drawable.cellborder);
            t14v.setGravity(Gravity.CENTER);
            tbrow.addView(t14v);

            TextView t15v = new TextView(this);
            t15v.setText(mlistdata.get(i).getFourthAlBreed());
            t15v.setTextColor(Color.BLACK);
            t15v.setTextSize(16);
            t15v.setPadding(8, 8, 8, 8);
            t15v.setBackgroundResource(R.drawable.cellborder);
            t15v.setGravity(Gravity.CENTER);
            tbrow.addView(t15v);

            TextView t16v = new TextView(this);
            t16v.setText( " "+mlistdata.get(i).getFourthAlDate()+" ");
            t16v.setTextColor(Color.BLACK);
            t16v.setTextSize(16);
            t16v.setPadding(8, 8, 8, 8);
            t16v.setBackgroundResource(R.drawable.cellborder);
            t16v.setGravity(Gravity.CENTER);
            tbrow.addView(t16v);

            TextView t17v = new TextView(this);

            if (mlistdata.get(i).getFourthAnimalHeat() == 1) {
                t17v.setText(" No ");
            } else {
                t17v.setText(" Yes ");
            }

            t17v.setTextColor(Color.BLACK);
            t17v.setTextSize(16);
            t17v.setPadding(8, 8, 8, 8);
            t17v.setBackgroundResource(R.drawable.cellborder);
            t17v.setGravity(Gravity.CENTER);
            tbrow.addView(t17v);


            TextView t18v = new TextView(this);
            t18v.setText(mlistdata.get(i).getFifthAlStrawno());
            t18v.setTextColor(Color.BLACK);
            t18v.setTextSize(16);
            t18v.setPadding(8, 8, 8, 8);
            t18v.setBackgroundResource(R.drawable.cellborder);
            t18v.setGravity(Gravity.CENTER);
            tbrow.addView(t18v);

            TextView t19v = new TextView(this);
            t19v.setText(mlistdata.get(i).getFifthAlBreed());
            t19v.setTextColor(Color.BLACK);
            t19v.setTextSize(16);
            t19v.setPadding(8, 8, 8, 8);
            t19v.setBackgroundResource(R.drawable.cellborder);
            t19v.setGravity(Gravity.CENTER);
            tbrow.addView(t19v);


            TextView t20v = new TextView(this);
            t20v.setText(" "+mlistdata.get(i).getFifthAlDate()+" ");
            t20v.setTextColor(Color.BLACK);
            t20v.setTextSize(16);
            t20v.setPadding(8, 8, 8, 8);
            t20v.setBackgroundResource(R.drawable.cellborder);
            t20v.setGravity(Gravity.CENTER);
            tbrow.addView(t20v);

            TextView t21v = new TextView(this);
            if (mlistdata.get(i).getFifthAnimalHeat() == 1) {
                t21v.setText(" No ");
            } else {
                t21v.setText(" Yes ");
            }

            t21v.setTextColor(Color.BLACK);
            t21v.setTextSize(16);
            t21v.setPadding(8, 8, 8, 8);
            t21v.setBackgroundResource(R.drawable.cellborder);
            t21v.setGravity(Gravity.CENTER);
            tbrow.addView(t21v);

            TextView t22v = new TextView(this);
            if (mlistdata.get(i).getPregnancyCheckedBy() == 1) {
                t22v.setText(" Yes ");
            } else {
                t22v.setText(" No ");
            }

            t22v.setTextColor(Color.BLACK);
            t22v.setTextSize(16);
            t22v.setPadding(8, 8, 8, 8);
            t22v.setBackgroundResource(R.drawable.cellborder);
            t22v.setGravity(Gravity.CENTER);
            tbrow.addView(t22v);


            TextView t23v = new TextView(this);
            t23v.setText(mlistdata.get(i).getPregnancyConfirmedOn());
            t23v.setTextColor(Color.BLACK);
            t23v.setTextSize(16);
            t23v.setPadding(8, 8, 8, 8);
            t23v.setBackgroundResource(R.drawable.cellborder);
            t23v.setGravity(Gravity.CENTER);
            tbrow.addView(t23v);

            TextView t24v = new TextView(this);
            t24v.setText(" "+mlistdata.get(i).getExpectedClavingDate()+" ");
            t24v.setTextColor(Color.BLACK);
            t24v.setTextSize(16);
            t24v.setPadding(8, 8, 8, 8);
            t24v.setBackgroundResource(R.drawable.cellborder);
            t24v.setGravity(Gravity.CENTER);
            tbrow.addView(t24v);

            TextView t25v = new TextView(this);
            t25v.setText(" "+mlistdata.get(i).getActualCalvingDate() +" ");
            t25v.setTextColor(Color.BLACK);
            t25v.setTextSize(16);
            t25v.setPadding(8, 8, 8, 8);
            t25v.setBackgroundResource(R.drawable.cellborder);
            t25v.setGravity(Gravity.CENTER);
            tbrow.addView(t25v);

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


        Call<ReproductionDetailsResponse> call = api.getReproduction(userid);


        call.enqueue(new Callback<ReproductionDetailsResponse>() {
            @Override
            public void onResponse(@NonNull Call<ReproductionDetailsResponse> call, @NonNull Response<ReproductionDetailsResponse> response) {

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
                        Toast.makeText(ReproductionAnalaysisActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        scrollView1.setVisibility(View.GONE);
                        animationView.setVisibility(View.VISIBLE);
                    }
                } else if (response.code() == 401) {
                    hideLoading();
                    Toast.makeText(ReproductionAnalaysisActivity.this, "Something went wrong try after sometimes! ", Toast.LENGTH_SHORT).show();
                } else {
                    hideLoading();

                    Toast.makeText(ReproductionAnalaysisActivity.this, "Error1*", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ReproductionDetailsResponse> call, @NonNull Throwable t) {
                hideLoading();
                Toast.makeText(ReproductionAnalaysisActivity.this, "Try after sometimes!" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }
}