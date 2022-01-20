package com.ashiqursuperfly.smallcommercecompanion.configurations

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket


@Configuration
class SwaggerConfig {

    @Bean
    fun docket(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.ashiqursuperfly.smallcommercecompanion"))
            .build()
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder().title("Small Commerce Application API")
            .description("Test Description")
            .version("v0.0.1")
            .build()
    }
//    fun addResourceHandlers(registry: ResourceHandlerRegistry) {
//        registry.addResourceHandler("/swagger-ui/**")
//            .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
//            .resourceChain(false)
//    }
}