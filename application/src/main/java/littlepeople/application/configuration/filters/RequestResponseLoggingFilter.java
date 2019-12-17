package littlepeople.application.configuration.filters;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Log4j2
public class RequestResponseLoggingFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse  httpResponse = (HttpServletResponse) servletResponse;
        log.info("Logging Request  {} : {}", httpRequest.getMethod(), httpRequest.getRequestURI());
        filterChain.doFilter(httpRequest, httpResponse);
        log.info("Logging Response : {}", httpResponse.getContentType());
    }
}
