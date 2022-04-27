package by.bntu.poisit.library_ee.command.impl;

import by.bntu.poisit.library_ee.command.AbstractCommand;
import by.bntu.poisit.library_ee.controller.CommandParameterName;
import by.bntu.poisit.library_ee.controller.JspPageParamName;
import by.bntu.poisit.library_ee.controller.MessageParamName;
import by.bntu.poisit.library_ee.service.CourseService;
import by.bntu.poisit.library_ee.service.ServiceException;
import by.bntu.poisit.library_ee.service.UserService;
import by.bntu.poisit.library_ee.manager.JspPagesManager;

import javax.servlet.http.HttpServletRequest;


public class UserDelete extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = JspPagesManager.getProperty(JspPageParamName.USERS_VIEV_PAGE);
        UserService ul = UserService.getInstance();
        try {
            if (ul.delete(new Integer(request.getParameter(CommandParameterName.PARAM_NAME_ID)))) {
                request.setAttribute("actionresult", MessageParamName.ACTION_USER_DELETED);
                page = JspPagesManager.getProperty(JspPageParamName.USER_ACTION_FINISHED_PAGE);
            }
        }catch (ServiceException e){
            logger.error(e.getMessage());
        }
        return page;
    }
}
