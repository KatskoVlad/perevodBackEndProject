package com.bank.perevod.service.impl;

import com.bank.perevod.domain.to.User;
import com.bank.perevod.exception.DaoException;
import com.bank.perevod.exception.NoSuchEntityException;
import com.bank.perevod.exception.ServiceException;
import com.bank.perevod.service.GenericServiceInterface;

import java.util.List;

public interface UserService extends GenericServiceInterface<User, List<User>> {
    User loadById(Integer userId) throws ServiceException, NoSuchEntityException;

    /**
     * Method provides operation for login user
     *
     * @param user object, that provides authorization operation
     * @return {@link User} - login record
     * @throws ServiceException
     */
    User authorization(String login, String password) throws ServiceException;

    void registration(User user) throws ServiceException, DaoException;
}

