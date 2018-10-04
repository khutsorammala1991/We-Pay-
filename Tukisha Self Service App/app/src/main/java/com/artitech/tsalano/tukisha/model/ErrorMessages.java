package com.artitech.tsalano.tukisha.model;

/**
 * Created by solly on 2018/04/11.
 */


public class ErrorMessages {


    private String code;

    private String dispHeader;

    private String custMsg;

    private String operatorMessage;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDispHeader() {
        return dispHeader;
    }

    public void setDispHeader(String dispHeader) {
        this.dispHeader = dispHeader;
    }

    public String getCustMsg() {
        return custMsg;
    }

    public void setCustMsg(String custMsg) {
        this.custMsg = custMsg;
    }

    public String getOperatorMessage() {
        return operatorMessage;
    }

    public void setOperatorMessage(String operatorMessage) {
        this.operatorMessage = operatorMessage;
    }

}
