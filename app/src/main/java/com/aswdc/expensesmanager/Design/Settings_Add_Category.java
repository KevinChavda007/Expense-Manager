package com.aswdc.expensesmanager.Design;

import android.app.AppComponentFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.aswdc.expensesmanager.Adapter.PagerViewAdapter;
import com.aswdc.expensesmanager.R;

public class Settings_Add_Category extends AppCompatActivity {

    TextView tvIncome,tvExpenses;
    ViewPager viewPager;
    PagerViewAdapter pagerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_add_category);
        init();
        String str = getIntent().getStringExtra("Title");
        setTitle(str);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        pagerViewAdapter = new PagerViewAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerViewAdapter);

        tvIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });
        tvExpenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onPageSelected(int position) {
                onChangeTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void onChangeTab(int position) {
        if (position == 0){
            tvIncome.setTextSize(17);
            tvIncome.setTextColor(getColor(R.color.md_white_1000));

            tvExpenses.setTextSize(17);
            tvExpenses.setTextColor(getColor(R.color.colorSecondaryText));
        }
        if (position == 1){
            tvIncome.setTextSize(17);
            tvIncome.setTextColor(getColor(R.color.colorSecondaryText));

            tvExpenses.setTextSize(17);
            tvExpenses.setTextColor(getColor(R.color.md_white_1000));
        }
    }

    public void init(){
        tvIncome = (TextView)findViewById(R.id.tb_income);
        tvExpenses =(TextView)findViewById(R.id.tb_expenses);
        viewPager = (ViewPager) findViewById(R.id.fragment_container);
    }
}
