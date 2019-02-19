package com.bank.perevod.dao.factory;

import com.bank.perevod.service.impl.PerevodService;
import com.bank.perevod.service.impl.PerevodServiceImpl;
import com.bank.perevod.service.impl.UserService;
import com.bank.perevod.service.impl.UserServiceImpl;

public class ServiceFactory {
    private final static ServiceFactory instance = new ServiceFactory();

    private final UserService userService =  new UserServiceImpl();
    private final PerevodService perevodService =   new PerevodServiceImpl();

    public static ServiceFactory getInstance(){
        return instance;
    }
    public UserService getUserService(){
        return userService;
    }
    public PerevodService getBookService(){
        return perevodService;
    }
}
