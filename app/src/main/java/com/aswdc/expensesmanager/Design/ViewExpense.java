package com.aswdc.expensesmanager.Design;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.aswdc.expensesmanager.R;

public class ViewExpense extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_expense);
        setTitle("View Expense");
    }
}
