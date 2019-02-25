package com.bank.perevod.service.impl;

import com.bank.perevod.dao.UserDao;
import com.bank.perevod.dao.factory.DaoFactory;
import com.bank.perevod.domain.to.User;
import com.bank.perevod.exception.DaoException;
import com.bank.perevod.exception.NoSuchEntityException;
import com.bank.perevod.exception.ServiceException;
import com.bank.perevod.service.validator.LoginValidator;
import com.bank.perevod.service.validator.ValidatorInterface;

import java.util.List;

public class UserServiceImpl implements UserService {

    private static final String MESSAGE_WRONG_LOGIN = "Не корректный логин!";
    private static final String MESSAGE_WRONG_PASSWORD= "Не верно введен пароль!";
    private static final String MESSAGE_WRONG_USER= "Клиент не существует!";

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
    public User loadById(Integer userId) throws SecurityException, NoSuchEntityException {
        return null;
    }

    @Override
    public void registration(User user) throws DaoException, ServiceException {
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
            userDao.checkUser(user.getLogin(), user.getPassword());
            i = userDao.create(user);
        } catch (DaoException e) {
            throw e;
        }
    }

    @Override
    public User authorization(String login, String password) throws NoSuchEntityException, ServiceException {
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
                    throw new ServiceException(MESSAGE_WRONG_USER);
                } else {
                    return userDao.getUserNode(login, password);
                }
        } catch (DaoException e) {
            throw new ServiceException("Не верно введен, пользователь или пароль", e);
        }
    }

    @Override
    public User create(User obj) throws SecurityException {
        throw new UnsatisfiedLinkError();
    }

    @Override
    public List<User> loadAll() throws ServiceException {
        throw new UnsatisfiedLinkError();
    }
}
