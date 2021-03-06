package by.bntu.poisit.library_ee.locales;

import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;


public class PageContentManager {
    private static final String RESOURCE_PAGECONTENT_BUNDLE="pagecontent";
    private ResourceBundle resourceBundle;
    private volatile static PageContentManager instance=null;
    public static PageContentManager getInstance(){
        if(instance==null){
            synchronized (PageContentManager.class){
                if(instance == null){
                    instance=new PageContentManager();}
                }
        }
        return instance;
    }
    private PageContentManager() {

    }

    public String getProperty(String key) {
        System.out.println("resource bundle: " + RESOURCE_PAGECONTENT_BUNDLE);
        return resourceBundle.getString(key);
    }
    public void setLanguage(String language){
        Locale locale = LocaleController.getInstance().getLocaleByLanguage(language);
        resourceBundle = resourceBundle.getBundle(RESOURCE_PAGECONTENT_BUNDLE, locale);
    }
}
