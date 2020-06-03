package web.dao;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    boolean addUser(User user);
    boolean deleteUser(long id);
    List<User> selectUsers() throws SQLException;
    boolean updateUser(User user);

    User getUserById(long id);

    UserDetails getUserByName(String s);


}
