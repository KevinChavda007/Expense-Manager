package com.aswdc.expensesmanager.DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.aswdc.expensesmanager.Bean.Bean_Transaction;
import com.aswdc.expensesmanager.Utility.Constant;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class DB_Transaction extends SQLiteAssetHelper {
    public DB_Transaction(Context context) {
        super(context, Constant.dbName, null, null, Constant.dbVersion);
    }

    public void insert(Bean_Transaction bt) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("CategoryID", bt.getCategoryID());
        cv.put("Amount", bt.getAmount());
        cv.put("Date", bt.getDate());
        cv.put("Description", bt.getDescription());
        cv.put("PaymentTypeID", bt.getPaymentTypeID());

        db.insert("MST_Transaction", null, cv);
        db.close();
    }

    public ArrayList<Bean_Transaction> selectAll() {
        SQLiteDatabase db = getReadableDatabase();
        String strQuery = "Select mt.CategoryID,mt.Amount,mt.Date,mt.ExpenseTypeID,mc.CategoryName from MST_Transaction mt inner join MST_Category mc on mt.CategoryID=mc.CategoryID";
        Cursor cur = db.rawQuery(strQuery, null);

        ArrayList<Bean_Transaction> arrayTransaction= new ArrayList<Bean_Transaction>();

        if (cur.moveToFirst()){
            do {
                Bean_Transaction bt= new Bean_Transaction();

                bt.setExpenseTypeID(cur.getInt(cur.getColumnIndex("ExpenseTypeID")));
                bt.setCategoryID(cur.getInt(cur.getColumnIndex("CategoryID")));
                bt.setAmount(cur.getString(cur.getColumnIndex("Amount")));
                bt.setDate(cur.getString(cur.getColumnIndex("Date")));
                bt.setCategoryName(cur.getString(cur.getColumnIndex("CategoryName")));

                arrayTransaction.add(bt);

            }while (cur.moveToNext());


        }
        db.close();
        return arrayTransaction;
    }
}
