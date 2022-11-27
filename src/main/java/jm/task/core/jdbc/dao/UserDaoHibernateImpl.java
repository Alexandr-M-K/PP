package jm.task.core.jdbc.dao;

import com.mysql.cj.Query;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class UserDaoHibernateImpl implements UserDao {

    Session session = Util.getSessionFactory().getCurrentSession();

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        session.beginTransaction();
        session.createQuery("CREATE TABLE IF NOT EXISTS Users(" +
                "id bigint PRIMARY KEY AUTO_INCREMENT," +
                "name varchar(30) NOT NULL," +
                "lastName varchar(30) NOT NULL," +
                "age int)")
                .executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        session.beginTransaction();
        session.createQuery("DROP TABLE IF EXISTS Users")
                .executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        session.beginTransaction();
        session.save(new User(name,lastName,age));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        session.beginTransaction();
        session.delete(session.get(User.class,id));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {

        session.beginTransaction();
        List<User> userList =session.createQuery("from User")
                        .getResultList();
        session.getTransaction().commit();
        session.close();
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        session.beginTransaction();
        session.delete(getAllUsers());
        session.getTransaction().commit();
        session.close();
    }
}
