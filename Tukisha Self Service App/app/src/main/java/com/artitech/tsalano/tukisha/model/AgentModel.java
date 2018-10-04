package com.artitech.tsalano.tukisha.model;

/**
 * Created by solly on 2017/06/01.
 */

public class AgentModel {

    private String agentBalance, status, name, surname, email, cellNumber, idNumber, customerID;

    public AgentModel(String balance, String status, String customerID) {

        this.agentBalance = balance;
        this.status = status;
        this.customerID = customerID;

    }

    public AgentModel(String surname, String name, String email, String cellNumber, String idNumber, String balance, String status) {

        this.surname = surname;
        this.name = name;
        this.email = email;
        this.cellNumber = cellNumber;
        this.idNumber = idNumber;
        this.agentBalance = balance;
        this.status = status;

    }

    public String getIDNumber() {
        return idNumber;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public String getAgentBalance() {return agentBalance;}

    public String getStatus() {
        return status;
    }

    public String getName() {return name;}

    public String getCustomerID() {return customerID;}

}
