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
import com.yodha.gadvasu.Activity.FortnightActivity;
import com.yodha.gadvasu.Activity.FortnightdetailsActivity;
import com.yodha.gadvasu.Activity.ListofanimalActivity;
import com.yodha.gadvasu.Activity.ProductAnalsisActivity;
import com.yodha.gadvasu.Activity.ReproductionActivity;
import com.yodha.gadvasu.Activity.ReproductionAnalaysisActivity;
import com.yodha.gadvasu.Activity.SellActivity;
import com.yodha.gadvasu.Activity.TodayproductionActivity;
import com.yodha.gadvasu.R;
import com.yodha.gadvasu.Utilsdata.Dashmodel;

import java.util.List;

public class ProductanalysisAdapter extends RecyclerView.Adapter<ProductanalysisAdapter.Dashdata> {
    Context mContex;
    List<Dashmodel> mListdash;

    public ProductanalysisAdapter(Context mContex, List<Dashmodel> mListdash) {
        this.mContex = mContex;
        this.mListdash = mListdash;
    }

    @NonNull
    @Override
    public Dashdata onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContex);
        return new ProductanalysisAdapter.Dashdata(layoutInflater.inflate(R.layout.dashboarddata, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Dashdata holder, int position) {
        Dashmodel dashmodel = mListdash.get(position);

        holder.TVdashboartit.setText(dashmodel.getTitle());
        holder.IVtitle.setImageResource(dashmodel.getImg());

        holder.itemView.setOnClickListener(view -> {
            switch (dashmodel.getTitle()) {
                case "Today Production":
                    callactiivity(0);
                    break;
                case "Fortnight Production":
                    callactiivity(1);
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
                intent = new Intent(mContex, ProductAnalsisActivity.class);
                break;
            case 1:
                intent = new Intent(mContex, FortnightdetailsActivity.class);
                break;
        }
        mContex.startActivity(intent);

    }
}
