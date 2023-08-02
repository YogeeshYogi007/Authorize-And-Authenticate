package com.cg.details.UserCrud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/home")
public class Controller {
	
	@Autowired
	private CustomUserDetailsService service;
	
	@GetMapping(value="/public")
	public ResponseEntity<String> publicUser(){
		return ResponseEntity.ok("iam a public user");
	}
	
	@PostMapping(value="/addnew")
	public ResponseEntity<User1> addUser(@RequestBody User1 user){
		return ResponseEntity.ok(service.addUser(user));
	}

	@GetMapping(value="/get")
	public ResponseEntity<List<User1>> getAllUser(){
		return ResponseEntity.ok(service.getAllUser());
	}
	
	@GetMapping(value="/get/{id}")
	public ResponseEntity<User1> getByid(@PathVariable int id){
		return ResponseEntity.ok(service.getByid(id));
	}
	
	@PutMapping(value="/update/{id}")
	public ResponseEntity<User1> updateUser(@PathVariable int id, @RequestBody User1 user){
		return ResponseEntity.ok(service.updateUser(id, user));
	}
	

	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id){
		 return ResponseEntity.ok(service.deleteuser(id));
	}
}
