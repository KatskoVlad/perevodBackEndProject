package com.bank.perevod.controller;

import com.bank.perevod.controller.command.CommandHelper;
import com.bank.perevod.controller.command.CommandInterface;
import com.bank.perevod.exception.DaoException;
import com.bank.perevod.exception.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * Performs processing requests from browser and the responses to browser
 */
public class FrontController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = Logger.getRootLogger();
    private static final String ERROR_PAGE = "/error";
    private static final String ACTION = "command";
    private static final String REDIRECT_ATTRIBUTE = "redirect";
    private static final String ERROR_MESSAGE = "errorMessage";
    private static final String ERROR_JSP = "WEB-INF/jsp/error.jsp";
    private static final String INDEX_JSP = "index.jsp";


    public FrontController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doRequest(request, response);
    }

    /*
     * It determines which team will be carried out and what actions will be implemented
     * during the transition between pages in accordance with the request (forward or sendRedirect)
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException
     * @throws IOException
     */
    private void doRequest(HttpServletRequest request,
                           HttpServletResponse response) throws ServletException, IOException {
        String commandName=request.getParameter(ACTION);

        CommandHelper helper = new CommandHelper();
        String page = INDEX_JSP;
        CommandInterface command = helper.getCommand(request);
        try {
            command.execute(request, response);
        } catch (DaoException | ServiceException e) {
            request.setAttribute(ERROR_MESSAGE, e.getMessage());
            page=ERROR_JSP;
            RequestDispatcher dispatcher=request.getRequestDispatcher(page);
            dispatcher.forward(request, response);
        }

//        String page;
//
//        CommandInterface action = helper.getCommand(request);
//
//        if(action != null) {
//            try {
//                page = action.execute(request, response);
//
//                if((request.getAttribute(ACTION)).equals(REDIRECT_ATTRIBUTE)) {
//                    response.sendRedirect(getServletContext().getContextPath() + page);
//                }
//                else {
//                    RequestDispatcher dispatcher = request.getRequestDispatcher(page);
//                    if (dispatcher != null) {
//                        dispatcher.forward(request, response);
//                    }
//                }
//            } catch (CommandException e) {
//                LOGGER.error("CommandException", e);
//                response.sendRedirect(request.getContextPath() + ERROR_PAGE);
//            }
//        }
    }
}
