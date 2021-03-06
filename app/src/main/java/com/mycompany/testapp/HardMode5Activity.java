package com.mycompany.testapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

public class HardMode5Activity extends AppCompatActivity {
    public int score;
    public final int questionTotal = 10;
    public int question = 5;
    public int questionsAnswered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_mode5);

        Intent j = getIntent(); // get values from EasyMode1Activity.java
        if (j != null) {
            score = j.getIntExtra("score", 5);
            questionsAnswered = j.getIntExtra("questionsAnswered", 5);
            question = j.getIntExtra("question", 5);
        }

        TextView questionText5 = (TextView) findViewById(R.id.txtquestion_number10);
        questionText5.setText(questionText5.getText() + " " +question+ " of " +questionTotal);

        TextView scoreText5 = (TextView) findViewById(R.id.txtScore10);
        scoreText5.setText(scoreText5.getText() + " " +score+ ""); // set the score from the previous intent

        final Chronometer timer5 = (Chronometer) findViewById(R.id.chronometer10);
        timer5.start();

        Button btn17 = (Button) findViewById(R.id.btnHard17);
        Button btn18 = (Button) findViewById(R.id.btnHard18);
        Button btn19 = (Button) findViewById(R.id.btnHard19);
        Button btn20 = (Button) findViewById(R.id.btnHard20);

        btn17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question++;
                // notify the user the answer was incorrect.
                Context context = getApplicationContext();
                CharSequence text = "Sorry, that answer is incorrect.";

                Toast showToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                showToast.show();
                toResults(view);
            }
        });

        btn18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // correct answer
                question++;
                score++;
                questionsAnswered++;
                // notify the user the answer was correct.
                Context context = getApplicationContext();
                CharSequence text = "Congratulations! You answered that correctly!";

                Toast showToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                showToast.show();
                toResults(view);
            }
        });

        btn19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question++;
                // notify the user the answer was incorrect.
                Context context = getApplicationContext();
                CharSequence text = "Sorry, that answer is incorrect.";

                Toast showToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                showToast.show();
                toResults(view);
            }
        });

        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question++;
                // notify the user the answer was incorrect.
                Context context = getApplicationContext();
                CharSequence text = "Sorry, that answer is incorrect.";

                Toast showToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                showToast.show();
                toResults(view);
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void toResults (View view) {
        Intent i = new Intent (this, ResultsActivity.class);
        Bundle b = new Bundle();
        b.putInt("score", score); // store the score
        b.putInt("questionsAnswered", questionsAnswered);
        b.putInt("question", question);
        i.putExtras(b); // put your score to your next intent
        startActivity(i);
    }

}
