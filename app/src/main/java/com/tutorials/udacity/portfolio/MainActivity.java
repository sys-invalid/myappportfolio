package com.tutorials.udacity.portfolio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView  lstAppNames;
    String[] arrAppNames ;
    ArrayAdapter lstAdpater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstAppNames = (ListView)findViewById(R.id.lstAppNames);
        arrAppNames  = getResources().getStringArray(R.array.appnames);
        lstAdpater  = new ArrayAdapter<String>(this,R.layout.app_list_item,R.id.tvapp,arrAppNames);
        lstAppNames.setAdapter(lstAdpater);
        lstAppNames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position < arrAppNames.length){
                    String message  = String.format(getString(R.string.toast_message),arrAppNames[position]);
                    Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();
                    view.setSelected(true);
                }
            }
        });

    }



}
