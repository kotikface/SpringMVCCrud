package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;


import java.util.List;

@Repository
public class UserHibernateDAO implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
        return true;
    }

    @Override
    public boolean deleteUser(long id) {
        User user = sessionFactory.getCurrentSession().get(User.class, id);
        sessionFactory.getCurrentSession().delete(user);
        return true;
    }

    @Override
    public List<User> selectUsers() {
        List<User> users = sessionFactory.getCurrentSession().createQuery("FROM User").list();
        return users;
    }

    @Override
    public boolean updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
        return true;
    }
    @Transactional
    @Override
    public User getUserById(long id) {
         return sessionFactory.getCurrentSession().get(User.class, id);

    }

    @Override
    public User getUserByName(String name) {
        return (User) sessionFactory.getCurrentSession().createQuery("select u from User u where name = :name").setParameter("name", name).getSingleResult();
    }
}
