package com.artitech.tsalano.tukisha.model;

/**
 * Created by solly on 2018/03/11.
 */

public class TopUpModel {


    private String topUpAmount;



    public TopUpModel(String topUpAmount)
    {
        this.topUpAmount =topUpAmount ;


    }

    public String getTopUpAmount() {
        return topUpAmount;
    }


    public String displayCustomerInfo()
    {
        return String.format(topUpAmount);
    }

}