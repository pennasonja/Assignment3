package com.example.a3_assignment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Adapter extends ArrayAdapter <Date> {

    Context mContext;
    int resourceLayout;
    ArrayList<Date> dates;

    public Adapter(@NonNull Context context, int resource, @NonNull ArrayList<Date> date) {
        super(context, resource, date);
        this.resourceLayout=resource;
        this.mContext = context;
        this.dates=date;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(mContext);
            v = vi.inflate(resourceLayout, null);
        }
        final Date currentDate= getItem(position);
        Button delete = (Button) v.findViewById(R.id.btn);
        delete.setTag(position);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dates.remove(position);
                notifyDataSetChanged();
            }
        });
        return v;
    }
}