package com.mohanty.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableJpaRepositories(basePackages="com.mohanty.repository")
@ComponentScan(basePackages="com.mohanty")
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class AppConfig extends WebSecurityConfigurerAdapter {

	// Authentication
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       
		auth.inMemoryAuthentication()
		.withUser("foo").password("foo")
		.roles("ADMIN")
		.and()
		.withUser("bar").password("bar")
		.roles("USER");
	
	}

	//Authorization
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

	//	http.csrf().disable();
		
		http.authorizeRequests()
		.antMatchers("**/secured/**").authenticated()
		.antMatchers("/h2_console/**").permitAll()
		.anyRequest().permitAll()
		.and()
        .headers().frameOptions().disable()
        .and()
        .csrf().ignoringAntMatchers("/h2-console/**")
		.and()
		.formLogin().permitAll();
	}

	//Password Authentication
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
