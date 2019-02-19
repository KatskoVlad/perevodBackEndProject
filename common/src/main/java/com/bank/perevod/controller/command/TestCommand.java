package com.bank.perevod.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class TestCommand implements CommandInterface {
    private static final String ACTION = "action";
    private static final String FORWARD_ACTION_ATTRIBUTE = "forward";
    private static final String CLIENT_ACTION = "client";


    private TestCommand() {
    }

    public static CommandInterface getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * Method performs the procedure for adding hotel room information on page and further viewing and updating
     * Also determines what action must be made for transition(forward or sendRedirect)
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @return the path to go to a specific page
     * @throws CommandException when getting all nodes fail
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        request.setAttribute("testList", Arrays.asList("Java", "C#", "GOLang"));
        request.setAttribute(ACTION, FORWARD_ACTION_ATTRIBUTE);

//        Client client = new Client();
//        client.setLogin("logins");
//        client.setId_client(1);
//        client.setSurname("SurName");
//
//        List list = new ArrayList();
//        list.add(client);
//
//        request.setAttribute("clients", Arrays.asList(client));

    }

    private static class SingletonHolder {
        private static final CommandInterface INSTANCE = new TestCommand();
    }
}
