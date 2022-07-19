package com.yodha.gadvasu.Activity;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.yodha.gadvasu.Adapter.FirmanalysisdAdapter;
import com.yodha.gadvasu.R;
import com.yodha.gadvasu.Utilsdata.Firmmodel;

import java.util.ArrayList;
import java.util.List;

public class FirmAnalysisActivity extends BaseActivity {
    RecyclerView RLproductionanalysisi;
    List<Firmmodel> mListdash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firm_analysis);
        Toolbar TBtoolabar = findViewById(R.id.TBtoollistofanimal);
        RLproductionanalysisi = findViewById(R.id.RLproductionanalysisi);
        setSupportActionBar(TBtoolabar);

        TBtoolabar.setNavigationOnClickListener(view -> finish());
        mListdash = new ArrayList<>();
        addtitle();
    }

    private void addtitle() {
        mListdash.add(new Firmmodel("Sale Analysis", R.mipmap.sales));
        mListdash.add(new Firmmodel("Expenditure during Specific Period", R.mipmap.budget));
        FirmanalysisdAdapter dashBoardAdapter = new FirmanalysisdAdapter(FirmAnalysisActivity.this, mListdash);
        RLproductionanalysisi.setAdapter(dashBoardAdapter);
    }
}