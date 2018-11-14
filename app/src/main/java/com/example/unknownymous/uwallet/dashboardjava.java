package com.example.unknownymous.uwallet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dashboardjava extends Activity {
    Button btnOpen,btnTransactions;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboardif);
        init();
    }

    public void init()
    {
        btnOpen = (Button)findViewById(R.id.btnOpen);
        btnTransactions = (Button)findViewById(R.id.btnTransactions);
    }

    public void Open(View view)
    {

    }

    public void Transactions(View view)
    {
        Intent intent = new Intent(this, transactionjava.class);
        this.startActivity(intent);
    }
}
