package com.example.newest;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class daily_plan_activity extends AppCompatActivity {

    TextView  tvCalories, tvSteps, tvSleep, tvWater, tvRunning, tvWalking, tvCycling, tvSwimming;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.plan);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.my_plan_activity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            tvCalories = findViewById(R.id.daily_planing_tvCalories);
            tvSteps = findViewById(R.id.daily_planing_tvSteps);
            tvSleep = findViewById(R.id.daily_planing_tvSleep);
            tvWater = findViewById(R.id.daily_planing_tvWater);

            tvCalories.setText(String.valueOf(read_records("calories")));
            tvSteps.setText(String.valueOf(read_records("steps")));
            tvSleep.setText(String.valueOf(read_records("sleep")));
            tvWater.setText(String.valueOf(read_records("water")));
            tvRunning.setText(String.valueOf(read_records("running_distance")));
            tvWalking.setText(String.valueOf(read_records("walking_distance")));
            tvCycling.setText(String.valueOf(read_records("cycling_distance")));
            tvSwimming.setText(String.valueOf(read_records("swimming_distance")));


            return insets;
        });
    }
    protected double read_records(String key){
        SharedPreferences sp=getSharedPreferences("personal informations",MODE_PRIVATE);
        return Double.parseDouble(sp.getString(key,"true"));
    }
}