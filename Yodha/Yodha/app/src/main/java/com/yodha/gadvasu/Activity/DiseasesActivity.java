package com.yodha.gadvasu.Activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
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
import com.yodha.gadvasu.ApiResponsedata.Diseasedata.DiseasesResponse;
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

public class DiseasesActivity extends BaseActivity {
    AppCompatSpinner SPanimaID;
    TextInputEditText ETdeses_date, ETdisease_comment, ETcured_date, ETreleapsedieses, ETreleapsediesescrtdt, ETreleapsevcndate,ETvacinestatus;
    TextView TVtodaysubmit,TVcleardata;

    List<String> mlistspinner = new ArrayList<>();
    String animalid = "";
    CheckBox CBDTone,CBDTtwo,CBDTthree,CBDTfour,CBDTfive,CBDTsix,CBCOone,CBCOtwo,CBCOthree,CBCOfour,CBCOfive;

    final Calendar myCalendar = Calendar.getInstance();
    String CBDTonedata,CBDTdatatwo,CBDTdatathree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diseases);
        Toolbar TBtoolabar = findViewById(R.id.TBtooldiseases);
        SPanimaID = findViewById(R.id.SPanimaID);
        ETdeses_date = findViewById(R.id.ETdeses_date);
        ETdisease_comment = findViewById(R.id.ETdisease_comment);
        ETcured_date = findViewById(R.id.ETcured_date);
        ETreleapsedieses = findViewById(R.id.ETreleapsedieses);
        ETreleapsediesescrtdt = findViewById(R.id.ETreleapsediesescrtdt);
        ETreleapsevcndate = findViewById(R.id.ETreleapsevcndate);
        ETvacinestatus = findViewById(R.id.ETvacinestatus);
        TVtodaysubmit = findViewById(R.id.TVtodaysubmit);
        TVcleardata = findViewById(R.id.TVcleardata);
        CBDTone = findViewById(R.id.CBDTone);
        CBDTtwo = findViewById(R.id.CBDTtwo);
        CBDTthree = findViewById(R.id.CBDTthree);
        CBDTfour = findViewById(R.id.CBDTfour);
        CBDTfive = findViewById(R.id.CBDTfive);
        CBDTsix = findViewById(R.id.CBDTsix);
        CBCOone = findViewById(R.id.CBCOone);
        CBCOtwo = findViewById(R.id.CBCOtwo);
        CBCOthree = findViewById(R.id.CBCOthree);
        CBCOfour = findViewById(R.id.CBCOfour);
        CBCOfive = findViewById(R.id.CBCOfive);

        setSupportActionBar(TBtoolabar);

        TBtoolabar.setNavigationOnClickListener(view -> finish());

        ETdeses_date.setText(currentDate());

        String userid = sharepreference.getData(Sharepredata.USERID);
        if (userid != null) {
            getanimalList(userid);
        }

        TVcleardata.setOnClickListener(view -> {
            ETdeses_date.setText("");
            ETdisease_comment.setText("");
            ETcured_date.setText("");
            ETreleapsedieses.setText("");
            ETreleapsediesescrtdt.setText("");
            ETreleapsevcndate.setText("");
            ETvacinestatus.setText("");
            CBDTone.setChecked(false);
            CBDTtwo.setChecked(false);
            CBDTthree.setChecked(false);
            CBDTfour.setChecked(false);
            CBDTfive.setChecked(false);
            CBDTsix.setChecked(false);
            CBCOone.setChecked(false);
            CBCOtwo.setChecked(false);
            CBCOthree.setChecked(false);
            CBCOfour.setChecked(false);
            CBCOfive.setChecked(false);
        });


        CBDTone.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                CBDTonedata ="1";

            }else{
                CBDTonedata ="0";

            }

        });

        CBDTtwo.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                CBDTdatatwo ="2";
            }else{
                CBDTonedata ="0";
            }

        });

        CBDTthree.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                CBDTdatathree ="3";
            }else{
                CBDTonedata ="0";
            }

        });

        DatePickerDialog.OnDateSetListener date = (view, year, month, day) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, day);

            updateLabel();
        };

        DatePickerDialog.OnDateSetListener date1 = (view, year, month, day) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, day);

            updateLabel1();
        };

        DatePickerDialog.OnDateSetListener date2 = (view, year, month, day) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, day);

            updateLabel2();
        };

        DatePickerDialog.OnDateSetListener date3 = (view, year, month, day) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, day);

            updateLabel3();
        };

        DatePickerDialog.OnDateSetListener date4 = (view, year, month, day) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, day);

            updateLabel4();
        };

        ETdeses_date.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(DiseasesActivity.this,
                    date,
                    myCalendar.get(Calendar.YEAR),
                    myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
            datePickerDialog.show();
        });

        ETcured_date.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(DiseasesActivity.this,
                    date1,
                    myCalendar.get(Calendar.YEAR),
                    myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
            datePickerDialog.show();
        });

        ETreleapsevcndate.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(DiseasesActivity.this,
                    date2,
                    myCalendar.get(Calendar.YEAR),
                    myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
            datePickerDialog.show();
        });

        ETreleapsediesescrtdt.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(DiseasesActivity.this,
                    date3,
                    myCalendar.get(Calendar.YEAR),
                    myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
            datePickerDialog.show();
        });

        ETreleapsedieses.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(DiseasesActivity.this,
                    date4,
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


        TVtodaysubmit.setOnClickListener(v -> {
            String fdate = String.valueOf(ETdeses_date.getText());
            String disease_comment = String.valueOf(ETdisease_comment.getText());
            String cured_date = String.valueOf(ETcured_date.getText());
            String releapsedieses = String.valueOf(ETreleapsedieses.getText());
            String releapsediesescrtdt = String.valueOf(ETreleapsediesescrtdt.getText());
            String releapsevcndate = String.valueOf(ETreleapsevcndate.getText());

            if(animalid.isEmpty()){
                Toast.makeText(DiseasesActivity.this,"Please select animalID First !",Toast.LENGTH_SHORT).show();
            }else{
                savefortnightdata(userid,animalid,fdate,disease_comment,cured_date,releapsedieses,releapsediesescrtdt,releapsevcndate);
            }
        });

    }


    private void savefortnightdata(String userid,String animalid,String fdate,String coment,String creddate,String relapse_of_diseasedate1,String relapse_of_diseasedate2,String vaccination_date){


        showLoading();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ApiInterface api = retrofit.create(ApiInterface.class);


        Call<DiseasesResponse> call = api.savediseasedata(userid,animalid,fdate,CBDTonedata,CBDTdatatwo,CBDTdatathree,coment,creddate,"0",relapse_of_diseasedate1,relapse_of_diseasedate2,
                "1",vaccination_date,"1");


        call.enqueue(new Callback<DiseasesResponse>() {
            @Override
            public void onResponse(@NonNull Call<DiseasesResponse> call, @NonNull Response<DiseasesResponse> response) {

                if (response.code() == 200) {
                    hideLoading();
                    assert response.body() != null;
                    if (response.body().isStatus()) {
                        ETdeses_date.setText("");
                        ETdisease_comment.setText("");
                        ETcured_date.setText("");
                        ETreleapsedieses.setText("");
                        ETreleapsediesescrtdt.setText("");
                        ETreleapsevcndate.setText("");
                        ETvacinestatus.setText("");
                     //   Toast.makeText(DiseasesActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        showdialogconfimation(response.body().getMsg());
                    } else {
                        showdialogerror(response.body().getMsg());
                        //Toast.makeText(DiseasesActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }
                } else if (response.code() == 401) {
                    hideLoading();
                    Toast.makeText(DiseasesActivity.this, "Error", Toast.LENGTH_SHORT).show();
                } else {
                    hideLoading();
                    Toast.makeText(DiseasesActivity.this, "Error1*", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<DiseasesResponse> call, @NonNull Throwable t) {
                hideLoading();
                Toast.makeText(DiseasesActivity.this, "Exception" + t, Toast.LENGTH_SHORT).show();
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
                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(DiseasesActivity.this, android.R.layout.simple_spinner_dropdown_item, mlistspinner);
                        SPanimaID.setAdapter(arrayAdapter);
                    } else {
                        Toast.makeText(DiseasesActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }
                } else if (response.code() == 401) {
                    hideLoading();
                    Toast.makeText(DiseasesActivity.this, "Something went wrong try after sometimes!", Toast.LENGTH_SHORT).show();
                } else {
                    hideLoading();
                    Toast.makeText(DiseasesActivity.this, "Error1*", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<AnimalidResponse> call, @NonNull Throwable t) {
                hideLoading();
                Toast.makeText(DiseasesActivity.this, "Exception" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateLabel() {
        String myFormat = "dd-MM-yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        ETdeses_date.setText(dateFormat.format(myCalendar.getTime()));
    }

    private void updateLabel1() {
        String myFormat = "dd-MM-yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        ETcured_date.setText(dateFormat.format(myCalendar.getTime()));
    }


    private void updateLabel2() {
        String myFormat = "dd-MM-yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        ETreleapsevcndate.setText(dateFormat.format(myCalendar.getTime()));
    }

    private void updateLabel3() {
        String myFormat = "dd-MM-yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        ETreleapsediesescrtdt.setText(dateFormat.format(myCalendar.getTime()));
    }

    private void updateLabel4() {
        String myFormat = "dd-MM-yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        ETreleapsedieses.setText(dateFormat.format(myCalendar.getTime()));
    }
}