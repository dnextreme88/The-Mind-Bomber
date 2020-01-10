package com.mycompany.testapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LevelsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        // set custom fonts
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/comic-reg.ttf");
        Button easy = (Button)findViewById(R.id.btnEasy);
        Button hard = (Button)findViewById(R.id.btnHard);
        TextView hint = (TextView) findViewById(R.id.txtLevelHint);
        easy.setTypeface(custom_font);
        hard.setTypeface(custom_font);
        hint.setTypeface(custom_font);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    // goes to Easy Mode screen when the button is selected
    public void startEasyMode(View view) {
        Intent easy = new Intent(this, EasyMode1Activity.class);
        startActivity(easy);
    }

    // goes to Hard Mode screen when the button is selected
    public void startHardMode(View view) {
        Intent hard = new Intent(this, HardMode1Activity.class);
        startActivity(hard);
    }
}
