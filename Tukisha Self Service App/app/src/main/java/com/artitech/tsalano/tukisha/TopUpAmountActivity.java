package com.artitech.tsalano.tukisha;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.artitech.tsalano.tukisha.model.TopUpModel;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class TopUpAmountActivity extends AppCompatActivity {

    EditText topUpAmount;
    Button topupButton;
    TextView messageTextView;
    private Context context;
    TukishaApplication tukishaApplication;
    TopUpModel TopUpModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up_amount);

        topUpAmount = (EditText) findViewById(R.id.editTopUpAmount);
        messageTextView = (TextView) findViewById(R.id.messageTextView);

        tukishaApplication = (TukishaApplication) getApplicationContext();

        Button btnGetMoreResults = (Button) findViewById(R.id.btnGetMoreResults);
        btnGetMoreResults.setText("Trading Balance :  " + tukishaApplication.getBalance() + "  |   Cash Back :  " + tukishaApplication.getTotalRewards());




        final View OTPpage = findViewById(R.id.processTransactionButton);
        OTPpage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                float cashBack = Float.parseFloat(tukishaApplication.getTotalRewards().replace("R ",""));
                float topupamount = Float.parseFloat(topUpAmount.getText().toString());

                if(topupamount > cashBack){

                    topUpAmount.setError(getResources().getString(R.string.error_massage).toString());
                    topUpAmount.requestFocus();
                    return;
                }





                final ProgressDialog progressDialog = new ProgressDialog(v.getContext()); // this = YourActivity
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.setMessage("Please wait...");
                progressDialog.setIndeterminate(true);
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();



                AsyncHttpClient client = new AsyncHttpClient();
                client.get("https://munipoiapp.herokuapp.com/api/selfservice/generateotp?agentid=" + tukishaApplication.getAgentID() + "&amount=" + topUpAmount.getText().toString(), new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        try {

                            String response = responseBody == null ? null : new String(
                                    responseBody, getCharset());

                            progressDialog.dismiss();

                            Gson gson = new Gson();

                            TopUpModel = gson.fromJson(response, TopUpModel.class);



                            AlertDialog.Builder confirmationDialog = new AlertDialog.Builder(TopUpAmountActivity.this);
                            confirmationDialog



                                    .setTitle("OTP Sent")
                                    .setMessage("OTP was sent successfully. Please check your SMS or email")
                                    .setCancelable(false)
                                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                                        public void onClick(DialogInterface dialog, int which) {

                                            Intent otppage = new Intent(TopUpAmountActivity.this,OTPActivity.class);
                                            otppage.putExtra("reEnterAmount",topUpAmount.getText().toString());
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



        final View gohome = findViewById(R.id.gohome);
        gohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(TopUpAmountActivity.this,MainTabProductActivity.class);
                startActivity(int1);
            }
        });




    }

}
