package com.dev.bodyfatcalculator.views.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dev.bodyfatcalculator.R;
import com.dev.bodyfatcalculator.model.Profile;

import java.util.List;

public class HistoryAdapter extends ArrayAdapter {

    private Context context;
    private int resource;

    public HistoryAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(resource, parent, false);

        Profile profile = (Profile) getItem(position);

        TextView height = convertView.findViewById(R.id.item_height);
        TextView weight = convertView.findViewById(R.id.item_weight);
        TextView age = convertView.findViewById(R.id.item_age);
        TextView gender = convertView.findViewById(R.id.item_gender);

        height.setText(String.valueOf(profile.getHeight()));
        weight.setText(String.valueOf(profile.getWeight()));
        age.setText(String.valueOf(profile.getAge()));
        if (profile.getGender() == 0) {
            gender.setText("Female");
        }
        else {
            gender.setText("Male");
        }

        return convertView;
    }
}
