package com.bank.perevod.controller.command;

import com.bank.perevod.exception.DaoException;
import com.bank.perevod.exception.ValidationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
        * Interface provide method for dealing with HttpServletRequest and HttpServletResponse
        */
public interface CommandInterface {
  /*
   *
   * Method performs some logic to process the request and determines
   * which page will be a transition after completion method
   *
   * @param request HttpServletRequest
   * @param response HttpServletResponse
   * @return the path to go to a specific page
   * @throws CommandException
   */
    void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, IOException, ServletException, DaoException;
}