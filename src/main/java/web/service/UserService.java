package web.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import web.model.User;
import java.sql.SQLException;
import java.util.List;

public interface UserService extends UserDetailsService {
    boolean addUser(User user) throws SQLException;
    List<User> getAllUser() throws SQLException;
    boolean updateUser(User user) throws SQLException;
    User getUserById(long id) throws SQLException;
    boolean deleteClient(long id) throws SQLException;

}
