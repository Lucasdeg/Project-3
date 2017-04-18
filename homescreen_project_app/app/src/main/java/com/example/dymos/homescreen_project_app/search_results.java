package com.example.dymos.homescreen_project_app;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Random;

public class search_results extends AppCompatActivity {

    BarChart barChart;
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        String value1;

        BarChart barChart = (BarChart) findViewById(R.id.BarGraph1);

        ArrayList<BarEntry> barEntries = new ArrayList();
        ArrayList<String> theDates = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            float n = rand.nextInt(50);
            barEntries.add(new BarEntry(n,i));
            String region = Float.toString(i);
            theDates.add(homescreen.selecting.getRegion1());
        }

        
        BarDataSet barDataSet = new BarDataSet(barEntries,"Laaggeletterdheid in %");

        BarData theData = new BarData(theDates,barDataSet);

        BarDataSet barDataSet2 = new BarDataSet(barEntries, "criminaliteit in ");
        //barDataset2.setColor(Color.RED);
        //theData.addDataSet();

        barChart.setData(theData);
        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);
        barChart.setDescription(" ");

        /**
         * Line Graph
         *
         */
        LineChart lineChart = (LineChart) findViewById(R.id.LineChart1);
            ArrayList<Entry> entries = new ArrayList<>();
            entries.add(new Entry(4f, 0));
            entries.add(new Entry(8f, 1));
            entries.add(new Entry(6f, 2));
            entries.add(new Entry(2f, 3));
            entries.add(new Entry(18f, 4));
            entries.add(new Entry(9f, 5));

        ArrayList<String> labels = new ArrayList<String>();
            labels.add("Jan");
            labels.add("Feb");
            labels.add("Mar");
            labels.add("Apr");
            labels.add("May");
            labels.add("Jun");

        LineDataSet dataset = new LineDataSet(entries,"Aantal overvallen");
        LineData data = new LineData(labels, dataset);
        lineChart.setData(data);
        dataset.setDrawFilled(true);
        lineChart.setDescription(" ");

    }
}
