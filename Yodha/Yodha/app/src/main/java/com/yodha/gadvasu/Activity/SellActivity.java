package com.yodha.gadvasu.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;

import com.airbnb.lottie.LottieAnimationView;
import com.yodha.gadvasu.ApiResponsedata.ApiInterface;
import com.yodha.gadvasu.ApiResponsedata.SalesAnalysis.DataItem;
import com.yodha.gadvasu.ApiResponsedata.SalesAnalysis.SalesdataResponse;
import com.yodha.gadvasu.Otherdatacls.Sharepredata;
import com.yodha.gadvasu.R;

import java.text.DecimalFormat;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SellActivity extends BaseActivity {
    LottieAnimationView animationView;
    TextView Saleanimal, gunnybagsale, Manuresale, Gheesale, Others, Totalamount;
    NestedScrollView scrollView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        Toolbar TBtoolabar = findViewById(R.id.TBtoolsell);
        animationView = findViewById(R.id.animationView);
        Saleanimal = findViewById(R.id.Saleanimal);
        gunnybagsale = findViewById(R.id.gunnybagsale);
        Manuresale = findViewById(R.id.Manuresale);
        Gheesale = findViewById(R.id.Gheesale);
        Others = findViewById(R.id.Others);
        Totalamount = findViewById(R.id.Totalamount);
        scrollView1 = findViewById(R.id.scrollView1);


        setSupportActionBar(TBtoolabar);

        TBtoolabar.setNavigationOnClickListener(view -> finish());
        String userid = sharepreference.getData(Sharepredata.USERID);
        if (userid != null) {
            getanimalList(userid);
        }
    }

    @SuppressLint("SetTextI18n")
    private void setdata(List<DataItem> mlistdata) {
        double animalprice = 0.0;
        double gunnybagprice = 0.0;
        double manuresale = 0.0;
        double gheesaleprice = 0.0;
        double otherprice = 0.0;


        for (int i = 0; i < mlistdata.size(); i++) {

            animalprice += Double.parseDouble(mlistdata.get(i).getAnimalSold());
            gunnybagprice += Double.parseDouble(mlistdata.get(i).getGunnyBagSold());
            gheesaleprice += Double.parseDouble(mlistdata.get(i).getGeeProductSold());
            manuresale += Double.parseDouble(mlistdata.get(i).getManureSold());
            otherprice += Double.parseDouble(mlistdata.get(i).getOtherDatasoldPrice());

        }

        Saleanimal.setText(new DecimalFormat("##.##").format(animalprice));
        gunnybagsale.setText(new DecimalFormat("##.##").format(gunnybagprice));
        Manuresale.setText(new DecimalFormat("##.##").format( manuresale));
        Gheesale.setText(new DecimalFormat("##.##").format( gheesaleprice));
        Others.setText(new DecimalFormat("##.##").format(otherprice));

        double titprice = (animalprice + gunnybagprice + manuresale + gheesaleprice + otherprice);
        if (titprice == 0) {
            Totalamount.setText("0");
        } else {
            Totalamount.setText("" + titprice);
        }


    }


    private void getanimalList(String userid) {
        showLoading();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface api = retrofit.create(ApiInterface.class);


        Call<SalesdataResponse> call = api.getSellsdata(userid);


        call.enqueue(new Callback<SalesdataResponse>() {
            @Override
            public void onResponse(@NonNull Call<SalesdataResponse> call, @NonNull Response<SalesdataResponse> response) {

                if (response.code() == 200) {
                    hideLoading();
                    assert response.body() != null;
                    if (response.body().isStatus()) {

                        if (response.body().getData().size() == 0) {
                            animationView.setVisibility(View.VISIBLE);
                            scrollView1.setVisibility(View.GONE);
                        } else {
                            animationView.setVisibility(View.GONE);
                            scrollView1.setVisibility(View.VISIBLE);
                            setdata(response.body().getData());

                        }

                    } else {
                        Toast.makeText(SellActivity.this, "Something went wrong try after sometimes!", Toast.LENGTH_SHORT).show();
                    }
                } else if (response.code() == 401) {
                    hideLoading();
                    Toast.makeText(SellActivity.this, "Error", Toast.LENGTH_SHORT).show();
                } else {
                    hideLoading();

                    Toast.makeText(SellActivity.this, "Error1*", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<SalesdataResponse> call, @NonNull Throwable t) {
                hideLoading();
                Toast.makeText(SellActivity.this, "Exception" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }
}