package com.cg.details.UserCrud;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
/*
 * @ComponentScan(basePackages =
 * {"com.cg.details.UserCrud.CustomUserDetailsService"})
 */
public class AuthApplication /* implements CommandLineRunner */ {
	
	/*
	 * @Autowired private UserRepository repo;
	 * 
	 * @Autowired private PasswordEncoder passwordEncoder;
	 */
	 
	


	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

	
	/*
	 * @Override public void run(String... args) throws Exception { String
	 * encodedpassword = passwordEncoder.encode("123"); User1 user1 = new User1();
	 * user1.setId(1); user1.setUsername("Yogeesh"); user1.setRoles("ROLE_ADMIN");
	 * user1.setPassword(encodedpassword); repo.save(user1);
	 * 
	 * String encodedpassword1 = passwordEncoder.encode("123"); User1 user = new
	 * User1(); user.setId(1); user.setUsername("Swamy");
	 * user.setRoles("ROLE_USER"); user.setPassword(encodedpassword1);
	 * repo.save(user);
	 * 
	 * }
	 */
	 



}
