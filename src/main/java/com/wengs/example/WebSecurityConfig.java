package com.wengs.example;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf()
				.disable()
				.headers()
				.addHeaderWriter(
						new XFrameOptionsHeaderWriter(
								XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
				.and().authorizeRequests()
				.antMatchers("/**")
				.permitAll()

				.anyRequest().authenticated().and().anonymous();
	}
}
