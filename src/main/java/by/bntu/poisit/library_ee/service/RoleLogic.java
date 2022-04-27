package by.bntu.poisit.library_ee.service;


import by.bntu.poisit.library_ee.dao.DaoException;
import by.bntu.poisit.library_ee.dao.DaoFactory;
import by.bntu.poisit.library_ee.dao.impl.CommandDao;
import by.bntu.poisit.library_ee.dao.impl.LoginDao;
import by.bntu.poisit.library_ee.dao.impl.RoleDao;
import by.bntu.poisit.library_ee.entity.Command;
import by.bntu.poisit.library_ee.entity.Login;
import by.bntu.poisit.library_ee.entity.Role;

import java.util.List;


public class RoleLogic {

    private volatile static RoleLogic instance=null;
    private RoleLogic(){}

    public static RoleLogic getInstance(){
        if(instance==null) {
            synchronized (RoleLogic.class){
            if (instance == null) {
                instance = new RoleLogic();}
            }

        }
        return instance;
    }

    public List<Role> getAll()throws ServiceException{
        List<Role> items=null;
        try {
            RoleDao dao = DaoFactory.getInstance().getRoleDao();
            items = dao.findAll();
        }catch(DaoException e){

            throw new ServiceException(e.getMessage());
        }
        return items;
    }

}

