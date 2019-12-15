package littlepeople.application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Xps 9560
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return (new Docket(DocumentationType.SWAGGER_2)).apiInfo(this.apiInfo()).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();

    }

    private ApiInfo apiInfo() {
        return (new ApiInfoBuilder()).title("LittlePeople Rest Interfaces").description("Declaration of all REST API's that are used for the LittlePeople application").termsOfServiceUrl("https://www.mhp.com/de/home/").license("Commercial License").version("1.0").build();
    }
}

