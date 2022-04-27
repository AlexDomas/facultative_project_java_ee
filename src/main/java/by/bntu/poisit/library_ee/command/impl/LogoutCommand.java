package by.bntu.poisit.library_ee.command.impl;

import by.bntu.poisit.library_ee.command.Command;
import by.bntu.poisit.library_ee.controller.SessionParamName;

import javax.servlet.http.HttpServletRequest;


public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().removeAttribute(SessionParamName.USER_DATA);
        return null;
    }
}
