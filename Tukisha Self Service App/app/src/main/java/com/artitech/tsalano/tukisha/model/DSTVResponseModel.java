package com.artitech.tsalano.tukisha.model;

/**
 * Created by solly on 2018/04/05.
 */

public class DSTVResponseModel {


    private String status;

    private String balance;

    private String transactionNumber;

    private String receiptNumber;

    private String totalCashBack;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getTotalCashBack() { return totalCashBack;}

    public void setTotalCashBack(String totalCashBack) {
        this.totalCashBack = totalCashBack;
    }

}