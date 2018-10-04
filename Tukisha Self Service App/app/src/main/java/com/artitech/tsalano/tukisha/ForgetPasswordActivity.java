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

public class ForgetPasswordActivity extends AppCompatActivity {

    EditText accountNumber;
    Button goHome;
    TextView messageTextView;
    TukishaApplication tukishaApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        accountNumber = (EditText) findViewById(R.id.enterOTP);
        messageTextView = (TextView) findViewById(R.id.messageTextView);

        tukishaApplication = (TukishaApplication) getApplicationContext();

        goHome = (Button) findViewById(R.id.gohome);
        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ForgetPasswordActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        final View OTPpage = findViewById(R.id.Submit);
        OTPpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog progressDialog = new ProgressDialog(v.getContext()); // this = YourActivity
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.setMessage("Please wait...");
                progressDialog.setIndeterminate(true);
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();

                AsyncHttpClient client = new AsyncHttpClient();
                client.get("https://munipoiapp.herokuapp.com/api/selfservice/forgot?agentid=" + accountNumber.getText().toString(), new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        try {

                            progressDialog.dismiss();

                            AlertDialog.Builder confirmationDialog = new AlertDialog.Builder(ForgetPasswordActivity.this);
                            confirmationDialog
                                    .setTitle("OTP Sent")
                                    .setMessage("OTP was sent successfully. Please check your SMS or email")
                                    .setCancelable(false)
                                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                                        public void onClick(DialogInterface dialog, int which) {

                                            Intent otppage = new Intent(ForgetPasswordActivity.this,OTPForgotPasswordActivity.class);
                                            startActivity(otppage);

                                        }
                                    }).show();



                        } catch (Exception e) {
                            Log.d("Response: ", e.toString());
                            progressDialog.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Log.d("Response: ", error.getMessage().toString());
                        progressDialog.dismiss();
                    }


                });


            }
        });




    }


}
