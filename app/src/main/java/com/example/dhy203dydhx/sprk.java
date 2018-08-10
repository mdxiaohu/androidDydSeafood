package com.example.dhy203dydhx;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class sprk extends Activity {


    private Spinner citySpinner;
    private String[] cityList= {"鱼","虾","蟹","贝"};

    private Spinner jinSpinner;
    private String[] jinList= {"斤","千克","克","两"};

    private Spinner ghsSpinner;
    private String[] ghsList= {"段baba","运mama","张三","刘禅"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sprk_jm);

        citySpinner=(Spinner)findViewById(R.id.citySpiner);
        jinSpinner=(Spinner)findViewById(R.id.jinSpiner);
        ghsSpinner=(Spinner)findViewById(R.id.ghsSpiner);

        ArrayAdapter<String> spinerAda=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,cityList);
        ArrayAdapter<String> spinerAda1=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,jinList);
        ArrayAdapter<String> spinerAda2=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,ghsList);

        citySpinner.setAdapter(spinerAda);
        citySpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        jinSpinner.setAdapter(spinerAda1);
        jinSpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ghsSpinner.setAdapter(spinerAda2);
        ghsSpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    }

