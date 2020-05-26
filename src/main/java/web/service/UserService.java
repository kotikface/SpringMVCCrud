package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserHibernateDAO;
import web.model.User;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService implements  UserServiceInterface{
    @Autowired
    UserHibernateDAO userDAO;
    @Transactional
    public boolean deleteClient(long id) throws SQLException {
        if (userDAO.deleteUser(id)) {
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public List<User> getAllUser() throws SQLException {
        return userDAO.selectUsers();
    }
    @Transactional
    public User getUserById(long id) throws SQLException {

        List<User> users = userDAO.selectUsers();
        for (User user1 : users) {
            if (user1.getId() == id) {
                return user1;
            }
        }
        return new User();
    }
    @Transactional
    public boolean addUser(User user) throws SQLException {
        List<User> users = getAllUser();
        if (users.isEmpty()) {
            userDAO.addUser(user);
        } else {
            for (User user1 : users) {
                if (user1.getId() == user.getId()) {
                    return false;
                }
            }
            userDAO.addUser(user);
        }
        return true;
    }
    @Transactional
    public boolean updateUser(User user) {
        return userDAO.updateUser(user);
    }
}
