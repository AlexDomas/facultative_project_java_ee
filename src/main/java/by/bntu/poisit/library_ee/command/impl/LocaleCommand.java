package by.bntu.poisit.library_ee.command.impl;

import by.bntu.poisit.library_ee.command.Command;
import by.bntu.poisit.library_ee.controller.CommandParameterName;
import by.bntu.poisit.library_ee.controller.SessionParamName;
import by.bntu.poisit.library_ee.locales.LocaleController;
import by.bntu.poisit.library_ee.locales.MessageManager;
import by.bntu.poisit.library_ee.locales.SupportedLocale;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public class LocaleCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {

        String newLocale = (String)request.getParameter(CommandParameterName.PARAM_LOCALE_LANGUAGE);

        if(newLocale!=null){
            for(SupportedLocale locale: SupportedLocale.values()){
                if(locale.getLanguage().equals(newLocale)){

                    Locale.setDefault(LocaleController.getInstance().getLocaleByLanguage(newLocale));

                    request.getSession().setAttribute(SessionParamName.CURRENT_LOCALE,newLocale);
                    MessageManager.getInstance().setLanguage(newLocale);
                    break;
                }
            }
        }
        return null;
    }
}
