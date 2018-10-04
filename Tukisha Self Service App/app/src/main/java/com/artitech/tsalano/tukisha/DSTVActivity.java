package com.artitech.tsalano.tukisha;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.artitech.tsalano.tukisha.model.DSTVCustomerModel;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cn.pedant.SweetAlert.SweetAlertDialog;
import cz.msebera.android.httpclient.Header;

public class DSTVActivity extends AppCompatActivity {
    EditText editAmount, editCustomerID;
    private Button buttoncontuct;
    Button payDSTVButton;
    TextView messageTextView;
    private static final String CHINESE = "GBK";
    private Context context;
    TukishaApplication tukishaApplication;
    DSTVCustomerModel DSTVCustomerInfo;
    private static final int PICK_CONTACT = 2;
    public static final int REQUEST_CODE = 1;

    String accountId;




    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_dstv);

        bundle = getIntent().getExtras();
        if (bundle != null && bundle.containsKey("accountNumber")) {
           accountId = bundle.getString("accountNumber");
        }


        ((Button) findViewById(R.id.contactButton)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                new SweetAlertDialog(view.getContext(), 3).setTitleText("Select Beneficiary")
                        .setContentText("please load from this options below ")
                        .setConfirmText("Beneficiary").setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismissWithAnimation();
                        Intent i = new Intent(DSTVActivity.this, SelectBeneficiarysActivity.class);
                        DSTVActivity.this.startActivity(i);
                    }
                }).setCancelText("Phone Book").setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                        startActivityForResult(intent,PICK_CONTACT);
                    }
                }).show();
            }
        });


        context = this;

        tukishaApplication = (TukishaApplication) getApplicationContext();

        Button btnGetMoreResults = (Button) findViewById(R.id.btnGetMoreResults);
        btnGetMoreResults.setText("Trading Balance :  " + tukishaApplication.getBalance() + "  |   Cash Back :  " + tukishaApplication.getTotalRewards());

        Button registerButton = (Button) findViewById(R.id.gohome);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginActivity = new Intent(DSTVActivity.this,MainTabProductActivity.class);
                startActivity(loginActivity);
            }
        });



        //editAccNumber=(EditText) findViewById(R.id.editAccNumber);
        editCustomerID =(EditText) findViewById(R.id.editCustomerID);
        editCustomerID.setText(this.accountId);
        editAmount=(EditText) findViewById(R.id.editAmount);
        messageTextView = (TextView) findViewById(R.id.messageTextView);
        payDSTVButton=(Button)findViewById(R.id.payDSTVButton);

        payDSTVButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editCustomerID.getText().length()>1)
                    confirmDialog();
                else {

                    editCustomerID.setError("Please enter customer number");
                }

            }
        });
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == PICK_CONTACT) {
            if (i2 == -REQUEST_CODE) {
                  managedQuery(intent.getData(), null, null, null, null);

            }
        } else if (i2 == -1) {
            editCustomerID.setText(intent.getStringExtra("accountNumber"));
        }
    }





    private void confirmDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder
                .setMessage("Continue Retrieving Customer Information " + editAmount.getText() + "?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // Yes-code

                        final ProgressDialog progressDialog = new ProgressDialog(context); // this = YourActivity
                        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                        progressDialog.setMessage("Getting Customer Information, please wait...");
                        progressDialog.setIndeterminate(true);
                        progressDialog.setCanceledOnTouchOutside(false);
                        progressDialog.show();

                        AsyncHttpClient client = new AsyncHttpClient();
                        client.get("https://munipoiapp.herokuapp.com/api/selfservice/dstvtcustomerinfo?agentid=" + tukishaApplication.getAgentID() + "&customerid=" + editCustomerID.getText().toString(), new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                                try {

                                    String response = responseBody == null ? null : new String(
                                            responseBody, getCharset());

                                    progressDialog.dismiss();

                                    if(response.contains("InvalidSearchIdentifier")) {

                                        AlertDialog.Builder confirmationDialog = new AlertDialog.Builder(context);
                                        confirmationDialog
                                                .setTitle("Customer Information")
                                                .setMessage("Customer not found.")
                                                .setCancelable(false)
                                                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                                                    public void onClick(DialogInterface dialog, int which) {


                                                    }
                                                }).show();

                                    } else {

                                        Gson gson = new Gson();
                                        DSTVCustomerInfo = gson.fromJson(response, DSTVCustomerModel.class);


                                        AlertDialog.Builder confirmationDialog = new AlertDialog.Builder(context);
                                        confirmationDialog
                                                .setTitle("Customer Information")
                                                .setMessage(DSTVCustomerInfo.displayCustomerInfo())
                                                .setCancelable(false)
                                                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                                                    public void onClick(DialogInterface dialog, int which) {

                                                        Intent i = new Intent(DSTVActivity.this, PayDSTVActivity.class);
                                                        i.putExtra("customernumber", DSTVCustomerInfo.getCustomerNumber());
                                                        i.putExtra("accountnumber", DSTVCustomerInfo.getAccountNumber());
                                                        i.putExtra("customerinitials", DSTVCustomerInfo.getInitials());
                                                        i.putExtra("customersurname", DSTVCustomerInfo.getSurname());
                                                        i.putExtra("amountdue", DSTVCustomerInfo.getPaymentAmount());
                                                        i.putExtra("amount", editAmount.getText().toString());
                                                        i.putExtra("cellNumber", DSTVCustomerInfo.getCellNumber());

                                                        startActivity(i);

                                                    }
                                                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                                            public void onClick(DialogInterface dialog, int which) {

                                            }

                                        })
                                                .show();
                                    }


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
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        }).show();

    }




}
