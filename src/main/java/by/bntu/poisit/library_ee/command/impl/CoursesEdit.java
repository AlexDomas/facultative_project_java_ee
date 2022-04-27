package by.bntu.poisit.library_ee.command.impl;

import by.bntu.poisit.library_ee.command.AbstractCommand;
import by.bntu.poisit.library_ee.controller.JspPageParamName;
import by.bntu.poisit.library_ee.manager.JspPagesManager;
import by.bntu.poisit.library_ee.command.AbstractCommand;
import by.bntu.poisit.library_ee.command.Command;
import by.bntu.poisit.library_ee.controller.CommandParameterName;
import by.bntu.poisit.library_ee.controller.MessageParamName;
import by.bntu.poisit.library_ee.controller.SessionParamName;
import by.bntu.poisit.library_ee.entity.Login;
import by.bntu.poisit.library_ee.locales.MessageManager;
import by.bntu.poisit.library_ee.service.CourseService;
import by.bntu.poisit.library_ee.service.ServiceException;


import javax.servlet.http.HttpServletRequest;

public class CoursesEdit extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {

        CourseService cl= CourseService.getInstance();

        String page = JspPagesManager.getProperty(JspPageParamName.COURSE_EDIT_PAGE);


        try {

            Integer courseId = new Integer(request.getParameter(CommandParameterName.PARAM_NAME_ID));
            String newName=request.getParameter(CommandParameterName.PARAM_NAME_NAME);

            if (courseId != null && newName != null) {
                if (cl.updateCourse(
                        new Integer(request.getParameter(CommandParameterName.PARAM_NAME_ID)),
                        request.getParameter(CommandParameterName.PARAM_NAME_NAME)
                )) {
                    request.setAttribute("actionresult", MessageParamName.ACTION_COURSE_UPDATED);

                    page = JspPagesManager.getProperty(JspPageParamName.COURSES_ACTION_FINISHED_PAGE);
                }

            } else {

                request.setAttribute("edititem", cl.getForEdit(
                        new Integer(request.getParameter(CommandParameterName.PARAM_NAME_ID))));
            }
        }catch(ServiceException e){
            logger.error(e.getMessage());
            request.setAttribute("errorMsg", e.getMessage());
            page = JspPagesManager.getProperty(JspPageParamName.ERROR_PAGE);
        }

        return page;
    }
}
