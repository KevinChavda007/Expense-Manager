package com.aswdc.expensesmanager.Design;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.aswdc.expensesmanager.R;

public class AddExpenseCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense_category);
        setTitle("Add Expense Category");
    }
}
