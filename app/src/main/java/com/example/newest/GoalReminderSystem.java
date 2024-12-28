package com.example.newest;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class GoalReminderSystem {
    private Context context;

    public GoalReminderSystem(Context context) {
        this.context = context;
    }

    public void checkGoalProgress(int current, int goal) {
        if (current >= goal) {
            Toast.makeText(context, "Goal achieved! 🎉", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Keep going! You're almost there!", Toast.LENGTH_SHORT).show();
        }
    }

}
