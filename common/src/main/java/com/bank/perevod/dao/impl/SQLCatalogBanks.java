package com.bank.perevod.dao.impl;

public class SQLCatalogBanks {

    private static final String SELECT_ALL_BANKS = "SELECT * FROM catalog_banks";
    private static final String SELECT_BY_ID_BANKS = "SELECT * FROM catalog_banks WHERE id_bank = ?";
    private static final String SELECT_BANK = "SELECT code_bic FROM catalog_banks WHERE code_bic = ?";
    private static final String DELETE_BANK = "DELETE FROM catalog_banks WHERE id_bank = ?";
    private static final String ADD_BANK = "INSERT INTO catalog_banks (id_bank, code_bic, description, " +
            "inn, name, adress, pnode) VALUES (?, ?, ?, ?, ?, ?, ?)";

//    public static CatalogBanksDao getInstance() {
//        return SingletonHolder.instance;
//    }
//
//    private static class SingletonHolder {
//        private static final CatalogBanksDao instance = new SQLCatalogBanks();
//    }
}
