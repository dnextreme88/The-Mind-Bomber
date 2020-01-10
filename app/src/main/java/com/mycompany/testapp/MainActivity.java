package com.mycompany.testapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setBackgroundColor(Color.argb(255, 102, 187, 106)); // test. fixes the white background on the main menu screen. green / #66BB6A

        // set custom fonts
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/comic-reg.ttf");
        TextView welcomeUserTxt = (TextView) findViewById(R.id.welcomeUser);
        Button newGame = (Button)findViewById(R.id.btnNewGame);
        Button instruct = (Button)findViewById(R.id.btnInstructions);
        Button set = (Button)findViewById(R.id.btnSettings);
        Button creds = (Button)findViewById(R.id.btnCredits);
        welcomeUserTxt.setTypeface(custom_font);
        newGame.setTypeface(custom_font);
        instruct.setTypeface(custom_font);
        set.setTypeface(custom_font);
        creds.setTypeface(custom_font);

        ImageView fb = (ImageView) findViewById(R.id.social_fb);
        ImageView twitter = (ImageView) findViewById(R.id.social_twitter);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = "Like our page: The Mind Bomber PH. :))";

                Toast showToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                showToast.show();
            }
        });
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = "Follow us @ themindbomberPH. :))";

                Toast showToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                showToast.show();
            }
        });
        greetUser();
    }
    // shows the user's name that was set in Settings. Guest is the default value.
    private void greetUser() {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this); // get the settings
        String getUser = sharedPrefs.getString("user_name", "Guest"); // get the ID of the option to be retrieved

        TextView welcomeUserTxt = (TextView) findViewById(R.id.welcomeUser);
        welcomeUserTxt.setText(welcomeUserTxt.getText() + getUser + "!");
    }
    // goes to Difficulty Level screen when New Game is selected
    public void startNewGame(View view) {
        Intent diffLevels = new Intent(this, LevelsActivity.class);
        startActivity(diffLevels);
    }

    // goes to the Instructions screen when Instructions is selected
    public void showInstructions(View view) {
        Intent ins = new Intent(this, InstructionsActivity.class);
        startActivity(ins);
    }
    // goes to Settings screen when Settings is selected
    public void showSettings(View view) {
        Intent set = new Intent(this, SettingsActivity.class);
        startActivity(set);
    }

    // goes to Credits screen when Credits is selected
    public void showCredits(View view) {
        Intent creds = new Intent(this, CreditsActivity.class);
        startActivity(creds);
    }
}
