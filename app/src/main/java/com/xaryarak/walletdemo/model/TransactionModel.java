package com.xaryarak.walletdemo.model;

public class TransactionModel {
    String vno,price,date;

    public TransactionModel() {
    }

    public TransactionModel(String vno, String price, String date) {
        this.vno = vno;
        this.price = price;
        this.date = date;
    }

    public String getVno() {
        return vno;
    }

    public void setVno(String vno) {
        this.vno = vno;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
