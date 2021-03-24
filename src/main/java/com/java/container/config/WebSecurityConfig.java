package com.java.container.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().disable();
        /*http.csrf().disable();
        //Permit login 
        http.authorizeRequests().antMatchers("/","/list" ,"/register", "/login", "/saveUser").permitAll();
        
        super.configure(http);*/
 
    }
}
