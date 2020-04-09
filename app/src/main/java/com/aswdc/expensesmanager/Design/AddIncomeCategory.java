package com.aswdc.expensesmanager.Design;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.aswdc.expensesmanager.R;

public class AddIncomeCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income_category);
        setTitle("Add Income Category");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
