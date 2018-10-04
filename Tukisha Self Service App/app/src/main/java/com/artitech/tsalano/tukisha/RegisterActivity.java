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
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.artitech.tsalano.tukisha.errorhandling.BackendDownException;
import com.artitech.tsalano.tukisha.errorhandling.LoginException;
import com.artitech.tsalano.tukisha.model.AgentModel;
import com.loopj.android.http.HttpGet;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.util.EntityUtils;

/**
 * A login screen that offers login via email/password.
 */
public class RegisterActivity extends AppCompatActivity {

    public static final String TAG ="event" ;
    String editSurname, editName, editEmail, editCellNumber,editIDNumber,promotion;
    EditText ReditSurname,  ReditName,  ReditEmail, ReditCellNumber, ReditIDNumber;
    Button  registerButton;
    CheckBox editpromotion;
    private AgentModel agent = null;
    private TextView messageTextView;
    private UserRegisterTask mAuthTask = null;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        final View gohome = findViewById(R.id.policy);
        gohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(RegisterActivity.this,PrivacyPolicyActivity.class);
                startActivity(int1);
            }
        });

        final View tnc = findViewById(R.id.TnCPage);
        tnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(RegisterActivity.this,TandCActicity.class);
                startActivity(int1);
            }
        });

        context = this;

        ReditSurname = (EditText) findViewById(R.id.editSurname);
        editpromotion= (CheckBox) findViewById(R.id.promotion);
        ReditName = (EditText) findViewById(R.id.editName);
        ReditEmail = (EditText) findViewById(R.id.editEmail);
        ReditCellNumber = (EditText) findViewById(R.id.editCellNumber);
        ReditIDNumber = (EditText) findViewById(R.id.editIDNumber);
        registerButton = (Button) findViewById(R.id.registerButton);
        messageTextView = (TextView) findViewById(R.id.messageTextView);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editSurname = ReditSurname.getText().toString();
                promotion = editpromotion.getText().toString();
                editName = ReditName.getText().toString();
                editEmail = ReditEmail.getText().toString();
                editCellNumber = ReditCellNumber.getText().toString();
                editIDNumber = ReditIDNumber.getText().toString();
                if (editSurname.equals("") || editName.equals("") || editEmail.equals("") || editCellNumber.equals("")|| promotion.equals("") || editIDNumber.equals("")) {

                    Toast.makeText(RegisterActivity.this, "Missing Field", Toast.LENGTH_SHORT).show();


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
        ReditSurname.setError(null);
        editpromotion.setError(null);
        ReditName.setError(null);
        ReditEmail.setError(null);
        ReditCellNumber.setError(null);
        ReditIDNumber.setError(null);


        // Store values at the time of the login attempt.
        String surname = ReditSurname.getText().toString().trim();
        String promotion = editpromotion.getText().toString().trim();
        String name = ReditName.getText().toString().trim();
        String email = ReditEmail.getText().toString().trim();
        String cellNumber = ReditCellNumber.getText().toString().trim();
        String idNumber = ReditIDNumber.getText().toString().trim();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (surname.isEmpty()||surname.length()>32) {
            ReditSurname.setError(getString(R.string.error_field_required));
            focusView = ReditSurname;
            cancel = true;
        }
        if (promotion.isEmpty()||promotion.length()>32) {
            editpromotion.setError(getString(R.string.error_field_required));
            focusView = editpromotion;
            cancel = true;
        }


        // Check for a name address.
        if (name.isEmpty()||name.length()>32) {
            ReditName.setError(getString(R.string.error_field_required));
            focusView = ReditName;
            cancel = true;
        }

        if (email.isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            ReditEmail.setError(getString(R.string.error_field_required));
            focusView = ReditEmail;
            cancel = true;
        }

        if (cellNumber.isEmpty()||name.length()>=10) {
            ReditCellNumber.setError(getString(R.string.error_field_required));
            focusView = ReditCellNumber;
            cancel = true;
        }


        if (TextUtils.isEmpty(idNumber)) {
            ReditIDNumber.setError(getString(R.string.error_field_required));
            focusView = ReditIDNumber;
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
            mAuthTask = new UserRegisterTask(surname,name,email,cellNumber,idNumber);
            mAuthTask.execute((Void) null);
        }
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    private class UserRegisterTask extends AsyncTask<Void, Void, Boolean> {



        private final String surname;
        private final String name;
        private final String email;
        private final String cellNumber;
        private final String idNumber;
        private Boolean isValid;

        UserRegisterTask(String surname, String firstName, String email, String cellNumber, String idNumber) {
            this.surname = surname;
            this.name = firstName;
            this.email = email;
            this.cellNumber = cellNumber;
            this.idNumber = idNumber;

            final ProgressDialog progressDialog = new ProgressDialog(RegisterActivity.this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage("Please wait...");
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(true);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
        }

        @Override
        protected Boolean doInBackground(Void... params) {

            HttpGet httpget = new HttpGet("https://munipoiapp.herokuapp.com/api/selfservice/agentregister?surname=" + surname + "&firstName=" + name + "&email=" + email + "&cellNumber=" + cellNumber + "&idNumber=" + idNumber);
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
                            .setTitle("Registration")
                            .setMessage("User registered successfully Check your Email for Login Details")
                            .setCancelable(false)
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int which) {


                                    Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
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

            ReditSurname.setVisibility(show ? View.GONE : View.VISIBLE);
            ReditSurname.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    ReditSurname.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            ReditName.setVisibility(show ? View.VISIBLE : View.GONE);
            ReditName.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    ReditName.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });

            ReditEmail.setVisibility(show ? View.VISIBLE : View.GONE);
            ReditEmail.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    ReditEmail.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });

            ReditCellNumber.setVisibility(show ? View.VISIBLE : View.GONE);
            ReditCellNumber.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    ReditCellNumber.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });

            ReditIDNumber.setVisibility(show ? View.VISIBLE : View.GONE);
            ReditIDNumber.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    ReditIDNumber.setVisibility(show ? View.VISIBLE : View.GONE);
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

