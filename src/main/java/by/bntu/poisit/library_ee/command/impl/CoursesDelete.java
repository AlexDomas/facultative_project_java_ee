package by.bntu.poisit.library_ee.command.impl;

import by.bntu.poisit.library_ee.command.AbstractCommand;
import by.bntu.poisit.library_ee.controller.JspPageParamName;
import by.bntu.poisit.library_ee.manager.JspPagesManager;
import by.bntu.poisit.library_ee.command.*;
import by.bntu.poisit.library_ee.controller.CommandParameterName;

import by.bntu.poisit.library_ee.controller.MessageParamName;
import by.bntu.poisit.library_ee.service.CourseService;
import by.bntu.poisit.library_ee.service.ServiceException;


import javax.servlet.http.HttpServletRequest;


public class CoursesDelete extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = JspPagesManager.getProperty(JspPageParamName.COURSE_EDIT_PAGE);
        CourseService cl = CourseService.getInstance();
        try {
            if (cl.deleteCourse(new Integer(request.getParameter(CommandParameterName.PARAM_NAME_ID)))) {
                request.setAttribute("actionresult", MessageParamName.ACTION_COURSE_DELETED);
                page = JspPagesManager.getProperty(JspPageParamName.COURSES_ACTION_FINISHED_PAGE);
            }
        }catch (ServiceException e){
            logger.error(e.getMessage());
        }
        return page;
    }
}
