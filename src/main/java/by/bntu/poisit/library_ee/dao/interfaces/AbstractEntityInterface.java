package by.bntu.poisit.library_ee.dao.interfaces;

import by.bntu.poisit.library_ee.dao.DaoException;
import by.bntu.poisit.library_ee.entity.Entity;

import java.util.List;


public interface AbstractEntityInterface<K, T extends Entity> {
    List<T> findAll() throws DaoException;
    T findEntityById(K id) throws DaoException;
    boolean delete(K id) throws DaoException;
    boolean delete(T entity) throws DaoException;
    boolean create(T entity) throws DaoException;
    T update(T entity) throws DaoException;
}

