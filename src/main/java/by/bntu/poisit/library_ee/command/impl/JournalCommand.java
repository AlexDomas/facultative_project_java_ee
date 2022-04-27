package by.bntu.poisit.library_ee.command.impl;

import by.bntu.poisit.library_ee.controller.*;
import by.bntu.poisit.library_ee.entity.Course;
import by.bntu.poisit.library_ee.entity.Journal;
import by.bntu.poisit.library_ee.entity.Login;
import by.bntu.poisit.library_ee.command.*;
import by.bntu.poisit.library_ee.locales.MessageManager;
import by.bntu.poisit.library_ee.service.CourseService;
import by.bntu.poisit.library_ee.service.JournalService;
import by.bntu.poisit.library_ee.service.ServiceException;
import by.bntu.poisit.library_ee.manager.JspPagesManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.logging.Logger;

public class JournalCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = JspPagesManager.getProperty(JspPageParamName.JOURNAL_PAGE);

        String requestId=request.getParameter(CommandParameterName.PARAM_NAME_ID);
        if(requestId==null){
            request.setAttribute("errorMsg", MessageManager.getInstance().getMessage(MessageParamName.WRONG_REQUEST_MESSAGE));
            page = JspPagesManager.getProperty(JspPageParamName.ERROR_PAGE);
        }else{

            Integer itemId=new Integer(requestId);

            JournalService jl = JournalService.getInstance();
            CourseService cl = CourseService.getInstance();


            try {
                Course course = cl.getForEdit(itemId);
                request.setAttribute("course", course);

                Login teaacher = (Login) request.getSession().getAttribute(SessionParamName.USER_DATA);
                if (course == null || course.getTeacherId() != teaacher.getId()) {
                    request.setAttribute("errorMsg", MessageManager.getInstance().getMessage(MessageParamName.WRONG_REQUEST_MESSAGE));
                    page = JspPagesManager.getProperty(JspPageParamName.ERROR_PAGE);
                } else {

                    List<Journal> students = jl.getStudentsList(course.getId());
                    request.setAttribute("students", students);
                }
            }catch(ServiceException e){
                logger.error(e.getMessage());
            }

        }
        return page;
    }
}