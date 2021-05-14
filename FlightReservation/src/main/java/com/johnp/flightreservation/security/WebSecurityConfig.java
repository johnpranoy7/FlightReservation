package com.johnp.flightreservation.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder getBCryptBean() {
		return new BCryptPasswordEncoder();
	}

	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	public void configure(HttpSecurity security) throws Exception {
		security.authorizeRequests()
				.antMatchers("/showFLights", "/", "/index.html", "/validatelogin", "/saveUser", "/showreg", "/login",
						"/reservation/*")
				.permitAll().antMatchers("/admin/addFlight").hasAnyAuthority("ADMIN").anyRequest().authenticated().and()
				.csrf().disable();
	}
}
