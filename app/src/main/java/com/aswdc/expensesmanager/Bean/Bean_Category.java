package com.aswdc.expensesmanager.Bean;

public class Bean_Category {
    private int CategoryID;
    private String CategoryName;
    private int ExpenseTypeID;

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int categoryID) {
        CategoryID = categoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public int getExpenseTypeID() {
        return ExpenseTypeID;
    }

    public void setExpenseTypeID(int expenseTypeID) {
        ExpenseTypeID = expenseTypeID;
    }
}
