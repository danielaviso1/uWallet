package com.example.unknownymous.uwallet;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dashboardjava extends Activity {
    Button btnOpen;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboardif);
        init();
    }

    public void init(){
        btnOpen = (Button)findViewById(R.id.btnOpen);
    }

    public void Open(View view)
    {

    }
}
