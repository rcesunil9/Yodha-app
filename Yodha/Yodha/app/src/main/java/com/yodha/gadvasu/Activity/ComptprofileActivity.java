package com.yodha.gadvasu.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yodha.gadvasu.ApiResponsedata.ApiInterface;
import com.yodha.gadvasu.ApiResponsedata.Completepro.CompleteResponse;
import com.yodha.gadvasu.ApiResponsedata.Signupdata.SignupResponse;
import com.yodha.gadvasu.MainActivity;
import com.yodha.gadvasu.Otherdatacls.Sharepredata;
import com.yodha.gadvasu.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ComptprofileActivity extends BaseActivity {
    TextView TVcomplete, TvloginTerm;
    TextInputEditText ETname, ETfarmname, ETstreet, ETcityvillage, ETpincode, ETdistric, ETstate, ETage;
    RadioButton radioMale, radioFemale, radioothers, radiofifth, radiotenth, radiograduate, radiograduated, radiolarge, radiomedium, radiosmall, radiononcommercial;
    CheckBox checkboxterms;
    boolean checkbox = false;
    RadioButton genderradioButton, educationradioButton, farmsizeradioButton;
    RadioGroup radioGroupGender, radioGroupeducation, radioGroupefarmsize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comptprofile);
        TVcomplete = findViewById(R.id.TVcomplete);
        ETname = findViewById(R.id.ETname);
        ETfarmname = findViewById(R.id.ETfarmname);
        ETstreet = findViewById(R.id.ETstreet);
        ETcityvillage = findViewById(R.id.ETcityvillage);
        ETpincode = findViewById(R.id.ETpincode);
        ETdistric = findViewById(R.id.ETdistric);
        ETstate = findViewById(R.id.ETstate);
        ETage = findViewById(R.id.ETage);
        radioMale = findViewById(R.id.radioMale);
        radioFemale = findViewById(R.id.radioFemale);
        radioothers = findViewById(R.id.radioothers);
        radiofifth = findViewById(R.id.radiofifth);
        radiotenth = findViewById(R.id.radiotenth);
        radiograduate = findViewById(R.id.radiograduate);
        radiograduated = findViewById(R.id.radiograduated);
        radiolarge = findViewById(R.id.radiolarge);
        radiomedium = findViewById(R.id.radiomedium);
        radiosmall = findViewById(R.id.radiosmall);
        radiononcommercial = findViewById(R.id.radiononcommercial);
        checkboxterms = findViewById(R.id.checkboxterms);
        TvloginTerm = findViewById(R.id.TvloginTerm);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioGroupeducation = findViewById(R.id.radioGroupeducation);
        radioGroupefarmsize = findViewById(R.id.radioGroupefarmsize);
        String Usermobile = sharepreference.getData(Sharepredata.USERMOBILE);
        String Useremail = sharepreference.getData(Sharepredata.USEREMAIL);


        SpannableString SpanString = new SpannableString(
                "By Complete Profile you agree to the Terms of Use!");


        ClickableSpan teremsAndCondition = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Intent mIntent = new Intent(ComptprofileActivity.this, TermscondiActivity.class);
                mIntent.putExtra("isTermsAndCondition", true);
                startActivity(mIntent);

            }
        };


        SpanString.setSpan(teremsAndCondition, 37, 49, 0);
        SpanString.setSpan(new ForegroundColorSpan(Color.BLUE), 37, 49, 0);
        SpanString.setSpan(new UnderlineSpan(), 37, 49, 0);


        TvloginTerm.setMovementMethod(LinkMovementMethod.getInstance());
        TvloginTerm.setText(SpanString, TextView.BufferType.SPANNABLE);
        TvloginTerm.setSelected(true);

        checkboxterms.setOnClickListener(v -> {
            checkbox = ((CheckBox) v).isChecked();
        });


        TVcomplete.setOnClickListener(view -> {


            if (checkbox) {
                String Username = String.valueOf(ETname.getText());
                String Userage = String.valueOf(ETage.getText());
                String Userfarmsname = String.valueOf(ETfarmname.getText());
                String Userstreet = String.valueOf(ETstreet.getText());
                String Usercity = String.valueOf(ETcityvillage.getText());
                String Userpicode = String.valueOf(ETpincode.getText());
                String Userdistric = String.valueOf(ETdistric.getText());
                String Userstate = String.valueOf(ETstate.getText());
                String gender = Selectgender(view);
                String farmsize = Selectfarmsize(view);
                String gender1;
                String farmsize1;
                if(gender.equals("Male")){
                    gender1 ="1";
                }else if(gender.equals("Female")){
                    gender1 ="2";
                }else{
                    gender1 ="3";
                }



                if(farmsize.equals("Large(>100)")){
                    farmsize1 ="1";
                }else if(farmsize.equals("Madium(31 to 100)")){
                    farmsize1 ="2";
                }else if(farmsize.equals("Non-commercial house hold purpose(<10)")){
                    farmsize1 ="2";
                }
                else{
                    farmsize1 ="4";
                }

                String education = Selecteducation(view);



                if (TextUtils.isEmpty(Username)) {
                    Toast.makeText(ComptprofileActivity.this, "EmailID is Required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (gender.equals("Please Select Gender!")) {
                    Toast.makeText(ComptprofileActivity.this, "Gender is Required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(Userage)) {
                    Toast.makeText(ComptprofileActivity.this, "Age is Required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (education.equals("Please Select Education!")) {
                    Toast.makeText(ComptprofileActivity.this, "Education is Required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (farmsize.equals("Please Select FarmSize!")) {
                    Toast.makeText(ComptprofileActivity.this, "FarmSize is Required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(Userfarmsname)) {
                    Toast.makeText(ComptprofileActivity.this, "Address is Required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(Userstreet)) {
                    Toast.makeText(ComptprofileActivity.this, "Street is Required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(Usercity)) {
                    Toast.makeText(ComptprofileActivity.this, "City is Required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(Userpicode)) {
                    Toast.makeText(ComptprofileActivity.this, "Pincode is Required!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Userdistric)) {
                    Toast.makeText(ComptprofileActivity.this, "District is Required!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Userstate)) {
                    Toast.makeText(ComptprofileActivity.this, "State is Required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Completeprofile(Usermobile, Username, Useremail, gender1, Userage, education, farmsize1, Userfarmsname, "ludhiana", Userstreet, Usercity, Userpicode, Userdistric, Userstate);

            } else {
                Toast.makeText(ComptprofileActivity.this, "Please accept Terms and condition!", Toast.LENGTH_SHORT).show();
            }

        });
    }


    public String Selectgender(View v) {
        int selectedId = radioGroupGender.getCheckedRadioButtonId();
        genderradioButton = (RadioButton) findViewById(selectedId);
        if (selectedId == -1) {
            return "Please Select Gender!";
        } else {
            return genderradioButton.getText().toString();
        }

    }

    public String Selecteducation(View v) {
        int selectedId = radioGroupeducation.getCheckedRadioButtonId();
        educationradioButton = (RadioButton) findViewById(selectedId);
        if (selectedId == -1) {
            return "Please Select Education!";
        } else {
            return genderradioButton.getText().toString();
        }

    }


    public String Selectfarmsize(View v) {
        int selectedId = radioGroupefarmsize.getCheckedRadioButtonId();
        farmsizeradioButton = (RadioButton) findViewById(selectedId);
        if (selectedId == -1) {
            return "Please Select FarmSize!";
        } else {
            return genderradioButton.getText().toString();
        }

    }


    private void Completeprofile(String mobile, String name, String email, String gender, String age, String Education, String faemsize, String farmName, String address, String street, String city, String pincode, String distric, String state) {
        showLoading();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ApiInterface api = retrofit.create(ApiInterface.class);


        Call<CompleteResponse> call = api.getcompleteprofile(mobile, name, email, gender, age, Education, faemsize, farmName, address, street, city, pincode,state, distric );


        call.enqueue(new Callback<CompleteResponse>() {
            @Override
            public void onResponse(@NonNull Call<CompleteResponse> call, @NonNull Response<CompleteResponse> response) {

                if (response.code() == 200) {
                    hideLoading();
                    assert response.body() != null;
                    if (response.body().isStatus()) {
                        sharepreference.setBooleanData(Sharepredata.HAS_LOGIN, true);
                        sharepreference.setData(Sharepredata.GENDER,response.body().getData().getGender());
                        sharepreference.setData(Sharepredata.EDUCATION,response.body().getData().getEducation());
                        sharepreference.setData(Sharepredata.FARMNAME,response.body().getData().getFarmName());
                        sharepreference.setData(Sharepredata.FARMSIZE,response.body().getData().getFarmSize());
                        sharepreference.setData(Sharepredata.STREET,response.body().getData().getStreet());
                        sharepreference.setData(Sharepredata.CITY,response.body().getData().getTown());
                        sharepreference.setData(Sharepredata.DISTRIC,response.body().getData().getDistrict());
                        sharepreference.setData(Sharepredata.STATE,response.body().getData().getState());
                        Intent intent = new Intent(ComptprofileActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(ComptprofileActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }
                } else if (response.code() == 401) {
                    hideLoading();
                    Toast.makeText(ComptprofileActivity.this, "Error", Toast.LENGTH_SHORT).show();
                } else {
                    hideLoading();
                    Toast.makeText(ComptprofileActivity.this, "Error1*", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<CompleteResponse> call, @NonNull Throwable t) {
                hideLoading();
                Toast.makeText(ComptprofileActivity.this, "Exception" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }
}