package com.artitech.tsalano.tukisha;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PayAccountPageActivity extends AppCompatActivity {

    EditText editAccNumber;
    Button payAccountButton;
    TextView messageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_account_page);

        editAccNumber=(EditText) findViewById(R.id.editAccNumber);
        messageTextView = (TextView) findViewById(R.id.messageTextView);

        payAccountButton=(Button)findViewById(R.id.payAccountButton);

        payAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                messageTextView.setText(" Your payment has been processed ");

            }
        });
    }

}
