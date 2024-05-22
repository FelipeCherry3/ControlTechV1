package com.losBicos.ControlTechV1.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("API ControlTech-V4")
                        .version("v4")
                        .description("Documentação de nossa API REST utilizado para alimentar o Painel ControlTech ADMIN")
                );

    }
}
