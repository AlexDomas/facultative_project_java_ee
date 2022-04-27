package by.bntu.poisit.library_ee.command.impl;

import by.bntu.poisit.library_ee.command.AbstractCommand;
import by.bntu.poisit.library_ee.controller.CommandParameterName;
import by.bntu.poisit.library_ee.controller.JspPageParamName;
import by.bntu.poisit.library_ee.controller.MessageParamName;
import by.bntu.poisit.library_ee.entity.Login;
import by.bntu.poisit.library_ee.locales.MessageManager;
import by.bntu.poisit.library_ee.service.CourseService;
import by.bntu.poisit.library_ee.service.ServiceException;
import by.bntu.poisit.library_ee.service.RoleLogic;
import by.bntu.poisit.library_ee.service.UserService;
import by.bntu.poisit.library_ee.manager.JspPagesManager;

import javax.servlet.http.HttpServletRequest;


public class UserEdit extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {

        UserService ul=UserService.getInstance();

        String page = JspPagesManager.getProperty(JspPageParamName.USER_EDIT_PAGE);


        try {

            Integer itemId = new Integer(request.getParameter(CommandParameterName.PARAM_NAME_ID));

            if (itemId != null) {


                Login item=ul.getById(itemId);

                if (item!=null){

                    String firstName=request.getParameter(CommandParameterName.PARAM_FIRST_NAME);
                    String lastName=request.getParameter(CommandParameterName.PARAM_LAST_NAME);
                    String login=request.getParameter(CommandParameterName.PARAM_NAME_LOGIN);
                    String password=request.getParameter(CommandParameterName.PARAM_NAME_PASSWORD);
                    String role=request.getParameter(CommandParameterName.PARAM_NAME_ROLE);

                    if(firstName!=null && lastName !=null && login!=null && password !=null && role!=null){

                        item.setFirstName(firstName);
                        item.setLastName(lastName);
                        item.setLogin(login);
                        item.setRoleId(new Integer(role));
                        if(!password.isEmpty()){
                            item.setMd5Password(password);
                        }
                        ul.updateUser(item);

                        request.setAttribute("actionresult", MessageParamName.ACTION_USER_UPDATED);
                        page = JspPagesManager.getProperty(JspPageParamName.USER_ACTION_FINISHED_PAGE);
                    }

                    request.setAttribute("edititem", item);
                    request.setAttribute("role_list", RoleLogic.getInstance().getAll());

                }else{
                    request.setAttribute("errorMsg", MessageManager.getInstance().getMessage(MessageParamName.WRONG_ACTION_MESSAGE));
                }

            } else {

                request.setAttribute("errorMsg", MessageManager.getInstance().getMessage(MessageParamName.WRONG_ACTION_MESSAGE));
            }
        }catch(ServiceException e){
            logger.error(e.getMessage());
            request.setAttribute("errorMsg", e.getMessage());
            page = JspPagesManager.getProperty(JspPageParamName.ERROR_PAGE);
        }

        return page;
    }
}
