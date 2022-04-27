package by.bntu.poisit.library_ee.command;


import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class AbstractCommand implements Command {
    static protected final Logger logger=Logger.getRootLogger();
    public String execute(HttpServletRequest request){return "";};
}
