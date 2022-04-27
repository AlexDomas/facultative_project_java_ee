package by.bntu.poisit.library_ee.controller;
import by.bntu.poisit.library_ee.command.Command;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.bntu.poisit.library_ee.command.*;
import by.bntu.poisit.library_ee.manager.DBResourceManager;
import by.bntu.poisit.library_ee.manager.JspPagesManager;


public class Controller extends HttpServlet {
    private  int counter=0;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request,
            HttpServletResponse response)
        throws ServletException, IOException {


        String page=(String)request.getAttribute(CommandParameterName.PARAM_NAME_DEFAULT_PAGE);


        Command command = CommandFactory.getInstance().defineCommand(request);


        if(command != null) {
            page = command.execute(request);
        }


        if (page != null & request.getParameter("isRedirect")==null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else {

            if(request.getParameter("isRedirect")!=null){

                response.sendRedirect(request.getParameter("redirectUrl"));
            }else {

                response.sendRedirect(request.getContextPath() + JspPageParamName.APPLICATION_CONTEXT);
            }
        }
    }
}
