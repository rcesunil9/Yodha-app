package com.yodha.gadvasu.Activity;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.yodha.gadvasu.R;

public class NotificationActivity extends BaseActivity {

    RecyclerView RLnotification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        Toolbar TBtoolabar = findViewById(R.id.TBtoolnotification);
        RLnotification = findViewById(R.id.RLnotification);


        setSupportActionBar(TBtoolabar);

        TBtoolabar.setNavigationOnClickListener(view -> finish());
    }
}