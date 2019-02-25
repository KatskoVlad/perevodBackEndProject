package com.bank.perevod.controller.command.impl.user_command;

import com.bank.perevod.controller.command.CommandInterface;
import com.bank.perevod.dao.factory.ServiceFactory;
import com.bank.perevod.dao.impl.SQLRoleDao;
import com.bank.perevod.domain.enums.Sex;
import com.bank.perevod.domain.to.Role;
import com.bank.perevod.domain.to.User;
import com.bank.perevod.exception.DaoException;
import com.bank.perevod.exception.ServiceException;
import com.bank.perevod.service.impl.UserService;
import com.bank.perevod.service.validator.LoginValidator;
import com.bank.perevod.service.validator.ValidatorInterface;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Registration implements CommandInterface {
    private static final String USER = "user";
    private static final String ERROR_MESSAGE = "errorMessage";
    private static final String MESSAGE_LOGIN_EXISTS = "The user with such login already exists";
    private static final String MESSAGE_ABOUT_PROBLEM = "Sorry,technical problem";
    private static final String ERROR_PASSWORD = "Password not valid!";
    private static final String MAIN_JSP = "WEB-INF/jsp/card_perevod/perevod_main.jsp";
    private static final String INDEX_JSP = "index.jsp";
    private static final String REGISTRATION_JSP = "registration.jsp";
    private static final String ERROR_LOGIN_JSP = "invalidLogin.jsp";


    private static final String ID_USER = "id_user";
    private static final String LOGIN = "login";
    private static final String PASSWORD1= "password1";
    private static final String PASSWORD2 = "password2";
    private static final String NAME_USER = "name";
    private static final String DATE_REG = "date_registr";
    private static final String IS_BLOCKING = "is_blocked";
    private static final String ID_ROLE = "id_role";
    private static final String ROLE = "role";
    private static final String SEX = "sex";
    private static final String SURNAME = "surname";
    private static final String EMAIL = "email";
    private static final ValidatorInterface<User> VALIDATE = LoginValidator.getInstance();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DaoException, ServiceException {
        String login = request.getParameter(LOGIN);
        String password1 = request.getParameter(PASSWORD1);
        String password2 = request.getParameter(PASSWORD1);
        String name = request.getParameter(NAME_USER);
        String date_registr = request.getParameter(DATE_REG);
        String role = request.getParameter(ROLE);
        String sex = request.getParameter(String.valueOf(Sex.FEMALE));
        if (sex == null) {
            sex = request.getParameter(String.valueOf(Sex.FEMALE));
        }
        String surname = request.getParameter(SURNAME);
        String email = request.getParameter(EMAIL);

        SQLRoleDao sqlRoleDao = new SQLRoleDao();
        Role role1 = new Role(role);
        int id_role = sqlRoleDao.getUserRole(role1);

        ServiceFactory factory = ServiceFactory.getInstance();
        UserService userService = factory.getUserService();
        String page = INDEX_JSP;
        try {
            VALIDATE.isValidPassword(password1, password2);
            User user = new User(login, password1, date_registr, false, sex, id_role, surname, name, email);
            VALIDATE.isValid(user);
            userService.registration(user);
            Integer role_id = user.getIdRole();
            HttpSession session = request.getSession(true);

            session.setAttribute(LOGIN, login);
            request.setAttribute(PASSWORD1, password1);
            session.setAttribute(NAME_USER, name);
            session.setAttribute(ROLE, role);
            request.setAttribute(SEX, sex);
            request.setAttribute(SURNAME, surname);
            request.setAttribute(EMAIL, email);
            request.setAttribute(USER, user);
        } catch (ServiceException e) {
            request.setAttribute(ERROR_MESSAGE, e.getMessage());
            page = REGISTRATION_JSP;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }
    public static CommandInterface getInstance() {
        return Registration.SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final CommandInterface INSTANCE = new Registration();
    }
}


