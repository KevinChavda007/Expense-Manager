package com.aswdc.expensesmanager.Design;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.aswdc.expensesmanager.R;

public class Reports extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);
        String str = getIntent().getStringExtra("Title");
        setTitle(str);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
