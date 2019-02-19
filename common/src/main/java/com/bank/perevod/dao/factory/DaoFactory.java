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

public abstract class DaoFactory {
    public static DaoFactory getDaoFactory() {
        return SQLDaoFactory.getInstance();
    }

    public abstract AccountDao getAccountDao();
    public abstract BankPerevodDao getBankPervod();
    public abstract CatalogBanksDao getCatalogBanks();
    public abstract RoleDao getRoleDao();
    public abstract UserDao getUserDao();

}
