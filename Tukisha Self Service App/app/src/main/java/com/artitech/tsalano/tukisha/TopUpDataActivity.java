package com.artitech.tsalano.tukisha;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.artitech.tsalano.tukisha.errorhandling.BackendDownException;
import com.artitech.tsalano.tukisha.model.AirtimeVoucher;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.net.SocketTimeoutException;
import java.util.regex.Pattern;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Lenovo on 10-May-17.
 */

public class TopUpDataActivity extends AppCompatActivity {

    TukishaApplication tukishaApplication;
    private TextView mToolbarTitleTextView, itemCellNumber, itemTitle;
    private Toolbar toolbar;
    private Button goHome, sendSMSButton;
    private String agentid, productcode, producttype;
    private Context context;
    private Button contactButton;
    private static final int REQ_PICK_CONTACT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        tukishaApplication = (TukishaApplication) getApplication();

        setContentView(R.layout.activity_topupdata);

        context = this;


        Button btnGetMoreResults = (Button) findViewById(R.id.btnGetMoreResults);
        btnGetMoreResults.setText("Trading Balance :  " + tukishaApplication.getBalance() + "  |   Cash Back :  " + tukishaApplication.getTotalRewards());


        Bundle bundle = getIntent().getExtras();
        productcode = bundle.getString("productcode");
        agentid = bundle.getString("agentid");
        producttype = bundle.getString("producttype");

        goHome = (Button) findViewById(R.id.gohome);
        sendSMSButton = (Button) findViewById(R.id.sendVoucherSMSButton);

        itemCellNumber = (EditText) findViewById(R.id.item_cellnumber);
        itemTitle = (TextView) findViewById(R.id.title_name);
        itemTitle.setText("Top Up " + producttype);

        sendSMSButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isValidMobile(itemCellNumber.getText().toString()))
                    confirmDialog();
            }
        });

        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TopUpDataActivity.this, MainTabProductActivity.class);
                startActivity(i);
            }
        });

        contactButton = (Button) findViewById(R.id.contactButton);
        contactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
                startActivityForResult(intent, REQ_PICK_CONTACT);

            }
        });


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        configureToolbar();

        if (mToolbarTitleTextView != null) {
            //Setting name for toolbar
            mToolbarTitleTextView.setText("Thank You");
        }

    }

    @Override
    public void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);

        if (reqCode == REQ_PICK_CONTACT) {
            if (resultCode == RESULT_OK) {
                Uri contactData = data.getData();
                Cursor cursor = managedQuery(contactData, null, null, null, null);
                cursor.moveToFirst();

                String number = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));

                number = number.replaceAll("\\W+","");

                itemCellNumber.setText(number);
            }
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void configureToolbar() {
        Toolbar mainToolbar = (Toolbar) findViewById(R.id.toolbar);

        if (mainToolbar != null) {
            mToolbarTitleTextView = (TextView) mainToolbar.findViewById(R.id.toolbar_title_textView);

            setSupportActionBar(mainToolbar);

            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setHomeButtonEnabled(true);
                getSupportActionBar().setDisplayShowTitleEnabled(false);
            }
        }

    }

    private void confirmDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder
                .setMessage("Are you sure you want to top up " + itemCellNumber.getText() + " with data?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // Yes-code

                        final ProgressDialog progressDialog = new ProgressDialog(context);
                        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                        progressDialog.setMessage("Sending voucher, please wait...");
                        progressDialog.setIndeterminate(true);
                        progressDialog.setCanceledOnTouchOutside(false);
                        progressDialog.show();

                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(20000);
                        client.get("http://munipoiapp.herokuapp.com/api/selfservice/data?productcode=" + productcode + "&agentid=" + agentid + "&mobileNumber=" + itemCellNumber.getText().toString(), new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                                try {

                                    String response = responseBody == null ? null : new String(
                                            responseBody, getCharset());

                                    Gson gson = new Gson();
                                    AirtimeVoucher voucher = gson.fromJson(response, AirtimeVoucher.class);
                                    Log.d("airtime: ", voucher.getVoucher());

                                    progressDialog.dismiss();

                                    //Update Balance
                                    if (voucher.getBalance() != null) {
                                        if (!voucher.getBalance().isEmpty())
                                            tukishaApplication.setBalance("" + voucher.getBalance());

                                        if (!voucher.getTotalCashBack().isEmpty())
                                            tukishaApplication.setTotalRewards(voucher.getTotalCashBack());

                                        /*Intent i = new Intent(TopUpDataActivity.this, AirtimeThankYouActivity.class);
                                        i.putExtra("vouchernumber", voucher.getVoucher());
                                        i.putExtra("operator", voucher.getOperator());
                                        i.putExtra("date", voucher.getDate());
                                        i.putExtra("amount", voucher.getAmount());
                                        i.putExtra("instructions", voucher.getInstructions());
                                        i.putExtra("balance", voucher.getBalance());
                                        startActivity(i);*/

                                        AlertDialog.Builder builder = new AlertDialog.Builder(TopUpDataActivity.this);

                                        builder
                                                .setMessage(producttype + " Purchase was successful for " + itemCellNumber.getText() + " was successful")
                                                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int id) {

                                                        Intent i = new Intent(TopUpDataActivity.this, MainTabProductActivity.class);
                                                        startActivity(i);
                                                    }
                                                }).show();

                                    } else {

                                        AlertDialog.Builder builder = new AlertDialog.Builder(TopUpDataActivity.this);

                                        builder
                                                .setMessage("Something went wrong, please check if voucher was issued for " + itemCellNumber.getText() + " for " + producttype + "?")
                                                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int id) {

                                                        Intent i = new Intent(TopUpDataActivity.this, TransactionMainActivityE.class);
                                                        startActivity(i);
                                                    }
                                                }).show();
                                    }

                                } catch (Exception e) {
                                    Log.d("airtime error: ", e.toString());
                                    progressDialog.dismiss();
                                }
                            }

                            @Override
                            public void onFailure(int status, Header[] headers, byte[] responseBody, Throwable error) {

                                if (status == 404) {
                                    try {
                                        throw new BackendDownException("System is down, Please try again later or Call this number 078 377 6207");
                                    } catch (BackendDownException e) {


                                    }
                                } else if (error instanceof SocketTimeoutException) {

                                    progressDialog.dismiss();

                                    AlertDialog.Builder builder = new AlertDialog.Builder(TopUpDataActivity.this);

                                    builder
                                            .setMessage("System is taking too long to process your request, please check if voucher was issued for " + itemCellNumber.getText() + " for " + producttype + "?")
                                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int id) {

                                                    Intent i = new Intent(TopUpDataActivity.this, TransactionMainActivityE.class);
                                                    startActivity(i);
                                                }
                                            }).show();

                                } else {

                                    AlertDialog.Builder builder = new AlertDialog.Builder(TopUpDataActivity.this);

                                    builder
                                            .setMessage("System is taking too long to process your request, please check if voucher was issued " + itemCellNumber.getText() + " for " + producttype + "?")
                                            .setPositiveButton("Technical error message", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int id) {
                                                    Intent i = new Intent(TopUpDataActivity.this, TransactionMainActivityE.class);
                                                    startActivity(i);
                                                }
                                            });

                                }
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

    private boolean isValidMobile(String phone) {
        boolean check = false;
        if (!Pattern.matches("[a-zA-Z]+", phone)) {
            if (phone.length() < 10 || phone.length() > 13) {
                // if(phone.length() != 10) {
                check = false;
                itemCellNumber.setError("Not Valid Number");
                itemCellNumber.requestFocus();
            } else {
                check = true;
            }
        } else {
            check = false;
        }
        return check;
    }

}
