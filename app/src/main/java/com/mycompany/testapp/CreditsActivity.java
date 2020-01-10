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

public class CreditsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        // sets a scrolling animation when Credits is loaded
        Animation scrollUp = AnimationUtils.loadAnimation(this, R.anim.creditsanimation);
        TextView pos1 = (TextView) findViewById(R.id.txtPos1);
        TextView pos2 = (TextView) findViewById(R.id.txtPos2);
        TextView pos3 = (TextView) findViewById(R.id.txtPos3);
        TextView pos4 = (TextView) findViewById(R.id.txtPos4);
        TextView pos5 = (TextView) findViewById(R.id.txtPos5);
        TextView staff1 = (TextView) findViewById(R.id.txtStaff1);
        TextView staff2 = (TextView) findViewById(R.id.txtStaff2);
        TextView staff3 = (TextView) findViewById(R.id.txtStaff3);
        TextView staff4 = (TextView) findViewById(R.id.txtStaff4);
        TextView staff5 = (TextView) findViewById(R.id.txtStaff5);
        TextView staff6 = (TextView) findViewById(R.id.txtStaff6);
        TextView res = (TextView) findViewById(R.id.cred_ResUsed);
        TextView resDesc = (TextView) findViewById(R.id.cred_ResUsed_desc);
        TextView copyright = (TextView) findViewById(R.id.txtCopyright);
        pos1.startAnimation(scrollUp);
        staff1.startAnimation(scrollUp);
        pos2.startAnimation(scrollUp);
        staff2.startAnimation(scrollUp);
        pos3.startAnimation(scrollUp);
        staff3.startAnimation(scrollUp);
        pos4.startAnimation(scrollUp);
        staff4.startAnimation(scrollUp);
        pos5.startAnimation(scrollUp);
        staff5.startAnimation(scrollUp);
        staff6.startAnimation(scrollUp);
        res.startAnimation(scrollUp);
        resDesc.startAnimation(scrollUp);
        copyright.startAnimation(scrollUp);

        // set custom fonts
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/comic-reg.ttf");
        pos1.setTypeface(custom_font);
        staff1.setTypeface(custom_font);
        pos2.setTypeface(custom_font);
        staff2.setTypeface(custom_font);
        pos3.setTypeface(custom_font);
        staff3.setTypeface(custom_font);
        pos4.setTypeface(custom_font);
        staff4.setTypeface(custom_font);
        pos5.setTypeface(custom_font);
        staff5.setTypeface(custom_font);
        staff6.setTypeface(custom_font);
        res.setTypeface(custom_font);
        resDesc.setTypeface(custom_font);
        copyright.setTypeface(custom_font);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Email us at cust-support@themindbomber.ph", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
