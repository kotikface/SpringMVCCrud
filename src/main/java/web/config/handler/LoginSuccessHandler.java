package web.config.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import web.model.Role;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private UserServiceInterface userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        User user = (User) authentication.getPrincipal();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Set<String> roles = new HashSet<>();
        for(GrantedAuthority a : authorities) {
            roles.add(a.getAuthority());
        }
        httpServletRequest.getSession().setAttribute("userInfo", user);
        if (roles.contains("ADMIN") && roles.contains("USER")){
            httpServletResponse.sendRedirect("/admin/select");
        } else if(roles.contains("USER") && !roles.contains("ADMIN")){
            httpServletResponse.sendRedirect("/user");
        }
    }
}