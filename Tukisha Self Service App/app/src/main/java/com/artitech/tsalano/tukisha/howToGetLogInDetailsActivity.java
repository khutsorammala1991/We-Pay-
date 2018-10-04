package com.artitech.tsalano.tukisha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class howToGetLogInDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_get_log_in_details);






        TextView next = (TextView ) findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginActivity = new Intent(howToGetLogInDetailsActivity.this,HowToTopUpActicity.class);
                startActivity(loginActivity);
            }
        });

        TextView  login = (TextView ) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginActivity = new Intent(howToGetLogInDetailsActivity.this,LoginActivity.class);
                startActivity(loginActivity);
            }
        });
        TextView  back = (TextView ) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginActivity = new Intent(howToGetLogInDetailsActivity.this,HowToRegisterActivity.class);
                startActivity(loginActivity);
            }
        });
    }
}
