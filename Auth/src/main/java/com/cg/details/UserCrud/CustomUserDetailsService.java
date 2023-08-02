package com.cg.details.UserCrud;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService{	

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	@Lazy
	private PasswordEncoder passwordEncoder;
	
	 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User1 user = userRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("Username not found for user: "+username);
		}
		
		return new CustomUserDetail(user);
		/*
		 * return new User( user.getUsername(), user.getPassword(),
		 * getAuthorities(user.getRoles())
		 * 
		 * );
		 */
				
	}
	
	public List<User1> getAllUser(){
		return userRepository.findAll();
	}
	
	public User1 getByid(int id) {
		return userRepository.findById(id).get();
	}
	
	public User1 addUser(User1 user) {
		String encodedPassword =passwordEncoder.encode(user.getPassword());
		User1 user1 = new User1();
		user1.setId(user.getId());
		user1.setUsername(user.getUsername());
		user1.setPassword(encodedPassword);
		return userRepository.save(user1);
	}
	
	public User1 updateUser(int id,User1 user) {
		User1 user2 = userRepository.findById(id).get();
		String encodedPassword =passwordEncoder.encode(user.getPassword());
		user2.setId(user.getId());
		user2.setUsername(user.getUsername());
		user2.setPassword(encodedPassword);
		user2.setRoles(user.getRoles());
		userRepository.save(user2);
		return user2;
	}
	
	public String deleteuser(int id) {
		User1 u = userRepository.findById(id).get();
		userRepository.delete(u);
		return "User Deleted Successfully";
	}
	


}
