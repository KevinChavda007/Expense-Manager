package com.aswdc.expensesmanager.Design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import com.aswdc.expensesmanager.R;

public class DashboardActivity extends AppCompatActivity {

    Button btnAddIncome;
    Button btnAddExpense;
    Button btnAllTransaction;
    Button btnReports;
    Button btnSettings;
    Button btnShare;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        init();
        btnAddIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(DashboardActivity.this,AddIncome.class);
                in.putExtra("Title",btnAddIncome.getText().toString());
                in.putExtra("From","New");
                startActivity(in);
            }
        });
        btnAddExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(DashboardActivity.this,AddExpense.class);
                in.putExtra("Title", btnAddExpense.getText().toString());
                in.putExtra("From", "New");
                startActivity(in);
            }
        });
        btnAllTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(DashboardActivity.this,AllTransaction.class);
                in.putExtra("Title",btnAllTransaction.getText().toString());
                in.putExtra("From","New");
                startActivity(in);
            }
        });
        btnReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(DashboardActivity.this,Reports.class);
                in.putExtra("Title",btnReports.getText().toString());
                in.putExtra("From","New");
                startActivity(in);
            }
        });
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(DashboardActivity.this, Settings.class);
                in.putExtra("Title",btnSettings.getText().toString());
                in.putExtra("From","New");
                startActivity(in);
            }
        });
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(DashboardActivity.this, AddIncomeCategory.class);
                in.putExtra("Title",btnShare.getText().toString());
                in.putExtra("From","New");
                startActivity(in);
            }
        });
    }

    void init() {
        btnAddIncome = (Button) findViewById(R.id.dashboard_btn_addincome);
        btnAddExpense = (Button) findViewById(R.id.dashboard_btn_addexpense);
        btnAllTransaction = (Button) findViewById(R.id.dashboard_btn_alltransaction);
        btnReports = (Button) findViewById(R.id.dashboard_btn_reports);
        btnSettings = (Button) findViewById(R.id.dashboard_btn_settings);
        btnShare = (Button) findViewById(R.id.dashboard_btn_share);

    }
}