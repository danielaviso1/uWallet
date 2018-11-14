package com.example.unknownymous.uwallet;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class signupjava extends Activity {
    Button SignRegister, SignGenerate;
    EditText SignPrivateKey,SignPublicKey,SignNemAddress,SignUsername,SignPassword;
    CheckBox chkShow;
    validationdb helper;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signupif);
        helper = new validationdb(getBaseContext());
        init();
    }

    public void init()
    {
        SignRegister = (Button)findViewById(R.id.SignRegister);
        SignGenerate = (Button)findViewById(R.id.SignGenerate);

        SignPrivateKey = (EditText)findViewById(R.id.SignPrivateKey);
        SignPublicKey = (EditText)findViewById(R.id.SignPublicKey);
        SignNemAddress = (EditText)findViewById(R.id.SignNemAddress);
        SignUsername = (EditText)findViewById(R.id.SignUsername);
        SignPassword = (EditText)findViewById(R.id.SignPassword);

        chkShow = (CheckBox)findViewById(R.id.chkShow);
    }

    public void Register(View view) {
        String usern, passw;
        usern = SignUsername.getText().toString();
        passw = SignPassword.getText().toString();
        if (usern.equals("") && passw.equals(""))
        {
            Toast.makeText(this, "You Skipped Registration", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, loginjava.class);
            this.startActivity(intent);
        }

        else
        {
            helper.open();
            long insert = helper.insertData(usern, passw);
            helper.close();
            Toast.makeText(this, "Register Successful", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, loginjava.class);
            this.startActivity(intent);
        }
    }

    public void ShowPassword(View view)
    {
        if(chkShow.isChecked())
        {
            SignPassword.setInputType(InputType.TYPE_CLASS_TEXT);
        }

        else
        {
            SignPassword.setInputType(129);
        }
    }
}
