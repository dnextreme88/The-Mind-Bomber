package com.mycompany.testapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class InstructionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        // set custom fonts
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/comic-reg.ttf");
        TextView insText = (TextView)findViewById(R.id.titleInstructions);
        TextView ins1 = (TextView)findViewById(R.id.ins1);
        TextView ins2 = (TextView)findViewById(R.id.ins2);
        TextView ins3 = (TextView)findViewById(R.id.ins3);
        insText.setTypeface(custom_font);
        ins1.setTypeface(custom_font);
        ins2.setTypeface(custom_font);
        ins3.setTypeface(custom_font);

        // sets a scrolling animation when Credits is loaded
        Animation scrollSide = AnimationUtils.loadAnimation(this, R.anim.instructionsanimation);
        //TextView ins1 = (TextView) findViewById(R.id.ins1);
        //TextView ins2 = (TextView) findViewById(R.id.ins2);
        //TextView ins3 = (TextView) findViewById(R.id.ins3);
        ins1.startAnimation(scrollSide);
        ins2.startAnimation(scrollSide);
        ins3.startAnimation(scrollSide);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
