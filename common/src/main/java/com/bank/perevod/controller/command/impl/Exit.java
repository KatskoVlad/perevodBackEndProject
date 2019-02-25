package com.bank.perevod.controller.command.impl;

import com.bank.perevod.controller.command.CommandInterface;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Exit implements CommandInterface {
    private static final String INDEX_JSP ="index.jsp";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session=request.getSession(true);
        session.invalidate();

        RequestDispatcher dispatcher=request.getRequestDispatcher(INDEX_JSP);
        dispatcher.forward(request, response);
    }
}
