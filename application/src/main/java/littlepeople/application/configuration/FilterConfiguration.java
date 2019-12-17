package littlepeople.application.configuration;

import littlepeople.application.configuration.filters.UserConnectionFilter;
import littlepeople.application.configuration.filters.RequestResponseLoggingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "littlepeople.application.configuration.filters") // #SpringBoot is dumb
public class FilterConfiguration {

    @Autowired
    private RequestResponseLoggingFilter requestResponseLoggingFilter;


    @Autowired
    private UserConnectionFilter userConnectionFilter;



    @Bean
    public FilterRegistrationBean<RequestResponseLoggingFilter> loggingFilter() {
        FilterRegistrationBean<RequestResponseLoggingFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(requestResponseLoggingFilter);
        registrationBean.setOrder(1);

        registrationBean.addUrlPatterns("/*");

        return registrationBean;
    }




    @Bean
    public FilterRegistrationBean<UserConnectionFilter> userConnectionFilter() {
        FilterRegistrationBean<UserConnectionFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(userConnectionFilter);
        registrationBean.setOrder(2);

        registrationBean.addUrlPatterns("/api/user/*");

        return registrationBean;
    }

}
