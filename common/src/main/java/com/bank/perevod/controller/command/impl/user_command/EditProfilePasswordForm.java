package com.bank.perevod.controller.command.impl.user_command;

import com.bank.perevod.controller.command.CommandInterface;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditProfilePasswordForm implements CommandInterface {

	private static final String EDIT_PASSWORD_JSP ="WEB-INF/jsp/editProfilePasswordForm.jsp";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(EDIT_PASSWORD_JSP);
		
		dispatcher.forward(request, response);
	}

}
