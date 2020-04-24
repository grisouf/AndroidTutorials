package com.gridev.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class UserItemAdapter extends ArrayAdapter {

    private Context context;
    private int resource;

    public UserItemAdapter(@NonNull Context context, int resource, @NonNull List<User> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(resource, parent, false);

        String name = ((User) getItem(position)).getName();
        int age = ((User) getItem(position)).getAge();

        TextView mName = convertView.findViewById(R.id.itemPersonName);
        TextView mAge = convertView.findViewById(R.id.itemPersonAge);

        mName.setText(name);
        mAge.setText(String.valueOf(age));

        return convertView;
    }
}








