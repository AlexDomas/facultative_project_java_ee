package by.bntu.poisit.library_ee.command.impl;

import by.bntu.poisit.library_ee.command.AbstractCommand;
import by.bntu.poisit.library_ee.command.Command;
import by.bntu.poisit.library_ee.controller.CommandParameterName;
import by.bntu.poisit.library_ee.controller.JspPageParamName;
import by.bntu.poisit.library_ee.controller.MessageParamName;
import by.bntu.poisit.library_ee.controller.SessionParamName;
import by.bntu.poisit.library_ee.entity.Login;
import by.bntu.poisit.library_ee.locales.MessageManager;
import by.bntu.poisit.library_ee.service.ServiceException;
import by.bntu.poisit.library_ee.service.UserService;
import by.bntu.poisit.library_ee.manager.JspPagesManager;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


public class LoginCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        String login = request.getParameter(CommandParameterName.PARAM_NAME_LOGIN);
        String pass = request.getParameter(CommandParameterName.PARAM_NAME_PASSWORD);

        UserService logic = UserService.getInstance();
        try {

            if (login != null && pass != null) {
                Login user = logic.userLogin(login, pass);
                if (user == null) {
                    request.setAttribute("errorMsg", MessageManager.getInstance().getMessage(MessageParamName.WRONG_LOGIN_OR_PASSWORD_MESSAGE));
                    page = JspPagesManager.getProperty(JspPageParamName.LOGIN_PAGE);
                } else {

                    user.setLastLogin(new Date());
                    logic.updateUser(user);
                    request.getSession().setAttribute(SessionParamName.USER_DATA, user);
                    request.getSession().setAttribute(SessionParamName.USER_ACCESS, logic.getUserAccessByRoleId(user.getRoleId()));
                }
            } else {
                page = JspPagesManager.getProperty(JspPageParamName.LOGIN_PAGE);
            }
        }catch(ServiceException e){
            logger.error(e.getMessage());
        }
        return page;
    }
}
