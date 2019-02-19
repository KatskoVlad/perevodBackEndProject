package com.bank.perevod.service.impl;

import com.bank.perevod.dao.BankPerevodDao;
import com.bank.perevod.dao.factory.DaoFactory;
import com.bank.perevod.dao.impl.SQLBankPerevod;
import com.bank.perevod.domain.to.Perevod;
import com.bank.perevod.exception.DaoException;
import com.bank.perevod.exception.ServiceException;

import java.util.ArrayList;

public class PerevodServiceImpl implements PerevodService {

    private static final String MESSAGE_WRONG_ID= "This perevod is not available";

    @Override
    public ArrayList<Perevod> showAllPerevods() throws ServiceException {
        DaoFactory daoObjectFactory=DaoFactory.getDaoFactory();
                BankPerevodDao pervodDAO=daoObjectFactory.getBankPervod();
        ArrayList <Perevod> listPerevods =null;
        try {
            listPerevods.addAll(pervodDAO.findAll());
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return listPerevods;
    }

    @Override
    public Perevod viewPerevod(Integer id_perevoda) throws ServiceException {
        if (id_perevoda==null){
            throw new ServiceException(MESSAGE_WRONG_ID );
        }
        DaoFactory daoObjectFactory=DaoFactory.getDaoFactory();
        BankPerevodDao bankPerevodDao=daoObjectFactory.getBankPervod();
        try {
            return bankPerevodDao.findById(id_perevoda);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
