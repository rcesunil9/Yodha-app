package com.yodha.gadvasu.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yodha.gadvasu.ApiResponsedata.Animaldetailsdata.AnimalsubmitResponse;
import com.yodha.gadvasu.ApiResponsedata.ApiInterface;
import com.yodha.gadvasu.ApiResponsedata.Signupdata.SignupResponse;
import com.yodha.gadvasu.MainActivity;
import com.yodha.gadvasu.Otherdatacls.Sharepredata;
import com.yodha.gadvasu.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AnimalDetailsActivity extends BaseActivity {
    TextInputEditText ETanimalid, ETspacies, ETbreed, ETdob, ETsireno, ETdam, ETdateofpurchage, ETpurchagefrom, ETownerscontacts, ETanimaltags;
    RadioGroup RGanimalgender;
    RadioButton radioMale, radioFemale;
    AppCompatSpinner SPtype;
    RadioButton genderradioButton;
    TextView TVsubmit;
    final Calendar myCalendar = Calendar.getInstance();
    String animaltype="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_details);
        Toolbar TBtoolabar = findViewById(R.id.TBtoolAnmldetails);
        ETanimalid = findViewById(R.id.ETanimalid);
        ETspacies = findViewById(R.id.ETspacies);
        ETbreed = findViewById(R.id.ETbreed);
        ETdob = findViewById(R.id.ETdob);
        ETsireno = findViewById(R.id.ETsireno);
        ETdam = findViewById(R.id.ETdam);
        ETdateofpurchage = findViewById(R.id.ETdateofpurchage);
        ETpurchagefrom = findViewById(R.id.ETpurchagefrom);
        SPtype = findViewById(R.id.SPtype);
        TVsubmit = findViewById(R.id.TVsubmit);
        RGanimalgender = findViewById(R.id.RGanimalgender);
        radioMale = findViewById(R.id.radioMale);
        radioFemale = findViewById(R.id.radioFemale);
        ETownerscontacts = findViewById(R.id.ETownerscontacts);
        ETanimaltags = findViewById(R.id.ETanimaltags);
        setSupportActionBar(TBtoolabar);

        TBtoolabar.setNavigationOnClickListener(view -> finish());

        ArrayList<String> list = new ArrayList<>();
        list.add("Calf");
        list.add("Heifer");
        list.add("Pregnant");
        list.add("Yielder");
        list.add("Dry Animal");

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, list);
        SPtype.setAdapter(adapter);


        DatePickerDialog.OnDateSetListener date = (view, year, month, day) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, day);

            updateLabel();
        };

        ETdob.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog   =  new DatePickerDialog(AnimalDetailsActivity.this,
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

        ETdateofpurchage.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog   =  new DatePickerDialog(AnimalDetailsActivity.this,
                    date1,
                    myCalendar.get(Calendar.YEAR),
                    myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
            datePickerDialog.show();
        });


        TVsubmit.setOnClickListener(v -> {
            String animalid = String.valueOf(ETanimalid.getText());
            String anspacies = String.valueOf(ETspacies.getText());
            String anbreed = String.valueOf(ETbreed.getText());
            String andob = String.valueOf(ETdob.getText());
            String ansireno = String.valueOf(ETsireno.getText());
            String andam = String.valueOf(ETdam.getText());
            String andateofpurchage = String.valueOf(ETdateofpurchage.getText());
            String anpurchagefrom = String.valueOf(ETpurchagefrom.getText());
            String anocontacs = String.valueOf(ETownerscontacts.getText());
            String angeotag = String.valueOf(ETanimaltags.getText());


            String gender = Selectgender(v);

            String gender1="";

            if(gender.equals("Male")){
                gender1 ="1";
            }else if(gender.equals("Female")){
                gender1 ="2";
            }


            if (TextUtils.isEmpty(animalid)) {
                Toast.makeText(AnimalDetailsActivity.this, "AnimalID is Required", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(anspacies)) {
                Toast.makeText(AnimalDetailsActivity.this, "Spacies is Required", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(anbreed)) {
                Toast.makeText(AnimalDetailsActivity.this, "Breed is  Required", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(andob)) {
                Toast.makeText(AnimalDetailsActivity.this, "DOB is  Required", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(ansireno)) {
                Toast.makeText(AnimalDetailsActivity.this, "Breed is  Required", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(andam)) {
                Toast.makeText(AnimalDetailsActivity.this, "Dam is  Required", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(andateofpurchage)) {
                Toast.makeText(AnimalDetailsActivity.this, "Date of Purchage is  Required", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(anpurchagefrom)) {
                Toast.makeText(AnimalDetailsActivity.this, "Purchage From is  Required", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(anocontacs)) {
                Toast.makeText(AnimalDetailsActivity.this, "OwnersContacs is  Required", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(angeotag)) {
                Toast.makeText(AnimalDetailsActivity.this, "Purchage From is  Required", Toast.LENGTH_SHORT).show();
                return;
            }
            String userid = sharepreference.getData(Sharepredata.USERID);
            if (userid != null) {
                Toast.makeText(AnimalDetailsActivity.this, userid, Toast.LENGTH_SHORT).show();
                animaldetails(userid,animalid,anspacies,anbreed,gender1,"2",andob,ansireno,andam,andateofpurchage,"village",anpurchagefrom,anocontacs,angeotag);
            }

        });



        SPtype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                animaltype = String.valueOf(position+1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public String Selectgender(View v) {
        int selectedId = RGanimalgender.getCheckedRadioButtonId();
        genderradioButton = findViewById(selectedId);
        if (selectedId == -1) {
            return "Please Select Gender!";
        } else {
            return genderradioButton.getText().toString();
        }

    }


    private void animaldetails(String userid,String animalid, String anispecies, String breed,String sex,String type,String dob,String sire_no,String dam_no,String dateofpurchase,String source_of_purchase,String purchased_from,String owner_mobile,String geotag) {
        showLoading();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ApiInterface api = retrofit.create(ApiInterface.class);


        Call<AnimalsubmitResponse> call = api.animaldetails(userid,animalid,anispecies, breed, sex,type,dob,sire_no,dam_no,dateofpurchase,source_of_purchase,purchased_from,owner_mobile,geotag);


        call.enqueue(new Callback<AnimalsubmitResponse>() {
            @Override
            public void onResponse(@NonNull Call<AnimalsubmitResponse> call, @NonNull Response<AnimalsubmitResponse> response) {

                if (response.code() == 200) {
                    hideLoading();
                    assert response.body() != null;
                    if (response.body().isStatus()) {
                        Intent intent = new Intent(AnimalDetailsActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(AnimalDetailsActivity.this, "Something Went Wrong! Try After Sometimes!", Toast.LENGTH_SHORT).show();
                    }
                } else if (response.code() == 401) {
                    hideLoading();
                    Toast.makeText(AnimalDetailsActivity.this, "Server Down!", Toast.LENGTH_SHORT).show();
                } else {
                    hideLoading();
                    Toast.makeText(AnimalDetailsActivity.this, "Something Went Wrong! Try After Sometimes.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<AnimalsubmitResponse> call, @NonNull Throwable t) {
                hideLoading();
                Toast.makeText(AnimalDetailsActivity.this, "Exception" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void updateLabel() {
        String myFormat = "dd-MM-yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        ETdob.setText(dateFormat.format(myCalendar.getTime()));

    }

    private void updateLabel1() {
        String myFormat = "dd-MM-yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        ETdateofpurchage.setText(dateFormat.format(myCalendar.getTime()));
    }
}