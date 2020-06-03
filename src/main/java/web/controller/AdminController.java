package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Role;
import web.model.User;
import web.service.UserService;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public String getUsers(ModelMap model) throws SQLException {
        List<User> users =  userService.getAllUser();
        model.addAttribute("users", users);
        return "select";
    }

    @RequestMapping(value = "/select",  method = RequestMethod.POST)
    public String insertUser(User user, @RequestParam(name = "roles") String roles) throws SQLException {
        Role adminRole = new Role("ADMIN");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(new Role("USER"));
        if (roles.equalsIgnoreCase("admin")){
            roleSet.add(adminRole);
        }
        user.setRoles(roleSet);
        userService.addUser(user);
        return "redirect:select";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String getUserById(ModelMap model, @RequestParam(name = "id") long id) throws SQLException {
        User user =  userService.getUserById(id);
        model.addAttribute("userById", user);
        return "update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser(User user, @RequestParam(name = "roles") String roles) throws SQLException {
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(new Role("USER"));
        if (roles.equalsIgnoreCase("admin")){
            roleSet.add(new Role("ADMIN"));
        }
        user.setRoles(roleSet);
        userService.updateUser(user);
        return "redirect:select";
    }

    @RequestMapping("/delete")
    public String deleteUserById(@RequestParam(name = "id") long id) throws SQLException {
        userService.deleteClient(id);
        return "redirect:select";
    }
}
