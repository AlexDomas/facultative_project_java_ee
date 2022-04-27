package by.bntu.poisit.library_ee.manager;

import java.util.ResourceBundle;


public class DBResourceManager {
    public final static String RESOURCE_DB_PARAMS_BUNDLE="db";
    private final static DBResourceManager instance = new DBResourceManager();
    private final ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_DB_PARAMS_BUNDLE);

    private DBResourceManager() { }
    public String getValue(String key) {
        return resourceBundle.getString(key);
    }
    
    public static DBResourceManager getInstance(){
        return instance;
    }
}
