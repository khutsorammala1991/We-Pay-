package com.artitech.tsalano.tukisha;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TrafficFinesActivity extends AppCompatActivity {

    TextView messageTextView;
    EditText editVehicleNumber;
    Button payFineButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_fees);

        editVehicleNumber=(EditText) findViewById(R.id.editAccNumber);
        messageTextView = (TextView) findViewById(R.id.messageTextView);

        payFineButton=(Button)findViewById(R.id.payFineButton);

        payFineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                messageTextView.setText(" Your payment has been processed ");

            }
        });
    }
}
