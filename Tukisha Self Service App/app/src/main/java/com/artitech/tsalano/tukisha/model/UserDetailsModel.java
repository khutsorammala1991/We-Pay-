package com.artitech.tsalano.tukisha.model;

/**
 * Created by solly on 2017/05/23.
 */

public class UserDetailsModel {

    private String firstname,surname,idNumber,cell,email,customerID;


    public UserDetailsModel(String firstname, String surname, String idNumber, String email, String cell,String customerID) {

        this.firstname = firstname;
        this.surname = surname;
        this.idNumber = idNumber;
        this.cell = cell;
        this.email = email;
        this.customerID = customerID;



    }

    public String getfirstname() {return firstname;}
    public String getCustomerID() {return customerID;}



    public String getSurnamer() {
        return surname;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getCell() {
        return cell;
    }

    public String getemail() {
        return email;
    }




}
