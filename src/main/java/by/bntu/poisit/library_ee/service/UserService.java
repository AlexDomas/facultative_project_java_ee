package by.bntu.poisit.library_ee.service;


import by.bntu.poisit.library_ee.entity.Command;
import by.bntu.poisit.library_ee.entity.Login;
import by.bntu.poisit.library_ee.dao.impl.CommandDao;
import by.bntu.poisit.library_ee.dao.DaoException;
import by.bntu.poisit.library_ee.dao.DaoFactory;
import by.bntu.poisit.library_ee.dao.impl.LoginDao;
import by.bntu.poisit.library_ee.controller.SessionParamName;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
import java.util.List;


public class UserService{

    private volatile static UserService instance=null;
    private UserService(){}

    public static UserService getInstance(){
        if(instance==null){
            synchronized (UserService.class){
                if(instance == null){
            instance=new UserService();}
            }
        }
        return (UserService)instance;
    }

    public List<Command> getUserAccessByRoleId(Integer roleId)throws ServiceException{
        List<Command> userAccess=null;
        try {
            CommandDao cd = new CommandDao();
            userAccess = cd.findByRoleId(roleId);

        } catch (DaoException e) {

            throw new ServiceException("Can't get commands list for role_id " + roleId);
        }
        return userAccess;
    }

    public Login userLogin(String userLogin, String userPassword)throws ServiceException{
        Login login=null;
        try {
            LoginDao ld = DaoFactory.getInstance().getLoginDao();
            login = ld.findByLoginAndPassword(userLogin, userPassword);
        }catch(DaoException e){
            throw new ServiceException(e.getMessage());
        }
        return login;
    }

    public Login updateUser(Login user)throws ServiceException{
        Login login=null;
        try {
            LoginDao ld = DaoFactory.getInstance().getLoginDao();
            login = ld.update(user);
        }catch(DaoException e){
            throw new ServiceException(e.getMessage());
        }
        return login;
    }

    public boolean registerUser(String userLogin, String userPassword, int roleId, String firstName, String lastName)throws ServiceException{
        Login user;
        try {
            LoginDao ld = DaoFactory.getInstance().getLoginDao();
            if(ld.findByLogin(userLogin)==null){

                user = new Login();
                user.setLogin(userLogin);
                user.setPassword(userPassword);
                user.setRoleId(roleId);
                user.setIsActive(true);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                ld.create(user);
                return true;
            }
        }catch (DaoException e){

            throw new ServiceException("User registration error: "+e.getMessage());
        }
        return false;
    }

    public List<Login> getAll()throws ServiceException{
        List<Login> courses=null;
        try {
            LoginDao dao = DaoFactory.getInstance().getLoginDao();
            courses = dao.findAll();
        }catch(DaoException e){

            throw new ServiceException(e.getMessage());
        }
        return courses;
    }

    public Login getById(Integer id) throws ServiceException{
        Login user=null;
        try {
            LoginDao dao = DaoFactory.getInstance().getLoginDao();
            user = dao.findEntityById(id);
        }catch(DaoException e){

            throw new ServiceException(e.getMessage());
        }
        return user;
    }

    public boolean delete(Integer id) throws ServiceException{
        boolean result=false;
        try {
            LoginDao dao = DaoFactory.getInstance().getLoginDao();
            result=dao.delete(id);
        }catch(DaoException e){

            throw new ServiceException(e.getMessage());
        }
        return result;
    }
}

