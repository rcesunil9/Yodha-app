package com.yodha.gadvasu.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yodha.gadvasu.ApiResponsedata.AnimalIDdata.DataItem;
import com.yodha.gadvasu.R;

import java.util.ArrayList;
import java.util.List;

public class SpinnerAdapterr  extends ArrayAdapter<DataItem> {

    public SpinnerAdapterr(Context context,
                          List<DataItem> algorithmList)
    {
        super(context, 0, algorithmList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable
            View convertView, @NonNull ViewGroup parent)
    {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable
            View convertView, @NonNull ViewGroup parent)
    {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView,
                          ViewGroup parent)
    {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_layout, parent, false);
        }

        TextView textViewName = convertView.findViewById(R.id.Sptext);
        DataItem currentItem = getItem(position);

        if (currentItem != null) {
            textViewName.setText(currentItem.getAnimalId());
        }
        return convertView;
    }
}