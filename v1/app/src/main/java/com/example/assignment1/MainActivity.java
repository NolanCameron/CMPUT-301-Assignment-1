package com.example.assignment1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity{

    private ArrayList<Log> logs;
    private ListView logList;
    private LogArrayAdapter logAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button happyBtn = findViewById(R.id.happyButton);
        Button angryBtn = findViewById(R.id.angryButton);
        Button excitedBtn = findViewById(R.id.excitedButton);
        Button tiredBtn = findViewById(R.id.tiredButton);
        Button gratefulBtn = findViewById(R.id.gratefulButton);
        Button sadBtn = findViewById(R.id.sadButton);

        logs = new ArrayList<>();

        logAdapter = new LogArrayAdapter(this, logs);
        View logPageView = LayoutInflater.from(this).inflate(R.layout.logpage, null);
        logList = logPageView.findViewById(R.id.logList);
        logList.setAdapter(logAdapter);

        findViewById(R.id.logButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LogListFragment().show(getSupportFragmentManager(), "Log");
            }
        });

        

        happyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 addLog(Emotion.HAPPY);
            }
        });

        angryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addLog(Emotion.ANGRY);
            }
        });

        excitedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addLog(Emotion.EXCITED);
            }
        });

        tiredBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addLog(Emotion.TIRED);
            }
        });

        gratefulBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addLog(Emotion.GRATEFUL);
            }
        });

        sadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addLog(Emotion.SAD);
            }
        });

    }

    public void addLog(Emotion emotion){
        logs.add(new Log(emotion, new Date()));
        logAdapter.notifyDataSetChanged();
        android.util.Log.d("MainActivity", "logs");
        android.util.Log.d("MainActivity", String.valueOf(logs.size()));
    }


}
