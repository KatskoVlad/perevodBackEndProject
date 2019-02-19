package com.bank.perevod.controller.command.impl;

import com.bank.perevod.controller.command.CommandException;
import com.bank.perevod.controller.command.CommandInterface;
import com.bank.perevod.domain.to.User;
import com.bank.perevod.exception.ValidationException;
import com.bank.perevod.service.impl.UserService;
import com.bank.perevod.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * Class is designed for the registration of a new user
 */
public class RegistrationCommand implements CommandInterface {
    private static final UserService SERVICE = UserServiceImpl.getInstance();
    //private static final PagesConfigManager MANAGER = PagesConfigManager.getInstance();

    private static final String USER_ROLE = "user";

    private static final String ACCOUNT_ID = "id_account";
    private static final String NAME_ATTRIBUTE = "name";
    private static final String SURNAME_ATTRIBUTE = "surname";
    private static final String SECONDNAME_ATTRIBUTE = "second_name";
    private static final String EMAIL = "email";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String ACTION = "action";
    private static final String REDIRECT_ACTION_ATTRIBUTE = "redirect";
    private static final String FORWARD_ACTION_ATTRIBUTE = "forward";

    private static final String ERROR_FLAG = "errorFlag";
    private static final int ERROR_FLAG_VALUE = 1;
    private static final int ERROR_FLAG_VALUE_2 = 2;

    public RegistrationCommand() {
    }

    public static CommandInterface getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final CommandInterface INSTANCE = new RegistrationCommand();
    }

    /*
     * Method performs the procedure for adding a new customer to the system.
     * Getting all information about new user and then create new node in system.
     * Also determines what action must be made for transition(forward or sendRedirect).
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return the path to go to a specific page
     * @throws CommandException when creating fail
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {

        try {
            String idAccount = request.getParameter(ACCOUNT_ID);
            String name = request.getParameter(NAME_ATTRIBUTE);
            String surname = request.getParameter(SURNAME_ATTRIBUTE);
            String secondName = request.getParameter(SECONDNAME_ATTRIBUTE);
            String email = request.getParameter(EMAIL);

            String login = request.getParameter(LOGIN);
            String password = request.getParameter(PASSWORD);

            User user = new User();
            user.setName(name);
            user.setSurname(surname);
            user.setEmail(email);
            user.setLogin(login);
            user.setPassword(password);

            User resultUser = SERVICE.create(user);
            if (resultUser == null) {
                request.setAttribute(ERROR_FLAG, ERROR_FLAG_VALUE_2);
                request.setAttribute(ACTION, REDIRECT_ACTION_ATTRIBUTE);
            } else {
                HttpSession session = request.getSession(true);
                session.setAttribute(USER_ROLE, resultUser);
                request.setAttribute(ACTION, REDIRECT_ACTION_ATTRIBUTE);
            }
        } catch (ValidationException e) {
            request.setAttribute(ERROR_FLAG, ERROR_FLAG_VALUE);
            request.setAttribute(ACTION, FORWARD_ACTION_ATTRIBUTE);
        } catch (Exception e) {
            throw new CommandException("Command Exception", e);
        }
    }
}
