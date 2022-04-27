package by.bntu.poisit.library_ee.command.impl;

import by.bntu.poisit.library_ee.command.AbstractCommand;
import by.bntu.poisit.library_ee.command.*;
import by.bntu.poisit.library_ee.controller.*;
import by.bntu.poisit.library_ee.service.CourseService;
import by.bntu.poisit.library_ee.service.ServiceException;
import by.bntu.poisit.library_ee.manager.JspPagesManager;
import javax.servlet.http.HttpServletRequest;


public class CoursesCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        CourseService cl= CourseService.getInstance();
        try {
            request.setAttribute("courses", cl.getAll());
        }catch (ServiceException e){
            logger.error(e.getMessage());
        }
        return JspPagesManager.getProperty(JspPageParamName.COURSES_PAGE);
    }
}
