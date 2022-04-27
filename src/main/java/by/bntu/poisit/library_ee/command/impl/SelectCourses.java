package by.bntu.poisit.library_ee.command.impl;

import by.bntu.poisit.library_ee.command.AbstractCommand;
import by.bntu.poisit.library_ee.controller.*;
import by.bntu.poisit.library_ee.dao.DaoException;
import by.bntu.poisit.library_ee.dao.DaoFactory;
import by.bntu.poisit.library_ee.dao.impl.CourseDao;
import by.bntu.poisit.library_ee.entity.Course;
import by.bntu.poisit.library_ee.entity.Login;
import by.bntu.poisit.library_ee.locales.MessageManager;
import by.bntu.poisit.library_ee.service.CourseService;
import by.bntu.poisit.library_ee.command.Command;
import by.bntu.poisit.library_ee.service.ServiceException;
import by.bntu.poisit.library_ee.manager.JspPagesManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class SelectCourses extends AbstractCommand {

    protected static final String ACTION_SUBSCRIBE="subscribe";
    protected static final String ACTION_UNSUBSCRIBE="unsubscribe";

    @Override
    public String execute(HttpServletRequest request) {
        String page = JspPagesManager.getProperty(JspPageParamName.SELECT_COURSES_PAGE);

        try {
            CourseService cl = CourseService.getInstance();
            Login userData = (Login) request.getSession().getAttribute(SessionParamName.USER_DATA);
            List<Course> courses = cl.findAllBySubscribe(userData.getId());

            request.setAttribute("courses", courses);
        }catch(ServiceException e){
            logger.error(e.getMessage());
        }

        return page;
    }

}
