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
import com.yodha.gadvasu.ApiResponsedata.Productiondetails.DataItem;
import com.yodha.gadvasu.ApiResponsedata.Productiondetails.ProductdataResponse;
import com.yodha.gadvasu.Otherdatacls.Sharepredata;
import com.yodha.gadvasu.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductAnalsisActivity extends BaseActivity {
    LottieAnimationView animationView;
    NestedScrollView scrollView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_analsis);
        Toolbar TBtoolabar = findViewById(R.id.TBtoolprodtanalysis);
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
        tv1.setText(" Breed ");
        tv1.setTextColor(Color.BLACK);
        tv1.setTextSize(16);
        tv1.setPadding(4, 4, 4, 4);
        tv1.setGravity(Gravity.CENTER);
        tv1.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv1);

        TextView tv2 = new TextView(this);
        tv2.setText(" Date ");
        tv2.setTextColor(Color.BLACK);
        tv2.setTextSize(16);
        tv2.setGravity(Gravity.CENTER);
        tv2.setPadding(4, 4, 4, 4);
        tv2.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv2);

        TextView tv3 = new TextView(this);
        tv3.setText(" Milk Sold  Morninn(Kg) ");
        tv3.setTextColor(Color.BLACK);
        tv3.setTextSize(16);
        tv3.setGravity(Gravity.CENTER);
        tv3.setPadding(4, 4, 4, 4);
        tv3.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv3);

        TextView tv4 = new TextView(this);
        tv4.setText(" Milk used at home ");
        tv4.setTextColor(Color.BLACK);
        tv4.setTextSize(16);
        tv4.setGravity(Gravity.CENTER);
        tv4.setPadding(4, 4, 4, 4);
        tv4.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv4);

        TextView tv5 = new TextView(this);
        tv5.setText(" Milk used for calves ");
        tv5.setTextColor(Color.BLACK);
        tv5.setTextSize(16);
        tv5.setGravity(Gravity.CENTER);
        tv5.setPadding(4, 4, 4, 4);
        tv5.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv5);

        TextView tv6 = new TextView(this);
        tv6.setText(" Milk sold Evening(Kg) ");
        tv6.setTextColor(Color.BLACK);
        tv6.setTextSize(16);
        tv6.setGravity(Gravity.CENTER);
        tv6.setPadding(4, 4, 4, 4);
        tv6.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv6);

        TextView tv7 = new TextView(this);
        tv7.setText(" Milk used at home  ");
        tv7.setTextColor(Color.BLACK);
        tv7.setTextSize(16);
        tv7.setGravity(Gravity.CENTER);
        tv7.setPadding(4, 4, 4, 4);
        tv7.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv7);

        TextView tv8 = new TextView(this);
        tv8.setText(" Milk used for calves ");
        tv8.setTextColor(Color.BLACK);
        tv8.setTextSize(16);
        tv8.setGravity(Gravity.CENTER);
        tv8.setPadding(4, 4, 4, 4);
        tv8.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv8);

        TextView tv9 = new TextView(this);
        tv9.setText(" Total Milk Yield ");
        tv9.setTextColor(Color.BLACK);
        tv9.setTextSize(16);
        tv9.setGravity(Gravity.CENTER);
        tv9.setPadding(4, 4, 4, 4);
        tv9.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv9);

        TextView tv10 = new TextView(this);
        tv10.setText(" Total Milk Sold ");
        tv10.setTextColor(Color.BLACK);
        tv10.setTextSize(16);
        tv10.setGravity(Gravity.CENTER);
        tv10.setPadding(4, 4, 4, 4);
        tv10.setBackgroundResource(R.drawable.cellborder);
        tbrow0.addView(tv10);

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
           // t2v.setText(mlistdata.get(i).getBreed());
            t2v.setText("Cattle");
            t2v.setGravity(Gravity.CENTER);
            t2v.setTextColor(Color.BLACK);
            t2v.setTextSize(16);
            t2v.setPadding(8, 8, 8, 8);
            t2v.setBackgroundResource(R.drawable.cellborder);
            tbrow.addView(t2v);

            TextView t3v = new TextView(this);
            t3v.setText(" "+mlistdata.get(i).getPdate()+" ");
            t3v.setGravity(Gravity.CENTER);
            t3v.setTextColor(Color.BLACK);
            t3v.setTextSize(16);
            t3v.setPadding(8, 8, 8, 8);
            t3v.setBackgroundResource(R.drawable.cellborder);
            tbrow.addView(t3v);

            TextView t4v = new TextView(this);
            t4v.setText(mlistdata.get(i).getMilkSoldMorning());
            t4v.setTextColor(Color.BLACK);
            t4v.setTextSize(16);
            t4v.setPadding(8, 8, 8, 8);
            t4v.setBackgroundResource(R.drawable.cellborder);
            t4v.setGravity(Gravity.CENTER);
            tbrow.addView(t4v);

            TextView t5v = new TextView(this);
            t5v.setText(mlistdata.get(i).getMilkUsedForHome());
            t5v.setTextColor(Color.BLACK);
            t5v.setTextSize(16);
            t5v.setPadding(8, 8, 8, 8);
            t5v.setBackgroundResource(R.drawable.cellborder);
            t5v.setGravity(Gravity.CENTER);
            tbrow.addView(t5v);

            TextView t6v = new TextView(this);
            t6v.setText(mlistdata.get(i).getMilkUsedForCalves());
            t6v.setTextColor(Color.BLACK);
            t6v.setTextSize(16);
            t6v.setPadding(8, 8, 8, 8);
            t6v.setBackgroundResource(R.drawable.cellborder);
            t6v.setGravity(Gravity.CENTER);
            tbrow.addView(t6v);

            TextView t7v = new TextView(this);
            t7v.setText(mlistdata.get(i).getMilkSoldEvening());
            t7v.setTextColor(Color.BLACK);
            t7v.setTextSize(16);
            t7v.setPadding(8, 8, 8, 8);
            t7v.setBackgroundResource(R.drawable.cellborder);
            t7v.setGravity(Gravity.CENTER);
            tbrow.addView(t7v);

            TextView t8v = new TextView(this);
            t8v.setText(" "+mlistdata.get(i).getMilkUsedForHomeEvening()+" ");
            t8v.setTextColor(Color.BLACK);
            t8v.setTextSize(16);
            t8v.setPadding(8, 8, 8, 8);
            t8v.setBackgroundResource(R.drawable.cellborder);
            t8v.setGravity(Gravity.CENTER);
            tbrow.addView(t8v);

            TextView t9v = new TextView(this);


            t9v.setText( mlistdata.get(i).getMilkUsedForCalvesEvening());
            t9v.setTextColor(Color.BLACK);
            t9v.setTextSize(16);
            t9v.setPadding(8, 8, 8, 8);
            t9v.setBackgroundResource(R.drawable.cellborder);
            t9v.setGravity(Gravity.CENTER);
            tbrow.addView(t9v);

            TextView t10v = new TextView(this);
            t10v.setText(mlistdata.get(i).getTotalTodayProduction());
            t10v.setTextColor(Color.BLACK);
            t10v.setTextSize(16);
            t10v.setPadding(8, 8, 8, 8);
            t10v.setBackgroundResource(R.drawable.cellborder);
            t10v.setGravity(Gravity.CENTER);
            tbrow.addView(t10v);

            TextView t11v = new TextView(this);
            if(mlistdata.get(i).getMilkSoldMorning() != null && mlistdata.get(i).getMilkSoldEvening() !=null) {
                t11v.setText("" + (Double.parseDouble(mlistdata.get(i).getMilkSoldMorning()) + Double.parseDouble(mlistdata.get(i).getMilkSoldEvening())));
            }else{
                t11v.setText("0");
            }

            t11v.setTextColor(Color.BLACK);
            t11v.setTextSize(16);
            t11v.setPadding(8, 8, 8, 8);
            t11v.setBackgroundResource(R.drawable.cellborder);
            t11v.setGravity(Gravity.CENTER);
            tbrow.addView(t11v);



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


        Call<ProductdataResponse> call = api.getProduction(userid);


        call.enqueue(new Callback<ProductdataResponse>() {
            @Override
            public void onResponse(@NonNull Call<ProductdataResponse> call, @NonNull Response<ProductdataResponse> response) {

                if (response.code() == 200) {
                    hideLoading();
                    assert response.body() != null;
                    if (response.body().isStatus()) {

                        if (response.body().getData().size() == 0) {
                            scrollView1.setVisibility(View.GONE);
                            animationView.setVisibility(View.VISIBLE);

                        } else {
                            init(response.body().getData());
                            scrollView1.setVisibility(View.VISIBLE);
                            animationView.setVisibility(View.GONE);
                        }

                    } else {
                        Toast.makeText(ProductAnalsisActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                } else if (response.code() == 401) {
                    hideLoading();
                    Toast.makeText(ProductAnalsisActivity.this, "Error", Toast.LENGTH_SHORT).show();
                } else {
                    hideLoading();

                    Toast.makeText(ProductAnalsisActivity.this, "Error1*", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ProductdataResponse> call, @NonNull Throwable t) {
                hideLoading();
                Toast.makeText(ProductAnalsisActivity.this, "Exception" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }
}