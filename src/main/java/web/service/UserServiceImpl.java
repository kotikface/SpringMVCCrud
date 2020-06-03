package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Transactional
    @Override
    public boolean deleteClient(long id) throws SQLException {
        return userDAO.deleteUser(id);
    }


    @Transactional
    @Override
    public List<User> getAllUser() throws SQLException {
        return userDAO.selectUsers();
    }
    @Transactional
    @Override
    public User getUserById(long id) throws SQLException {
       return userDAO.getUserById(id);
    }
    @Transactional
    @Override
    public boolean addUser(User user) throws SQLException {
        return userDAO.addUser(user);

    }
    @Transactional
    @Override
    public boolean updateUser(User user) {
        return userDAO.updateUser(user);
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDAO.getUserByName(s);
    }
}
