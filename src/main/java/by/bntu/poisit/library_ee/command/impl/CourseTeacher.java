package by.bntu.poisit.library_ee.command.impl;

import by.bntu.poisit.library_ee.command.AbstractCommand;
import by.bntu.poisit.library_ee.command.*;
import by.bntu.poisit.library_ee.controller.*;
import by.bntu.poisit.library_ee.service.CourseService;
import by.bntu.poisit.library_ee.service.ServiceException;
import by.bntu.poisit.library_ee.manager.JspPagesManager;
import javax.servlet.http.HttpServletRequest;
import by.bntu.poisit.library_ee.entity.Login;

public class CourseTeacher extends AbstractCommand  {
    public String execute(HttpServletRequest request) {

        Login userData = (Login) request.getSession().getAttribute(SessionParamName.USER_DATA);
        CourseService cl= CourseService.getInstance();

        try {
            request.setAttribute("courses", cl.getAllByIdTeacher(userData.getId()));
        }catch (ServiceException e){
            logger.error(e.getMessage());
        }
        return JspPagesManager.getProperty(JspPageParamName.COURSES_PAGE);
    }
}
