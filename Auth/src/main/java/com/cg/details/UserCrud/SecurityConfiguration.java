package com.cg.details.UserCrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
	return http.csrf().disable()
			.authorizeHttpRequests()
			.requestMatchers("/swagger-ui/**","/v3/api-docs/**","/home/addnew").permitAll()
			.requestMatchers("/home/public","/home/get/{id}").hasRole("USER")
			.requestMatchers("/home/get","/home/delete/{id}","/home/update/{id}").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.and()
			.build();
	}
	
	
	
	/*
	 * @Bean
	 * 
	 * @Qualifier("passwordEncoder") public PasswordEncoder passwordEncoder() {
	 * return new BCryptPasswordEncoder(); }
	 */
	  
	  @Bean
	  public PasswordEncoder passwordEncoder() { 
		  return new BCryptPasswordEncoder(); 
		  }
	 
	
	/*
	 * @Bean public UserDetailsService userDetailsService() {
	 * 
	 * 
	 * UserDetails user1 = User.withUsername("Yogi")
	 * .password(passwordEncoder().encode("pas1")) .roles("USER") .build();
	 * 
	 * UserDetails user2 = User.withUsername("Swamy")
	 * .password(passwordEncoder().encode("pas2")) .roles("ADMIN") .build();
	 * 
	 * return new InMemoryUserDetailsManager(user1,user2);
	 * 
	 * }
	 */
	
	
	
	  @Bean public DaoAuthenticationProvider daoAuthenticationProvider() {
	  DaoAuthenticationProvider provider =new DaoAuthenticationProvider();
	  provider.setUserDetailsService(customUserDetailsService);
	  provider.setPasswordEncoder(passwordEncoder());
	  
	  return provider; }
	 

	

}
