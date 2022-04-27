package by.bntu.poisit.library_ee.command.impl;

import by.bntu.poisit.library_ee.command.AbstractCommand;
import by.bntu.poisit.library_ee.locales.MessageManager;
import by.bntu.poisit.library_ee.command.Command;
import by.bntu.poisit.library_ee.controller.JspPageParamName;
import by.bntu.poisit.library_ee.manager.JspPagesManager;
import by.bntu.poisit.library_ee.controller.CommandParameterName;
import by.bntu.poisit.library_ee.controller.MessageParamName;
import by.bntu.poisit.library_ee.controller.SessionParamName;
import by.bntu.poisit.library_ee.entity.Login;
import by.bntu.poisit.library_ee.service.CourseService;
import by.bntu.poisit.library_ee.service.ServiceException;



import javax.servlet.http.HttpServletRequest;


public class CoursesAdd extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {

        String page = JspPagesManager.getProperty(JspPageParamName.COURSES_PAGE);
        String name = request.getParameter(CommandParameterName.PARAM_NAME_NAME);
        Login userData = (Login) request.getSession().getAttribute(SessionParamName.USER_DATA);

        if (name != null && !name.isEmpty()) {
            CourseService cl=CourseService.getInstance();
            try {
                if (cl.addNewCourse(name, userData.getId())) {
                    request.setAttribute("actionresult", MessageParamName.ACTION_COURSE_ADDED);
                    page = JspPagesManager.getProperty(JspPageParamName.COURSES_ACTION_FINISHED_PAGE);
                } else {
                    request.setAttribute("errorMsg", MessageManager.getInstance().getMessage(MessageParamName.COURSE_NOT_CREATED));
                }
            }catch (ServiceException e){
                logger.error(e.getMessage());
            }

        } else {
            request.setAttribute("errorMsg", MessageManager.getInstance().getMessage(MessageParamName.EMPTY_NAME_FIELD_MESSAGE));
        }

        return page;
    }
}