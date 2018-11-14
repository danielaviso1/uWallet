package com.example.unknownymous.uwallet;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginjava extends Activity {
    Button btnLogin,btnExit;
    EditText edUsername,edPassword;
    CheckBox chkShow;
    TextView txtWallet;
    validationdb helper;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginif);
        helper = new validationdb(getBaseContext());
        init();
    }

    public void init(){
        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnExit = (Button)findViewById(R.id.btnExit);

        edUsername = (EditText)findViewById(R.id.edUsername);
        edPassword = (EditText)findViewById(R.id.edPassword);

        chkShow = (CheckBox)findViewById(R.id.chkShow);

        txtWallet = (TextView) findViewById(R.id.txtWallet);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/WetArial-Regular.otf");
        txtWallet.setTypeface(typeface);
    }

    public void Login(View view){
        String edUser,edPass;
        edUser = edUsername.getText().toString();
        edPass = edPassword.getText().toString();

        helper.open();
        Cursor c = helper.showdata();
        int x = c.getCount();
        if(x == 0 || edUsername.getText().toString().equals("") || edPassword.getText().toString().equals(""))
        {
            Toast.makeText(this, "Incorrect Username or Password", Toast.LENGTH_LONG).show();
        }

        else
        {
            for(int a = 0; a < x; a++)
            {
                c.moveToPosition(a);
                if(edUser.equals(c.getString(1)) && edPass.equals(c.getString(2)))
                {
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, dashboardjava.class);
                    this.startActivity(intent);
                }

                else if(a == x-1)
                {
                    Toast.makeText(this, "Incorrect Username or Password", Toast.LENGTH_LONG).show();
                }
            }


        }
        edUsername.setText("");
        edPassword.setText("");
        helper.close();
    }

    public void ShowPassword(View view)
    {
        if(chkShow.isChecked())
        {
            edPassword.setInputType(InputType.TYPE_CLASS_TEXT);
        }

        else
        {
            edPassword.setInputType(129);
        }
    }

    public void Exit(View view)
    {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
