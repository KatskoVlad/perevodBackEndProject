package com.bank.perevod.controller.command.impl.user_command;

import com.bank.perevod.controller.command.CommandInterface;
import com.bank.perevod.dao.factory.ServiceFactory;
import com.bank.perevod.domain.to.User;
import com.bank.perevod.exception.ServiceException;
import com.bank.perevod.service.impl.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EditProfileName implements CommandInterface {
    private static final String LOGIN = "login";
    private static final String USER = "user";
    private static final String ERROR_MESSAGE = "errorMessage";
    private static final String MESSAGE_LOGIN_EXISTS = "The user with such login already exists";
    private static final String MESSAGE_ABOUT_PROBLEM = "Sorry,technical problem";
    private static final String MAIN_JSP = "WEB-INF/jsp/main.jsp";
    private static final String EDIT_PROFILE_JSP = "WEB-INF/jsp/EditProfile.jsp";
    private static final String NAME_USER = "name";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter(NAME_USER);

        HttpSession session = request.getSession(true);//use true?
        String login = (String) session.getAttribute(LOGIN);

        ServiceFactory factory = ServiceFactory.getInstance();
        UserService userService = factory.getUserService();

        String page;
        User user = null;
        try {
            user = userService.authorization(name, login);
            if (user != null) {
                String Name = user.getName();
                session.removeAttribute(NAME_USER);
                session.setAttribute(NAME_USER, Name);

                request.setAttribute(USER, user);
                page = MAIN_JSP;
            } else {
                request.setAttribute(ERROR_MESSAGE, MESSAGE_LOGIN_EXISTS);
                page = EDIT_PROFILE_JSP;

            }
        } catch (ServiceException e) {
            request.setAttribute(ERROR_MESSAGE, MESSAGE_ABOUT_PROBLEM);
            page = MAIN_JSP;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(page);

        dispatcher.forward(request, response);
    }
}
