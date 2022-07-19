package com.yodha.gadvasu.Activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yodha.gadvasu.Adapter.SpinnerAdapterr;
import com.yodha.gadvasu.ApiResponsedata.AnimalIDdata.AnimalidResponse;
import com.yodha.gadvasu.ApiResponsedata.AnimalIDdata.DataItem;
import com.yodha.gadvasu.ApiResponsedata.ApiInterface;
import com.yodha.gadvasu.ApiResponsedata.Reproductiondata.ReproductionResponse;
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

public class ReproductionActivity extends BaseActivity {


    AppCompatSpinner SPanimaID;
    TextInputEditText ETanimal_strawno, ETanimal_breed, ETanimal_date, ETanimal_secondstrw, ETanimal_secondaibreed, ETanimal_secondaidate, ETanimal_thirdstrw, ETanimal_thirdaibreed, ETanimal_thirdaidate,
            ETanimal_fourthstrw, ETanimal_fourthaibreed, ETanimal_fourthaidate, ETanimal_fifthstrw, ETanimal_fifthaibreed, ETanimal_fiftaidate, ETanimal_pregnecyaidate, ETanimal_expcalvingdate, ETanimal_atulcalvingdate;
    TextView TVreproductionsubmit,TVcleardata;
    String animalid = "";
    int type;
    RadioButton genderradioButton, educationradioButton, farmsizeradioButton;
    RadioGroup radioGroupsouceby, radioagainheat2, radioagainheat3, radioagainheat4, radioagainheat5, radioapregnecycheck;
    TextInputLayout TILreprostsecondno,TILreprostsecondbreed,TILreproseconddate,TILreprostthirdno,TILreprostthirdbreed,TILreprothirddate,TILreprostfourthno,TILreprostfourthbreed,TILreprofourthdate,TILreprostfifthhno,TILreprostfiftbreed,TILreprofifthdate;
    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproduction);
        Toolbar TBtoolabar = findViewById(R.id.TBtoolrepdut);
        SPanimaID = findViewById(R.id.SPanimaID);
        ETanimal_strawno = findViewById(R.id.ETanimal_strawno);
        ETanimal_breed = findViewById(R.id.ETanimal_breed);
        ETanimal_date = findViewById(R.id.ETanimal_date);
        ETanimal_secondstrw = findViewById(R.id.ETanimal_secondstrw);
        ETanimal_secondaibreed = findViewById(R.id.ETanimal_secondaibreed);
        ETanimal_secondaidate = findViewById(R.id.ETanimal_secondaidate);
        ETanimal_thirdstrw = findViewById(R.id.ETanimal_thirdstrw);
        ETanimal_thirdaibreed = findViewById(R.id.ETanimal_thirdaibreed);
        ETanimal_thirdaidate = findViewById(R.id.ETanimal_thirdaidate);
        ETanimal_fourthstrw = findViewById(R.id.ETanimal_fourthstrw);
        ETanimal_fourthaibreed = findViewById(R.id.ETanimal_fourthaibreed);
        ETanimal_fourthaidate = findViewById(R.id.ETanimal_fourthaidate);
        ETanimal_fifthstrw = findViewById(R.id.ETanimal_fifthstrw);
        ETanimal_fifthaibreed = findViewById(R.id.ETanimal_fifthaibreed);
        ETanimal_fiftaidate = findViewById(R.id.ETanimal_fiftaidate);
        ETanimal_pregnecyaidate = findViewById(R.id.ETanimal_pregnecyaidate);
        ETanimal_expcalvingdate = findViewById(R.id.ETanimal_expcalvingdate);
        ETanimal_atulcalvingdate = findViewById(R.id.ETanimal_atulcalvingdate);
        TVreproductionsubmit = findViewById(R.id.TVreproductionsubmit);
        radioGroupsouceby = findViewById(R.id.radioGroupsouceby);
        radioagainheat2 = findViewById(R.id.radioagainheat2);
        radioagainheat3 = findViewById(R.id.radioagainheat3);
        radioagainheat4 = findViewById(R.id.radioagainheat4);
        TILreprostsecondno = findViewById(R.id.TILreprostsecondno);
        TILreprostsecondbreed = findViewById(R.id.TILreprostsecondbreed);
        TILreproseconddate = findViewById(R.id.TILreproseconddate);
        TILreprostthirdno = findViewById(R.id.TILreprostthirdno);
        TILreprostthirdbreed = findViewById(R.id.TILreprostthirdbreed);
        TILreprothirddate = findViewById(R.id.TILreprothirddate);
        TILreprostfourthno = findViewById(R.id.TILreprostfourthno);
        TILreprostfourthbreed = findViewById(R.id.TILreprostfourthbreed);
        TILreprofourthdate = findViewById(R.id.TILreprofourthdate);
        TILreprostfifthhno = findViewById(R.id.TILreprostfifthhno);
        TILreprostfiftbreed = findViewById(R.id.TILreprostfiftbreed);
        TILreprofifthdate = findViewById(R.id.TILreprofifthdate);
        TVcleardata = findViewById(R.id.TVcleardata);


        setSupportActionBar(TBtoolabar);

        TBtoolabar.setNavigationOnClickListener(view -> finish());

      //  ETanimal_date.setText(currentDate());

        String userid = sharepreference.getData(Sharepredata.USERID);
        if (userid != null) {
            getanimalList(userid);
        }


        TVcleardata.setOnClickListener(view -> {
            ETanimal_strawno.setText("");
            ETanimal_breed.setText("");
            ETanimal_date.setText("");
            ETanimal_secondstrw.setText("");
            ETanimal_secondaibreed.setText("");
            ETanimal_secondaidate.setText("");
            ETanimal_thirdstrw.setText("");
            ETanimal_thirdaibreed.setText("");
            ETanimal_thirdaidate.setText("");
            ETanimal_thirdaidate.setText("");
            ETanimal_fourthstrw.setText("");
            ETanimal_fourthaibreed.setText("");
            ETanimal_fourthaidate.setText("");
            ETanimal_fifthstrw.setText("");
            ETanimal_fifthaibreed.setText("");
            ETanimal_fiftaidate.setText("");
            ETanimal_pregnecyaidate.setText("");
            ETanimal_expcalvingdate.setText("");
            ETanimal_atulcalvingdate.setText("");

        });

        DatePickerDialog.OnDateSetListener date = (view, year, month, day) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, day);

            updateLabel();
        };


        ETanimal_date.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(ReproductionActivity.this,
                    date,
                    myCalendar.get(Calendar.YEAR),
                    myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
            datePickerDialog.show();
        });


        DatePickerDialog.OnDateSetListener date1 = (view, year, month, day) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, day);

            updateLabel1();
        };


        ETanimal_secondaidate.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(ReproductionActivity.this,
                    date1,
                    myCalendar.get(Calendar.YEAR),
                    myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
            datePickerDialog.show();
        });


        DatePickerDialog.OnDateSetListener date2 = (view, year, month, day) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, day);

            updateLabel2();
        };


        ETanimal_thirdaidate.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(ReproductionActivity.this,
                    date2,
                    myCalendar.get(Calendar.YEAR),
                    myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
            datePickerDialog.show();
        });

        DatePickerDialog.OnDateSetListener date3 = (view, year, month, day) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, day);

            updateLabel3();
        };


        ETanimal_fourthaidate.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(ReproductionActivity.this,
                    date3,
                    myCalendar.get(Calendar.YEAR),
                    myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
            datePickerDialog.show();
        });

        DatePickerDialog.OnDateSetListener date4 = (view, year, month, day) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, day);

            updateLabel4();
        };


        ETanimal_fiftaidate.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(ReproductionActivity.this,
                    date4,
                    myCalendar.get(Calendar.YEAR),
                    myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
            datePickerDialog.show();
        });

        DatePickerDialog.OnDateSetListener date5 = (view, year, month, day) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, day);

            updateLabel5();
        };


        ETanimal_pregnecyaidate.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(ReproductionActivity.this,
                    date5,
                    myCalendar.get(Calendar.YEAR),
                    myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
            datePickerDialog.show();

        });


        DatePickerDialog.OnDateSetListener date6 = (view, year, month, day) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, day);

            updateLabel6();
        };


        ETanimal_expcalvingdate.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(ReproductionActivity.this,
                    date6,
                    myCalendar.get(Calendar.YEAR),
                    myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.getDatePicker().setMinDate(myCalendar.getTimeInMillis());
            datePickerDialog.show();
        });

        DatePickerDialog.OnDateSetListener date7 = (view, year, month, day) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, day);

            updateLabel7();
        };


        ETanimal_atulcalvingdate.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(ReproductionActivity.this,
                    date7,
                    myCalendar.get(Calendar.YEAR),
                    myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.getDatePicker().setMinDate(myCalendar.getTimeInMillis());
            datePickerDialog.show();
        });

        radioGroupsouceby.setOnCheckedChangeListener((radioGroup, i) -> {
            int selectedId = radioGroupsouceby.getCheckedRadioButtonId();
            genderradioButton = findViewById(selectedId);
            if (selectedId == -1) {
             Toast.makeText(ReproductionActivity.this,"Please Select AI",Toast.LENGTH_SHORT).show();
            } else {
                if(genderradioButton.getText().toString().equals("Yes")){

                   // Toast.makeText(ReproductionActivity.this,"Please Select",Toast.LENGTH_SHORT).show();
                    TILreprostsecondno.setVisibility(View.VISIBLE);
                    TILreprostsecondbreed.setVisibility(View.VISIBLE);
                    TILreproseconddate.setVisibility(View.VISIBLE);
                }else{
                    TILreprostsecondno.setVisibility(View.GONE);
                    TILreprostsecondbreed.setVisibility(View.GONE);
                    TILreproseconddate.setVisibility(View.GONE);
                }

            }
        });

        radioagainheat3.setOnCheckedChangeListener((radioGroup, i) -> {
            int selectedId = radioagainheat3.getCheckedRadioButtonId();
            genderradioButton = findViewById(selectedId);
            if (selectedId == -1) {
                Toast.makeText(ReproductionActivity.this,"Please Select",Toast.LENGTH_SHORT).show();
            } else {
                if(genderradioButton.getText().toString().equals("Yes")){

                    // Toast.makeText(ReproductionActivity.this,"Please Select",Toast.LENGTH_SHORT).show();
                    TILreprostfourthno.setVisibility(View.VISIBLE);
                    TILreprostfourthbreed.setVisibility(View.VISIBLE);
                    TILreprofourthdate.setVisibility(View.VISIBLE);
                }else{
                    TILreprostfourthno.setVisibility(View.GONE);
                    TILreprostfourthbreed.setVisibility(View.GONE);
                    TILreprofourthdate.setVisibility(View.GONE);
                }

            }
        });





        radioagainheat4.setOnCheckedChangeListener((radioGroup, i) -> {
            int selectedId = radioagainheat4.getCheckedRadioButtonId();
            genderradioButton = findViewById(selectedId);
            if (selectedId == -1) {
                Toast.makeText(ReproductionActivity.this,"Please Select",Toast.LENGTH_SHORT).show();
            } else {
                if(genderradioButton.getText().toString().equals("Yes")){

                    // Toast.makeText(ReproductionActivity.this,"Please Select",Toast.LENGTH_SHORT).show();
                    TILreprostfifthhno.setVisibility(View.VISIBLE);
                    TILreprostfiftbreed.setVisibility(View.VISIBLE);
                    TILreprofifthdate.setVisibility(View.VISIBLE);
                }else{
                    TILreprostfifthhno.setVisibility(View.GONE);
                    TILreprostfiftbreed.setVisibility(View.GONE);
                    TILreprofifthdate.setVisibility(View.GONE);
                }

            }
        });


        radioagainheat2.setOnCheckedChangeListener((radioGroup, i) -> {
            int selectedId = radioagainheat2.getCheckedRadioButtonId();
            genderradioButton = findViewById(selectedId);
            if (selectedId == -1) {
                Toast.makeText(ReproductionActivity.this,"Please Select",Toast.LENGTH_SHORT).show();
            } else {
                if(genderradioButton.getText().toString().equals("Yes")){

                    // Toast.makeText(ReproductionActivity.this,"Please Select",Toast.LENGTH_SHORT).show();
                    TILreprostthirdno.setVisibility(View.VISIBLE);
                    TILreprostthirdbreed.setVisibility(View.VISIBLE);
                    TILreprothirddate.setVisibility(View.VISIBLE);
                }else{
                    TILreprostthirdno.setVisibility(View.GONE);
                    TILreprostthirdbreed.setVisibility(View.GONE);
                    TILreprothirddate.setVisibility(View.GONE);
                }

            }
        });


        TVreproductionsubmit.setOnClickListener(v -> {
            String amlstrno = String.valueOf(ETanimal_strawno.getText());
            String amlbreed = String.valueOf(ETanimal_breed.getText());
            String amldate = String.valueOf(ETanimal_date.getText());
            String amlsecondstrno = String.valueOf(ETanimal_secondstrw.getText());
            String amlsecondbreed = String.valueOf(ETanimal_secondaibreed.getText());
            String amlseconddate = String.valueOf(ETanimal_secondaidate.getText());
            String amlthirdstno = String.valueOf(ETanimal_thirdstrw.getText());
            String amlthirdbreed = String.valueOf(ETanimal_thirdaibreed.getText());
            String amlthirddate = String.valueOf(ETanimal_thirdaidate.getText());
            String amlfourthstno = String.valueOf(ETanimal_fourthstrw.getText());
            String amlfourthbreed = String.valueOf(ETanimal_fourthaibreed.getText());
            String amlfourthdate = String.valueOf(ETanimal_fourthaidate.getText());
            String amlfifthhstno = String.valueOf(ETanimal_fifthstrw.getText());
            String amlfifthbreed = String.valueOf(ETanimal_fifthaibreed.getText());
            String amlfifthdate = String.valueOf(ETanimal_fiftaidate.getText());
            String pregnecydate = String.valueOf(ETanimal_pregnecyaidate.getText());
            String expcalvingdate = String.valueOf(ETanimal_expcalvingdate.getText());
            String actualdate = String.valueOf(ETanimal_atulcalvingdate.getText());


            String gender = Selectgender(v);

            String gender1;

            if (gender.equals("Yes")) {
                gender1 = "1";
            } else if (gender.equals("No")) {
                gender1 = "2";
            }


            if (animalid.isEmpty()) {
                Toast.makeText(ReproductionActivity.this, "Please select animalID First !", Toast.LENGTH_SHORT).show();
            } else {
                savereproduction(userid, animalid, amlstrno, amlbreed, amldate, amlsecondstrno, amlsecondbreed, amlseconddate, amlthirdstno, amlthirdbreed, amlthirddate, amlfourthstno,
                        amlfourthbreed, amlfourthdate, amlfifthhstno, amlfifthbreed, amlfifthdate, pregnecydate, expcalvingdate, actualdate);
            }


        });

        SPanimaID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                DataItem clickedItem = (DataItem)
                        parent.getItemAtPosition(position);
                animalid = clickedItem.getAnimalId();
                type =clickedItem.getType();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public String Selectgender(View v) {
        int selectedId = radioGroupsouceby.getCheckedRadioButtonId();
        genderradioButton = findViewById(selectedId);
        if (selectedId == -1) {
            return "Please Select Gender!";
        } else {
            return genderradioButton.getText().toString();
        }

    }






    private void savereproduction(String userid, String animalid, String amlstrno, String amlbreed, String amldate, String amlsecondstrno, String amlsecondbreed, String amlseconddate,
                                  String amlthirdstno, String amlthirdbreed, String amlthirddate, String amlfourthstno, String amlfourthbreed, String amlfourthdate, String amlfifthhstno,
                                  String amlfifthbreed, String amlfifthdate, String pregencydate, String expcalvingdate, String actualdate) {


        showLoading();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ApiInterface api = retrofit.create(ApiInterface.class);


        Call<ReproductionResponse> call = api.savereproduction(userid, animalid, amlstrno, amlbreed, amldate, "0", amlsecondstrno, amlsecondbreed, amlseconddate, "0", amlthirdstno,
                amlthirdbreed, amlthirddate, "0", amlfourthstno, amlfourthbreed, amlfourthdate, "0", amlfifthhstno,
                amlfifthbreed, amlfifthdate, "0", "0", pregencydate, expcalvingdate, actualdate);


        call.enqueue(new Callback<ReproductionResponse>() {
            @Override
            public void onResponse(@NonNull Call<ReproductionResponse> call, @NonNull Response<ReproductionResponse> response) {

                if (response.code() == 200) {
                    hideLoading();
                    assert response.body() != null;
                    if (response.body().isStatus()) {
                        ETanimal_strawno.setText("");
                        ETanimal_breed.setText("");
                        ETanimal_date.setText("");
                        ETanimal_secondstrw.setText("");
                        ETanimal_secondaibreed.setText("");
                        ETanimal_secondaidate.setText("");
                        ETanimal_thirdstrw.setText("");
                        ETanimal_thirdaibreed.setText("");
                        ETanimal_thirdaidate.setText("");
                        ETanimal_thirdaidate.setText("");
                        ETanimal_fourthstrw.setText("");
                        ETanimal_fourthaibreed.setText("");
                        ETanimal_fourthaidate.setText("");
                        ETanimal_fifthstrw.setText("");
                        ETanimal_fifthaibreed.setText("");
                        ETanimal_fiftaidate.setText("");
                        ETanimal_pregnecyaidate.setText("");
                        ETanimal_expcalvingdate.setText("");
                        ETanimal_atulcalvingdate.setText("");
                        showdialogconfimation(response.body().getMsg());
                       // Toast.makeText(ReproductionActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    } else {
                        showdialogerror(response.body().getMsg());
                       // Toast.makeText(ReproductionActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }
                } else if (response.code() == 401) {
                    hideLoading();
                    Toast.makeText(ReproductionActivity.this, "Try after sometimes!", Toast.LENGTH_SHORT).show();
                } else {
                    hideLoading();
                    Toast.makeText(ReproductionActivity.this, "Error1*", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ReproductionResponse> call, @NonNull Throwable t) {
                hideLoading();
                Toast.makeText(ReproductionActivity.this, "Exception" + t, Toast.LENGTH_SHORT).show();
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

                        SpinnerAdapterr arrayAdapter = new SpinnerAdapterr(ReproductionActivity.this,response.body().getData());
                        SPanimaID.setAdapter(arrayAdapter);
                    } else {
                        Toast.makeText(ReproductionActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }
                } else if (response.code() == 401) {
                    hideLoading();
                    Toast.makeText(ReproductionActivity.this, "Error", Toast.LENGTH_SHORT).show();
                } else {
                    hideLoading();
                    Toast.makeText(ReproductionActivity.this, "Error1*", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<AnimalidResponse> call, @NonNull Throwable t) {
                hideLoading();
                Toast.makeText(ReproductionActivity.this, "Exception" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateLabel() {
        String myFormat = "dd-MM-yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        ETanimal_date.setText(dateFormat.format(myCalendar.getTime()));
    }

    private void updateLabel1() {
        String myFormat = "dd-MM-yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        ETanimal_secondaidate.setText(dateFormat.format(myCalendar.getTime()));
    }

    private void updateLabel2() {
        String myFormat = "dd-MM-yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        ETanimal_thirdaidate.setText(dateFormat.format(myCalendar.getTime()));
    }

    private void updateLabel3() {
        String myFormat = "dd-MM-yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        ETanimal_fourthaidate.setText(dateFormat.format(myCalendar.getTime()));
    }

    private void updateLabel4() {
        String myFormat = "dd-MM-yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        ETanimal_fiftaidate.setText(dateFormat.format(myCalendar.getTime()));
    }

    private void updateLabel5() {
        String myFormat = "dd-MM-yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        ETanimal_pregnecyaidate.setText(dateFormat.format(myCalendar.getTime()));
        if(type==0) {
            myCalendar.add(Calendar.DATE, 281);
            ETanimal_expcalvingdate.setText(dateFormat.format(myCalendar.getTime()));
        }else{
            myCalendar.add(Calendar.DATE, 310);
            ETanimal_expcalvingdate.setText(dateFormat.format(myCalendar.getTime()));
        }
    }

    private void updateLabel6() {
        String myFormat = "dd-MM-yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        ETanimal_expcalvingdate.setText(dateFormat.format(myCalendar.getTimeInMillis()));
    }

    private void updateLabel7() {
        String myFormat = "dd-MM-yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        ETanimal_atulcalvingdate.setText(dateFormat.format(myCalendar.getTimeInMillis()));
    }
}