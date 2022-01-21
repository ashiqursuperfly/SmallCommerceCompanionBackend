package com.ashiqursuperfly.smallcommercecompanion

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties


@EnableConfigurationProperties
@SpringBootApplication
class SmallCommerceCompanionApplication {

    /*@Bean
    fun commandLineRunner(ctx: ApplicationContext): CommandLineRunner {
        return CommandLineRunner { args: Array<String?>? ->
            println("Let's inspect the beans provided by Spring Boot:")
            val beanNames = ctx.beanDefinitionNames
            Arrays.sort(beanNames)
            for (beanName in beanNames) {
                println("BEAN: $beanName")
            }
        }
    }*/

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(SmallCommerceCompanionApplication::class.java, *args)
        }
    }
}