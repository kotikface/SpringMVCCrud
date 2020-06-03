package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;

@Repository
public class RoleHibernateDAO implements RoleDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Role getRoleByName(String user) {
        return (Role)sessionFactory.getCurrentSession().createQuery("select role from Role role where name=:name").setParameter("name", user).getSingleResult();
    }
}
