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
        registrationBean.addUrlPatterns("/api/report/*");
        registrationBean.addUrlPatterns("/api/activity/*");
        registrationBean.addUrlPatterns("/api/hospital/*");
        registrationBean.addUrlPatterns("/api/proposal/*");
        registrationBean.addUrlPatterns("/api/vote/*");

        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<AdminConnectionFilter> adminConnectionFilterFilterRegistrationBean() {
        FilterRegistrationBean<AdminConnectionFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(adminConnectionFilter);
        registrationBean.setOrder(3);

        registrationBean.addUrlPatterns("/api/user/leader/*");
        registrationBean.addUrlPatterns("/api/report/leader/*");
        registrationBean.addUrlPatterns("/api/activity/leader/*");
        registrationBean.addUrlPatterns("/api/hospital/leader/*");
        registrationBean.addUrlPatterns("/api/proposal/leader/*");
        registrationBean.addUrlPatterns("/api/vote/leader/*");


        return registrationBean;
    }

}
