package com.example.assignment1;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class LogArrayAdapter extends ArrayAdapter<Log> {

    public LogArrayAdapter(Context context, ArrayList<Log> logs) {
        super(context, 0, logs);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View view;
        if (convertView == null)
            view = LayoutInflater.from(getContext()).inflate(R.layout.content, parent, false);
        else
            view = convertView;

        City city = getItem(position);

        TextView cityName =view.findViewById(R.id.city_text);
        TextView provinceName =view.findViewById(R.id.province_text);

        cityName.setText(city.getName());
        provinceName.setText(city.getProvince());

        return view;
    }

}
