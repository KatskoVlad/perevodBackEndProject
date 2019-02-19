package com.bank.perevod.dao.impl;

import com.bank.perevod.dao.BankPerevodDao;

public class SQLBankPerevod implements BankPerevodDao {
    private static final String SELECT_ALL_PEREVOD = "SELECT * FROM bank_perevod";
    private static final String ADD_PEREVOD = "INSERT INTO bank_perevod (NAME,NAZVANIE,STATUS) VALUES(?,?,'EXIST')";
    private static final String SELECT_PEREVOD_ID = "SELECT * FROM bank_perevod WHERE ID=? AND STATUS='EXIST' ";
    private static final String DELETE_PEREVOD = "DELETE FROM bank_perevod WHERE id_perevod=?";
    private static final String UPDATE_PEREVOD = "UPDATE bank_perevod SET STATUS='DELETE' WHERE NAME=? AND NAZVANIE=?";
    private static final int FIRST= 1;

}
