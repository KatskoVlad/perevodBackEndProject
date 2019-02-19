package com.bank.perevod.service.impl;

import com.bank.perevod.dao.UserDao;
import com.bank.perevod.dao.factory.DaoFactory;
import com.bank.perevod.domain.to.User;
import com.bank.perevod.exception.DaoException;
import com.bank.perevod.exception.NoSuchEntityException;
import com.bank.perevod.exception.ServiceException;
import com.bank.perevod.service.validator.LoginValidator;
import com.bank.perevod.service.validator.ValidatorInterface;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.List;

public class UserServiceImpl implements UserService {

    private static final String MESSAGE_WRONG_LOGIN = "Incorrect login!";
    private static final String MESSAGE_WRONG_PASSWORD= "Incorrect password!";
    private static final String MESSAGE_WRONG_NAME= "Incorrect name!";
    private static final String MESSAGE_WRONG_USER= "Incorrect user!";

    private static final DaoFactory factory = DaoFactory.getDaoFactory();
    private static final ValidatorInterface<User> VALIDATE = LoginValidator.getInstance();

    public UserServiceImpl() {
    }

    public static UserService getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final UserServiceImpl instance = new UserServiceImpl();
    }

    @Override
    public User loadById(Integer userId) throws ServiceException, NoSuchEntityException {
        return null;
    }

    @Override
    public User registration(User user) throws ServiceException, DaoException {
        if (user.getLogin() == null || user.getLogin().isEmpty()) {
            throw new ServiceException(MESSAGE_WRONG_LOGIN);
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new ServiceException(MESSAGE_WRONG_PASSWORD);
        }
        DaoFactory daoObjectFactory = DaoFactory.getDaoFactory();
        UserDao userDao = daoObjectFactory.getUserDao();
        int i = 0;
        try {
            i = userDao.create(user);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return userDao.checkUserById(i);
    }

    @Override
    public User authorization(String login, String password) throws ServiceException, NoSuchEntityException {
        try {
            if (login==null||login.isEmpty()){
                throw new ServiceException(MESSAGE_WRONG_LOGIN);
            }
            if (password==null||password.isEmpty()){
                throw new ServiceException(MESSAGE_WRONG_PASSWORD);
            }

            UserDao userDao = factory.getUserDao();

                boolean check = userDao.checkUser(login, password);
                if (!check) {
//                    throw new NoSuchEntityException("Error!!! No surch User");
                    throw new ServiceException(MESSAGE_WRONG_USER);

                } else {
                    return userDao.getUserNode(login, password);
                }
        } catch (DaoException e) {
            throw new ServiceException("Service Exception", e);
        }
    }

    @Override
    public User create(User obj) throws ServiceException {
        throw new UnsatisfiedLinkError();
    }

    @Override
    public List<User> loadAll() throws ServiceException {
        throw new UnsatisfiedLinkError();
    }
}
