package by.bntu.poisit.library_ee.command.impl;

import by.bntu.poisit.library_ee.command.AbstractCommand;
import by.bntu.poisit.library_ee.command.Command;
import by.bntu.poisit.library_ee.controller.CommandParameterName;
import by.bntu.poisit.library_ee.controller.JspPageParamName;
import by.bntu.poisit.library_ee.controller.MessageParamName;
import by.bntu.poisit.library_ee.controller.SessionParamName;
import by.bntu.poisit.library_ee.locales.MessageManager;
import by.bntu.poisit.library_ee.service.ServiceException;
import by.bntu.poisit.library_ee.service.UserService;
import by.bntu.poisit.library_ee.manager.JspPagesManager;
import by.bntu.poisit.library_ee.entity.Login;


import javax.servlet.http.HttpServletRequest;
import java.util.Date;


public class RegisterCommand extends AbstractCommand {

    private static final String REGISTER_USER_PARAM_VALUE = "add";
    private static final int DEFAULT_ROLE_ID = 2;   // 1 - teacher, 2 - student, 3 - admin

    @Override
    public String execute(HttpServletRequest request) {

        String page = JspPagesManager.getProperty(JspPageParamName.REGISTER_PAGE);

        String action=request.getParameter(CommandParameterName.PARAM_NAME_ACTION);
        if(action!=null && action.equals(REGISTER_USER_PARAM_VALUE)) {

            String login = request.getParameter(CommandParameterName.PARAM_NAME_LOGIN);
            String password = request.getParameter(CommandParameterName.PARAM_NAME_PASSWORD);
            String passwordConfirmation = request.getParameter(CommandParameterName.PARAM_NAME_PASSWORD_CONFIRMATION);
            String firstName = request.getParameter(CommandParameterName.PARAM_FIRST_NAME);
            String lastName = request.getParameter(CommandParameterName.PARAM_LAST_NAME);

            if (login != null && password != null
                    && passwordConfirmation != null && firstName!=null
                    && lastName!=null && !login.isEmpty()
                    && !password.isEmpty() && !firstName.isEmpty()
                    && !lastName.isEmpty()) { // need create new user

                UserService ul = (UserService) UserService.getInstance();
                if (password.equals(passwordConfirmation)) {
                    try { Login user = ul.userLogin(login, password);
                        if (user == null) {
                            ul.registerUser(login, password, DEFAULT_ROLE_ID, firstName, lastName);
                            request.setAttribute("userName", login);
                            page = JspPagesManager.getProperty(JspPageParamName.REGISTER_OK_PAGE);
                        } else {

                            request.setAttribute("errorMsg", MessageManager.getInstance().getMessage(MessageParamName.USER_ALREADY_EXIST_MESSAGE));
                        }

                    }catch(ServiceException e){
                        logger.error(e.getMessage());
                    }
                } else {
                    request.setAttribute("errorMsg", MessageManager.getInstance().getMessage(MessageParamName.WRONG_PASSWORD_CONFIRMATION_MESSAGE));
                }
            } else {
                request.setAttribute("errorMsg", MessageManager.getInstance().getMessage(MessageParamName.ALL_FORM_FIELDS_REQUIRED_MESSAGE));
            }
        }
        return page;
    }
}
