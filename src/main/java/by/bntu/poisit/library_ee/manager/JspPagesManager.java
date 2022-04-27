package by.bntu.poisit.library_ee.manager;

import java.util.ResourceBundle;


public class JspPagesManager {
    private static final String RESOURCE_JSPPAGES_BUNDLE="jsppages";
    private static final ResourceBundle resourceBundle=ResourceBundle.getBundle(RESOURCE_JSPPAGES_BUNDLE);

    public static String getProperty(String key) {

        return resourceBundle.getString(key);
    }
}
