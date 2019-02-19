package com.bank.perevod.controller.command.impl.user_command;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bank.perevod.controller.command.CommandInterface;

public class EditProfileNameForm implements CommandInterface {
	private static final String EDIT_NAME_JSP ="WEB-INF/jsp/editProfileNameForm.jsp";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(EDIT_NAME_JSP);
		
		dispatcher.forward(request, response);
	}
}
