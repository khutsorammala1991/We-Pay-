package com.artitech.tsalano.tukisha.model;

import android.text.TextUtils;

/**
 * Created by solly on 2017/05/23.
 */

public class ElectricityVoucherModel {

    private String customerID;
    private String customerName;
    private String voucherNumber;
    private String dateProcessed;
    private String amount;
    private String productType;
    private String Provider;
    private String meterNumber;
    private String messageID;

    public ElectricityVoucherModel(String customerID, String customerName,String voucherNumber, String dateProcessed, String amount, String productType, String Provider, String messageID, String meterNumber) {

        this.customerID = customerID;
        this.customerName = customerName;
        this.voucherNumber = voucherNumber;
        this.dateProcessed = dateProcessed;
        this.productType = productType;
        this.Provider = Provider;
        this.amount = amount;
        this.meterNumber = meterNumber;
        this.messageID = messageID;

    }

    public String getCustomerID() { return customerID;}

    public String getCustomerName() { return customerName;}

    public String getVoucherNumber() {
        return voucherNumber;
    }

    public String getDateProcessed() {
        return dateProcessed;
    }

    public String getProductType() {
        return productType;
    }

    public String getProvider() {
        return Provider;
    }

    public String getAmount() {
        return amount;
    }

    public String getMeternumber() { return meterNumber; }

    public String getMessageID() { return messageID; }

    @Override
    public String toString() {
        return "messageID=" + messageID;
    }
}
