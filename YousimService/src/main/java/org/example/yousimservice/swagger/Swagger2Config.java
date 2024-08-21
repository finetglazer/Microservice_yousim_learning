package org.example.yousimservice.swagger;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class Swagger2Config {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Your API Title")
                        .version("1.0.0")
                        .description("This is first project for Spring Boot API of me")
                        .contact(new Contact()
                                .name("Tran Manh Hung")
                                .email("tranhung174303@gmail.com")
                                .url("https://www.facebook.com/tranhung10122003/"))
                        .license(new License()
                                .name("Your License")
                                .url("https://www.facebook.com/tranhung10122003/")));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public-api")
                .pathsToMatch("/api/**")
                .build();
    }
}
