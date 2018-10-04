package com.artitech.tsalano.tukisha;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class ConfirmTopUpActivity extends AppCompatActivity {

    Button topupButton;
    TextView messageTextView;
    private TukishaApplication tukishaApplication;
    private String topUpAmount;
    private TextView EnterAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_top_up);

        tukishaApplication = (TukishaApplication) getApplicationContext();

        Bundle bundle = getIntent().getExtras();
        topUpAmount = bundle.getString("reEnterAmount");

        EnterAmount = (TextView) findViewById(R.id.editTopUpAmount);
        messageTextView = (TextView) findViewById(R.id.messageTextView);

        EnterAmount.setText( topUpAmount);




        Button btnGetMoreResults = (Button) findViewById(R.id.btnGetMoreResults);
        btnGetMoreResults.setText("Trading Balance : R " + tukishaApplication.getBalance() + "  |   Cash Back :  " + tukishaApplication.getTotalRewards());


        final View otpButton = findViewById(R.id.processTransactionButton);
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
                client.get("https://munipoiapp.herokuapp.com/api/selfservice/confirmtopup?agentid=" + tukishaApplication.getAgentID() + "&amount=" + topUpAmount, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int status, Header[] headers, byte[] responseBody) {
                        try {

                            String response = responseBody == null ? null : new String(
                                    responseBody, getCharset());

                            progressDialog.dismiss();

                            if (status == 200) {

                                if (response.contains("failure")) {

                                    AlertDialog.Builder confirmationDialog = new AlertDialog.Builder(ConfirmTopUpActivity.this);
                                    confirmationDialog
                                            .setTitle("Insufficient Rewards")
                                            .setMessage("You do not have enough rewards to process this transaction.")
                                            .setCancelable(false)
                                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                                                public void onClick(DialogInterface dialog, int which) {



                                                }
                                            }).show();

                                } else {

                                    JSONObject responseCashback = new JSONObject(response);
                                    tukishaApplication.setTotalRewards(responseCashback.getString("totalRewards"));
                                    tukishaApplication.setBalance(responseCashback.getString("tradingBalance"));

                                    AlertDialog.Builder confirmationDialog = new AlertDialog.Builder(ConfirmTopUpActivity.this);
                                    confirmationDialog
                                            .setTitle("Top Up Successful")
                                            .setMessage("Top Up was processed successfully.")
                                            .setCancelable(false)
                                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                                                public void onClick(DialogInterface dialog, int which) {

                                                    Intent MainTabProductActivity = new Intent(ConfirmTopUpActivity.this,MainTabProductActivity.class);
                                                    MainTabProductActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                    startActivity(MainTabProductActivity);

                                                }
                                            }).show();

                                }
                            }

                        } catch (Exception e) {
                            messageTextView.setText("Technical error " + e.toString());
                            progressDialog.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        messageTextView.setText("Technical error " + error.getMessage().toString());
                        progressDialog.dismiss();
                    }


                });

            }
        });

        final View gohome = findViewById(R.id.gohome);
        gohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MainTabProductActivity = new Intent(ConfirmTopUpActivity.this,MainTabProductActivity.class);
                startActivity(MainTabProductActivity);
            }
        });

    }
}
