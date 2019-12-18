package littlepeople.application.filters;

import littlepeople.application.service.LoginService;
import littlepeople.application.session.Session;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Component
@Log4j2
public class AdminConnectionFilter extends GenericFilterBean {

    @Autowired
    private LoginService loginService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        String userToken = httpRequest.getHeader("AUTHORIZATION");
        try {
            Session userSession = loginService.getUserSession(userToken);
            if (!userSession.isAdmin()) {
                httpResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            httpResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return;
        }

        //we are logged in move forward
        filterChain.doFilter(httpRequest, httpResponse);
    }
}
