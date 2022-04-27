package by.bntu.poisit.library_ee.controller.filters;

import javax.servlet.*;
import java.io.IOException;


public class CodePageFilter implements Filter {
    private static String encoding;

    public void destroy(){};


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException, ServletException{
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
    }


    public void init(FilterConfig filterConfig)throws ServletException{
        encoding = filterConfig.getInitParameter("characterEncoding");
    }

}



