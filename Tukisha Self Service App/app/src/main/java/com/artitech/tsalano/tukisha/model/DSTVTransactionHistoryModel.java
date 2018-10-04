package com.artitech.tsalano.tukisha.model;

/**
 * Created by solly on 2018/03/11.
 */

public class DSTVTransactionHistoryModel {

    private String paymentDate;

    private String dstvAccountNumber;

    private String receiptNumber;

    private String firstName;

    private String lastName;

    private String amountDue;

    private String amountPaid;


    public DSTVTransactionHistoryModel(String paymentDate, String dstvAccountNumber,String receiptNumber,String firstName,String lastName, String amountDue, String amountPaid)
    {
        this.paymentDate = paymentDate;
        this.dstvAccountNumber = dstvAccountNumber;
        this.receiptNumber = receiptNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.amountDue = amountDue;
        this.amountPaid = amountPaid;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public String getDstvAccountNumber() {
        return dstvAccountNumber;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAmountDue() {
        return amountDue;
    }


    public String getAmountPaid() {
        return amountPaid;
    }

}
