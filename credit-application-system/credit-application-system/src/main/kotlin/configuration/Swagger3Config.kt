package dev.Roberto.Simoes.credit.applicationsystem.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springdoc.core.models.GroupedOpenApi
@Configuration
class Swagger3Config {
    @Bean
    fun publicApi():GroupedOpenApi? {
        return GroupedOpenApi.builder()
            .group("springcreditapplicationsystem-pulbic")
            .pathsToMatch("/api/customers/**", "/api/credits/**")
            .build()

    }
}