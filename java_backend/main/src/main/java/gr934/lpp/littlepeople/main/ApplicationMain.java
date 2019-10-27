package gr934.lpp.littlepeople.main;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "gr934.lpp.littlepeople")
@EntityScan(basePackages = "gr934.lpp.littlepeople.core.entities")
@EnableJpaRepositories(basePackages = "gr934.lpp.littlepeople.core.repository")
public class ApplicationMain {
    @Autowired
    private ApplicationContext context;


    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class, args);
    }
}
