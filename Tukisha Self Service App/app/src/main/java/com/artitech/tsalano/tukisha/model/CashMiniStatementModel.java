package com.artitech.tsalano.tukisha.model;

/**
 * Created by solly on 2017/07/11.
 */

public class CashMiniStatementModel {

    private String totalEskomTransactions, totalEskomAmount, totalMunicipalityTransactions, totalMunicipalityAmount, totalTelcoTransactions,
            totalTelcoAmount, totalTransactions, totalAmount,totalDSTVTransactions,totalDSTVAmount;

    private StatusResponse statusResponse;

    public CashMiniStatementModel(String totalEskomTransactions,String totalDSTVTransactions, String totalEskomAmount,String totalDSTVAmount, String totalMunicipalityTransactions,
                                  String totalMunicipalityAmount, String totalTelcoTransactions, String totalTelcoAmount,
                                  String totalTransactions, String totalAmount, StatusResponse statusResponse) {

        this.totalEskomTransactions = totalEskomTransactions;
        this.totalEskomAmount = totalEskomAmount;
        this.totalMunicipalityTransactions = totalMunicipalityTransactions;
        this.totalMunicipalityAmount = totalMunicipalityAmount;
        this.totalTelcoTransactions = totalTelcoTransactions;
        this.totalTelcoAmount = totalTelcoAmount;
        this.totalTransactions = totalTransactions;
        this.totalAmount = totalAmount;
        this.totalDSTVTransactions=totalDSTVTransactions;
        this.totalDSTVAmount=totalDSTVAmount;
        this.statusResponse = statusResponse;

    }



    public String getTotalDSTVTransactions() {
        return totalDSTVTransactions;
    }
    public String getTotalDSTVAmount() {
        return totalDSTVAmount;
    }

    public String getTotalEskomAmount() {
        return totalEskomAmount;
    }
    public String getTotalEskomTransactions() {
        return totalEskomTransactions;
    }

    public String getTotalMunicipalityTransactions() {
        return totalMunicipalityTransactions;
    }
    public String getTotalMunicipalityAmount() {
        return totalMunicipalityAmount;
    }

    public String getTotalTelcoTransactions() {
        return totalTelcoTransactions;
    }
    public String getTotalTelcoAmount() {
        return totalTelcoAmount;
    }

    public String getTotalTransactions() {
        return totalTransactions;
    }
    public String getTotalAmount() {
        return totalAmount;
    }

    public String getStatusResponse() {
        return statusResponse.toString();
    }

}

