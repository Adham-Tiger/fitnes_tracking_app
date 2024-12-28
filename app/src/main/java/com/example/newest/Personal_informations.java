package com.example.newest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Personal_informations extends AppCompatActivity {


    EditText Name,Weight;
    Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_personal_informations);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            //registering workout
            Name=findViewById(R.id.Name);
            Weight=findViewById(R.id.Weight);
            confirm=findViewById(R.id.add_goal);

            confirm.setOnClickListener(v1 -> {
                String islogged= String.valueOf(read_records("islogged"));
                 if(islogged.equals("true")){
                String name = Name.getText().toString();
                String weight = Weight.getText().toString();
                save_records("name", name);
                save_records("weight", weight);
                save_records("islogged", "false");}
                 else if (islogged.equals("false")) {
                     Intent intent = new Intent(Personal_informations.this, Home_Activity.class);
                     startActivity(intent);
                     finish();

                 }
            });



            return insets;
        });
    }
    protected void save_records(String key,String value){
        SharedPreferences sp=getSharedPreferences("personal informations",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString(key,value);
        editor.apply();}
    protected double read_records(String key){
        SharedPreferences sp=getSharedPreferences("personal informations",MODE_PRIVATE);
        return Double.parseDouble(sp.getString(key,"true"));
    }
}