package littlepeople.application.configuration.filters;

import littlepeople.application.service.LoginService;
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
public class UserConnectionFilter extends GenericFilterBean {
    @Autowired
    private LoginService loginService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        Optional<String> optionalUserToken = Optional.ofNullable(httpRequest.getHeader("AUTHORIZATION"));
        if (!optionalUserToken.isPresent()) {
            httpResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
            return;
        }

        String userToken = optionalUserToken.get();
        if (!loginService.isUserLoggedIn(userToken)) {
            httpResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
            return;
        }

        //we are logged in move forward
        filterChain.doFilter(httpRequest, httpResponse);
    }
}
