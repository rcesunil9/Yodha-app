package com.yodha.gadvasu.Activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.yodha.gadvasu.ApiResponsedata.Todayproduct.TodayproductResponse;
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

public class TodayproductionActivity extends BaseActivity {
    TextInputEditText ETanimalidtodaydate, ETmilkyieldmorn, ETmilkmornsold, ETmilkusdcanvasmorn, ETmilkusdhomemorn, ETmilkuyieldeven, ETmilkusdevensold,
            ETtotaldaysoldprice, ETmilkusdevencalves, ETmilkusdevenhome, ETtodayproct, ETtotaldaysold, ETanisold, ETgannysold, ETmanuresold, ETgeesold, ETotherdatasoldwrite, ETotherdatasold;
    TextView TVtodaysubmit,TVcleardata;
    AppCompatSpinner SPtodayanimaID;
    List<String> mlistspinner = new ArrayList<>();
    String animalid = "";
    double todayproduction =0.0;
    double mornsoldmilk =0.0;
    double morncalvemilk =0.0;
    double mornhomemilk =0.0;
    double evenyieldmilk =0.0;
    double evenslddmilk =0.0;
    double evencalvmilk =0.0;
    double evenhomevmilk =0.0;




    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todayproduction);
        Toolbar TBtoolabar = findViewById(R.id.TBtooltodayproduct);
        ETanimalidtodaydate = findViewById(R.id.ETanimalidtodaydate);
        ETmilkyieldmorn = findViewById(R.id.ETmilkyieldmorn);
        ETmilkmornsold = findViewById(R.id.ETmilkmornsold);
        ETmilkusdcanvasmorn = findViewById(R.id.ETmilkusdcanvasmorn);
        ETmilkusdhomemorn = findViewById(R.id.ETmilkusdhomemorn);
        ETmilkuyieldeven = findViewById(R.id.ETmilkuyieldeven);
        ETmilkusdevensold = findViewById(R.id.ETmilkusdevensold);
        ETmilkusdevencalves = findViewById(R.id.ETmilkusdevencalves);
        ETmilkusdevenhome = findViewById(R.id.ETmilkusdevenhome);
        ETtodayproct = findViewById(R.id.ETtodayproct);
        ETtotaldaysold = findViewById(R.id.ETtotaldaysold);
        ETanisold = findViewById(R.id.ETanisold);
        ETgannysold = findViewById(R.id.ETgannysold);
        ETmanuresold = findViewById(R.id.ETmanuresold);
        ETgeesold = findViewById(R.id.ETgeesold);
        ETotherdatasold = findViewById(R.id.ETotherdatasold);
        ETtotaldaysoldprice = findViewById(R.id.ETtotaldaysoldprice);
        ETotherdatasoldwrite = findViewById(R.id.ETotherdatasoldwrite);
        TVtodaysubmit = findViewById(R.id.TVtodaysubmit);
        TVcleardata = findViewById(R.id.TVcleardata);
        SPtodayanimaID = findViewById(R.id.SPtodayanimaID);

        setSupportActionBar(TBtoolabar);

        TBtoolabar.setNavigationOnClickListener(view -> finish());

        ETanimalidtodaydate.setText(currentDate());

        String userid = sharepreference.getData(Sharepredata.USERID);
        if (userid != null) {
            getanimalList(userid);
        }

        TVcleardata.setOnClickListener(view -> {
            ETanimalidtodaydate.setText("");
            ETmilkyieldmorn.setText("");
            ETmilkmornsold.setText("");
            ETmilkusdcanvasmorn.setText("");
            ETmilkusdhomemorn.setText("");
            ETmilkuyieldeven.setText("");
            ETmilkusdevensold.setText("");
            ETmilkusdevencalves.setText("");
            ETmilkusdevenhome.setText("");
            ETtodayproct.setText("");
            ETtotaldaysold.setText("");
            ETanisold.setText("");
            ETgannysold.setText("");
            ETmanuresold.setText("");
            ETgeesold.setText("");
            ETotherdatasold.setText("");
            ETtotaldaysoldprice.setText("");
            ETotherdatasoldwrite.setText("");
        });

        ETmilkyieldmorn.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence.length() !=0){
                    String ttproduct = String.valueOf(ETmilkyieldmorn.getText());
                    todayproduction = Double.parseDouble(ttproduct);
                }else{
                    todayproduction=0.0;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

                double todaypr =todayproduction+evenyieldmilk;

                ETtodayproct.setText(String.valueOf(todaypr));
            }
        });


        ETmilkmornsold.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence.length() !=0){
                    String ttproductsold = String.valueOf(ETmilkmornsold.getText());
                    mornsoldmilk = Double.parseDouble(ttproductsold);
                }else{
                    mornsoldmilk=0.0;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(todayproduction > mornsoldmilk) {
                    double todaypr =   todayproduction + evenyieldmilk ;
                    double soldmilk = mornsoldmilk + evenslddmilk;
                    ETtotaldaysold.setText(String.valueOf(soldmilk));
                    ETtodayproct.setText(String.valueOf(todaypr));
                }else{
                    Toast.makeText(TodayproductionActivity.this,"Sold Milk value is not greater than Yield Milk!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        ETmilkusdcanvasmorn.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence.length() !=0){
                    String ttproductsold = String.valueOf(ETmilkusdcanvasmorn.getText());
                    morncalvemilk = Double.parseDouble(ttproductsold);
                }else{
                    morncalvemilk=0.0;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(todayproduction > morncalvemilk) {
                    double todaypr =   todayproduction + evenyieldmilk ;
                    ETtodayproct.setText(String.valueOf(todaypr));
                }else{
                    Toast.makeText(TodayproductionActivity.this,"Calves Milk value is not greater than Yield Milk!", Toast.LENGTH_SHORT).show();
                }
            }

        });


        ETmilkusdhomemorn.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence.length() !=0){
                    String ttproductsold = String.valueOf(ETmilkusdhomemorn.getText());
                    mornhomemilk = Double.parseDouble(ttproductsold);
                }else{
                    mornhomemilk=0.0;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(todayproduction > mornhomemilk) {
                double todaypr =todayproduction+evenyieldmilk;

                ETtodayproct.setText(String.valueOf(todaypr));
                }else{
                    Toast.makeText(TodayproductionActivity.this,"Home Used Milk value is not greater than Yield Milk!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ETmilkuyieldeven.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence.length() !=0){
                    String ttproductsold = String.valueOf(ETmilkuyieldeven.getText());
                    evenyieldmilk = Double.parseDouble(ttproductsold);
                }else{
                    evenyieldmilk=0.0;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

                double todaypr =todayproduction+evenyieldmilk;

                ETtodayproct.setText(String.valueOf(todaypr));
            }
        });

        ETmilkusdevensold.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence.length() !=0){
                    String ttproductsold = String.valueOf(ETmilkusdevensold.getText());
                    evenslddmilk = Double.parseDouble(ttproductsold);
                }else{
                    evenslddmilk=0.0;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(evenyieldmilk > evenslddmilk) {
                    double todaypr =  todayproduction + evenyieldmilk;
                    double soldmilk = mornsoldmilk + evenslddmilk;
                    ETtotaldaysold.setText(String.valueOf(soldmilk));
                    ETtodayproct.setText(String.valueOf(todaypr));
                }else{
                    Toast.makeText(TodayproductionActivity.this,"Sold Milk value is not greater than Yield Milk!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ETmilkusdevencalves.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence.length() !=0){
                    String ttproductsold = String.valueOf(ETmilkusdevencalves.getText());
                    evencalvmilk = Double.parseDouble(ttproductsold);
                }else{
                    evencalvmilk=0.0;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(evenyieldmilk > evencalvmilk) {
                    double todaypr = todayproduction + evenyieldmilk ;

                    ETtodayproct.setText(String.valueOf(todaypr));
                }else{
                    Toast.makeText(TodayproductionActivity.this,"Calves Milk value is not greater than Yield Milk!", Toast.LENGTH_SHORT).show();
                }
            }


        });

        ETmilkusdevenhome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence.length() !=0){
                    String ttproductsold = String.valueOf(ETmilkusdevenhome.getText());
                    evenhomevmilk = Double.parseDouble(ttproductsold);
                }else{
                    evenhomevmilk=0.0;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(evenyieldmilk > evenhomevmilk) {
                    double todaypr =   todayproduction + evenyieldmilk ;

                    ETtodayproct.setText(String.valueOf(todaypr));
                }else{

                        Toast.makeText(TodayproductionActivity.this,"Home used Milk value is not greater than Yield Milk!", Toast.LENGTH_SHORT).show();

                }
            }
        });


        DatePickerDialog.OnDateSetListener date = (view, year, month, day) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, day);

            updateLabel();
        };

        ETanimalidtodaydate.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(TodayproductionActivity.this,
                    date,
                    myCalendar.get(Calendar.YEAR),
                    myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
            datePickerDialog.show();
        });

        TVtodaysubmit.setOnClickListener(v -> {
            String todaydate = String.valueOf(ETanimalidtodaydate.getText());
            String milkyieldmorn = String.valueOf(ETmilkyieldmorn.getText());
            String milkmornsold = String.valueOf(ETmilkmornsold.getText());
            String milkusdcanvasmorn = String.valueOf(ETmilkusdcanvasmorn.getText());
            String milkusdhomemorn = String.valueOf(ETmilkusdhomemorn.getText());
            String milkuyieldeven = String.valueOf(ETmilkuyieldeven.getText());
            String milkusdevensold = String.valueOf(ETmilkusdevensold.getText());
            String milkusdevencalves = String.valueOf(ETmilkusdevencalves.getText());
            String milkusdevenhome = String.valueOf(ETmilkusdevenhome.getText());
            String todayproct = String.valueOf(ETtodayproct.getText());
            String totaldaysold = String.valueOf(ETtotaldaysold.getText());
            String totaldaysoldprice = String.valueOf(ETtotaldaysoldprice.getText());
            String anisold = String.valueOf(ETanisold.getText());
            String gannysold = String.valueOf(ETgannysold.getText());
            String manuresold = String.valueOf(ETmanuresold.getText());
            String geesold = String.valueOf(ETgeesold.getText());
            String otherdatasoldwrt = String.valueOf(ETotherdatasoldwrite.getText());
            String otherdatasold = String.valueOf(ETotherdatasold.getText());
            if (animalid.isEmpty()) {
                Toast.makeText(TodayproductionActivity.this, "Please select animalID First !", Toast.LENGTH_SHORT).show();
            }else if(milkyieldmorn.isEmpty() || milkuyieldeven.isEmpty()){
                Toast.makeText(TodayproductionActivity.this, "Please Morning or Evening data Fill!", Toast.LENGTH_SHORT).show();
            }   else{
                savedartatoday(userid, animalid, todaydate, milkyieldmorn, milkmornsold, milkusdcanvasmorn, milkusdhomemorn, milkuyieldeven, milkusdevensold, milkusdevencalves, milkusdevenhome, todayproct,
                        totaldaysold, totaldaysoldprice, anisold, gannysold, manuresold, geesold, otherdatasoldwrt, otherdatasold);
            }

        });


        SPtodayanimaID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                animalid =parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    private void savedartatoday(String userid, String animalid, String tdate, String milkmorn, String milkmornsold, String milkcanvmorn, String milkusdmorn, String milkeven, String milksoldeven, String milkcanveven, String milkhomeeven,
                                String milktproduct, String milktsold, String totalmilkprice, String anisold, String gannysold, String manursold, String geesold, String fothersoldwrite, String othersold) {

        showLoading();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ApiInterface api = retrofit.create(ApiInterface.class);


        Call<TodayproductResponse> call = api.savetodayproduct(userid, animalid, tdate, milkmorn, milkmornsold, milkcanvmorn, milkusdmorn, milkeven, milksoldeven, milkcanveven, milkhomeeven,
                milktproduct, milktsold, totalmilkprice, anisold, gannysold, manursold, geesold, fothersoldwrite, othersold);


        call.enqueue(new Callback<TodayproductResponse>() {
            @Override
            public void onResponse(@NonNull Call<TodayproductResponse> call, @NonNull Response<TodayproductResponse> response) {

                if (response.code() == 200) {
                    hideLoading();
                    assert response.body() != null;
                    if (response.body().isStatus()) {
                        ETanimalidtodaydate.setText("");
                        ETmilkyieldmorn.setText("");
                        ETmilkmornsold.setText("");
                        ETmilkusdhomemorn.setText("");
                        ETmilkuyieldeven.setText("");
                        ETmilkusdevensold.setText("");
                        ETmilkusdevencalves.setText("");
                        ETmilkusdevenhome.setText("");
                        ETtodayproct.setText("");
                        ETtotaldaysold.setText("");
                        ETtotaldaysoldprice.setText("");
                        ETanisold.setText("");
                        ETgannysold.setText("");
                        ETmanuresold.setText("");
                        ETgeesold.setText("");
                        ETotherdatasoldwrite.setText("");
                        ETotherdatasold.setText("");
                        showdialogconfimation(response.body().getMsg());
                       // Toast.makeText(TodayproductionActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    } else {
                        showdialogerror(response.body().getMsg());
                        //Toast.makeText(TodayproductionActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }
                } else if (response.code() == 401) {
                    hideLoading();
                    Toast.makeText(TodayproductionActivity.this, "Something went wrong try after sometimes!", Toast.LENGTH_SHORT).show();
                } else {
                    hideLoading();
                    Toast.makeText(TodayproductionActivity.this, "Error1*", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<TodayproductResponse> call, @NonNull Throwable t) {
                hideLoading();
                Toast.makeText(TodayproductionActivity.this, "Exception" + t, Toast.LENGTH_SHORT).show();
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
                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(TodayproductionActivity.this, android.R.layout.simple_spinner_dropdown_item, mlistspinner);
                        SPtodayanimaID.setAdapter(arrayAdapter);
                    } else {
                        Toast.makeText(TodayproductionActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }
                } else if (response.code() == 401) {
                    hideLoading();
                    Toast.makeText(TodayproductionActivity.this, "Server Not Response!", Toast.LENGTH_SHORT).show();
                } else {
                    hideLoading();
                    Toast.makeText(TodayproductionActivity.this, "Error1*", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<AnimalidResponse> call, @NonNull Throwable t) {
                hideLoading();
                Toast.makeText(TodayproductionActivity.this, "Exception" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateLabel() {
        String myFormat = "dd-MM-yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        ETanimalidtodaydate.setText(dateFormat.format(myCalendar.getTime()));
    }
}