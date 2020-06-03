package web.config.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import web.model.User;
import web.service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private RoleService roleService;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        User user = (User) authentication.getPrincipal();

        httpServletRequest.getSession().setAttribute("userInfo", user);
        if (user.getRoles().contains(roleService.getRoleByName("ADMIN"))){
            httpServletResponse.sendRedirect("/admin/select");
        } else if(user.getRoles().contains(roleService.getRoleByName("USER")) && !user.getRoles().contains(roleService.getRoleByName("ADMIN"))){
            httpServletResponse.sendRedirect("/user");
        }
    }
}