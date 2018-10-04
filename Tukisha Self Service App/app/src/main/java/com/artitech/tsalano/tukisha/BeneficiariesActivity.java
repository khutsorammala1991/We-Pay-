package com.artitech.tsalano.tukisha;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.artitech.tsalano.tukisha.errorhandling.BackendDownException;
import com.artitech.tsalano.tukisha.errorhandling.LoginException;
import com.artitech.tsalano.tukisha.model.AgentModel;
import com.loopj.android.http.HttpGet;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.util.EntityUtils;

public class BeneficiariesActivity extends  AppCompatActivity {
    public static final String TAG = "event";
    EditText ReditCMeterNumber;
    EditText ReditMeter;
    EditText ReditProvider;
    EditText Reditname;
    EditText Reditsurname;
    ArrayAdapter<String> adapter;
    private AgentModel agent = null;
    private Context context;
    TextView description;
    String editCMeterNumber;
    String editMeter;
    String editProvider;
    String editname;
    String editsurname;
    private BeneficiaryTask mAuthTask = null;
    private TextView messageTextView;
    Button registerButton;
    Spinner sp;
    private Spinner spinner2;
    Spinner spinnerProvider;
    TukishaApplication tukishaApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beneficiaries);

        tukishaApplication = (TukishaApplication) getApplicationContext();

        Button gohome = (Button) findViewById(R.id.gohome);

        gohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginActivity = new Intent(BeneficiariesActivity.this,MainTabProductActivity.class);
                startActivity(loginActivity);
            }
        });




        spinner2 = (Spinner) findViewById(R.id.spinner1);
        List<String> list = new ArrayList<String>();
        list.add("DSTV");
        list.add("Eskom");
        list.add("Municipalities");
        list.add("Telco");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);



        context = this;

        Reditname = (EditText) findViewById(R.id.enterName);
        Reditsurname = (EditText) findViewById(R.id.enterSurname);
        spinnerProvider = (Spinner) findViewById(R.id.spinner1);
        ReditMeter = (EditText) findViewById(R.id.meterNumber);
        ReditCMeterNumber = (EditText) findViewById(R.id.meterNumber1);
        registerButton = (Button) findViewById(R.id.save);
        messageTextView = (TextView) findViewById(R.id.messageTextView);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editname = Reditname.getText().toString();
                editProvider = spinnerProvider.getSelectedItem().toString();
                editMeter = BeneficiariesActivity.this.ReditMeter.getText().toString();
                editCMeterNumber = ReditCMeterNumber.getText().toString();



                if (editname.equals("") || editProvider.equals("") || editMeter.equals("")||editCMeterNumber.equals("") ) {

                    Toast.makeText(BeneficiariesActivity.this, "Fill in Missing Field", Toast.LENGTH_SHORT).show();


                } else
                    attemptRegister();

            }
        });


    }




    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptRegister() {
        if (mAuthTask != null) {
            return;
        }

        // Reset errors.
        Reditname.setError(null);
        Reditsurname.setError(null);
        spinnerProvider.setOnItemSelectedListener(null);
        ReditMeter.setError(null);
        ReditCMeterNumber.setError(null);



        // Store values at the time of the login attempt.

        String name = Reditname.getText().toString().trim();
        String surname =Reditsurname.getText().toString().trim();
        String categories = spinnerProvider.getSelectedItem().toString().trim();
        String meternumber= ReditMeter.getText().toString().trim();
        String confirmmeternumber = ReditCMeterNumber.getText().toString().trim();


        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (surname.isEmpty()||surname.length()>32) {
           Reditsurname.setError(getString(R.string.error_field_required));
            focusView = Reditsurname;
            cancel = true;
        }


        // Check for a name address.
        if (name.isEmpty()||name.length()>32) {
            Reditname.setError(getString(R.string.error_field_required));
            focusView = Reditname;
            cancel = true;
        }


        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            //showProgress(true);
            mAuthTask = new BeneficiaryTask (name,surname,meternumber,confirmmeternumber,categories);
            mAuthTask.execute((Void) null);
        }
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    private class BeneficiaryTask  extends AsyncTask<Void, Void, Boolean> {



        private final String categories;
        private final String confirmmeternumber;
        private Boolean isValid = Boolean.valueOf(true);
        private final String meternumber;
        private final String name;
        private final String surname;

        BeneficiaryTask (String name, String surname, String meternumber, String confirmmeternumber, String categories) {
            this.name = name;
            this.surname = surname;
            this.meternumber = meternumber;
            this.confirmmeternumber = confirmmeternumber;
            this.categories = categories;

            final ProgressDialog progressDialog = new ProgressDialog(BeneficiariesActivity.this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage("Please wait...");
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(true);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
        }

        @Override
        protected Boolean doInBackground(Void... params) {

            HttpGet httpget = new HttpGet("https://munipoiapp.herokuapp.com/api/selfservice/createbeneficiary?agentid=" +tukishaApplication.getAgentID() + "&name=" + name + "&surname=" + surname + "&cell=" + categories + "&meternumber=" + meternumber + "&confirmmeternumber=" + confirmmeternumber);
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response;
            try {

                response = httpclient.execute(httpget);

                int status = response.getStatusLine().getStatusCode();

                if (status == 200) {

                    HttpEntity entity = response.getEntity();
                    String responsedata = EntityUtils.toString(entity);

                    JSONObject responseAgent = new JSONObject(responsedata);

                    if (responseAgent.getString("status").contains("invalid"))
                        throw new LoginException(responseAgent.getString("status"));

                    isValid = true;

                } else {
                    if (status == 404) {
                        throw new BackendDownException("System is down, Please try again later or Call this number 078899999");
                    }
                }

                Log.d("Error", response.getStatusLine().toString());


            } catch (final IOException e) {

                runOnUiThread(new Runnable() {
                    public void run() {
                        messageTextView.setError("Technical error occurred " + e.getMessage());
                        messageTextView.requestFocus();
                    }
                });

                isValid = false;

            } catch (final JSONException e) {

                runOnUiThread(new Runnable() {
                    public void run() {
                        messageTextView.setError("Technical error occurred:" + e.getMessage());
                        messageTextView.requestFocus();
                    }
                });


            } catch (final LoginException e) {

                runOnUiThread(new Runnable() {
                    public void run() {
                        // update your UI component here.
                        messageTextView.setError(e.getMessage());
                        messageTextView.requestFocus();
                    }
                });

                isValid = false;

            } catch (final BackendDownException e) {
                runOnUiThread(new Runnable() {
                    public void run() {
                        // update your UI component here.
                        messageTextView.setError(e.getMessage());
                        messageTextView.requestFocus();
                    }
                });

                isValid = false;
            } catch (final Exception e) {
                runOnUiThread(new Runnable() {
                    public void run() {
                        // update your UI component here.
                        messageTextView.setError("Something went horrible wrong. Please restart the app.");
                        messageTextView.requestFocus();
                    }
                });

                isValid = false;
            }

            // TODO: register the new account here.
            return isValid;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;
            showProgress(false);

            if (success) {

                try {

                    AlertDialog.Builder confirmationDialog = new AlertDialog.Builder(context);
                    confirmationDialog
                            .setTitle("Create Beneficiaries")
                            .setMessage("User  successfully Added Beneficiary Details")
                            .setCancelable(false)
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int which) {


                                    Intent i = new Intent(BeneficiariesActivity.this, SelectBeneficiarysActivity.class);
                                    startActivity(i);


                                }
                            }).show();


                } catch (Exception ex) {
                    messageTextView.setError("Something went horrible wrong. Please restart the app. " + ex.getMessage());
                    messageTextView.requestFocus();
                }


                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);

            }

        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
        }



    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            Reditname.setVisibility(show ? View.GONE : View.VISIBLE);
            Reditname.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    Reditname.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });



            ReditMeter.setVisibility(show ? View.VISIBLE : View.GONE);
            ReditMeter.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    ReditMeter.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });

        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            messageTextView.setVisibility(show ? View.VISIBLE : View.GONE);
            messageTextView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }






}










