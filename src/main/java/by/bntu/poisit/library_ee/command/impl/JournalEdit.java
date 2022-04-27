package by.bntu.poisit.library_ee.command.impl;

import by.bntu.poisit.library_ee.command.AbstractCommand;
import by.bntu.poisit.library_ee.command.Command;
import by.bntu.poisit.library_ee.controller.CommandParameterName;
import by.bntu.poisit.library_ee.controller.JspPageParamName;
import by.bntu.poisit.library_ee.controller.MessageParamName;
import by.bntu.poisit.library_ee.entity.Journal;
import by.bntu.poisit.library_ee.locales.MessageManager;
import by.bntu.poisit.library_ee.service.CourseService;
import by.bntu.poisit.library_ee.service.JournalService;
import by.bntu.poisit.library_ee.service.ServiceException;
import by.bntu.poisit.library_ee.manager.JspPagesManager;

import javax.servlet.http.HttpServletRequest;


public class JournalEdit extends AbstractCommand {
    public String execute(HttpServletRequest request) {

        String page = JspPagesManager.getProperty(JspPageParamName.JOURNAL_RECORD_EDIT);

        JournalService jl = JournalService.getInstance();
        CourseService cl = CourseService.getInstance();


        String mark = request.getParameter(CommandParameterName.PARAM_NAME_MARK);
        String note = request.getParameter(CommandParameterName.PARAM_NAME_NOTE);

        Journal journal;

        String requestId=request.getParameter(CommandParameterName.PARAM_NAME_ID);
        if(requestId==null){
            request.setAttribute("errorMsg", MessageManager.getInstance().getMessage(MessageParamName.WRONG_REQUEST_MESSAGE));
            page = JspPagesManager.getProperty(JspPageParamName.ERROR_PAGE);
        }else {
            Integer itemId=new Integer(requestId);
            try {

                if (mark != null && note != null) {

                    journal = jl.findById(itemId);
                    jl.setMark(itemId, new Integer(mark), note);
                    request.setAttribute("course", cl.getForEdit(journal.getCourseId()));

                    request.setAttribute("edititem", journal);
                    request.setAttribute("actionresult", MessageParamName.JORNAL_RECORD_UPDATED);
                    page = JspPagesManager.getProperty(JspPageParamName.JOURNAL_ACTION_FINISHED_PAGE);

                } else {
                    journal = jl.findById(itemId);
                    request.setAttribute("edititem", journal);
                    request.setAttribute("course", cl.getForEdit(journal.getCourseId()));
                }
            }catch(ServiceException e){
                logger.error(e.getMessage());
            }
        }

        return page;
    }

}
