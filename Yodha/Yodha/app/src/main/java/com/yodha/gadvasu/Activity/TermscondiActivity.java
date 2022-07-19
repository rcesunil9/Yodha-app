package com.yodha.gadvasu.Activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.yodha.gadvasu.R;

public class TermscondiActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termscondi);
        Toolbar TBtoolabar = findViewById(R.id.TBtooltermscondition);

        setSupportActionBar(TBtoolabar);

        TBtoolabar.setNavigationOnClickListener(view -> finish());
    }
}