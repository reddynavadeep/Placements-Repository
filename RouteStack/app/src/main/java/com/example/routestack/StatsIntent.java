package com.example.routestack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class StatsIntent extends AppCompatActivity {
    int intentvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_intent);
        PieChart pieChart = findViewById(R.id.piechart);
        ArrayList NoOfEmp = new ArrayList();

        Intent mintent=getIntent();
        intentvalue = mintent.getIntExtra("pos",0);
        if(intentvalue==0)
        {
            NoOfEmp.add(new Entry(545f, 0));
            NoOfEmp.add(new Entry(186f, 1));
            NoOfEmp.add(new Entry( 89f, 2));
            NoOfEmp.add(new Entry(1040f, 3));
            NoOfEmp.add(new Entry(1869f, 4));
            NoOfEmp.add(new Entry(987f, 5));
            NoOfEmp.add(new Entry(645f, 6));
            PieDataSet dataSet = new PieDataSet(NoOfEmp, "Number Of Employees");

            ArrayList year = new ArrayList();

            year.add("Cisco");
            year.add("Microsoft");
            year.add("Google");
            year.add("Musigma");
            year.add("Wipro");
            year.add("Oracle");
            year.add("TCS Digital");
            PieData data = new PieData(year, dataSet);
            pieChart.setData(data);
            dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            pieChart.animateXY(5000, 5000);

        }
        else if(intentvalue==1)
        {
            NoOfEmp.add(new Entry(856f, 0));
            NoOfEmp.add(new Entry(440f, 1));
            NoOfEmp.add(new Entry(133f, 2));
            NoOfEmp.add(new Entry(1340f, 3));
            NoOfEmp.add(new Entry(1969f, 4));
            NoOfEmp.add(new Entry(1187f, 5));
            NoOfEmp.add(new Entry(901f, 6));

            PieDataSet dataSet = new PieDataSet(NoOfEmp, "Number Of Employees");

            ArrayList year = new ArrayList();

            year.add("Cisco");
            year.add("Microsoft");
            year.add("Google");
            year.add("Musigma");
            year.add("Wipro");
            year.add("Oracle");
            year.add("TCS Digital");
            PieData data = new PieData(year, dataSet);
            pieChart.setData(data);
            dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            pieChart.animateXY(5000, 5000);

        }
        else if(intentvalue==2)
        {
            NoOfEmp.add(new Entry(945f, 0));
            NoOfEmp.add(new Entry(740f, 1));
            NoOfEmp.add(new Entry(333f, 2));
            NoOfEmp.add(new Entry(1440f, 3));
            NoOfEmp.add(new Entry(2069f, 4));
            NoOfEmp.add(new Entry(1687f, 5));
            NoOfEmp.add(new Entry(1301f, 6));

            PieDataSet dataSet = new PieDataSet(NoOfEmp, "Number Of Employees");

            ArrayList year = new ArrayList();

            year.add("Cisco");
            year.add("Microsoft");
            year.add("Google");
            year.add("Musigma");
            year.add("Wipro");
            year.add("Oracle");
            year.add("TCS Digital");
            PieData data = new PieData(year, dataSet);
            pieChart.setData(data);
            dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            pieChart.animateXY(5000, 5000);

        }
        else if(intentvalue==3)
        {
            NoOfEmp.add(new Entry(1045f, 0));
            NoOfEmp.add(new Entry(940f, 1));
            NoOfEmp.add(new Entry(533f, 2));
            NoOfEmp.add(new Entry(1640f, 3));
            NoOfEmp.add(new Entry(2569f, 4));
            NoOfEmp.add(new Entry(1787f, 5));
            NoOfEmp.add(new Entry(1501f, 6));

            PieDataSet dataSet = new PieDataSet(NoOfEmp, "Number Of Employees");

            ArrayList year = new ArrayList();

            year.add("Cisco");
            year.add("Microsoft");
            year.add("Google");
            year.add("Musigma");
            year.add("Wipro");
            year.add("Oracle");
            year.add("TCS Digital");
            PieData data = new PieData(year, dataSet);
            pieChart.setData(data);
            dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            pieChart.animateXY(5000, 5000);

        }

            }
}