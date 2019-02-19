package com.bank.perevod.controller.command.impl.user_command;

import com.bank.perevod.controller.command.CommandInterface;
import com.bank.perevod.dao.UserDao;
import com.bank.perevod.dao.factory.ServiceFactory;
import com.bank.perevod.domain.to.User;
import com.bank.perevod.exception.ServiceException;
import com.bank.perevod.service.impl.UserService;
import com.bank.perevod.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Authorization implements CommandInterface {
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String USER = "user";
    private static final UserService USER_SERVICE = UserServiceImpl.getInstance();
    private static final String ERROR_MESSAGE = "errorMessage";
    private static final String MESSAGE_WRONG_INFO = "wrong login or password";
    private static final String MESSAGE_ABOUT_PROBLEM = "Sorry,technical problem";
    private static final String MAIN_JSP = "WEB-INF/jsp/card_perevod/perevod_main.jsp";
    private static final String INDEX_JSP = "index.jsp";
    private static final String ROLE = "role_id";
    private static final String NAME_USERS = "name";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);


        ServiceFactory factory = ServiceFactory.getInstance();
        UserService userService = factory.getUserService();

        User user = null;
        String page = null;
        try {
            user = userService.authorization(login, password);
            if (user != null) {
                int role_id = user.getIdUser();
                String name = user.getName();
                HttpSession session = request.getSession(true);

                session.setAttribute(NAME_USERS, name);
                session.setAttribute(ROLE, role_id);
                session.setAttribute(LOGIN, login);
                request.setAttribute(USER, user);
                page = MAIN_JSP;
            } else {
                request.setAttribute(ERROR_MESSAGE, MESSAGE_WRONG_INFO);
                page = INDEX_JSP;

            }
        } catch (ServiceException e) {
            request.setAttribute(ERROR_MESSAGE, MESSAGE_ABOUT_PROBLEM);
            page = INDEX_JSP;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(page);

        dispatcher.forward(request, response);
    }
    public static CommandInterface getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final CommandInterface INSTANCE = new Authorization();
    }

}
