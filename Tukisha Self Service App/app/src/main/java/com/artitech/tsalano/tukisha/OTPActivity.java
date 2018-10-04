package com.artitech.tsalano.tukisha;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class OTPActivity extends AppCompatActivity {

    private TukishaApplication tukishaApplication;
    private Button topUpAmountButton;
    private EditText otp;
    private TextView messageTextView;
    private String topUpAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        tukishaApplication = (TukishaApplication) getApplicationContext();

        Button otpButton = (Button) findViewById(R.id.processTransactionButton);

        otp = (EditText) findViewById(R.id.editOTPNumber);
        messageTextView = (TextView) findViewById(R.id.messageTextView);

        Bundle bundle = getIntent().getExtras();
        topUpAmount = bundle.getString("reEnterAmount");

        Button btnGetMoreResults = (Button) findViewById(R.id.btnGetMoreResults);
        btnGetMoreResults.setText("Trading Balance :  " + tukishaApplication.getBalance() + "  |   Cash Back :  " + tukishaApplication.getTotalRewards());


        otpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog progressDialog = new ProgressDialog(v.getContext()); // this = YourActivity
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.setMessage("Please wait...");
                progressDialog.setIndeterminate(true);
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();

                AsyncHttpClient client = new AsyncHttpClient();
                client.get("https://munipoiapp.herokuapp.com/api/selfservice/validateotp?agentid=" + tukishaApplication.getAgentID() + "&otp=" + otp.getText().toString(), new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int status, Header[] headers, byte[] responseBody) {
                        try {

                            String response = responseBody == null ? null : new String(
                                    responseBody, getCharset());

                            progressDialog.dismiss();

                            if (status == 200) {

                                if (response.contains("failure")) {

                                    AlertDialog.Builder confirmationDialog = new AlertDialog.Builder(OTPActivity.this);
                                    confirmationDialog
                                            .setTitle("Insufficient Rewards or Invalid OTP")
                                            .setMessage("You do not have enough rewards to process this transaction or your OTP is incorrect.")
                                            .setCancelable(false)
                                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                                                public void onClick(DialogInterface dialog, int which) {


                                                }
                                            }).show();

                                } else {


                                    Intent ConfirmTopUpActivity = new Intent(OTPActivity.this,ConfirmTopUpActivity.class);
                                    ConfirmTopUpActivity.putExtra("reEnterAmount",topUpAmount);
                                    startActivity(ConfirmTopUpActivity);

                                }
                            }

                        } catch (Exception e) {
                            Log.d("Response: ", e.toString());
                            messageTextView.setText("Technical error " + e.toString());
                            progressDialog.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Log.d("Response: ", error.getMessage().toString());
                        messageTextView.setText("Technical error " +  error.getMessage().toString());
                        progressDialog.dismiss();
                    }


                });

            }
        });

        final View gohome = findViewById(R.id.gohome);
        gohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(OTPActivity.this,MainTabProductActivity.class);
                startActivity(int1);
            }
        });
    }
}
