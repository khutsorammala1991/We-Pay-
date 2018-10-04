package com.artitech.tsalano.tukisha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class GetStartedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        TextView registerButton = (TextView) findViewById(R.id.howtoregister);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginActivity = new Intent(GetStartedActivity.this,HowToRegisterActivity.class);
                startActivity(loginActivity);
            }
        });

        TextView  login = (TextView ) findViewById(R.id.backtologin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginActivity = new Intent(GetStartedActivity.this,LoginActivity.class);
                startActivity(loginActivity);
            }
        });

        TextView  logindetails = (TextView ) findViewById(R.id.logindetails);

        logindetails .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginActivity = new Intent(GetStartedActivity.this,howToGetLogInDetailsActivity.class);
                startActivity(loginActivity);
            }
        });

       TextView Topupacount = (TextView) findViewById(R.id.topupaccount);

        Topupacount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginActivity = new Intent(GetStartedActivity.this,HowToTopUpActicity.class);
                startActivity(loginActivity);
            }
        });
        TextView howtologin = (TextView) findViewById(R.id.howtologin);

        howtologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginActivity = new Intent(GetStartedActivity.this,HowToLogInActivity.class);
                startActivity(loginActivity);
            }
        });

        TextView howtouseap = (TextView) findViewById(R.id.howtouseapp);

        howtouseap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginActivity = new Intent(GetStartedActivity.this,HowToUseApp.class);
                startActivity(loginActivity);
            }
        });



    }
}
