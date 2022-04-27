package by.bntu.poisit.library_ee.command.impl;

import by.bntu.poisit.library_ee.command.AbstractCommand;
import by.bntu.poisit.library_ee.command.Command;
import by.bntu.poisit.library_ee.controller.CommandParameterName;
import by.bntu.poisit.library_ee.controller.JspPageParamName;
import by.bntu.poisit.library_ee.controller.MessageParamName;
import by.bntu.poisit.library_ee.controller.SessionParamName;
import by.bntu.poisit.library_ee.entity.Course;
import by.bntu.poisit.library_ee.entity.Login;
import by.bntu.poisit.library_ee.locales.MessageManager;
import by.bntu.poisit.library_ee.service.CourseService;
import by.bntu.poisit.library_ee.service.ServiceException;
import by.bntu.poisit.library_ee.manager.JspPagesManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class SelectCoursesSubscribe extends AbstractCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = JspPagesManager.getProperty(JspPageParamName.SELECT_COURSES_PAGE);

        String id=request.getParameter(CommandParameterName.PARAM_NAME_ID);
        Integer courseId=new Integer(id);
        if(id!=null) {
            try {
                CourseService cl = CourseService.getInstance();
                Login login = (Login) request.getSession().getAttribute(SessionParamName.USER_DATA);
                cl.subscribe(courseId, login.getId());

                request.setAttribute("actionresult", MessageManager.getInstance().getMessage(MessageParamName.SUBSCRIBED_OK_MESSAGE));
                page = JspPagesManager.getProperty(JspPageParamName.SUBSCRIBE_ACTION_FINISHED_PAGE);
            }catch(ServiceException e){
                logger.error(e.getMessage());
            }

        }else{
            request.setAttribute("errorMsg",MessageManager.getInstance().getMessage(MessageParamName.WRONG_REQUEST_MESSAGE));
        }

        return page;
    }

}
