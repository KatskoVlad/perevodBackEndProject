package com.bank.perevod;

import com.bank.perevod.dao.RoleDao;
import com.bank.perevod.dao.UserDao;
import com.bank.perevod.dao.connection_pool.ConnectionPool;
import com.bank.perevod.dao.connection_pool.ConnectionPoolException;
import com.bank.perevod.dao.factory.DaoFactory;
import com.bank.perevod.dao.impl.SQLRoleDao;
import com.bank.perevod.domain.to.Role;
import com.bank.perevod.domain.to.User;
import com.bank.perevod.exception.DaoException;
import com.bank.perevod.exception.ServiceException;
import com.bank.perevod.service.impl.UserServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    private static final DaoFactory factory = DaoFactory.getDaoFactory();

    public static void main(String[] args) throws ConnectionPoolException, DaoException {
        ConnectionPool.getInstance().init();
        UserDao userDao = factory.getUserDao();
        UserServiceImpl userService = new UserServiceImpl();

//        String date1 = "01.03.2016";
//        String date2 = "01.02.2016";
//
//        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
//
//        Date dateOne = null;
//        Date dateTwo = null;
//
//        try {
//            dateOne = format.parse(date1);
//            dateTwo = format.parse(date2);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        User user = new User(0, "admin","vlad", null, false, "M", 1,"Katsko","Vlad", "1572730@gmail.com");
//        try {
//            userDao.create(user);
//        } catch (DaoException e){
//            e.printStackTrace();
//        }

        RoleDao roleDao = factory.getRoleDao();
            try {
                roleDao.delete(60);
            } catch (DaoException e){
                e.printStackTrace();
            }

        }
//        User user = new User();
//        user.setLogin("admin");
//        user.setPassword("pass");
//        user.setBlocked(false);
//        user.setEmail("1234@gmail.com");
//        user.setMobilePhone("14123424");
//        user.setRole("ADMIN");
//        user.setSex(Sex.FEMALE);
//        user.setSurname("Ivanov");
//        user.setUserName("Ivan");
//        user.setIdUser(1L);
//        try {
//            userService.authorization(user);
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
//        try {
//            userDao.findById(user.getIdUser());
//            System.out.println(user.toString());
//        } catch (DaoException e) {
//            e.printStackTrace();
//        }
}
