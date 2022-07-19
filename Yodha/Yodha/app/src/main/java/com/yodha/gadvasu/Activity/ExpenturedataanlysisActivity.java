package com.yodha.gadvasu.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;

import com.airbnb.lottie.LottieAnimationView;
import com.yodha.gadvasu.ApiResponsedata.ApiInterface;
import com.yodha.gadvasu.ApiResponsedata.Expenduturedeatils.ExpendturedataResponse;
import com.yodha.gadvasu.Otherdatacls.Sharepredata;
import com.yodha.gadvasu.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ExpenturedataanlysisActivity extends BaseActivity {
    LinearLayout LVchild;
    LottieAnimationView animationView;
    NestedScrollView scrollView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenturedataanlysis);
        Toolbar TBtoolabar = findViewById(R.id.TBtoollistofanimal);
        LVchild = findViewById(R.id.LVchild);
        animationView = findViewById(R.id.animationView);
        scrollView1 = findViewById(R.id.scrollView1);
        setSupportActionBar(TBtoolabar);

        TBtoolabar.setNavigationOnClickListener(view -> finish());
        String userid = sharepreference.getData(Sharepredata.USERID);
        if (userid != null) {
            getanimalList(userid);
        }


    }

   /* @SuppressLint({"CutPasteId", "SetTextI18n"})
    void addview(List<DataItem> mlist){
        boolean mcheckview =true;
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        TextView TVsrno,TVexpdate,TVexpentutured,TVcost;

        for (int j=0; j<mlist.size();j++) {
            if(j == 0) {
                for (int i = 0; i < 11; i++) {
                    @SuppressLint("InflateParams") View newRowView = inflater.inflate(R.layout.firmchildviewdata_lay, LVchild, false);
                    TVexpdate = newRowView.findViewById(R.id.TVexpdate);
                    TVsrno = newRowView.findViewById(R.id.TVsrno);
                    TVcost = newRowView.findViewById(R.id.TVexpdate);
                    TVexpentutured = newRowView.findViewById(R.id.TVexpdate);
                    TVsrno.setText("" + (i + 1));
                    // TVexpdate.setText(mlist.get(i).getCreatedAt());
                    if (i == 0) {
                        TVexpentutured.setText("Animal Purchage Cost");
                    } else if (i == 1) {
                        TVexpentutured.setText("Feed Purchage");
                    } else if (i == 2) {
                        TVexpentutured.setText("Fodder Purchage");
                    } else if (i == 3) {
                        TVexpentutured.setText("Mineral Purchage");
                    } else if (i == 4) {
                        TVexpentutured.setText("Vaccination");
                    } else if (i == 5) {
                        TVexpentutured.setText("Medicine");
                    } else if (i == 6) {
                        TVexpentutured.setText("Vet");
                    } else if (i == 7) {
                        TVexpentutured.setText("Loan Repayment");
                    } else if (i == 8) {
                        TVexpentutured.setText("Equipment name entered");
                    } else if (i == 9) {
                        TVexpentutured.setText("Labour");
                    } else {
                        TVexpentutured.setText("Construction");
                    }


                    //  TVcost.setText(mlist.get(i).getCreatedAt());
                    LinearLayout linearLayout = newRowView.findViewById(R.id.LLchildlay);

                    LVchild.addView(linearLayout);
                }
            }else{

            }
        }

    }*/


    private void getanimalList(String userid) {
        showLoading();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface api = retrofit.create(ApiInterface.class);


        Call<ExpendturedataResponse> call = api.getExpenditure(userid);


        call.enqueue(new Callback<ExpendturedataResponse>() {
            @Override
            public void onResponse(@NonNull Call<ExpendturedataResponse> call, @NonNull Response<ExpendturedataResponse> response) {

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
                            //  addview(response.body().getData());
                        }

                    } else {
                        Toast.makeText(ExpenturedataanlysisActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        scrollView1.setVisibility(View.GONE);
                        animationView.setVisibility(View.VISIBLE);
                    }
                } else if (response.code() == 401) {
                    hideLoading();
                    Toast.makeText(ExpenturedataanlysisActivity.this, "Something went wrong try after sometimes! ", Toast.LENGTH_SHORT).show();
                } else {
                    hideLoading();

                    Toast.makeText(ExpenturedataanlysisActivity.this, "Server Error!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ExpendturedataResponse> call, @NonNull Throwable t) {
                hideLoading();
                Toast.makeText(ExpenturedataanlysisActivity.this, "Try after sometimes!" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }
}