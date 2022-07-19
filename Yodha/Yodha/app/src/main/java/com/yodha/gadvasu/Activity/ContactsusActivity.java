package com.yodha.gadvasu.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.yodha.gadvasu.R;

public class ContactsusActivity extends BaseActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactsus);
        Toolbar TBtoolabar = findViewById(R.id.TBtoolcontact);
        TextView TVcantcus = findViewById(R.id.TVcantcus);
        setSupportActionBar(TBtoolabar);

        TVcantcus.setText("co.gadvasu@gmail.com");

        TBtoolabar.setNavigationOnClickListener(view -> finish());
    }
}