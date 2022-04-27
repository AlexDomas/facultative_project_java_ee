package by.bntu.poisit.library_ee.command;

import javax.servlet.http.HttpServletRequest;


public interface Command {
    String execute(HttpServletRequest request);
}
