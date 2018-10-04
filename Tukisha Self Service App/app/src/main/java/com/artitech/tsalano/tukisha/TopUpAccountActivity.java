package com.artitech.tsalano.tukisha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.artitech.tsalano.tukisha.R.id.messageTextView;

public class TopUpAccountActivity extends AppCompatActivity {



    EditText topupacount;
    Button topupButton;
    TextView messageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up_account);

        topupacount=(EditText) findViewById(R.id.editAccNumber);
        messageTextView = (TextView) findViewById(R.id.messageTextView);

        topupButton = (Button) findViewById(R.id.processTransactionButton);

        topupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                messageTextView.setText(" Your Top Up has been processed ");

            }
        });

        final View gohome = findViewById(R.id.gohome);
        gohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(TopUpAccountActivity.this,MainTabProductActivity.class);
                startActivity(int1);
            }
        });


    }
}