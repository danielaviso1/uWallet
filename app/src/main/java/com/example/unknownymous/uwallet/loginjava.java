package com.example.unknownymous.uwallet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class loginjava extends Activity {
    Button btnLogin;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginif);
        init();
    }

    public void init(){
        btnLogin = (Button)findViewById(R.id.btnLogin);
    }

    public void Login(View view){
        Intent intent = new Intent(this, dashboardjava.class);
        startActivity(intent);
    }
}
