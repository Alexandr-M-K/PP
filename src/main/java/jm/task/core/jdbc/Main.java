package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import javax.transaction.SystemException;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, SystemException {

            UserDao userDao = new UserDaoHibernateImpl();

            userDao.createUsersTable();

            userDao.saveUser("Sasha","Marienko",(byte)2);
            userDao.saveUser("Lesha","Ivanov",(byte)3);
            userDao.saveUser("Pasha","Sidorov",(byte)4);
            userDao.saveUser("Anton","Popov", (byte)5);

            List<User> userList = userDao.getAllUsers();

            System.out.println(userList);

             userDao.cleanUsersTable();

            userDao.dropUsersTable();

        }
}
