package com.aswdc.expensesmanager.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.aswdc.expensesmanager.Fragment.Fragment_Expenses_Category;
import com.aswdc.expensesmanager.Fragment.Fragment_Income_Category;

public class PagerViewAdapter extends FragmentPagerAdapter {
    public PagerViewAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new Fragment_Income_Category();
                break;
            case 1:
                fragment = new Fragment_Expenses_Category();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
