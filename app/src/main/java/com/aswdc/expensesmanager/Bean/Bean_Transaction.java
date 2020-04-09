package com.aswdc.expensesmanager.Bean;

public class Bean_Transaction {

    private int Transaction;
    private int ExpenseTypeID;
    private int CategoryID;
    private String CategoryName;
    private String Amount;
    private String Description;
    private String Date;
    private int PaymentTypeID;

    public int getTransaction() {
        return Transaction;
    }

    public void setTransaction(int transaction) {
        Transaction = transaction;
    }

    public int getExpenseTypeID() {
        return ExpenseTypeID;
    }

    public void setExpenseTypeID(int expenseTypeID) {
        ExpenseTypeID = expenseTypeID;
    }

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

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getPaymentTypeID() {
        return PaymentTypeID;
    }

    public void setPaymentTypeID(int paymentTypeID) {
        PaymentTypeID = paymentTypeID;
    }
}
