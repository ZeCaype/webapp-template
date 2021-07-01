package com.example.restservice.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
public class WebSecurityConfig {

  @Configuration
  public static class ApiConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.cors().and().csrf().disable().sessionManagement()
          .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
          .and().authorizeRequests()
          .antMatchers("/**")
          .permitAll();
    }
    
  }
}
