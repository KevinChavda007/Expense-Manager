package com.aswdc.expensesmanager.DBHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.aswdc.expensesmanager.Bean.Bean_Category;
import com.aswdc.expensesmanager.Utility.Constant;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class DB_Category extends SQLiteAssetHelper {
    public DB_Category(Context context){
        super(context, Constant.dbName, null,null,Constant.dbVersion);
    }

    public int getCategoryID(String strCategoryName) {
        strCategoryName = '"' + strCategoryName + '"';
        SQLiteDatabase db = getReadableDatabase();
        String strQuery = "Select CategoryID from MST_Category where CategoryName=" + strCategoryName;
        Cursor cur = db.rawQuery(strQuery, null);
        int categoryID = 0;
        if (cur.moveToFirst()) {
            categoryID = cur.getInt(cur.getColumnIndex("CategoryID"));
        }
        return categoryID;
    }

    public ArrayList<Bean_Category> selectAllCategory(int ExpenseTypeID){
        SQLiteDatabase db=getReadableDatabase();
        String strQuery="Select * from MST_Category where ExpenseTypeID=" +ExpenseTypeID ;
        Cursor cur=db.rawQuery(strQuery,null);
        ArrayList<Bean_Category> arrayCategory= new ArrayList<Bean_Category>();
        if (cur.moveToFirst()){
            do {
                Bean_Category bc= new Bean_Category();
                bc.setCategoryID(cur.getInt(cur.getColumnIndex("CategoryID")));
                bc.setCategoryName(cur.getString(cur.getColumnIndex("CategoryName")));
                arrayCategory.add(bc);
            }while (cur.moveToNext());
        }
        return arrayCategory;
    }
}


