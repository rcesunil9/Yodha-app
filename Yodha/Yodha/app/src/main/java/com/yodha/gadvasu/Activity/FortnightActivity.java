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
import com.yodha.gadvasu.ApiResponsedata.Fornightdata.FortproResponse;
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

public class FortnightActivity extends BaseActivity {
  AppCompatSpinner SPftnightanimaID;
  TextInputEditText ETanimalidftnightdate,ETmilkyieldmornftnt,ETmilkmornsoldftnt,ETmilkusdcanvasmornftnt,ETmilkusdhomemornftnt,ETmilksnfmornftnt,
          ETmilkfatmornftnt,ETmilkyieldevenftnt,ETmilkevensoldftnt,ETmilkusdcanvasevenftnt,ETmilkusdhomeevenftnt,ETmilksnfevenftnt,ETmilkfatevenftnt,ETtotaldaysoldprice,
          ETtodayproct,ETtotaldaysold,ETanisold,ETgannysold,ETmanuresold,ETgeesold,ETotherdatasold,ETotherdatasoldwrite;

  TextView TVtodaysubmit,TVcleardata;
    List<String> mlistspinner = new ArrayList<>();
    String animalid = "";

    final Calendar myCalendar = Calendar.getInstance();

    double todayproduction =0.0;
    double mornsoldmilk =0.0;
    double morncalvemilk =0.0;
    double mornhomemilk =0.0;
    double evenyieldmilk =0.0;
    double evenslddmilk =0.0;
    double evencalvmilk =0.0;
    double evenhomevmilk =0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fortnight);
        Toolbar TBtoolabar = findViewById(R.id.TBtoolfortonight);
        ETanimalidftnightdate = findViewById(R.id.ETanimalidftnightdate);
        ETmilkyieldmornftnt = findViewById(R.id.ETmilkyieldmornftnt);
        ETmilkmornsoldftnt = findViewById(R.id.ETmilkmornsoldftnt);
        ETmilkusdcanvasmornftnt = findViewById(R.id.ETmilkusdcanvasmornftnt);
        ETmilkusdhomemornftnt = findViewById(R.id.ETmilkusdhomemornftnt);
        ETmilksnfmornftnt = findViewById(R.id.ETmilksnfmornftnt);
        ETmilkfatmornftnt = findViewById(R.id.ETmilkfatmornftnt);
        ETmilkyieldevenftnt = findViewById(R.id.ETmilkyieldevenftnt);
        ETmilkevensoldftnt = findViewById(R.id.ETmilkevensoldftnt);
        ETmilkusdcanvasevenftnt = findViewById(R.id.ETmilkusdcanvasevenftnt);
        ETmilkusdhomeevenftnt = findViewById(R.id.ETmilkusdhomeevenftnt);
        ETmilksnfevenftnt = findViewById(R.id.ETmilksnfevenftnt);
        ETmilkfatevenftnt = findViewById(R.id.ETmilkfatevenftnt);
        ETtodayproct = findViewById(R.id.ETtodayproct);
        ETtotaldaysold = findViewById(R.id.ETtotaldaysold);
        ETanisold = findViewById(R.id.ETanisold);
        ETgannysold = findViewById(R.id.ETgannysold);
        ETmanuresold = findViewById(R.id.ETmanuresold);
        ETgeesold = findViewById(R.id.ETgeesold);
        ETtotaldaysoldprice = findViewById(R.id.ETtotaldaysoldprice);
        ETotherdatasold = findViewById(R.id.ETotherdatasold);
        ETotherdatasoldwrite = findViewById(R.id.ETotherdatasoldwrite);
        SPftnightanimaID = findViewById(R.id.SPftnightanimaID);
        TVtodaysubmit = findViewById(R.id.TVtodaysubmit);
        TVcleardata = findViewById(R.id.TVcleardata);

        setSupportActionBar(TBtoolabar);

        TBtoolabar.setNavigationOnClickListener(view -> finish());

        ETanimalidftnightdate.setText(currentDate());

        String userid = sharepreference.getData(Sharepredata.USERID);
        if (userid != null) {
            getanimalList(userid);
        }


        TVcleardata.setOnClickListener(view -> {
            ETanimalidftnightdate.setText("");
            ETmilkyieldmornftnt.setText("");
            ETmilkmornsoldftnt.setText("");
            ETmilkusdcanvasmornftnt.setText("");
            ETmilkusdhomemornftnt.setText("");
            ETmilksnfmornftnt.setText("");
            ETmilkfatmornftnt.setText("");
            ETmilkyieldevenftnt.setText("");
            ETmilkevensoldftnt.setText("");
            ETmilkusdcanvasevenftnt.setText("");
            ETmilkusdhomeevenftnt.setText("");
            ETmilksnfevenftnt.setText("");
            ETmilkfatevenftnt.setText("");
            ETtodayproct.setText("");
            ETtotaldaysold.setText("");
            ETanisold.setText("");
            ETgannysold.setText("");
            ETmanuresold.setText("");
            ETgeesold.setText("");
            ETtotaldaysoldprice.setText("");
            ETotherdatasold.setText("");
            ETotherdatasoldwrite.setText("");
        });

        ETmilkyieldmornftnt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence.length() !=0){
                    String ttproduct = String.valueOf(ETmilkyieldmornftnt.getText());
                    todayproduction = Double.parseDouble(ttproduct);
                }else{
                    todayproduction=0.0;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

                double todaypr =todayproduction + evenyieldmilk ;
                ETtodayproct.setText(String.valueOf(todaypr));
            }
        });


        ETmilkmornsoldftnt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence.length() !=0){
                    String ttproductsold = String.valueOf(ETmilkmornsoldftnt.getText());
                    mornsoldmilk = Double.parseDouble(ttproductsold);
                }else{
                    mornsoldmilk=0.0;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(todayproduction > mornsoldmilk) {
                    double todaypr =todayproduction + evenyieldmilk ;
                    double soldmilk = mornsoldmilk + evenslddmilk;
                    ETtotaldaysold.setText(String.valueOf(soldmilk));
                    ETtodayproct.setText(String.valueOf(todaypr));
                }else{
                    Toast.makeText(FortnightActivity.this,"Sold Milk value is not greater than Yield Milk!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        ETmilkusdcanvasmornftnt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence.length() !=0){
                    String ttproductsold = String.valueOf(ETmilkusdcanvasmornftnt.getText());
                    morncalvemilk = Double.parseDouble(ttproductsold);
                }else{
                    morncalvemilk=0.0;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(todayproduction > morncalvemilk) {
                    double todaypr =todayproduction + evenyieldmilk ;
                    ETtodayproct.setText(String.valueOf(todaypr));
                }else{
                    Toast.makeText(FortnightActivity.this,"Calves Milk value is not greater than Yield Milk!", Toast.LENGTH_SHORT).show();
                }
            }

        });


        ETmilkusdhomemornftnt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence.length() !=0){
                    String ttproductsold = String.valueOf(ETmilkusdhomemornftnt.getText());
                    mornhomemilk = Double.parseDouble(ttproductsold);
                }else{
                    mornhomemilk=0.0;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(todayproduction > mornhomemilk) {
                    double todaypr =todayproduction + evenyieldmilk ;

                    ETtodayproct.setText(String.valueOf(todaypr));
                }else{
                    Toast.makeText(FortnightActivity.this,"Home Used Milk value is not greater than Yield Milk!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ETmilkyieldevenftnt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence.length() !=0){
                    String ttproductsold = String.valueOf(ETmilkyieldevenftnt.getText());
                    evenyieldmilk = Double.parseDouble(ttproductsold);
                }else{
                    evenyieldmilk=0.0;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

                double todaypr =todayproduction + evenyieldmilk ;

                ETtodayproct.setText(String.valueOf(todaypr));
            }
        });

        ETmilkevensoldftnt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence.length() !=0){
                    String ttproductsold = String.valueOf(ETmilkevensoldftnt.getText());
                    evenslddmilk = Double.parseDouble(ttproductsold);
                }else{
                    evenslddmilk=0.0;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(evenyieldmilk > evenslddmilk) {
                    double todaypr =todayproduction + evenyieldmilk ;
                    double soldmilk = mornsoldmilk + evenslddmilk;
                    ETtotaldaysold.setText(String.valueOf(soldmilk));
                    ETtodayproct.setText(String.valueOf(todaypr));
                }else{
                    Toast.makeText(FortnightActivity.this,"Sold Milk value is not greater than Yield Milk!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ETmilkusdcanvasevenftnt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence.length() !=0){
                    String ttproductsold = String.valueOf(ETmilkusdcanvasevenftnt.getText());
                    evencalvmilk = Double.parseDouble(ttproductsold);
                }else{
                    evencalvmilk=0.0;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(evenyieldmilk > evencalvmilk) {
                    double todaypr =todayproduction + evenyieldmilk ;

                    ETtodayproct.setText(String.valueOf(todaypr));
                }else{
                    Toast.makeText(FortnightActivity.this,"Calves Milk value is not greater than Yield Milk!", Toast.LENGTH_SHORT).show();
                }
            }


        });

        ETmilkusdhomeevenftnt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence.length() !=0){
                    String ttproductsold = String.valueOf(ETmilkusdhomeevenftnt.getText());
                    evenhomevmilk = Double.parseDouble(ttproductsold);
                }else{
                    evenhomevmilk=0.0;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(evenyieldmilk > evenhomevmilk) {
                    double todaypr =todayproduction + evenyieldmilk ;

                    ETtodayproct.setText(String.valueOf(todaypr));
                }else{

                    Toast.makeText(FortnightActivity.this,"Home used Milk value is not greater than Yield Milk!", Toast.LENGTH_SHORT).show();

                }
            }
        });






        DatePickerDialog.OnDateSetListener date = (view, year, month, day) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, day);

            updateLabel();
        };

        ETanimalidftnightdate.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog   =  new DatePickerDialog(FortnightActivity.this,
                    date,
                    myCalendar.get(Calendar.YEAR),
                    myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
            datePickerDialog.show();
        });


        SPftnightanimaID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                animalid =parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        TVtodaysubmit.setOnClickListener(view -> {
            String fdate = String.valueOf(ETanimalidftnightdate.getText());
            String fmornyieldmilk = String.valueOf(ETmilkyieldmornftnt.getText());
            String fmornsoldmilk = String.valueOf(ETmilkmornsoldftnt.getText());
            String fmorncanvasmilk = String.valueOf(ETmilkusdcanvasmornftnt.getText());
            String fmornhomemilk = String.valueOf(ETmilkusdhomemornftnt.getText());
            String fmornsnfmilk = String.valueOf(ETmilksnfmornftnt.getText());
            String fmornfatmilk = String.valueOf(ETmilkfatmornftnt.getText());
            String fevenyieldmilk = String.valueOf(ETmilkyieldevenftnt.getText());
            String fevensolddmilk = String.valueOf(ETmilkevensoldftnt.getText());
            String fevencalvesmilk = String.valueOf(ETmilkusdcanvasevenftnt.getText());
            String fevenhomesmilk = String.valueOf(ETmilkusdhomeevenftnt.getText());
            String fevensnfsmilk = String.valueOf(ETmilksnfevenftnt.getText());
            String fevenfatsmilk = String.valueOf(ETmilkfatevenftnt.getText());
            String ftotalmilk = String.valueOf(ETtodayproct.getText());
            String ftotalsoldmilk = String.valueOf(ETtotaldaysold.getText());
            String fanisold = String.valueOf(ETanisold.getText());
            String fgannysold = String.valueOf(ETgannysold.getText());
            String fmanuresold = String.valueOf(ETmanuresold.getText());
            String fgeesold = String.valueOf(ETgeesold.getText());
            String fothersold = String.valueOf(ETotherdatasold.getText());
            String fothersoldwrite = String.valueOf(ETotherdatasoldwrite.getText());
            String ftotalmilksodprice = String.valueOf(ETtotaldaysoldprice.getText());
            if(animalid.isEmpty()){
                Toast.makeText(FortnightActivity.this,"Please select animalID First !",Toast.LENGTH_SHORT).show();
            }else{
                savefortnightdata(userid,animalid,fdate,fmornyieldmilk,fmornsoldmilk,fmorncanvasmilk,fmornhomemilk,fmornsnfmilk,fmornfatmilk,fevenyieldmilk,fevensolddmilk,
                        fevencalvesmilk,fevenhomesmilk,fevensnfsmilk,fevenfatsmilk,ftotalmilk,ftotalsoldmilk,ftotalmilksodprice,fanisold,fgannysold,fmanuresold,fgeesold,fothersoldwrite,fothersold);
            }
        });
    }

    private void savefortnightdata(String userid,String animalid,String fdate,String mornyield,String mornsold,String mornconvas,String mornhome,String mornsnf,String mornfat,String evenyield,String evensold,
                                   String evencalves,String evenhome,String evensnf,String evenfat,String totalmilk,String totalsold,String ftotalmilksodprice,String anisold,String gannysold,
                                   String manuresold,String geesold,String fothersoldwrite,String othersold){


        showLoading();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ApiInterface api = retrofit.create(ApiInterface.class);


        Call<FortproResponse> call = api.savefortnight(userid,animalid,fdate,mornyield,mornsold,mornconvas,mornhome,mornsnf,mornfat,evenyield,evensold,evencalves,
                evenhome,evensnf,evenfat,totalmilk,totalsold,ftotalmilksodprice,anisold,gannysold,manuresold,geesold,fothersoldwrite,othersold);


        call.enqueue(new Callback<FortproResponse>() {
            @Override
            public void onResponse(@NonNull Call<FortproResponse> call, @NonNull Response<FortproResponse> response) {

                if (response.code() == 200) {
                    hideLoading();
                    assert response.body() != null;
                    if (response.body().isStatus()) {
                        ETanimalidftnightdate.setText("");
                        ETmilkyieldmornftnt.setText("");
                        ETmilkmornsoldftnt.setText("");
                        ETmilkusdcanvasmornftnt.setText("");
                        ETmilkusdhomemornftnt.setText("");
                        ETmilksnfmornftnt.setText("");
                        ETmilkfatmornftnt.setText("");
                        ETmilkyieldevenftnt.setText("");
                        ETmilkevensoldftnt.setText("");
                        ETmilkusdcanvasevenftnt.setText("");
                        ETmilkusdhomeevenftnt.setText("");
                        ETmilksnfevenftnt.setText("");
                        ETmilkfatevenftnt.setText("");
                        ETtodayproct.setText("");
                        ETtotaldaysold.setText("");
                        ETanisold.setText("");
                        ETgannysold.setText("");
                        ETmanuresold.setText("");
                        ETgeesold.setText("");
                        ETtotaldaysoldprice.setText("");
                        ETotherdatasold.setText("");
                        ETotherdatasoldwrite.setText("");
                        showdialogconfimation(response.body().getMsg());
                       // Toast.makeText(FortnightActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    } else {
                        showdialogerror(response.body().getMsg());
                       // Toast.makeText(FortnightActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }
                } else if (response.code() == 401) {
                    hideLoading();
                    Toast.makeText(FortnightActivity.this, "Error", Toast.LENGTH_SHORT).show();
                } else {
                    hideLoading();
                    Toast.makeText(FortnightActivity.this, "Error1*", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<FortproResponse> call, @NonNull Throwable t) {
                hideLoading();
                Toast.makeText(FortnightActivity.this, "Exception" + t, Toast.LENGTH_SHORT).show();
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
                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(FortnightActivity.this, android.R.layout.simple_spinner_dropdown_item, mlistspinner);
                        SPftnightanimaID.setAdapter(arrayAdapter);
                    } else {
                        Toast.makeText(FortnightActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }
                } else if (response.code() == 401) {
                    hideLoading();
                    Toast.makeText(FortnightActivity.this, "Error", Toast.LENGTH_SHORT).show();
                } else {
                    hideLoading();
                    Toast.makeText(FortnightActivity.this, "Error1*", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<AnimalidResponse> call, @NonNull Throwable t) {
                hideLoading();
                Toast.makeText(FortnightActivity.this, "Exception" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateLabel() {
        String myFormat = "dd-MM-yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        ETanimalidftnightdate.setText(dateFormat.format(myCalendar.getTime()));
    }



}