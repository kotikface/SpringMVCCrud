package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserServiceInterface;

import java.sql.SQLException;

@Controller
@RequestMapping("/")
public class UpdateController {
    @Autowired
    UserServiceInterface userService;

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String getUserById(ModelMap model, @RequestParam(name = "id") long id) throws SQLException {
        User user =  userService.getUserById(id);
        model.addAttribute("userById", user);
        return "update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser(@RequestParam(name = "id") long id, @RequestParam(name = "name") String name, @RequestParam(name = "password")
            String password, @RequestParam(name = "age") int age) throws SQLException {
        userService.updateUser(new User(id, name, password, age));
        return "redirect:select";
    }

}
