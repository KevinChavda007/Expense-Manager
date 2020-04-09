package com.aswdc.expensesmanager.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.aswdc.expensesmanager.Bean.Bean_Category;
import com.aswdc.expensesmanager.R;

import java.util.ArrayList;

public class Adapter_Category extends BaseAdapter {
    Activity act;
    ArrayList<Bean_Category> arrayCategory;


    public Adapter_Category(Activity act, ArrayList<Bean_Category> arrayCategory){
        this.act=act;
        this.arrayCategory=arrayCategory;

    }

    @Override
    public int getCount() {
        return arrayCategory.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayCategory.get(i).getCategoryID();
    }

    @Override
    public long getItemId(int i) {
        return arrayCategory.get(i).getCategoryID();
    }

    private class ViewHolder{
        TextView tvCategoryName;
        TextView tvCategoryID;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        LayoutInflater inflater = act.getLayoutInflater();

        if (view == null){

            view = inflater.inflate(R.layout.sp_income_category,null,false);
            viewHolder = new ViewHolder();

            viewHolder.tvCategoryName=view.findViewById(R.id.sp_tv_income_category);
            viewHolder.tvCategoryID=view.findViewById(R.id.sp_tv_category_id);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.tvCategoryName.setText(arrayCategory.get(i).getCategoryName());
        viewHolder.tvCategoryID.setText(arrayCategory.get(i).getCategoryID()+"");
        return view;
    }
}
