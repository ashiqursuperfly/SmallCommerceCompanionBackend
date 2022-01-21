package com.ashiqursuperfly.smallcommercecompanion.configurations

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.info.BuildProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket


@Configuration
class SwaggerConfig {

    @Autowired
    private lateinit var buildProperties: BuildProperties

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
            .version(buildProperties.version)
            .build()
    }

//    fun addResourceHandlers(registry: ResourceHandlerRegistry) {
//        registry.addResourceHandler("/swagger-ui/**")
//            .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
//            .resourceChain(false)
//    }
}