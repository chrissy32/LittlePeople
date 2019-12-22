package littlepeople.application.filters;

import littlepeople.application.service.LoginService;
import lombok.RequiredArgsConstructor;
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
import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

@Component
@Log4j2
public class UserConnectionFilter extends GenericFilterBean {
    @Autowired
    private LoginService loginService;

    private final int numberSecondsToExpire = 60 * 60;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        if (httpRequest.getMethod().equals("OPTIONS")) {
            filterChain.doFilter(httpRequest, httpResponse);
            return;
        }


        Optional<String> optionalUserToken = Optional.ofNullable(httpRequest.getHeader("AUTHORIZATION"));
        if (!optionalUserToken.isPresent()) {
            log.trace("UserConnectionFilter: doFilter() No AUTHORIZATION header!");
            httpResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
            return;
        }


        String userToken = optionalUserToken.get();
        if (!loginService.isUserLoggedIn(userToken)) {
            log.trace("UserConnectionFilter: doFilter() Invalid token!");
            httpResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
            return;
        }


        //now we check for expiration
        try {
            Instant sessionCreationTime = loginService.getUserSession(userToken).getSessionCreationTime();
            Instant currentTime = Instant.now();

            Duration duration = Duration.between(sessionCreationTime, currentTime);

            if (duration.getSeconds() > this.numberSecondsToExpire) {
                log.trace("UserConnectionFilter: doFilter() Session has expired!");
                httpResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
            httpResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
            return;
        }


        //we are logged in move forward
        filterChain.doFilter(httpRequest, httpResponse);
    }
}
