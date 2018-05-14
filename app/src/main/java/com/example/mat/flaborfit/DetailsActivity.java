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

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener{

    public static String weightResults = "";
    public static CheckBox setOne, setTwo, setThree, setFour, setFive;
    public static int progress = 0;
    public static int Total;
    public static int First, Second, Third, Fourth, Fifth;
    public static String btn1 = "unchecked";
    public static String btn2 = "unchecked";
    public static String btn3 = "unchecked";
    public static String btn4 = "unchecked";
    public static String btn5 = "unchecked";

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

            if (btn1.equalsIgnoreCase("checked")) {
                setOne.setChecked(true);
            } else {
                setOne.setChecked(false);
            }
            if (btn2.equalsIgnoreCase("checked")) {
                setTwo.setChecked(true);
            } else {
                setTwo.setChecked(false);
            }
            if (btn3.equalsIgnoreCase("checked")) {
                setThree.setChecked(true);
            } else {
                setThree.setChecked(false);
            }
            if (btn4.equalsIgnoreCase("checked")) {
                setFour.setChecked(true);
            } else {
                setFour.setChecked(false);
            }
            if (btn5.equalsIgnoreCase("checked")) {
                setFive.setChecked(true);
            } else {
                setFive.setChecked(false);
            }

            setOne.setOnClickListener(this);
            setTwo.setOnClickListener(this);
            setThree.setOnClickListener(this);
            setFour.setOnClickListener(this);
            setFive.setOnClickListener(this);

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
/*
    void weightProgress(int sets){

        if (sets >= 101 || sets < 0){
            progress = 20;
            weightResults = String.valueOf(progress);
            MainActivity.weightResult.setText(weightResults + "%");
        } else {
            weightResults = String.valueOf(progress);
            MainActivity.weightResult.setText(weightResults + "%");
        }
    }
*/
    @Override
    public void onClick(View v) {

        if (setOne.isChecked()) {
            progress = 20;
            btn1 = "checked";
        } else {
            btn1 = "unchecked";
        }
        if (setTwo.isChecked()) {
            progress = 20;
            btn2 = "checked";
        } else {
            btn2 = "unchecked";
        }
        if (setThree.isChecked()) {
            progress = 20;
            btn3 = "checked";
        } else {
            btn3 = "unchecked";
        }
        if (setFour.isChecked()) {
            progress = 20;
            btn4 = "checked";
        } else {
            btn4 = "unchecked";
        }
        if (setFive.isChecked()) {
            progress = 20;
            btn5 = "checked";
        } else {
            btn5 = "unchecked";
        }
        if ((setOne.isChecked() && setTwo.isChecked()) || (setOne.isChecked() && setThree.isChecked()) || (setOne.isChecked() && setFour.isChecked())
                || (setOne.isChecked() && setFive.isChecked()) || (setTwo.isChecked() && setThree.isChecked()) || (setTwo.isChecked() && setFour.isChecked())
                || (setTwo.isChecked() && setFive.isChecked()) || (setThree.isChecked() && setFour.isChecked())
                || (setThree.isChecked() && setFive.isChecked()) || (setFour.isChecked() && setFive.isChecked())) {
            progress = 40;
        }
        if ((setOne.isChecked() && setTwo.isChecked() && setThree.isChecked()) || (setTwo.isChecked() && setThree.isChecked() && setFour.isChecked())
                || (setThree.isChecked() && setFour.isChecked() && setFive.isChecked()) || (setOne.isChecked() && setFour.isChecked() && setFive.isChecked())
                || (setOne.isChecked() && setTwo.isChecked() && setFive.isChecked())) {
            progress = 60;
        }
        if ((setOne.isChecked() && setTwo.isChecked() && setThree.isChecked() && setFour.isChecked())
                || (setTwo.isChecked() && setThree.isChecked() && setFour.isChecked() && setFive.isChecked())
                || (setThree.isChecked() && setFour.isChecked() && setFive.isChecked() && setOne.isChecked())
                || (setFour.isChecked() && setFive.isChecked() && setOne.isChecked() && setTwo.isChecked())
                || (setOne.isChecked() && setTwo.isChecked() && setThree.isChecked() && setFive.isChecked())) {
            progress = 80;
        }
        if (setOne.isChecked() && setTwo.isChecked() && setThree.isChecked() && setFour.isChecked() && setFive.isChecked()) {
            progress = 100;
        }


        // Re-doing everything to have a shorter amount of code (simplification).
        /*
        if (setOne.isChecked()) {
            btn1 = "checked";
            First = 1;
            Total = First;
        } else {
            btn1 = "unchecked";
        }
        if (setTwo.isChecked()) {
            btn2 = "checked";
            Second = 2;
            Total = Second;
        } else {
            btn2 = "unchecked";
        }
        if (setThree.isChecked()) {
            btn3 = "checked";
            Third = 4;
            Total = Third;
        } else {
            btn3 = "unchecked";
        }
        if (setFour.isChecked()) {
            btn4 = "checked";
            Fourth = 8;
            Total = Fourth;
        } else {
            btn4 = "unchecked";
        }
        if (setFive.isChecked()) {
            btn5 = "checked";
            Fifth = 13;
            Total = Fifth;
        } else {
            btn5 = "unchecked";
        }
        if (setOne.isChecked() && setTwo.isChecked()) {
            Total = 3;
        }
        if (setOne.isChecked() && setThree.isChecked()) {
            Total = 5;
        }
        if (setOne.isChecked() && setFour.isChecked()) {
            Total = 9;
        }
        if (setOne.isChecked() && setFive.isChecked()) {
            Total = 14;
        }
        if (setTwo.isChecked() && setThree.isChecked()) {
            Total = 6;
        }
        if (setTwo.isChecked() && setFour.isChecked()) {
            Total = 10;
        }
        if (setTwo.isChecked() && setFive.isChecked()) {
            Total = 15;
        }
        if (setThree.isChecked() && setFour.isChecked()) {
            Total = 12;
        }
        if (setThree.isChecked() && setFive.isChecked()) {
            Total = 17;
        }
        if (setFour.isChecked() && setFive.isChecked()) {
            Total = 21;
        }
        if (setOne.isChecked() && setTwo.isChecked() && setThree.isChecked()) {
            Total = 7;
        }
        if (setTwo.isChecked() && setThree.isChecked() && setFour.isChecked()) {
            Total = 11;
        }
        if (setThree.isChecked() && setFour.isChecked() && setFive.isChecked()) {
            Total = 16;
        }
        if (setOne.isChecked() && setFour.isChecked() && setFive.isChecked()) {
            Total = 34;
        }
        if (setOne.isChecked() && setTwo.isChecked() && setFive.isChecked()) {
            Total = 35;
        }
        if (setOne.isChecked() && setTwo.isChecked() && setThree.isChecked() && setFour.isChecked()) { // start here now
            Total = 29;
        }
        if (setTwo.isChecked() && setThree.isChecked() && setFour.isChecked() && setFive.isChecked()) { //
            Total = 30;
        }
        if (setThree.isChecked() && setFour.isChecked() && setFive.isChecked() && setOne.isChecked()) { //
            Total = 31;
        }
        if (setFour.isChecked() && setFive.isChecked() && setOne.isChecked() && setTwo.isChecked()) { //
            Total = 32;
        }
        if (setOne.isChecked() && setTwo.isChecked() && setThree.isChecked() && setFive.isChecked()) { //
            Total = 33;
        }
        if (setOne.isChecked() && setTwo.isChecked() && setThree.isChecked() && setFour.isChecked() && setFive.isChecked()) {
            Total = 28;
        }
        switch (Total)
        {
            case 1:
                progress = 20;
                break;
            case 2:
                progress = 20;
                break;
            case 3:
                progress = 40;
                break;
            case 4:
                progress = 20;
                break;
            case 5:
                progress = 40;
                break;
            case 6:
                progress = 40;
                break;
            case 7:
                progress = 60;
                break;
            case 8:
                progress = 20;
                break;
            case 9:
                progress = 40;
                break;
            case 10:
                progress = 40;
                break;
            case 11:
                progress = 60;
                break;
            case 12:
                progress = 40;
                break;
            case 13:
                progress = 20;
                break;
            case 14:
                progress = 40;
                break;
            case 15:
                progress = 40;
                break;
            case 16:
                progress = 60;
                break;
            case 17:
                progress = 40;
                break;
            case 21:
                progress = 40;
                break;
            case 28:
                progress = 100;
                break;
            case 29:
                progress = 80;
                break;
            case 30:
                progress = 80;
                break;
            case 31:
                progress = 80;
                break;
            case 32:
                progress = 80;
                break;
            case 33:
                progress = 80;
                break;
            case 34:
                progress = 60;
                break;
            case 35:
                progress = 60;
                break;
        } */
    }
}
