package com.example.sam.myapplication;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by SAM on 5/30/2016.
 */
public class ListItemView extends Activity {

    private DatabaseController dbController;
    private TextView mTextView;
    private ListView listView;
    private ArrayAdapter <String>adapter;

    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry","WebOS","Ubuntu","Windows7","Max OS X"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.d("saurabh","ListItem onCreate()");
        setContentView(R.layout.list_item_view);

        dbController = new DatabaseController(this);
        mTextView = (TextView)findViewById(R.id.total_count);
        listView = (ListView)findViewById(R.id.list_view);

        adapter = new ArrayAdapter<String>(this, R.layout.list_item_layout, R.id.word_view, mobileArray);
        listView.setAdapter(adapter);


        Log.d("saurabh","ListItem dbController = " + dbController);
        Toast.makeText(this, "list created ", Toast.LENGTH_LONG).show();

        mTextView.setText(" "+ dbController.getCount());

    }
}
