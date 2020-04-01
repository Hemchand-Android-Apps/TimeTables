package com.example.timetables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    ListView listView;
    ArrayAdapter<String> timeTableAdapter;
    ArrayList<String> timeTableArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        listView = (ListView) findViewById(R.id.listView);

        seekBar.setMax(20);
        seekBar.setProgress(10);
        generateTimeTable(seekBar.getProgress());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress < 1) {
                    generateTimeTable(1);
                } else {
                    generateTimeTable(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void generateTimeTable(int number) {
        timeTableArray = new ArrayList<String>();
        for (int i = 1; i <= 100; i++) {
            timeTableArray.add(number + " * " + i + " = " + number * i);
        }
        timeTableAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, timeTableArray);
        listView.setAdapter(timeTableAdapter);
    }
}
