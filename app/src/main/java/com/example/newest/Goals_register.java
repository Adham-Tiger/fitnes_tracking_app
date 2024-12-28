package com.example.newest;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Goals_register extends AppCompatActivity {
    public static boolean isSteps_goal,issleeping_goal =false,issteps_goal=false,iswater_goal=false,iscalories_goal=false;

    static String CALORIES_GOAL="cal_goal",STEPS_GOAL="steps_goal",WATER_GOAL="water_goal",SLEEP_GOAL="sleep_goal";
    EditText get_goal;
    Button add_goal;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_goals_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        get_goal=findViewById(R.id.get_goal);
        add_goal=findViewById(R.id.add_goal);

        add_goal.setOnClickListener(v1 -> {
            String goal=get_goal.getText().toString();

            if(issleeping_goal) {
                save_records(SLEEP_GOAL, goal);
                issleeping_goal=false;


            }

            //calories calculations and saving
            else if(iscalories_goal){
                save_records(CALORIES_GOAL,goal);
                iscalories_goal=false;
            }
            else if(iswater_goal) {
                save_records(WATER_GOAL, goal);
                iswater_goal=false;
            }
            else if(issteps_goal){
             save_records(STEPS_GOAL,goal);
             issteps_goal=false;
            }
            finish();
        });

    }
    protected void save_records(String key,String value){
        SharedPreferences sp=getSharedPreferences("goals",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString(key,value);
        editor.apply();
    }

    //making reading in shared prefrences easier
    protected double read_records(String key){
        SharedPreferences sp=getSharedPreferences("goals",MODE_PRIVATE);
        return Double.parseDouble(sp.getString(key,"0"));
    }
}