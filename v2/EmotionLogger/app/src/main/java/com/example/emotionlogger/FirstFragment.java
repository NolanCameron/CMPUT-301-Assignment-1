package com.example.emotionlogger;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.emotionlogger.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.Date;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private ArrayList<Log> logs;
    private LogArrayAdapter logAdapter;
    private ListView logList;


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.logButton.setOnClickListener(v ->
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment)
        );

        Button happyBtn = view.findViewById(R.id.happyButton);
        Button angryBtn = view.findViewById(R.id.angryButton);
        Button excitedBtn = view.findViewById(R.id.excitedButton);
        Button tiredBtn = view.findViewById(R.id.tiredButton);
        Button gratefulBtn = view.findViewById(R.id.gratefulButton);
        Button sadBtn = view.findViewById(R.id.sadButton);

        logs = new ArrayList<>();

        logAdapter = new LogArrayAdapter(SecondFragment, logs);
        View logPageView = LayoutInflater.from(this).inflate(R.layout.logpage, null);
        logList = logPageView.findViewById(R.id.logList);
        logList.setAdapter(logAdapter);


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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void addLog(Emotion emotion){
        logs.add(new Log(emotion, new Date()));
        logAdapter.notifyDataSetChanged();
        android.util.Log.d("MainActivity", "logs");
        android.util.Log.d("MainActivity", String.valueOf(logs.size()));
    }

}