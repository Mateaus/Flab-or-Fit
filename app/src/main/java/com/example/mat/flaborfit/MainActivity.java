package com.example.mat.flaborfit;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_ITEM_TITLE = "extra.item.title";
    public static final String EXTRA_ITEM_NAME = "extra.item.name";
    public static final String SETTING_BUTTON = "SettingButton";
    public static final String EXERCISE_WEIGHTS = "Weight lifting";
    public static final String EXERCISE_YOGA = "Yoga";
    public static final String EXERCISE_CARDIO = "Cardio";

    public static TextView weightResult;
    public static Button settingBtn;
    public static LinearLayout mainLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout weightBtn = (RelativeLayout)findViewById(R.id.weightBtn);
        RelativeLayout yogaBtn = (RelativeLayout)findViewById(R.id.yogaBtn);
        RelativeLayout cardioBtn = (RelativeLayout)findViewById(R.id.cardioBtn);
        mainLayout = (LinearLayout)findViewById(R.id.mainLayout);
        settingBtn = (Button)findViewById(R.id.settingBtn);
        weightResult = (TextView)findViewById(R.id.weightResult);
        weightResult.setText("0%");


        if (SettingsActivity.mode.equalsIgnoreCase("night")) {
            mainLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary, getApplicationContext().getTheme()));
        } else {
            mainLayout.setBackgroundColor(getResources().getColor(R.color.colorAccent, getApplicationContext().getTheme()));
        }

        if (DetailsActivity.btn1.equalsIgnoreCase("checked")
                || DetailsActivity.btn2.equalsIgnoreCase("checked")
                || DetailsActivity.btn3.equalsIgnoreCase("checked")
                || DetailsActivity.btn4.equalsIgnoreCase("checked")
                || DetailsActivity.btn5.equalsIgnoreCase("checked")) {
            DetailsActivity.weightResults = String.valueOf(DetailsActivity.progress);
            weightResult.setText(DetailsActivity.weightResults + "%");
        } else {
            DetailsActivity.progress -= 20;
        }


        weightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDetailActivity(MainActivity.EXERCISE_WEIGHTS);
            }
        });

        yogaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDetailActivity(MainActivity.EXERCISE_YOGA);
            }
        });

        cardioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDetailActivity(MainActivity.EXERCISE_CARDIO);
            }
        });
        settingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadSettingActivity(MainActivity.SETTING_BUTTON);
            }
        });
    }

    private void loadDetailActivity(String exerciseTitle){ //exerciseTitle are the EXERCISE's variables created.
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class); //grabs main activity and tells to load the next activity
        intent.putExtra(MainActivity.EXTRA_ITEM_TITLE, exerciseTitle); //load activity and then fetch that data
        startActivity(intent); //starActivity talks to the activity manager at the operating system level
    }

    private void loadSettingActivity(String settingTitle) {
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        intent.putExtra(MainActivity.EXTRA_ITEM_NAME, settingTitle);
        startActivity(intent);
    }
}
