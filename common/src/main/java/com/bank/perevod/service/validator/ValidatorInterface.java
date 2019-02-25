package com.bank.perevod.service.validator;

import com.bank.perevod.exception.ServiceException;

/*
 * Provides interface to validate input parameters
 * @param <T>
 */
public interface ValidatorInterface<T> {
    /*
     * Validates the values in the fields of the object entity.
     * @param entity object type T which is need to validate.
     * @return true if parameters are valid, else return false.
     */
    boolean isValid(T entity) throws ServiceException;

    void isValidPassword(String password1, String password2) throws ServiceException;
}
