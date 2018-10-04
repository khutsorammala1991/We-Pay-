package com.artitech.tsalano.tukisha;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.artitech.tsalano.tukisha.errorhandling.BackendDownException;
import com.artitech.tsalano.tukisha.model.UserDetailsModel;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.io.IOException;
import java.net.SocketTimeoutException;

import cz.msebera.android.httpclient.Header;

public class MyProfileActivity extends AppCompatActivity {
    TukishaApplication tukishaApplication;
    TextView errorMessage;
    TextView displayName;
    TextView displaySurname;
    TextView displayIdNumber;
    TextView email;
    TextView displayCellNumber;
    TextView referenceNumber;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        tukishaApplication = (TukishaApplication) getApplicationContext();


        displayName = (TextView) findViewById(R.id.Entername);
        displaySurname = (TextView) findViewById(R.id.Entersurname);
        displayIdNumber = (TextView) findViewById(R.id.Enteridnumber);
        email= (TextView) findViewById(R.id.Enteremail);
        displayCellNumber = (TextView) findViewById(R.id.Entercell);
        referenceNumber = (TextView) findViewById(R.id.reference);



        tukishaApplication = (TukishaApplication)getApplicationContext();
        final ProgressDialog progressDialog = new ProgressDialog(this); // this = YourActivity
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Retrieving Profile");
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(true);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();


        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://munipoiapp.herokuapp.com/api/selfservice/userdetails?&agentid=" + tukishaApplication.getAgentID(), new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int status, Header[] headers, byte[] responseBody) {
                try {

                    String response = responseBody == null ? null : new String(
                            responseBody, getCharset());

                    progressDialog.dismiss();

                    if (status == 200) {

                        if (response.contains("ERROR")) {

                        } else {

                            Gson gson = new Gson();
                            UserDetailsModel userDetails = gson.fromJson(response, UserDetailsModel.class);

                            displayName.setText(userDetails.getfirstname());
                            displaySurname.setText(userDetails.getSurnamer());
                            displayIdNumber.setText(userDetails.getIdNumber());
                            email.setText(userDetails.getemail());
                            displayCellNumber.setText(userDetails.getCell());
                            referenceNumber.setText(userDetails.getCustomerID());



                        }

                    }

                } catch (final IOException e) {
                }
            }

            @Override
            public void onFailure(int status, Header[] headers, byte[] responseBody, Throwable error) {

                progressDialog.dismiss();

                if (status == 404) {
                    try {
                        throw new BackendDownException("System is down, Please try again later or Call this number 078 377 6207");
                    } catch (BackendDownException e) {
                        errorMessage.setText("Technical error occurred " + e.getMessage());
                    }
                } else if (error instanceof SocketTimeoutException) {
                    errorMessage.setText("Connection timeout !");
                } else {
                    errorMessage.setText("Technical error occurred");
                }


            }


        });


        final View gohome = findViewById(R.id.gohome);
        gohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(MyProfileActivity.this,MainTabProductActivity.class);
                startActivity(int1);
            }
        });
    }
}
