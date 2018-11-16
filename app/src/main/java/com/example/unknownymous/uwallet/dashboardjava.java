package com.example.unknownymous.uwallet;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class dashboardjava extends Activity {
    Button btnOpen,btnTransactions,btnReceive,btnSend;
    TextView txtMoney;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboardif);
        init();
    }

    public void init()
    {
        btnOpen = (Button)findViewById(R.id.btnOpen);
        btnTransactions = (Button)findViewById(R.id.btnTransactions);
        btnReceive = (Button)findViewById(R.id.btnReceive);
        btnSend = (Button)findViewById(R.id.btnSend);

        txtMoney = (TextView)findViewById(R.id.txtMoney);
    }

    public void Open(View view)
    {
        Intent i = new Intent(this, qrreceivejava.class);
        startActivity(i);
    }

    public void Send(View view)
    {
        Intent i = new Intent(this, qrsendjava.class);
        startActivity(i);
    }

    public void Receive(View view)
    {
        txtMoney.setText(getIntent().getStringExtra("EXTRA_SESSION_ID") + "Xem");
        txtMoney.setTextColor(Color.parseColor("#FFFFFF"));
    }

    public void Transactions(View view)
    {
        Intent intent = new Intent(this, transactionjava.class);
        this.startActivity(intent);
    }
}
