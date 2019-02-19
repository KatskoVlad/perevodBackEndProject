package com.bank.perevod.dao.impl;

public class SQLAccountDao {
    private static final String SELECT_ALL_ACCOUNT = "SELECT * FROM accounts";
    private static final String ADD_ACCOUNT = "INSERT INTO accounts (NAME,NAZVANIE,STATUS) VALUES(?,?,'EXIST')";
    private static final String SELECT_ACCOUNT_ID = "SELECT * FROM accounts WHERE ID=? AND STATUS='EXIST' ";
    private static final String DELETE_ACCOUNT = "DELETE FROM accounts WHERE id_accounts=?";
    private static final String UPDATE_ACCOUNT = "UPDATE accounts SET STATUS='DELETE' WHERE NAME=? AND NAZVANIE=?";
    private static final int FIRST= 1;
}
