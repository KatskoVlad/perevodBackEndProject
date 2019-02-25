package com.bank.perevod.controller.command.impl;

import com.bank.perevod.controller.command.CommandInterface;
import com.bank.perevod.domain.to.User;
import com.bank.perevod.exception.ServiceException;
import com.bank.perevod.service.PagePath;
import com.bank.perevod.service.impl.UserService;
import com.bank.perevod.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * Class is designed for the log in in system as administrator or client
 */
public class LoginCommand implements CommandInterface {

    private static final UserService SERVICE = UserServiceImpl.getInstance();
    //private static final PagesConfigManager MANAGER = PagesConfigManager.getInstance();
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String USER_ROLE = "user";
    private static final String ERROR_FLAG = "errorFlag";
    private static final int ERROR_FLAG_VALUE = 1;
    private static final String ACTION = "action";
    private static final String REDIRECT_ACTION_ATTRIBUTE = "redirect";
    private static final String FORWARD_ACTION_ATTRIBUTE = "forward";

    private LoginCommand() {
    }

    public static CommandInterface getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final CommandInterface INSTANCE = new LoginCommand();
    }

    /*
     * Method performs the procedure for authorization in system
     * In first, getting login and password parameters from request
     * Then finding node with equals parameters. If procedure return not null, then necessary define client or admin
     * log in. According to role of user creating admin or client object and put into session.
     *
     * Also determines what action must be made for transition(forward or sendRedirect)
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return the path to go to a specific page
     * @throws CommandException if authorization method process fail
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {

        PagePath page;
        try {
            User tempUser = new User();
            String login = request.getParameter(LOGIN);
            String password = request.getParameter(PASSWORD);
            tempUser.setLogin(login);
            tempUser.setPassword(password);

            HttpSession session = request.getSession(true);
            User user = SERVICE.authorization(tempUser.getLogin(), tempUser.getPassword());

            if (user == null) {
                request.setAttribute(ERROR_FLAG, ERROR_FLAG_VALUE); // Одна из возможных реализаций message в зависимости от запроса
                request.setAttribute(ACTION, FORWARD_ACTION_ATTRIBUTE);
                page = PagePath.INDEX;
            } else {

                user.setLogin(user.getLogin());
                user.setPassword(user.getPassword());
                user.setIdUser(user.getIdUser());

                session.setAttribute(USER_ROLE, user);
                page = PagePath.RESULT;

                request.setAttribute(ACTION, REDIRECT_ACTION_ATTRIBUTE);
            }
        } catch (ServiceException e) {
            request.setAttribute(ERROR_FLAG, ERROR_FLAG_VALUE);
            request.setAttribute(ACTION, FORWARD_ACTION_ATTRIBUTE);
            page = PagePath.INDEX;
        }
//        return null;
//        return MANAGER.getProperty(page.toString());
    }
}
