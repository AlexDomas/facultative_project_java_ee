package by.bntu.poisit.library_ee.dao.connectionpool;

public class ConnectionPoolException extends Exception{
    private static final long serialVersionUID = 1L;
    public ConnectionPoolException(String message, Exception e){
        super(message, e);
    }
}
