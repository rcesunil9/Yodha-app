package com.yodha.gadvasu.Activity;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;

import com.yodha.gadvasu.R;

public class PrivacyPolicyActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
        Toolbar TBtoolabar = findViewById(R.id.TBtoolprivacypolicy);
        setSupportActionBar(TBtoolabar);

        TBtoolabar.setNavigationOnClickListener(view -> finish());
    }
}