package by.bntu.poisit.library_ee.service;



public class ServiceException extends Exception{
    private static final long serialVersionUID = 2L;
    public ServiceException(String message, Exception e){
        super(message, e);
    }
    public ServiceException(String message){
        super(message);
    }
}

