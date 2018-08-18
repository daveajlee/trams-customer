package de.davelee.trams.customer;

import com.google.common.base.Predicate;
import de.davelee.trams.customer.admin.pages.CustomerLoginPage;
import de.davelee.trams.customer.admin.pages.CustomerWelcomePage;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * This class represents the Spring Boot application for TraMS Customer Management.
 * @author Dave Lee
 */
@Configuration
@SpringBootApplication
@EnableSwagger2
@ComponentScan
@EnableJpaRepositories("de.davelee.trams.customer.repository")
public class TramsCustomerApplication {

    @Value("${operator.test}")
    private static String test;

    @Value("#{'${operators.list}'.split(',')}")
    private static List<String> operators;

    /**
     * Main method to start the application.
     * @param args a <code>String</code> array of arguments which are not presently used.
     */
    public static void main ( String[] args ) {
        new SpringApplicationBuilder()
                .sources(TramsCustomerApplication.class)
                .run(args);
    }

    @Bean
    /**
     * Configure Swagger to display appropriate information.
     * @return a <code>Docket</code> object containing the configured information.
     */
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("operations")
                .apiInfo(apiInfo())
                .select()
                .paths(paths())
                .build();
    }

    /**
     * Only map urls starting with driver.
     * @return a <code>Predicate</code> object containing the configuration of limited urls.
     */
    private Predicate<String> paths() {
        return or (
                regex("/customer.*")
        );
    }

    /**
     * Return an API Info object with the configured information for the Swagger UI.
     * @return a <code>ApiInfo</code> object with the configured information for the Swagger UI.
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("TraMS Customer Rest API")
                .description("Rest API for TraMS Customer")
                .termsOfServiceUrl("http://www.davelee.de")
                .contact("Dave Lee")
                .license("TraMS Website")
                .licenseUrl("http://www.davelee.de")
                .version("0.1")
                .build();
    }

}
