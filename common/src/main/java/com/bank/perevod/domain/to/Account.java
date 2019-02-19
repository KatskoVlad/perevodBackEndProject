package com.bank.perevod.domain.to;

import java.util.Date;

public class Account {
    private Long idAccount;
    private String account;
    private double balans;
    private Date dateReg;
    private Long idClient;

    public Account() {
    }

    public Account(Long idAccount, String account, double balans, Date dateReg, Long idClient) {
        this.idAccount = idAccount;
        this.account = account;
        this.balans = balans;
        this.dateReg = dateReg;
        this.idClient = idClient;
    }
    public Long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public double getBalans() {
        return balans;
    }

    public void setBalans(double balans) {
        this.balans = balans;
    }

    public Date getDateReg() {
        return dateReg;
    }

    public void setDateReg(Date dateReg) {
        this.dateReg = dateReg;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }


}
