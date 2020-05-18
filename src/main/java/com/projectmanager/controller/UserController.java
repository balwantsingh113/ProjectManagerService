/**
 * 
 */
package com.projectmanager.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectmanager.model.User;
import com.projectmanager.service.UserService;

/**
 * @author Balwant Singh
 *
 */

@CrossOrigin(
	    allowCredentials = "true",
	    origins = "*", 
	    allowedHeaders = "*", 
	    methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT}
	)
@RestController
@RequestMapping("/v1")
public class UserController {

	/** Initialize the LOGGER object */
	// private static final Log logger = LogFactory.getLog(UserService.class);

	@Autowired
	private UserService userService;

	@PostMapping(value = "/adduser", produces = MediaType.APPLICATION_JSON_VALUE)
	public User addUser(@Valid @RequestBody User user) {
		return userService.addUser(user);
	}

	@PostMapping(value = "/updateuser", produces = MediaType.APPLICATION_JSON_VALUE)
	public User updateUser(@Valid @RequestBody User user) {
		
		return userService.updateUser(user);
	}

	@GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getUsers() {
		
		List<User> userList = new ArrayList<User>();
		userList = userService.getUsers();
		return userList;
	}
	
	@GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUser(@PathVariable int id) {
		
		User user = new User();
		user = userService.getUser(id);
		return user;
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
	}

}
