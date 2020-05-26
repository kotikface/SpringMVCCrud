package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceInterface;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/")
public class SelectController {
    @Autowired
    private UserServiceInterface userService;

    @RequestMapping(value = "select", method = RequestMethod.GET)
    public String getUsers(ModelMap model) throws SQLException {
        List<User> users =  userService.getAllUser();
        model.addAttribute("users", users);
        return "select";
    }

    @RequestMapping(value = "select",  method = RequestMethod.POST)
    public String insertUser(@RequestParam(name = "name") String name, @RequestParam(name = "password") String password, @RequestParam(name = "age") int age) throws SQLException {
        userService.addUser(new User(name, password, age));
        return "redirect:select";
    }
}
