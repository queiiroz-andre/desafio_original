package br.com.original.queiroz.desafio_original.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).select()
                .apis(RequestHandlerSelectors.any()).build()
                .useDefaultResponseMessages(false);
    }

    private ApiInfo getApiInfo() {
        var contact = new springfox.documentation.service.Contact("Atendimento Queiroz", "", "andre.queiroz@original.com.br");
        return new ApiInfoBuilder()
                .title("Calculo IMC - API Queiroz")
                .description("Api que define a dieta para os diferentes tipos de IMC")
                .version("1.0.3")
                .contact(contact)
                .license("Apache License Version 2.0")
                .licenseUrl("'http://www.apache.org/licenses/LICENSE-2.0.html'")
                .build();
    }
}

