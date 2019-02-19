package com.bank.perevod.controller.command;

import com.bank.perevod.controller.CommandName;
import com.bank.perevod.controller.command.impl.user_command.Authorization;
import com.bank.perevod.controller.command.impl.user_command.Registration;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandHelper {
    private static final String ATTRIBUTE_COMMAND = "action";
    private static final String DASH = "-";
    private static final String UNDERSCORE = "_";



    private final Map<CommandName, CommandInterface> commands = new HashMap<>();

    public CommandHelper() {
        commands.put(CommandName.REGISTRATION, Registration.getInstance());
        commands.put(CommandName.TEST_COMMAND, TestCommand.getInstance());
        commands.put(CommandName.AUTHORIZATION, Authorization.getInstance());
    }
    /**
     * Method determines by request of which command is needed and returns the command object
     *
     * @param request HttpServletRequest
     * @return command object if command exists in map, else return null
     */
    public CommandInterface getCommand(HttpServletRequest request) {
        String commandName = request.getParameter(ATTRIBUTE_COMMAND);
        if(commandName != null) {
            CommandName name = CommandName.valueOf(commandName.toUpperCase().replace(DASH, UNDERSCORE));
            return commands.get(name);
        } else {
            return null;
        }
    }
    public void setCommandNeme() {
        commands.put(CommandName.REGISTRATION, Registration.getInstance());
    }
}
