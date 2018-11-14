package com.example.unknownymous.uwallet;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginjava extends Activity {
    Button btnLogin;
    EditText edUsername,edPassword;
    validationdb helper;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginif);
        helper = new validationdb(getBaseContext());
        init();
    }

    public void init(){
        btnLogin = (Button)findViewById(R.id.btnLogin);

        edUsername = (EditText)findViewById(R.id.edUsername);
        edPassword = (EditText)findViewById(R.id.edPassword);
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
        helper.close();
    }
}
