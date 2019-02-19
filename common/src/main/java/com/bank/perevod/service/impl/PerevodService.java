package com.bank.perevod.service.impl;

import com.bank.perevod.domain.to.Perevod;
import com.bank.perevod.exception.ServiceException;

import java.util.ArrayList;

public interface PerevodService {
    ArrayList<Perevod> showAllPerevods () throws ServiceException;
    Perevod viewPerevod(Integer id_perevoda)throws ServiceException;
}
