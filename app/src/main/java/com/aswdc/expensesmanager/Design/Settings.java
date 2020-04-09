package com.aswdc.expensesmanager.Design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.aswdc.expensesmanager.R;

public class Settings extends AppCompatActivity {

    TextView tvAddCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        String str = getIntent().getStringExtra("Title");
        setTitle(str);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvAddCategory=(TextView)findViewById(R.id.settings_list_tv_add_category);

        tvAddCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Settings.this, Settings_Add_Category.class);
                in.putExtra("Title",tvAddCategory.getText().toString());
                in.putExtra("From","New");
                startActivity(in);
            }
        });

    }
}


