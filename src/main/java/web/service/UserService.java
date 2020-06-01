package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.dao.UserHibernateDAO;
import web.model.User;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserService implements  UserServiceInterface {
    @Autowired
    private UserDAO userDAO;

    @Transactional
    public boolean deleteClient(long id) throws SQLException {
        return userDAO.deleteUser(id);
    }

    @Transactional
    public List<User> getAllUser() throws SQLException {
        return userDAO.selectUsers();
    }
    @Transactional
    public User getUserById(long id) throws SQLException {
       return userDAO.getUserById(id);
    }
    @Transactional
    public boolean addUser(User user) throws SQLException {
        return userDAO.addUser(user);

    }
    @Transactional
    public boolean updateUser(User user) {
        return userDAO.updateUser(user);
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDAO.getUserByName(s);
    }
}
