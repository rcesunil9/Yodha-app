package com.yodha.gadvasu.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yodha.gadvasu.Activity.BaseActivity;
import com.yodha.gadvasu.Activity.ListofanimalActivity;
import com.yodha.gadvasu.ApiResponsedata.Animallistdetails.AnimallistdetdataResponse;
import com.yodha.gadvasu.ApiResponsedata.Animallistdetails.DataItem;
import com.yodha.gadvasu.ApiResponsedata.ApiInterface;
import com.yodha.gadvasu.ApiResponsedata.Deletedata.DeletedataResponse;
import com.yodha.gadvasu.R;

import java.util.List;

import dev.shreyaspatil.MaterialDialog.MaterialDialog;
import dev.shreyaspatil.MaterialDialog.interfaces.DialogInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListofanimalAdapter extends RecyclerView.Adapter<ListofanimalAdapter.Listanimal> {


    Context mContex;
    List<DataItem> mListdash;
    String userid;
    String username;
    ListofanimalActivity listofanimalActivity;
    BaseActivity baseActivity;


    public ListofanimalAdapter(ListofanimalActivity listofanimalActivity,Context mContex, List<DataItem> mListdash, String userid, String username) {
        this.listofanimalActivity = listofanimalActivity;
        this.mContex = mContex;
        this.mListdash = mListdash;
        this.userid = userid;
        this.username = username;
        baseActivity =new BaseActivity();
    }

    @NonNull
    @Override
    public Listanimal onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContex);
        return new ListofanimalAdapter.Listanimal(layoutInflater.inflate(R.layout.listofanimalcustom, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Listanimal holder, int position) {

        DataItem dataItem = mListdash.get(position);
        holder.TVaniamlid.setText(dataItem.getAnimalId());
        holder.TVanimalspecies.setText(dataItem.getSireNo());
        holder.TVanimalbreed.setText(dataItem.getBreed());

        if(dataItem.getSex() ==0){
            holder.TVanimalsex.setText("Female");
        }else if(dataItem.getSex() ==1){
            holder.TVanimalsex.setText("Male");
        }else{
            holder.TVanimalsex.setText("Others");
        }

        holder.TVanimaliddelete.setOnClickListener(v ->  show_dialog(holder.getAdapterPosition(),holder.TVaniamlid.getText().toString()));

    }

    @Override
    public int getItemCount() {
        return mListdash.size();
    }

    static class Listanimal extends RecyclerView.ViewHolder {
        TextView TVaniamlid, TVanimalspecies, TVanimaliddelete,TVanimalsex,TVanimalbreed,TVusernametit;

        public Listanimal(@NonNull View itemView) {
            super(itemView);
            TVaniamlid = itemView.findViewById(R.id.TVaniamlid);
            TVanimalspecies = itemView.findViewById(R.id.TVanimalspecies);
            TVanimaliddelete = itemView.findViewById(R.id.TVanimaliddelete);
            TVanimalsex = itemView.findViewById(R.id.TVanimalsex);
            TVanimalbreed = itemView.findViewById(R.id.TVanimalbreed);
            TVusernametit = itemView.findViewById(R.id.TVusernametit);
        }
    }



    private  void show_dialog(int position,String animalid){
        MaterialDialog mDialog = new MaterialDialog.Builder((Activity) mContex)
                .setTitle("Delete?")
                .setMessage("Are you sure want to delete this file?")
                .setCancelable(false)
                .setPositiveButton("Delete", R.drawable.ic_baseline_delete_24, (dialogInterface, which) -> {
                  //  deleteItem(position);
                    getanimalList(position,animalid);
                    dialogInterface.dismiss();
                    // Delete Operation
                })
                .setNegativeButton("Cancel", R.drawable.ic_baseline_close_24, (dialogInterface, which) -> dialogInterface.dismiss())
                .build();

        // Show Dialog
        mDialog.show();
    }


    private void getanimalList(int position,String animalid) {
        baseActivity.showLoading();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface api = retrofit.create(ApiInterface.class);


        Call<DeletedataResponse> call = api.deleteanimalid(animalid);


        call.enqueue(new Callback<DeletedataResponse>() {
            @Override
            public void onResponse(@NonNull Call<DeletedataResponse> call, @NonNull Response<DeletedataResponse> response) {

                if (response.code() == 200) {
                    baseActivity.hideLoading();
                    assert response.body() != null;
                    if (response.body().isStatus()) {
                            mListdash.remove(position);
                            notifyItemRemoved(position);
                            notifyItemRangeChanged(position, mListdash.size());
                    } else {

                        Toast.makeText(mContex, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }
                } else if (response.code() == 401) {
                    baseActivity.hideLoading();
                    Toast.makeText(mContex, "Something went wrong try after sometimes!", Toast.LENGTH_SHORT).show();
                } else {
                    baseActivity.hideLoading();
                    Toast.makeText(mContex, "Error1*", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<DeletedataResponse> call, @NonNull Throwable t) {
                baseActivity.hideLoading();
                Toast.makeText(mContex, "Exception" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
