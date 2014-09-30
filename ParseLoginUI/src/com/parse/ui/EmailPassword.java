package com.parse.ui;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class EmailPassword extends Activity implements OnClickListener {

    Button no;
    Button add;
    TextView email;
    TextView password;
    TextView passwordConfirm;
    TextViewEx label;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Show the login form
        setContentView(R.layout.emailpassword);
        label = (TextViewEx) findViewById(R.id.passwordtext);
        label.setText("If you would like to be able to sign in later using a username and password, instead of your facebook account, Enter a User Name and Password in the boxes below.", true);
        no = (Button) findViewById(R.id.no_thanks);
        no.setOnClickListener(this);
        add = (Button) findViewById(R.id.add_data);
        add.setOnClickListener(this);
        email = (TextView) findViewById(R.id.email);
        password = (TextView) findViewById(R.id.password);
        passwordConfirm = (TextView) findViewById(R.id.password2);
    }

    @Override
    public void onClick(View v) {
        Intent resultIntent = new Intent();
        int id = v.getId();
        if (id == R.id.no_thanks) {

            setResult(Activity.RESULT_CANCELED, resultIntent);

        } else if (id == R.id.add_data) {
            String strPass1 = password.getText().toString();
            String strPass2 = passwordConfirm.getText().toString();
            if (!strPass1.equals(strPass2)) {
                passwordConfirm.setError(Html.fromHtml("<font color='red'>Passwords do not Match!</font>"));

            } else {
                resultIntent.putExtra("email", email.getText().toString().trim().toLowerCase(Locale.US));
                resultIntent.putExtra("password", password.getText().toString());

                setResult(Activity.RESULT_OK, resultIntent);
            }
        }
        finish();
    }
}
