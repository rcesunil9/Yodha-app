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
import com.yodha.gadvasu.Activity.FirmAnalysisActivity;
import com.yodha.gadvasu.Activity.FortnightActivity;
import com.yodha.gadvasu.Activity.ListofanimalActivity;
import com.yodha.gadvasu.Activity.ProductAnalsisActivity;
import com.yodha.gadvasu.Activity.ProductanalylistActivity;
import com.yodha.gadvasu.Activity.ReproductionActivity;
import com.yodha.gadvasu.Activity.ReproductionAnalaysisActivity;
import com.yodha.gadvasu.Activity.SellActivity;
import com.yodha.gadvasu.Activity.TodayproductionActivity;
import com.yodha.gadvasu.R;
import com.yodha.gadvasu.Utilsdata.Dashmodel;

import java.util.List;

public class DashBoardAdapter extends RecyclerView.Adapter<DashBoardAdapter.Dashdata> {
    Context mContex;
    List<Dashmodel> mListdash;

    public DashBoardAdapter(Context mContex, List<Dashmodel> mListdash) {
        this.mContex = mContex;
        this.mListdash = mListdash;
    }

    @NonNull
    @Override
    public Dashdata onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContex);
        return new DashBoardAdapter.Dashdata(layoutInflater.inflate(R.layout.dashboarddata, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Dashdata holder, int position) {
        Dashmodel dashmodel = mListdash.get(position);

        holder.TVdashboartit.setText(dashmodel.getTitle());
        holder.IVtitle.setImageResource(dashmodel.getImg());

        holder.itemView.setOnClickListener(view -> {
            switch (dashmodel.getTitle()) {
                case "Enter Animal Details":
                    callactiivity(0);
                    break;
                case "Reproduction":
                    callactiivity(1);
                    break;
                case "Today's Production":
                    callactiivity(2);
                    break;
                case "Expenditure":
                    callactiivity(3);
                    break;
                case "Diseases":
                    callactiivity(4);
                    break;
                case "Fortnight Production":
                    callactiivity(5);
                    break;
                case "List of Animal":
                    callactiivity(6);
                    break;
                case "Reproduction Analysis":
                    callactiivity(7);
                    break;
                case "Production Analysis":
                    callactiivity(8);
                    break;
                case "Disease Occurrence":
                    callactiivity(9);
                    break;
                case "Farm Analysis":
                    callactiivity(10);
                    break;

            }
        });
    }

    @Override
    public int getItemCount() {
        return mListdash.size();
    }

    static class Dashdata extends RecyclerView.ViewHolder {

        TextView TVdashboartit;
        ImageView IVtitle;

        public Dashdata(@NonNull View itemView) {

            super(itemView);

            TVdashboartit = itemView.findViewById(R.id.TVdashboartit);
            IVtitle = itemView.findViewById(R.id.IVtitle);
        }
    }

    private void callactiivity(int postion) {
        Intent intent = new Intent();
        switch (postion) {
            case 0:
                intent = new Intent(mContex, AnimalDetailsActivity.class);
                break;
            case 1:
                intent = new Intent(mContex, ReproductionActivity.class);
                break;
            case 2:
                intent = new Intent(mContex, TodayproductionActivity.class);
                break;
            case 3:
                intent = new Intent(mContex, ExpentitureActivity.class);
                break;
            case 4:
                intent = new Intent(mContex, DiseasesActivity.class);
                break;
            case 5:
                intent = new Intent(mContex, FortnightActivity.class);
                break;
            case 6:
                intent = new Intent(mContex, ListofanimalActivity.class);
                break;
            case 7:
                intent = new Intent(mContex, ReproductionAnalaysisActivity.class);
                break;
            case 8:
                intent = new Intent(mContex, ProductanalylistActivity.class);
                break;
            case 9:
                intent = new Intent(mContex, DisesesOccuerActivity.class);
                break;
            case 10:
                intent = new Intent(mContex, FirmAnalysisActivity.class);
                break;


        }
        mContex.startActivity(intent);

    }
}
