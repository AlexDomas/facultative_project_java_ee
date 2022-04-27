package by.bntu.poisit.library_ee.dao.impl;

import by.bntu.poisit.library_ee.dao.AbstractDao;
import by.bntu.poisit.library_ee.dao.DaoException;
import by.bntu.poisit.library_ee.dao.connectionpool.ConnectionPoolException;
import by.bntu.poisit.library_ee.dao.interfaces.CourseDaoInterface;
import by.bntu.poisit.library_ee.dao.interfaces.RoleDaoInterface;
import by.bntu.poisit.library_ee.entity.Course;
import by.bntu.poisit.library_ee.entity.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class RoleDao extends AbstractDao<Integer, Role> implements RoleDaoInterface {

     private static final String SQL_GET_ALL="SELECT Role.id, Role.name FROM Role ORDER BY name";
     private static final String SQL_DELETE="DELETE FROM Course WHERE id=?";

    @Override
    public List<Role> findAll() throws DaoException {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet resultSet=null;
        List<Role> list=new ArrayList<Role>();
        try {
            connection = pool.takeConnection();
            try {
                stmt=connection.prepareStatement(SQL_GET_ALL);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Role c = new Role();
                    c.setId(rs.getInt("id"));
                    c.setName(rs.getString("name"));
                    list.add(c);
                }

            } catch (SQLException e) {
                logger.error("findAll error: " + e.getMessage());
                throw new DaoException("findAll error",e);
            }

        }catch (ConnectionPoolException e){
            logger.error("take connection from connectionpool error: "+e.getMessage());
            throw new DaoException("take connection from connectionpool error", e);
        }finally {
            close(connection, stmt, resultSet);
        }
        return list;
    }

    public boolean delete(Integer id)  throws DaoException{
        boolean result=false;
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = pool.takeConnection();
            try {
                stmt=connection.prepareStatement(SQL_DELETE);
                stmt.setInt(1, id);
                stmt.executeUpdate();

            } catch (SQLException e) {
                logger.error("delete error: " + e.getMessage());
                throw new DaoException("delete error",e);
            }

        }catch (ConnectionPoolException e){
            logger.error("take connection from connectionpool error: "+e.getMessage());
            throw new DaoException("take connection from connectionpool error", e);
        }finally {
            close(connection, stmt);
        }

        return result;
    }

}
