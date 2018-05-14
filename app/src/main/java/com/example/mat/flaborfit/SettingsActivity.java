package com.example.mat.flaborfit;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.content.Intent;

public class SettingsActivity extends AppCompatActivity {

    public static String mode = "light";
    public static CheckBox nightMode;
    Button returnBtn;
    LinearLayout settingLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        /*getSupportActionBar().setTitle("Settings"); Don't use this if toolbar is gone, else it will crash everything!*/

        nightMode = (CheckBox)findViewById(R.id.nightMode);
        settingLayout = (LinearLayout)findViewById(R.id.settingLayout);
        returnBtn = (Button)findViewById(R.id.returnBtn);

        if (mode.equalsIgnoreCase("night")) {
            nightMode.setChecked(true);
            settingLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary, getApplicationContext().getTheme()));
            nightMode.setTextColor(getResources().getColor(R.color.colorAccent));
        } else {
            nightMode.setChecked(false);
            settingLayout.setBackgroundColor(getResources().getColor(R.color.colorAccent, getApplicationContext().getTheme()));
            nightMode.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }

        nightMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nightMode.isChecked()){
                    mode = "night";
                    MainActivity.mainLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary, getApplicationContext().getTheme()));
                    settingLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary, getApplicationContext().getTheme()));
                    nightMode.setTextColor(getResources().getColor(R.color.colorAccent));
                } else {
                    mode = "light";
                    MainActivity.mainLayout.setBackgroundColor(getResources().getColor(R.color.colorAccent, getApplicationContext().getTheme()));
                    settingLayout.setBackgroundColor(getResources().getColor(R.color.colorAccent, getApplicationContext().getTheme()));
                    nightMode.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                }
            }
        });

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                startActivity(intent);
            }

        });
    }
}
