package com.example.assignment1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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
            view = LayoutInflater.from(getContext()).inflate(R.layout.log, parent, false);
        else
            view = convertView;

        Log log = getItem(position);
        android.util.Log.d("Array", "test");

        TextView emotionName =view.findViewById(R.id.emotionText);
        TextView timestampName = view.findViewById(R.id.timestampText);

        emotionName.setText(log.getEmotion());
        timestampName.setText(log.getTimestamp().toString());

        return view;
    }

}
