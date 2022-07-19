package com.yodha.gadvasu.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.yodha.gadvasu.BuildConfig;
import com.yodha.gadvasu.R;

public class AboutActivity extends BaseActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar TBtoolabar = findViewById(R.id.TBtoolabout);
        TextView TVversion = findViewById(R.id.TVversion);
        setSupportActionBar(TBtoolabar);
        TVversion.setText("App version: "+BuildConfig.VERSION_NAME);
        TBtoolabar.setNavigationOnClickListener(view -> finish());
    }
}