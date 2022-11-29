package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import javax.transaction.SystemException;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    void createUsersTable() throws SQLException, SystemException;

    void dropUsersTable() throws SQLException, SystemException;

    void saveUser(String name, String lastName, byte age) throws SQLException, SystemException;

    void removeUserById(long id) throws SQLException, SystemException;

    List<User> getAllUsers() throws SQLException;

    void cleanUsersTable() throws SQLException, SystemException;
}
