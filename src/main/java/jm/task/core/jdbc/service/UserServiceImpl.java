package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import javax.transaction.SystemException;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoHibernateImpl();

    public void createUsersTable() throws SQLException, SystemException {
        userDao.createUsersTable();
    }

    public void dropUsersTable() throws SQLException, SystemException {
        userDao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException, SystemException {
        userDao.saveUser(name,lastName,age);
    }

    public void removeUserById(long id) throws SQLException, SystemException {
        userDao.removeUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
        return userDao.getAllUsers();
    }

    public void cleanUsersTable() throws SQLException, SystemException {
        userDao.cleanUsersTable();
    }
}
