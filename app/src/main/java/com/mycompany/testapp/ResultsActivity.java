package com.mycompany.testapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.Rating;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/comic-reg.ttf");
        TextView score = (TextView)findViewById(R.id.score_result);
        TextView question = (TextView)findViewById(R.id.question_result);
        TextView rating = (TextView)findViewById(R.id.rating_desc);
        Button back = (Button)findViewById(R.id.btnBackToMain);
        score.setTypeface(custom_font);
        question.setTypeface(custom_font);
        rating.setTypeface(custom_font);
        back.setTypeface(custom_font);

        getScore();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void getScore() {
        Intent i = getIntent();
        i.getIntExtra("score", 0);
        i.getIntExtra("questionsAnswered", 0);

        TextView scoreResult = (TextView) findViewById(R.id.score_result);
        scoreResult.setText(scoreResult.getText() + "" +i.getIntExtra("score", 0));

        TextView ansQuestion = (TextView) findViewById(R.id.question_result);
        ansQuestion.setText(ansQuestion.getText() + "" +i.getIntExtra("questionsAnswered", 0)+ " out of 5 questions correctly.");

        RatingBar stars = (RatingBar) findViewById(R.id.rating_star);
        stars.setFocusable(false); // disables clicking the rating bar
        TextView stars_text = (TextView) findViewById(R.id.rating_desc);
        Bundle b = getIntent().getExtras();
        int getScore = b.getInt("score");

        stars.setRating(getScore);
            switch (getScore) {
                case 1:
                case 2:
                    stars_text.setText("Better luck next time!");
                    break;
                case 3:
                case 4:
                    stars_text.setText("So close.");
                    break;
                case 5:
                    stars_text.setText("Perfect! You're brainy!");
                    break;
            }
    }

    // goes back to the Main Menu screen when back to main menu is selected
    public void backToMain(View view) {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }
}
