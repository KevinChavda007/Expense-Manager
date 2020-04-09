package com.aswdc.expensesmanager.Design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import com.aswdc.expensesmanager.Adapter.Adapter_Transaction;
import com.aswdc.expensesmanager.Bean.Bean_Transaction;
import com.aswdc.expensesmanager.DBHelper.DB_Transaction;
import com.aswdc.expensesmanager.R;

import java.util.ArrayList;

public class AllTransaction extends AppCompatActivity {

    ImageView CategoryIcon;
    String CategoryID;
    Context context;
    ListView lst;
    DB_Transaction dbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_transaction);
        String str = getIntent().getStringExtra("Title");
        setTitle(str);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lst=(ListView)findViewById(R.id.display_lst);
        CategoryIcon=(ImageView)findViewById(R.id.transaction_list_img_category);

        dbt=new DB_Transaction(this);
        lst.setAdapter(new Adapter_Transaction(this,dbt.selectAll()));


    }
}
