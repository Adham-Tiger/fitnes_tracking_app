package com.example.newest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Progress_tracking_menu extends AppCompatActivity {
    Button runningButton;
    Button sleepingButton;
    Button stepsButton;
    Button caloriesButton;
    Button exerciseButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.progress_tracking_menu);



        runningButton=findViewById(R.id.Running);
        runningButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToActivityStats = new Intent(Progress_tracking_menu.this, Progress_running_activity.class);
                startActivity(goToActivityStats);
            }
        });
        sleepingButton=findViewById(R.id.SleepingTime);
        sleepingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToActivityStats = new Intent(Progress_tracking_menu.this, SleepingTime_progress.class);
                startActivity(goToActivityStats);
            }
        });
        stepsButton=findViewById(R.id.Steps);
        stepsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToActivityStats = new Intent(Progress_tracking_menu.this, Steps_progress.class);
                startActivity(goToActivityStats);
            }
        });
        caloriesButton=findViewById(R.id.BurnedCalories);
        caloriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToActivityStats = new Intent(Progress_tracking_menu.this,Calories.class);
                startActivity(goToActivityStats);
            }
        });
        exerciseButton=findViewById(R.id.ExerciseMinutes);
        exerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToActivityStats = new Intent(Progress_tracking_menu.this, Progress_Exercise_activity.class);
                startActivity(goToActivityStats);
            }
        });


    }
}