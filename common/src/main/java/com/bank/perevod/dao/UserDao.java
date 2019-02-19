package com.bank.perevod.dao;

import com.bank.perevod.domain.to.User;
import com.bank.perevod.exception.DaoException;

/*
 * Interface for User table in database with concrete parameters.
 * Provides specific method with {@link User} objects
 */

public interface UserDao extends GenericDAO<User, Integer> {
    /*
     * Method get {@link User} object from database by login and password
     *
     * @param login login unique parameter
     * @param password password parameter
     * @return {@link User} object
     * @throws DaoException
     */
    User getUserNode(String login, String password) throws DaoException;

    /**
     * Method check user node in database by login and password transfers parameters
     *
     * @param login    login unique parameter
     * @param password password parameter
     * @return boolean result of operation
     * @throws DaoException
     */
    boolean checkUser(String login, String password) throws DaoException;

    User checkUserById(int id) throws DaoException;

    void currentUser (String login, String password) throws DaoException;

}