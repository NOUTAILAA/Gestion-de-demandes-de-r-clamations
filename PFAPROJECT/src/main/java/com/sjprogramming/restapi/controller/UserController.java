
package com.sjprogramming.restapi.controller;


import java.util.List;

import com.sjprogramming.restapi.repository.UserRepository;
import com.sjprogramming.restapi.entity.User;

import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.sjprogramming.restapi.ResourceNotFoundException.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sjprogramming.restapi.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@CrossOrigin(origins = "*")
@RestController
 public class UserController{
	@Autowired
	UserRepository repo;
	@GetMapping("/users")
	public List<User> getAllUsers(){
		
		List<User> users = repo.findAll();
		return users;
	}
	
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id) {
		User user =repo.findById(id).get();
		return user;
	}
	
	
	@PostMapping("/users/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createUser(@RequestBody User user) {
		repo.save(user);
	}
	
	@PutMapping("/users/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User userDetails) {
	    User user = repo.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));

	    user.setNom(userDetails.getNom());
	    user.setPrenom(userDetails.getPrenom());
	    user.setMdp(userDetails.getMdp());
	    user.setRole(userDetails.getRole());
	    user.setTele(userDetails.getTele());
	    user.setEmail(userDetails.getEmail());
	    final User updatedUser = repo.save(user);
	    return ResponseEntity.ok(updatedUser);
	}
	
	
	@DeleteMapping("/users/delete/{id}")
	public void removeUser(@PathVariable int id) {
		
		User user =repo.findById(id).get();
		repo.delete(user);
	}
}
 
