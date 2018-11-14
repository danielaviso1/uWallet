package com.example.unknownymous.uwallet;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class transactionjava extends ListActivity {
    validationdb helper;
    ArrayList<String> transactionlist = new ArrayList<String>();
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public int getSelectedItemPosition() {
        // TODO Auto-generated method stub
        return super.getSelectedItemPosition();
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);
        if(position == 1)
        {

        }

        else
        {

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        helper = new validationdb(getBaseContext());
        String getname;
        helper.open();
        Cursor c = helper.showdata();
        int x = c.getCount();
        for(int a = 0; a < x; a++)
        {
            c.moveToPosition(a);
            getname = c.getString(1);
            transactionlist.add(getname);
        }

        setListAdapter(new ArrayAdapter<String>(transactionjava.this,android.R.layout.simple_list_item_1,transactionlist));
        helper.close();
    }
}
