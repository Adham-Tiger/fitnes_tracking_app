package com.example.newest;

import static com.example.myapplication.SleepingTime.createStats;
import static com.example.newest.SleepingTime_progress.createStats;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class Progress_running_activity extends AppCompatActivity {
    private GoalReminderSystem reminderSystem;
    Button returnRunning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_running_tracking);

        // Initialize the GoalReminderSystem
        reminderSystem = new GoalReminderSystem(this);

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
        Button checkGoalButton = findViewById(R.id.check_goal_button);
        checkGoalButton.setOnClickListener(v -> reminderSystem.checkGoalProgress(800, 1000));

        returnRunning = findViewById(R.id.returnRunning);
        returnRunning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnToMainFromRunning = new Intent(Progress_running_activity.this, Progress_tracking_menu.class);
                startActivity(returnToMainFromRunning);
            }
        });
    }


    // Helper method to create stats for each day

}
