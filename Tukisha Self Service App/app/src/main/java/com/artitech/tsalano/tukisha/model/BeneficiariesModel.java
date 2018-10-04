package com.artitech.tsalano.tukisha.model;

import android.view.View.OnClickListener;

public class BeneficiariesModel {
    private String categories;
    private String cell;
    private String meterNumber;
    private String name;
    private OnClickListener onClickListener;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCell() {
        return this.cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getCategories() {
        return this.categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getMeterNumber() {
        return this.meterNumber;
    }

    public void setMeterNumber(String meterNumber) {
        this.meterNumber = meterNumber;
    }
}
