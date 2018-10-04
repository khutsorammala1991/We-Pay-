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

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class OTPForgotPasswordActivity extends AppCompatActivity {

    private TukishaApplication tukishaApplication;
    private Button topUpAmountButton;
    private EditText enterOTP;
    private EditText enterNewpassword;
    private EditText confpassword;
    private TextView messageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpforgot_password);

        tukishaApplication = (TukishaApplication) getApplicationContext();

        Button resetButton = (Button) findViewById(R.id.resetButton);

        enterOTP = (EditText) findViewById(R.id.enterOTP);
        enterNewpassword = (EditText) findViewById(R.id.newPassword);
        confpassword = (EditText) findViewById(R.id.confirmPassword);
        messageTextView = (TextView) findViewById(R.id.messageTextView);


        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(!confpassword.getText().toString().equals(enterNewpassword.getText().toString()))
                {
                    messageTextView.setText("Password doesnt match");
                    return;
                }

                final ProgressDialog progressDialog = new ProgressDialog(v.getContext()); // this = YourActivity
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.setMessage("Please wait...");
                progressDialog.setIndeterminate(true);
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();

                AsyncHttpClient client = new AsyncHttpClient();
                client.get("https://munipoiapp.herokuapp.com/api/selfservice/reset?agentid="
                                + tukishaApplication.getAgentID() + "&otp=" + enterOTP.getText().toString() + "&password="
                                + confpassword.getText().toString()+ "&confirm=" +  enterNewpassword.getText().toString(),
                        new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        try {

                            String response = responseBody == null ? null : new String(
                                    responseBody, getCharset());

                            progressDialog.dismiss();

                            if (response.contains("failure")) {

                                JSONObject responsePasswordReset = new JSONObject(response);
                                AlertDialog.Builder confirmationDialog = new AlertDialog.Builder(OTPForgotPasswordActivity.this);
                                confirmationDialog
                                        .setTitle("Password Reset Failure")
                                        .setMessage(responsePasswordReset.getString("statusDescription"))
                                        .setCancelable(false)
                                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                                            public void onClick(DialogInterface dialog, int which) { }

                                        }).show();

                            } else {

                                AlertDialog.Builder confirmationDialog = new AlertDialog.Builder(OTPForgotPasswordActivity.this);
                                confirmationDialog
                                        .setTitle("Reset Password Successful")
                                        .setMessage("Log In to your Account")
                                        .setCancelable(false)
                                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                                            public void onClick(DialogInterface dialog, int which) {

                                                Intent otppage = new Intent(OTPForgotPasswordActivity.this, LoginActivity.class);
                                                startActivity(otppage);

                                            }
                                        }).show();

                            }

                        } catch (Exception e) {
                            Log.d("Response: ", e.toString());
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


    }
}

