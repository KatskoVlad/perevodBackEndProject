package com.bank.perevod.dao.factory;

import com.bank.perevod.dao.AccountDao;
import com.bank.perevod.dao.BankPerevodDao;
import com.bank.perevod.dao.CatalogBanksDao;
import com.bank.perevod.dao.RoleDao;
import com.bank.perevod.dao.UserDao;
import com.bank.perevod.dao.impl.SQLAccountDao;
import com.bank.perevod.dao.impl.SQLBankPerevod;
import com.bank.perevod.dao.impl.SQLCatalogBanks;
import com.bank.perevod.dao.impl.SQLRoleDao;
import com.bank.perevod.dao.impl.SQLUserDao;

public class SQLDaoFactory extends DaoFactory {

    private static final SQLDaoFactory instance = new SQLDaoFactory();

    private SQLDaoFactory() {
    }

    public static SQLDaoFactory getInstance() {
        return instance;
    }

    @Override
    public UserDao getUserDao() {
        return SQLUserDao.getInstance();
    }

    @Override
    public AccountDao getAccountDao() {
        //return SQLAccountDao.getInstance();
        return null;
    }

    @Override
    public BankPerevodDao getBankPervod() {
        //return SQLBankPerevod.getInstance();
        return null;
    }

    @Override
    public CatalogBanksDao getCatalogBanks() {
        //return SQLCatalogBanks.getInstance();
        return null;
    }

    @Override
    public RoleDao getRoleDao() {
        return SQLRoleDao.getInstance();
    }
}