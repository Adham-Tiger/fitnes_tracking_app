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

public class Work_out_Activity_register extends AppCompatActivity {
    public static boolean isswimming=false,iscycling=true,isrunning=false,isjumping=false;

    double running_distance=0,cycling_distance=0,swimming_distance=0,jumping_rope_times=0;
    static String CALORIES="calories";
    EditText Distance_register,time_register;
    Button confirm_register;
    double calories=0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_work_out_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            //registering workout
            Distance_register=findViewById(R.id.distanceInput);
            time_register=findViewById(R.id.timeInput);
            confirm_register=findViewById(R.id.confirmButton);

            confirm_register.setOnClickListener(v1 -> {

                calories = read_records("calories");

                if(isrunning) {
                    calories += Calculations.running_calories(Double.parseDouble(Distance_register.getText().toString()), Double.parseDouble(time_register.getText().toString()));
                    running_distance=read_records("running_distance");
                   running_distance+=Double.parseDouble(Distance_register.getText().toString());
                    save_records("runing_distance", String.valueOf(running_distance));
                    isrunning=false;
                }

                //calories calculations and saving
                else if(iscycling){
                    calories+=Calculations.cycling_calories(Double.parseDouble(Distance_register.getText().toString()),Double.parseDouble(time_register.getText().toString()));
                    iscycling=false;
                    cycling_distance=read_records("cycling_distance");
                    cycling_distance+=Double.parseDouble(Distance_register.getText().toString());
                    save_records("cycling_distance",String.valueOf(cycling_distance));
                }
                else if(isswimming) {
                    isswimming=false;
                    calories += Calculations.swimming_calories(Double.parseDouble(Distance_register.getText().toString()), Double.parseDouble(time_register.getText().toString()));
                    swimming_distance=read_records("swimming_distance");
                    swimming_distance+=Double.parseDouble(Distance_register.getText().toString());
                    save_records("swimming_distance",String.valueOf(swimming_distance));
                }
                else if(isjumping){
                    isjumping=false;
                    calories+=Calculations.jumping_rope_calories(Double.parseDouble(Distance_register.getText().toString()),Double.parseDouble(time_register.getText().toString()));
                    jumping_rope_times=read_records("jumping_rope_times");
                    jumping_rope_times+=Double.parseDouble(Distance_register.getText().toString());
                    save_records("jumping_rope_times",String.valueOf(jumping_rope_times));
                }

                ///// add calories in main activity code here

                save_records("calories",String.valueOf(calories));
                Distance_register.setText("0");
                time_register.setText("0");


            });


            return insets;
        });
    }
    //making saving in shared prefrences easier
    protected void save_records(String key,String value){
        SharedPreferences sp=getSharedPreferences("records",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString(key,value);
        editor.apply();
    }

    //making reading in shared prefrences easier
    public double read_records(String key){
        SharedPreferences sp=getSharedPreferences("records",MODE_PRIVATE);
        return Double.parseDouble(sp.getString(key,"0"));
    }
}