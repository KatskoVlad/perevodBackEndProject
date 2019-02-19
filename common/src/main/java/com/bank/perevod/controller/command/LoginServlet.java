package com.bank.perevod.controller.command;

import com.bank.perevod.dao.UserDao;
import com.bank.perevod.dao.factory.DaoFactory;
import com.bank.perevod.domain.to.User;
import com.bank.perevod.service.validator.LoginValidator;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {

    private static final org.apache.log4j.Logger LOGGER_ROOT = Logger.getRootLogger();
    private static final DaoFactory factory = DaoFactory.getDaoFactory();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try
        {
            User user = new User();
            LoginValidator loginValidator = new LoginValidator();
            UserDao userDao = factory.getUserDao();
            user = userDao.getUserNode(request.getParameter("login"), request.getParameter("password"));

            if (loginValidator.isValid(user))
            {

                HttpSession session = request.getSession(true);
                session.setAttribute("currentSessionUser",user);
                response.sendRedirect("userLogged.jsp"); //logged-in page
            }

            else
                response.sendRedirect("invalidLogin.jsp"); //error page
        }


        catch (Throwable theException)
        {
            LOGGER_ROOT.error("Error LoginServlet, Throwable", theException);
        }
    }
}
