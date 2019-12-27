package littlepeople.application.configuration;

import littlepeople.application.filters.AdminConnectionFilter;
import littlepeople.application.filters.RequestResponseLoggingFilter;
import littlepeople.application.filters.UserConnectionFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FilterConfiguration {


    @Autowired
    private UserConnectionFilter userConnectionFilter;

    @Autowired
    private RequestResponseLoggingFilter requestResponseLoggingFilter;

    @Autowired
    private AdminConnectionFilter adminConnectionFilter;


    @Bean
    public FilterRegistrationBean<RequestResponseLoggingFilter> loggingFilterFilterRegistrationBean() {
        FilterRegistrationBean<RequestResponseLoggingFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(requestResponseLoggingFilter);
        registrationBean.setOrder(1);

        registrationBean.addUrlPatterns("/*");

        return registrationBean;
    }


    @Bean
    public FilterRegistrationBean<UserConnectionFilter> userConnectionFilterFilterRegistrationBean() {
        FilterRegistrationBean<UserConnectionFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(userConnectionFilter);
        registrationBean.setOrder(2);

        registrationBean.addUrlPatterns("/api/user/*");

        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<AdminConnectionFilter> adminConnectionFilterFilterRegistrationBean() {
        FilterRegistrationBean<AdminConnectionFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(adminConnectionFilter);
        registrationBean.setOrder(3);

        registrationBean.addUrlPatterns("/api/user/leader/*");

        return registrationBean;
    }

}
