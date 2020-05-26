package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
}
