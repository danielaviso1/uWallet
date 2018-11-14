package com.example.unknownymous.uwallet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signupjava extends Activity {
    Button SignRegister, SignGenerate;
    EditText SignPrivateKey,SignPublicKey,SignNemAddress,SignUsername,SignPassword;
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
    }

    public void Register(View view)
    {
        String usern,passw;
        usern = SignUsername.getText().toString();
        passw = SignPassword.getText().toString();

        helper.open();
        long insert = helper.insertData(usern, passw);
        helper.close();
        Toast.makeText(this, "Register Successful", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, loginjava.class);
        this.startActivity(intent);
    }
}
