package com.example.mat.flaborfit;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    public static String weightResults = "";
    public static CheckBox setOne, setTwo, setThree, setFour, setFive;
    public static int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView exerciseText = (TextView)findViewById(R.id.exerciseTitle);
        ImageView exerciseImage = (ImageView)findViewById(R.id.exerciseImage);
        LinearLayout mainBG = (LinearLayout)findViewById(R.id.mainBG);
        setOne = (CheckBox)findViewById(R.id.setOne);
        setTwo = (CheckBox)findViewById(R.id.setTwo);
        setThree = (CheckBox)findViewById(R.id.setThree);
        setFour = (CheckBox)findViewById(R.id.setFour);
        setFive = (CheckBox)findViewById(R.id.setFive);
        Button returnBtn = (Button)findViewById(R.id.returnBtn);

        String exerciseTitle = getIntent().getStringExtra(MainActivity.EXTRA_ITEM_TITLE);
        exerciseText.setText(exerciseTitle);

        setOne.setText("Complete set 1");
        setTwo.setText("Complete set 2");
        setThree.setText("Complete set 3");
        setFour.setText("Complete set 4");
        setFive.setText("Complete set 5");



        if (exerciseTitle.equalsIgnoreCase(MainActivity.EXERCISE_WEIGHTS)) {
            exerciseImage.setImageDrawable(getResources().getDrawable(R.drawable.weight, getApplicationContext().getTheme()));
            mainBG.setBackgroundColor(Color.parseColor("#2ca5f5"));


            setOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (setOne.isChecked()) {
                        progress += 20;
                        weightProgress(progress);
                    }
                    else {
                        progress -= 20;
                        weightProgress(progress);
                    }
                }
            });

            setTwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (setOne.isChecked()) {
                        progress += 20;
                        weightProgress(progress);
                    }
                    else {
                        progress -= 20;
                        weightProgress(progress);
                    }
                }
            });

            setThree.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (setOne.isChecked()) {
                        progress += 20;
                        weightProgress(progress);
                    }
                    else {
                        progress -= 20;
                        weightProgress(progress);
                    }
                }
            });

            setFour.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (setOne.isChecked()) {
                        progress += 20;
                        weightProgress(progress);
                    }
                    else {
                        progress -= 20;
                        weightProgress(progress);
                    }
                }
            });

            setFive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (setOne.isChecked()) {
                        progress += 20;
                        weightProgress(progress);
                    }
                    else {
                        progress -= 20;
                        weightProgress(progress);
                    }
                }
            });


        } else if (exerciseTitle.equalsIgnoreCase(MainActivity.EXERCISE_YOGA)) {
            exerciseImage.setImageDrawable(getResources().getDrawable(R.drawable.lotus, getApplicationContext().getTheme()));
            mainBG.setBackgroundColor(Color.parseColor("#916bcd"));
        } else {
            exerciseImage.setImageDrawable(getResources().getDrawable(R.drawable.heart, getApplicationContext().getTheme()));
            mainBG.setBackgroundColor(Color.parseColor("#52ad56"));
        }

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    void weightProgress(int sets){

        if (sets >= 101){
            progress = 20;
            weightResults = String.valueOf(progress);
            MainActivity.weightResult.setText(weightResults + "%");
        } else {
            weightResults = String.valueOf(progress);
            MainActivity.weightResult.setText(weightResults + "%");
        }
    }
}
