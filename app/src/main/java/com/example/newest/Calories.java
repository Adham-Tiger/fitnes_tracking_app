package com.example.newest;

import static com.example.newest.SleepingTime_progress.createStats;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class Calories extends AppCompatActivity {

    private GoalReminderSystem caloriesReminderSystem;
    Button returnCalories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.progress_tracking_calories);
        caloriesReminderSystem = new GoalReminderSystem(this);

        // Sample data for the bar chart
        Map<String, Map<String, Integer>> weeklyData = new HashMap<>();
        weeklyData.put("Mon", createStats(500, 45));
        weeklyData.put("Tue", createStats(600, 60));
        weeklyData.put("Wed", createStats(450, 30));
        weeklyData.put("Thu", createStats(700, 75));
        weeklyData.put("Fri", createStats(550, 50));
        weeklyData.put("Sat", createStats(800, 90));
        weeklyData.put("Sun", createStats(400, 40));

        // Bind the BarChartView and set data
        BarChartView barChartView = findViewById(R.id.bar_chart_view);
        barChartView.setData(weeklyData, "calories","Weekly Calories Burned");

        // Set the click listener for the goal check button
        Button checkGoalButton = findViewById(R.id.check_calories_goal_button);
        checkGoalButton.setOnClickListener(v -> caloriesReminderSystem.checkGoalProgress(read_calories("calories"), read_calories_goals("cal_goal")));

        returnCalories = findViewById(R.id.returnCalories);
        returnCalories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnToMain = new Intent(Calories.this, Progress_tracking_menu.class);
                startActivity(returnToMain);
            }
        });
    }
    public int read_calories(String key){
        SharedPreferences sp=getSharedPreferences("records",MODE_PRIVATE);
        return Integer.parseInt(sp.getString(key,"0"));
    }

    public int read_calories_goals(String key){
        SharedPreferences sp=getSharedPreferences("goals",MODE_PRIVATE);
        return Integer.parseInt(sp.getString(key,"0"));
    }
}