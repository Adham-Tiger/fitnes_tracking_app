package com.example.newest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class daily_plan_activity extends AppCompatActivity {

    TextView tvDailyPlan, tvCalories, tvSteps, tvSleep, tvWater, tvRunning;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.plan);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.my_plan_activity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            tvDailyPlan = findViewById(R.id.tvDailyPlan);
            tvCalories = findViewById(R.id.daily_planing_tvCalories);
            tvSteps = findViewById(R.id.daily_planing_tvSteps);
            tvSleep = findViewById(R.id.daily_planing_tvSleep);
            tvWater = findViewById(R.id.daily_planing_tvWater);
            tvDailyPlan.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            tvCalories.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            return insets;
        });
    }
}