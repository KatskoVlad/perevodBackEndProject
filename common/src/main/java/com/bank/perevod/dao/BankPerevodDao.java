package com.bank.perevod.dao;

import com.bank.perevod.domain.to.Perevod;
import com.bank.perevod.exception.DaoException;

import java.util.List;

public interface BankPerevodDao extends  GenericDAO<Perevod, Integer> {

    @Override
    default List<Perevod> findAll() throws DaoException {
        return null;
    }

    @Override
    default Perevod findById(Integer id) throws DaoException {
        return null;
    }

    @Override
    default boolean delete(Integer id) throws DaoException {
        return false;
    }

    @Override
    default int create(Perevod entity) throws DaoException {
        return 0;
    }

    @Override
    default Integer update(Perevod entity) throws DaoException {
        return null;
    }
}
