package by.bntu.poisit.library_ee.controller.filters;


import by.bntu.poisit.library_ee.command.CommandEnum;
import by.bntu.poisit.library_ee.command.CommandFactory;
import by.bntu.poisit.library_ee.controller.CommandParameterName;
import by.bntu.poisit.library_ee.controller.JspPageParamName;
import by.bntu.poisit.library_ee.controller.SessionParamName;
import by.bntu.poisit.library_ee.entity.Command;
import by.bntu.poisit.library_ee.manager.JspPagesManager;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class AccessFilter implements Filter {
   
    public void init(FilterConfig fg){};
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)throws IOException, ServletException{

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;


        String commandName=request.getParameter(CommandParameterName.COMMAND_NAME);

        boolean accessResult=true;


        if(commandName!=null){

            accessResult = CommandFactory.getInstance().isFreeAccess(commandName);


            if(!accessResult && request.getSession().getAttribute(SessionParamName.USER_DATA)!=null){

                List<Command> access=(List<Command>)request.getSession().getAttribute(SessionParamName.USER_ACCESS);
                boolean wrongAccess=true;
                for(Command acc:  access){
                    if(acc.getName().equals(commandName)){
                        wrongAccess=false;
                        break;
                    }
                }

                accessResult=!wrongAccess;
            }

        }

        if(!accessResult) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        }else {
            chain.doFilter(req, res);
        }
        
         
    }
    
    public void destroy(){};
}
