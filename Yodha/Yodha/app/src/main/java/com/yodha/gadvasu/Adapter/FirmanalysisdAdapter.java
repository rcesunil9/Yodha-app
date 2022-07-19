package com.yodha.gadvasu.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yodha.gadvasu.Activity.AnimalDetailsActivity;
import com.yodha.gadvasu.Activity.DiseasesActivity;
import com.yodha.gadvasu.Activity.DisesesOccuerActivity;
import com.yodha.gadvasu.Activity.ExpentitureActivity;
import com.yodha.gadvasu.Activity.ExpenturedataanlysisActivity;
import com.yodha.gadvasu.Activity.FirmAnalysisActivity;
import com.yodha.gadvasu.Activity.FortnightActivity;
import com.yodha.gadvasu.Activity.ListofanimalActivity;
import com.yodha.gadvasu.Activity.ProductanalylistActivity;
import com.yodha.gadvasu.Activity.ReproductionActivity;
import com.yodha.gadvasu.Activity.ReproductionAnalaysisActivity;
import com.yodha.gadvasu.Activity.SellActivity;
import com.yodha.gadvasu.Activity.TodayproductionActivity;
import com.yodha.gadvasu.R;
import com.yodha.gadvasu.Utilsdata.Dashmodel;
import com.yodha.gadvasu.Utilsdata.Firmmodel;

import java.util.List;

public class FirmanalysisdAdapter extends RecyclerView.Adapter<FirmanalysisdAdapter.Firmdata> {
    Context mContex;
    List<Firmmodel> mListdash;

    public FirmanalysisdAdapter(Context mContex, List<Firmmodel> mListdash) {
        this.mContex = mContex;
        this.mListdash = mListdash;
    }

    @NonNull
    @Override
    public Firmdata onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContex);
        return new FirmanalysisdAdapter.Firmdata(layoutInflater.inflate(R.layout.firm_customlayout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Firmdata holder, int position) {
        Firmmodel dashmodel = mListdash.get(position);

        holder.TVdashboartit.setText(dashmodel.getTitle());
        holder.IVtitle.setImageResource(dashmodel.getImg());

        holder.itemView.setOnClickListener(view -> {
            switch (dashmodel.getTitle()) {
                case "Sale Analysis":
                    callactiivity(0);
                    break;
                case "Expenditure during Specific Period":
                    callactiivity(1);
                    break;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListdash.size();
    }

    static class Firmdata extends RecyclerView.ViewHolder {

        TextView TVdashboartit;
        ImageView IVtitle;

        public Firmdata(@NonNull View itemView) {

            super(itemView);

            TVdashboartit = itemView.findViewById(R.id.TVdashboartit);
            IVtitle = itemView.findViewById(R.id.IVtitle);
        }
    }

    private void callactiivity(int postion) {
        Intent intent = new Intent();
        switch (postion) {
            case 0:
                intent = new Intent(mContex, SellActivity.class);
                break;
            case 1:
                intent = new Intent(mContex, ExpenturedataanlysisActivity.class);
                break;

        }
        mContex.startActivity(intent);

    }
}
