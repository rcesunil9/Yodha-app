package com.yodha.gadvasu.Activity;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yodha.gadvasu.Adapter.ProductanalysisAdapter;
import com.yodha.gadvasu.R;
import com.yodha.gadvasu.Utilsdata.Dashmodel;

import java.util.ArrayList;
import java.util.List;

public class ProductanalylistActivity extends BaseActivity {
    RecyclerView RLproductionanalysisi;
    List<Dashmodel> mListdash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productanalylist);
        Toolbar TBtoolabar = findViewById(R.id.TBtoolprodtanalysis);
        setSupportActionBar(TBtoolabar);

        TBtoolabar.setNavigationOnClickListener(view -> finish());
        RLproductionanalysisi = findViewById(R.id.RLproductionanalysisi);
        mListdash = new ArrayList<>();
        addtitle();

    }

    private void addtitle() {
        mListdash.add(new Dashmodel("Today Production", R.mipmap.milk_box));
        mListdash.add(new Dashmodel("Fortnight Production", R.mipmap.fitteenminutes));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(ProductanalylistActivity.this, 2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // set Horizontal Orientation
        RLproductionanalysisi.setLayoutManager(gridLayoutManager);
        ProductanalysisAdapter dashBoardAdapter = new ProductanalysisAdapter(ProductanalylistActivity.this, mListdash);
        RLproductionanalysisi.setAdapter(dashBoardAdapter);
    }

}