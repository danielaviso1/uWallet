package com.example.unknownymous.uwallet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class trdetailsjava extends Activity {
    EditText TrAmountXem,TrReceiverPublicKey,TrDateAndTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transactionif);
        init();
        int position;
        Intent intent = getIntent();
        position = intent.getIntExtra("position", 0);
    }

    public void init()
    {
        TrAmountXem = (EditText)findViewById(R.id.TrAmountXem);
        TrReceiverPublicKey = (EditText)findViewById(R.id.TrReceiverPublicKey);
        TrDateAndTime = (EditText)findViewById(R.id.TrDateAndTime);
    }
}
