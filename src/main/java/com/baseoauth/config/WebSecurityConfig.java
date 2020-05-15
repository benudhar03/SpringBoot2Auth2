package com.baseoauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	protected AuthenticationManager getAuthenticationManager() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	 
    @Bean
	public CorsFilter corsFilterBean() throws Exception {
    	CorsFilter corsFilter = new CorsFilter();
		return corsFilter;
	}
    @Bean
    public OAuth2AuthenticationEntryPoint clientAuthenticationEntryPoint(){
    	OAuth2AuthenticationEntryPoint unauthorizedEntry = new OAuth2AuthenticationEntryPoint();
    	return unauthorizedEntry;
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		 .anonymous().disable()
	        .exceptionHandling().authenticationEntryPoint(clientAuthenticationEntryPoint()).and()
			// don't create session
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			//.and().authorizeRequests().antMatchers(HttpMethod.OPTIONS,"/oauth/token","/oauth/token/").permitAll()
			.and().authorizeRequests().antMatchers("/admin-rest/api/**").permitAll()
	        .and().authorizeRequests().antMatchers("/api/**","/member/**").authenticated()
	        .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler())
	        .and().addFilterBefore(corsFilterBean(), ChannelProcessingFilter.class);
	}	
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/admin-rest/api/**")
        .antMatchers("/baseAuth2Web/**");
    }
	
	
}
