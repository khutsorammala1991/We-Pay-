package com.artitech.tsalano.tukisha.model;

import android.text.TextUtils;

/**
 * Created by solly on 2017/05/23.
 */

public class AirtimeVoucher {

    private String agentID;
    private String voucher;
    private String operator;
    private String date;
    private String amount;
    private String instructions;
    private String balance = "0";
    private String totalCashBack = "0";
    private ErrorMessages errorMessages;


    public AirtimeVoucher(String agentID,String voucher, String operator, String date, String amount, String instructions, String balance, String totalCashBack) {

        this.agentID = agentID;
        this.voucher = voucher;
        this.operator = operator;
        this.date = date;
        this.amount = amount;
        this.instructions = instructions;
        this.balance = balance;
        this.totalCashBack = totalCashBack;

    }

    public String getBalance() {
        return balance;
    }

    public String getTotalCashBack() {
        return totalCashBack;
    }

    public String getVoucher() {
        return TextUtils.isEmpty(voucher) ? "" : voucher;
    }

    public String getOperator() {
        return operator;
    }

    public String getDate() {
        return date;
    }

    public String getAmount() {
        return amount;
    }

    public String getInstructions() {
        return instructions;
    }

    public ErrorMessages getErrorMessages() { return errorMessages;}

    @Override
    public String toString() {
        return "agentID=" + agentID;
    }
}
