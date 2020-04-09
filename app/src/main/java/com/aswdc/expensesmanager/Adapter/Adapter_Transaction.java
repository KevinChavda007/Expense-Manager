package com.aswdc.expensesmanager.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aswdc.expensesmanager.Bean.Bean_Transaction;
import com.aswdc.expensesmanager.DBHelper.DB_Transaction;
import com.aswdc.expensesmanager.R;

import java.util.ArrayList;

public class Adapter_Transaction extends BaseAdapter {

    Activity act;
    ArrayList<Bean_Transaction> arrayTransaction;
    DB_Transaction dbt;
    Typeface tf;

   public Adapter_Transaction(Activity act, ArrayList<Bean_Transaction> arrayTransaction) {
        this.act=act;
        this.arrayTransaction=arrayTransaction;
        dbt=new DB_Transaction(act);
        tf=Typeface.createFromAsset(act.getAssets(), "MaterialFont.ttf");
   }

    @Override
    public int getCount() {
        return arrayTransaction.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return arrayTransaction.get(i).getTransaction();
    }

    private class ViewHolder{
        ImageView imgCategory;
        TextView tvCategoryName;
        TextView tvDate;
        TextView tvAmount;
        TextView tvArrow;

    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        final ViewHolder viewHolder;
        LayoutInflater inflater = act.getLayoutInflater();

        if (view == null) {

            view = inflater.inflate(R.layout.transaction_list, null, false);
            viewHolder = new ViewHolder();

            viewHolder.imgCategory = (ImageView) view.findViewById(R.id.transaction_list_img_category);
            viewHolder.tvCategoryName = (TextView) view.findViewById(R.id.transaction_list_tv_category_name);
            viewHolder.tvDate = (TextView) view.findViewById(R.id.transaction_list_tv_date);
            viewHolder.tvAmount = (TextView) view.findViewById(R.id.transaction_list_tv_amount);
            viewHolder.tvArrow=(TextView) view.findViewById(R.id.transaction_list_tv_arrow);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.tvCategoryName.setText(arrayTransaction.get(i).getCategoryName());
        viewHolder.tvDate.setText(arrayTransaction.get(i).getDate());
        viewHolder.tvAmount.setText(arrayTransaction.get(i).getAmount());
        viewHolder.tvArrow.setTypeface(tf);

        return view;
    }

}
