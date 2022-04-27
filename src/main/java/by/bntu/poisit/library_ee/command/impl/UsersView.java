package by.bntu.poisit.library_ee.command.impl;

import by.bntu.poisit.library_ee.command.AbstractCommand;
import by.bntu.poisit.library_ee.controller.JspPageParamName;
import by.bntu.poisit.library_ee.service.ServiceException;
import by.bntu.poisit.library_ee.service.UserService;
import by.bntu.poisit.library_ee.manager.JspPagesManager;

import javax.servlet.http.HttpServletRequest;


public class UsersView extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        UserService cl=UserService.getInstance();
        try {
            request.setAttribute("items", cl.getAll());
        }catch (ServiceException e){
            logger.error(e.getMessage());
        }
        return JspPagesManager.getProperty(JspPageParamName.USERS_VIEV_PAGE);
    }
}
