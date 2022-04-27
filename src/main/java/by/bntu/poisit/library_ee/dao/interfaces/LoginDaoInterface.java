package by.bntu.poisit.library_ee.dao.interfaces;

import by.bntu.poisit.library_ee.entity.Login;

public interface LoginDaoInterface extends AbstractEntityInterface<Integer, Login>{
    Login findByLoginAndPassword(String userLogin, String userPassword);
    Login findByLogin(String userLogin);
}
