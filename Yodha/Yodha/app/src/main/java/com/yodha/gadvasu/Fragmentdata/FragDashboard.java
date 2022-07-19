package com.yodha.gadvasu.Fragmentdata;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yodha.gadvasu.Adapter.DashBoardAdapter;
import com.yodha.gadvasu.R;
import com.yodha.gadvasu.Utilsdata.Dashmodel;

import java.util.ArrayList;
import java.util.List;

public class FragDashboard extends BaseFragment {
    RecyclerView RLdashboard, RLdashboard1;

    List<Dashmodel> mListdash;
    List<Dashmodel> mListdash1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_dashboard, container, false);
        RLdashboard = view.findViewById(R.id.RLdashboard);
        RLdashboard1 = view.findViewById(R.id.RLdashboard1);
        mListdash = new ArrayList<>();
        mListdash1 = new ArrayList<>();
        addtitle();
        addtitle1();
        return view;
    }

    private void addtitle() {
        mListdash.add(new Dashmodel("Enter Animal Details", R.drawable.ic_baseline_add_circle_24));
        mListdash.add(new Dashmodel("Reproduction", R.mipmap.animal));
        mListdash.add(new Dashmodel("Today's Production", R.mipmap.milk_box));
        mListdash.add(new Dashmodel("Expenditure", R.mipmap.budget));
        mListdash.add(new Dashmodel("Diseases", R.mipmap.autoimmune_disease));
        mListdash.add(new Dashmodel("Fortnight Production", R.mipmap.fitteenminutes));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // set Horizontal Orientation
        RLdashboard.setLayoutManager(gridLayoutManager);
        DashBoardAdapter dashBoardAdapter = new DashBoardAdapter(getActivity(), mListdash);
        RLdashboard.setAdapter(dashBoardAdapter);
    }


    private void addtitle1() {
        mListdash1.add(new Dashmodel("List of Animal", R.mipmap.list));
        mListdash1.add(new Dashmodel("Reproduction Analysis", R.mipmap.data_analysis));
        mListdash1.add(new Dashmodel("Production Analysis", R.mipmap.analysis));
        mListdash1.add(new Dashmodel("Disease Occurrence", R.mipmap.bacteria));
        mListdash1.add(new Dashmodel("Farm Analysis", R.mipmap.sales));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // set Horizontal Orientation
        RLdashboard1.setLayoutManager(gridLayoutManager);
        DashBoardAdapter dashBoardAdapter = new DashBoardAdapter(getActivity(), mListdash1);
        RLdashboard1.setAdapter(dashBoardAdapter);
    }
}
