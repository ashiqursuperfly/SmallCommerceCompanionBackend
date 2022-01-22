package com.ashiqursuperfly.smallcommercecompanion.configurations

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.util.matcher.RequestMatcher
import javax.servlet.http.HttpServletRequest

@Configuration
class WebSecurityConfig : WebSecurityConfigurerAdapter() {
  @Throws(Exception::class)
  override fun configure(http: HttpSecurity) {
    http.headers().cacheControl()
    http.csrf().disable()
    http.requiresChannel()
      .requestMatchers(RequestMatcher { r: HttpServletRequest ->
        r.getHeader(
          "X-Forwarded-Proto"
        ) != null
      })
      .requiresSecure()
  }
}