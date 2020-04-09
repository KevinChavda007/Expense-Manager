package com.aswdc.expensesmanager.Design;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.aswdc.expensesmanager.Adapter.Adapter_Category;
import com.aswdc.expensesmanager.Bean.Bean_Category;
import com.aswdc.expensesmanager.Bean.Bean_Transaction;
import com.aswdc.expensesmanager.DBHelper.DB_Category;
import com.aswdc.expensesmanager.DBHelper.DB_Transaction;
import com.aswdc.expensesmanager.R;
import com.aswdc.expensesmanager.Utility.Constant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AddExpense extends AppCompatActivity {

    Spinner spSelectcategory;
    EditText etAmount;
    EditText etDate;
    EditText etDescription;
    Spinner spPaymentmethod;
    Button btnAdd;
    Button btnReset;
    int categoryID=0;

    SimpleDateFormat sdf;

    DB_Transaction dbt;
    DB_Category dbc;
    Bean_Transaction bt;
    Bean_Category bc;
    ArrayList<Bean_Category> arrayCategory;

    String strFrom = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);
        String str = getIntent().getStringExtra("Title");
        setTitle(str);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        strFrom = getIntent().getStringExtra("From");

        spSelectcategory =(Spinner)findViewById(R.id.ex_sp_category);
        etAmount = (EditText) findViewById(R.id.ex_et_amount);
        etDate = (EditText) findViewById(R.id.ex_et_date);
        etDescription = (EditText) findViewById(R.id.ex_et_description);
        spPaymentmethod =(Spinner)findViewById(R.id.ex_sp_paymentmethod);
        btnAdd = (Button) findViewById(R.id.ex_btn_add);
        btnReset = (Button) findViewById(R.id.ex_btn_reset);

        etDate.setInputType(InputType.TYPE_NULL);

        dbt= new DB_Transaction(this);
        dbc = new DB_Category(this);
        bt = new Bean_Transaction();
        bc = new Bean_Category();
        arrayCategory=dbc.selectAllCategory(Constant.Expense);
        spSelectcategory.setAdapter(new Adapter_Category(this,arrayCategory));

        sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        etDate.setText(sdf.format(new Date().getTime()));

        bt = new Bean_Transaction();

        spSelectcategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                TextView tvCategoryID=(TextView)view.findViewById(R.id.sp_tv_category_id);
                categoryID=Integer.parseInt(tvCategoryID.getText().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDateTimeFiled(etDate);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int flag = 0;
                if (etAmount.getText().length() > 0) {
                    bt.setAmount(etAmount.getText().toString());
                } else {
                    etAmount.setError("Please Enter Amount");
                    flag = 1;
                }
                bt.setDate(etDate.getText().toString());
                int i = (int)spSelectcategory.getSelectedItemId();
                Log.d("i", i + "");
                bt.setCategoryID(i);
                bt.setExpenseTypeID(Constant.Expense);
                if (flag == 0) {
                    Intent in = new Intent(AddExpense.this, DashboardActivity.class);
                    startActivity(in);
                    dbt.insert(bt);
                    Toast.makeText(AddExpense.this, "Saved!", Toast.LENGTH_LONG).show();
                    btnReset.performClick();
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spSelectcategory.setSelection(0);
                etAmount.setText("");
                etDate.setText("");
                etDescription.setText("");
                spPaymentmethod.setSelection(0);
                spSelectcategory.requestFocus();
            }
        });

    }

    public void setDateTimeFiled(final EditText etDate) {
        Calendar newCalendar = Calendar.getInstance();
        try {
            newCalendar.setTime(new SimpleDateFormat("dd-MM-yyyy").parse(etDate.getText().toString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                Date date = null;
                try {
                    date = format.parse(etDate.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Calendar newDate = Calendar.getInstance();

                newDate.set(year, monthOfYear, dayOfMonth);
                etDate.setText(sdf.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }
}
