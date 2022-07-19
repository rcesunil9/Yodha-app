package com.yodha.gadvasu.Activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yodha.gadvasu.ApiResponsedata.AnimalIDdata.AnimalidResponse;
import com.yodha.gadvasu.ApiResponsedata.ApiInterface;
import com.yodha.gadvasu.ApiResponsedata.Expenduturedata.ExpendetureResponse;
import com.yodha.gadvasu.Otherdatacls.Sharepredata;
import com.yodha.gadvasu.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ExpentitureActivity extends BaseActivity {
    TextInputEditText ETdateofexture,ETanimalpuchage_expend,ETfeed_purchase_weight,ETfeed_purchase_amt,ETfeed_purchase_mixedwht,ETfeed_mix_amt,ETfeed_greenfeedamt_wt,
            ETfeed_greenfeedamt,ETfeed_vaccineantioncost,ET_medecinecost,ETvet_cost,ETai_cost,ETshelder_cost,ETneweqip_name,ETneweqip_cost,ETlabout_cost,ETelectric_cost,ETloan_cost,ETconstruction_cost,ETinsurance_cost,ETmix_cost;

    TextView TVexpentsubmit,TVcleardata;
    AppCompatSpinner SPanimaID;

    List<String> mlistspinner = new ArrayList<>();
    String animalid="";
    final Calendar myCalendar = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expentiture);
        Toolbar TBtoolabar = findViewById(R.id.TBtoolexpediture);
        ETdateofexture = findViewById(R.id.ETdateofexture);
        ETanimalpuchage_expend = findViewById(R.id.ETanimalpuchage_expend);
        ETfeed_purchase_weight = findViewById(R.id.ETfeed_purchase_weight);
        ETfeed_purchase_amt = findViewById(R.id.ETfeed_purchase_amt);
        ETfeed_purchase_mixedwht = findViewById(R.id.ETfeed_purchase_mixedwht);
        ETfeed_mix_amt = findViewById(R.id.ETfeed_mix_amt);
        ETfeed_greenfeedamt_wt = findViewById(R.id.ETfeed_greenfeedamt_wt);
        ETfeed_greenfeedamt = findViewById(R.id.ETfeed_greenfeedamt);
        ETfeed_vaccineantioncost = findViewById(R.id.ETfeed_vaccineantioncost);
        ET_medecinecost = findViewById(R.id.ET_medecinecost);
        ETvet_cost = findViewById(R.id.ETvet_cost);
        ETai_cost = findViewById(R.id.ETai_cost);
        ETshelder_cost = findViewById(R.id.ETshelder_cost);
        ETneweqip_name = findViewById(R.id.ETneweqip_name);
        ETneweqip_cost = findViewById(R.id.ETneweqip_cost);
        ETlabout_cost = findViewById(R.id.ETlabout_cost);
        ETelectric_cost = findViewById(R.id.ETelectric_cost);
        ETloan_cost = findViewById(R.id.ETloan_cost);
        ETconstruction_cost = findViewById(R.id.ETconstruction_cost);
        ETinsurance_cost = findViewById(R.id.ETinsurance_cost);
        ETmix_cost = findViewById(R.id.ETmix_cost);
        TVexpentsubmit = findViewById(R.id.TVexpentsubmit);
        TVcleardata = findViewById(R.id.TVcleardata);
        SPanimaID = findViewById(R.id.SPanimaID);

        setSupportActionBar(TBtoolabar);

        TBtoolabar.setNavigationOnClickListener(view -> finish());


        ETdateofexture.setText(currentDate());

        String userid = sharepreference.getData(Sharepredata.USERID);
        if (userid != null) {
            getanimalList(userid);
        }


        TVcleardata.setOnClickListener(view -> {
            ETdateofexture.setText("");
            ETanimalpuchage_expend.setText("");
            ETfeed_purchase_weight.setText("");
            ETfeed_purchase_amt.setText("");
            ETfeed_purchase_mixedwht.setText("");
            ETfeed_mix_amt.setText("");
            ETfeed_greenfeedamt_wt.setText("");
            ETfeed_greenfeedamt.setText("");
            ETfeed_vaccineantioncost.setText("");
            ET_medecinecost.setText("");
            ETvet_cost.setText("");
            ETai_cost.setText("");
            ETshelder_cost.setText("");
            ETneweqip_name.setText("");
            ETneweqip_cost.setText("");
            ETlabout_cost.setText("");
            ETelectric_cost.setText("");
            ETloan_cost.setText("");
            ETconstruction_cost.setText("");
            ETinsurance_cost.setText("");
            ETmix_cost.setText("");
        });

        DatePickerDialog.OnDateSetListener date = (view, year, month, day) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, day);

            updateLabel();
        };

        ETdateofexture.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog   =  new DatePickerDialog(ExpentitureActivity.this,
                    date,
                    myCalendar.get(Calendar.YEAR),
                    myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
            datePickerDialog.show();
        });


        SPanimaID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                animalid =parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        TVexpentsubmit.setOnClickListener(view -> {
            String date1 = String.valueOf(ETdateofexture.getText());
            String purchage = String.valueOf(ETanimalpuchage_expend.getText());
            String feedwt = String.valueOf(ETfeed_purchase_weight.getText());
            String feedprice = String.valueOf(ETfeed_purchase_amt.getText());
            String mixwt = String.valueOf(ETfeed_purchase_mixedwht.getText());
            String mixwtprice = String.valueOf(ETfeed_mix_amt.getText());
            String greenfeedwt = String.valueOf(ETfeed_greenfeedamt_wt.getText());
            String greenfeedwtprice = String.valueOf(ETfeed_greenfeedamt.getText());
            String vacctioncost = String.valueOf(ETfeed_vaccineantioncost.getText());
            String madecinecost = String.valueOf(ET_medecinecost.getText());
            String vet_cost = String.valueOf(ETvet_cost.getText());
            String ai_cost = String.valueOf(ETai_cost.getText());
            String shelder_cost = String.valueOf(ETshelder_cost.getText());
            String neweqip_name = String.valueOf(ETneweqip_name.getText());
            String neweqip_cost = String.valueOf(ETneweqip_cost.getText());
            String labout_cost = String.valueOf(ETlabout_cost.getText());
            String electric_cost = String.valueOf(ETelectric_cost.getText());
            String loan_cost = String.valueOf(ETloan_cost.getText());
            String construction_cost = String.valueOf(ETconstruction_cost.getText());
            String insurance_cost = String.valueOf(ETinsurance_cost.getText());
            String mix_cost = String.valueOf(ETmix_cost.getText());

            if(animalid.isEmpty()){
                Toast.makeText(ExpentitureActivity.this,"Please select animalID First !",Toast.LENGTH_SHORT).show();
            }else{
                savefortnightdata(userid,animalid,date1,purchage,feedwt,feedprice,mixwt,mixwtprice,greenfeedwt,greenfeedwtprice,vacctioncost,
                        madecinecost,vet_cost,ai_cost,shelder_cost,neweqip_name,neweqip_cost,labout_cost,electric_cost,loan_cost,construction_cost,insurance_cost,mix_cost);
            }

        });

    }

    private void savefortnightdata(String userid,String animalid,String fdate,String purchage,String feedwt,String feedprice,String mixwt,String mixwtprice,String greenfeedwt,String greenfeedwtprice,String vacctioncost,
                                   String madecinecost,String vet_cost,String ai_cost,String shelder_cost,String neweqip_name,String neweqip_cost,String labout_cost,String electric_cost,String loan_cost,
                                   String construction_cost,String insurance_cost,String mix_cost){


        showLoading();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ApiInterface api = retrofit.create(ApiInterface.class);


        Call<ExpendetureResponse> call = api.saveexpenture(userid,animalid,fdate,purchage,feedwt,feedprice,mixwt,mixwtprice,greenfeedwt,greenfeedwtprice,vacctioncost,
                madecinecost,vet_cost,ai_cost,shelder_cost,neweqip_name,neweqip_cost,labout_cost,electric_cost,loan_cost,construction_cost,insurance_cost,mix_cost);


        call.enqueue(new Callback<ExpendetureResponse>() {
            @Override
            public void onResponse(@NonNull Call<ExpendetureResponse> call, @NonNull Response<ExpendetureResponse> response) {

                if (response.code() == 200) {
                    hideLoading();
                    assert response.body() != null;
                    if (response.body().isStatus()) {
                        ETdateofexture.setText("");
                        ETanimalpuchage_expend.setText("");
                        ETfeed_purchase_weight.setText("");
                        ETfeed_purchase_amt.setText("");
                        ETfeed_purchase_mixedwht.setText("");
                        ETfeed_mix_amt.setText("");
                        ETfeed_greenfeedamt_wt.setText("");
                        ETfeed_greenfeedamt.setText("");
                        ETfeed_vaccineantioncost.setText("");
                        ET_medecinecost.setText("");
                        ETvet_cost.setText("");
                        ETai_cost.setText("");
                        ETshelder_cost.setText("");
                        ETneweqip_name.setText("");
                        ETneweqip_cost.setText("");
                        ETlabout_cost.setText("");
                        ETelectric_cost.setText("");
                        ETloan_cost.setText("");
                        ETconstruction_cost.setText("");
                        ETinsurance_cost.setText("");
                        ETmix_cost.setText("");
                        showdialogconfimation(response.body().getMsg());
                        //Toast.makeText(ExpentitureActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    } else {
                        showdialogerror(response.body().getMsg());
                       // Toast.makeText(ExpentitureActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }
                } else if (response.code() == 401) {
                    hideLoading();
                    Toast.makeText(ExpentitureActivity.this, "Error", Toast.LENGTH_SHORT).show();
                } else {
                    hideLoading();
                    Toast.makeText(ExpentitureActivity.this, "Error1*", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ExpendetureResponse> call, @NonNull Throwable t) {
                hideLoading();
                Toast.makeText(ExpentitureActivity.this, "Exception" + t, Toast.LENGTH_SHORT).show();
            }
        });



    }

    private void getanimalList(String userid) {
        showLoading();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface api = retrofit.create(ApiInterface.class);


        Call<AnimalidResponse> call = api.getanimallist(userid);


        call.enqueue(new Callback<AnimalidResponse>() {
            @Override
            public void onResponse(@NonNull Call<AnimalidResponse> call, @NonNull Response<AnimalidResponse> response) {

                if (response.code() == 200) {
                    hideLoading();
                    assert response.body() != null;
                    if (response.body().isStatus()) {
                        for (int i = 0; i < response.body().getData().size(); i++) {
                            mlistspinner.add(response.body().getData().get(i).getAnimalId());
                        }
                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ExpentitureActivity.this, android.R.layout.simple_spinner_dropdown_item, mlistspinner);
                        SPanimaID.setAdapter(arrayAdapter);
                    } else {
                        Toast.makeText(ExpentitureActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }
                } else if (response.code() == 401) {
                    hideLoading();
                    Toast.makeText(ExpentitureActivity.this, "Error", Toast.LENGTH_SHORT).show();
                } else {
                    hideLoading();
                    Toast.makeText(ExpentitureActivity.this, "Error1*", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<AnimalidResponse> call, @NonNull Throwable t) {
                hideLoading();
                Toast.makeText(ExpentitureActivity.this, "Exception" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateLabel() {
        String myFormat = "dd-MM-yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        ETdateofexture.setText(dateFormat.format(myCalendar.getTime()));
    }
}