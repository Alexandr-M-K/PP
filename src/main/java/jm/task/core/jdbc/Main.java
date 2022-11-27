package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

            UserDao userDao = new UserDaoHibernateImpl();

            userDao.createUsersTable();

            userDao.saveUser("Sasha","Marienko",(byte)2);
            userDao.saveUser("Lesha","Ivanov",(byte)3);
            userDao.saveUser("Pasha","Sidorov",(byte)4);
            userDao.saveUser("Anton","Popov", (byte)5);

            var list = userDao.getAllUsers();
            System.out.printf(list.toString());

            userDao.cleanUsersTable();

            userDao.dropUsersTable();

        }
}
