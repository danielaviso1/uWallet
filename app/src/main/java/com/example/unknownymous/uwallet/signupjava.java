package com.example.unknownymous.uwallet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class signupjava extends Activity {
    Button btnRegister;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signupif);
        init();
    }

    public void init()
    {
        btnRegister = (Button)findViewById(R.id.btnRegister);
    }

    public void Register(View view)
    {
        Intent intent = new Intent(this, loginjava.class);
        startActivity(intent);
    }
}
