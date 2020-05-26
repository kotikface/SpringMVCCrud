package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.UserServiceInterface;

import java.sql.SQLException;

@Controller
@RequestMapping("/")
public class DeleteController {
    @Autowired
    UserServiceInterface userService;
    @RequestMapping("/delete")
    public String deleteUserById(@RequestParam(name = "id") long id) throws SQLException {
        userService.deleteClient(id);
        return "redirect:select";
    }
}
