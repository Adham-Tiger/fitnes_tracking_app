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

public class Steps_progress extends AppCompatActivity {
    private GoalReminderSystem stepsReminderSystem;
    Button returnSteps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_steps);
        stepsReminderSystem = new GoalReminderSystem(this);

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
        Button checkGoalButton = findViewById(R.id.check_steps_goal_button);
        checkGoalButton.setOnClickListener(v -> stepsReminderSystem.checkGoalProgress(read_steps(""),read_steps_goals("steps_goal")));
        returnSteps = findViewById(R.id.returnStepss);
        returnSteps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnToMainFromRunning = new Intent(Steps_progress.this, Progress_tracking_menu.class);
                startActivity(returnToMainFromRunning);
            }
        });
    }
    public int read_steps(String key){
        SharedPreferences sp=getSharedPreferences("records",MODE_PRIVATE);
        return Integer.parseInt(sp.getString(key,"0"));
    }

    public int read_steps_goals(String key){
        SharedPreferences sp=getSharedPreferences("goals",MODE_PRIVATE);
        return Integer.parseInt(sp.getString(key,"0"));
    }


    // Helper method to create stats for each day

}
