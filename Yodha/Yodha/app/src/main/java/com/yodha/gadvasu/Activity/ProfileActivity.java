package com.yodha.gadvasu.Activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.yodha.gadvasu.Otherdatacls.Sharepredata;
import com.yodha.gadvasu.R;

public class ProfileActivity extends BaseActivity {
    TextView username, email, mobile, TVEducation, TVGender, TVFarmname, TVFarmsize, TVstreet, TVcity, TVdistric, TVstate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar TBtoolabar = findViewById(R.id.TBtoolprofile);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        mobile = findViewById(R.id.mobile);
        TVEducation = findViewById(R.id.TVEducation);
        TVGender = findViewById(R.id.TVGender);
        TVFarmname = findViewById(R.id.TVFarmname);
        TVFarmsize = findViewById(R.id.TVFarmsize);
        TVstreet = findViewById(R.id.TVstreet);
        TVcity = findViewById(R.id.TVcity);
        TVdistric = findViewById(R.id.TVdistric);
        TVstate = findViewById(R.id.TVstate);
        setSupportActionBar(TBtoolabar);

        TBtoolabar.setNavigationOnClickListener(view -> finish());

        String Username = sharepreference.getData(Sharepredata.USERNAME);
        String Useremail = sharepreference.getData(Sharepredata.USEREMAIL);
        String Usermobile = sharepreference.getData(Sharepredata.USERMOBILE);
        String Usergender="";
        if(sharepreference.getData(Sharepredata.GENDER).equals("1")){
            Usergender ="Female";
        }else{
            Usergender ="Male";
        }

        String UserEducation = sharepreference.getData(Sharepredata.EDUCATION);
        String Userfname = sharepreference.getData(Sharepredata.FARMNAME);
        String Userfsize = sharepreference.getData(Sharepredata.FARMSIZE);
        String Userstreet = sharepreference.getData(Sharepredata.STREET);
        String Usercity = sharepreference.getData(Sharepredata.CITY);
        String Userdistric = sharepreference.getData(Sharepredata.DISTRIC);
        String Userstate = sharepreference.getData(Sharepredata.STATE);

        if (username != null) {
            username.setText(Username);
            email.setText(Useremail);
            mobile.setText(Usermobile);
            TVGender.setText(Usergender);
            TVEducation.setText(UserEducation);
            TVFarmname.setText(Userfname);
            TVFarmsize.setText(Userfsize);
            TVstreet.setText(Userstreet);
            TVcity.setText(Usercity);
            TVdistric.setText(Userdistric);
            TVstate.setText(Userstate);
        }


    }
}