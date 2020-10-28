package com.learning.ws.controller;

import java.util.Collection;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.learning.ws.model.UpdateRequest;
import com.learning.ws.model.UserRecord;
import com.learning.ws.model.Request.UserRecordRequest;
import com.learning.ws.userserv.UserService;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

	@Autowired
	UserService userService;

	@SuppressWarnings("rawtypes")
	// With Request Parameters
	// http://localhost:8080/users?page=1&limit=10
	// Above request is using Request parameters.
	// defaultValue is indirectly to make paramter optional.
	// required = false this option wont work for primitive data types
	@GetMapping
	public ResponseEntity<Collection> getUser(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "100") int limit,
			@RequestParam(value = "sort", required = false) Integer sort) {
		Collection<UserRecord> users = userService.getAllUsers();
		return sendResponse(users);

	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRecord> getUser(@PathVariable String userId) {
		UserRecord ur = userService.getSpecificUser(userId);
		return sendResponse(ur);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRecord> createUser(@Valid @RequestBody UserRecordRequest userRecord) {
		// Depandancy Injection
		UserRecord resp = userService.CreateUser(userRecord);
		return sendResponse(resp);
	}

	@PutMapping(path = "/{userId}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRecord> updateUser(@PathVariable String userId,
			@Valid @RequestBody UpdateRequest updtRequest) {

		UserRecord ur = userService.UpdateUser(userId, updtRequest);
		return sendResponse(ur);
	}

	@DeleteMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRecord> deleteUser(@PathVariable String userId) {
		UserRecord ur = userService.DeleteSpecificUser(userId);
		return sendResponse(ur);
	}

	private ResponseEntity<UserRecord> sendResponse(UserRecord ur) {
		if (ur != null) {
			return new ResponseEntity<UserRecord>(ur, HttpStatus.OK);
		} else {
			return new ResponseEntity<UserRecord>(HttpStatus.NO_CONTENT);
		}
	}

	@SuppressWarnings("rawtypes")
	private ResponseEntity<Collection> sendResponse(Collection<UserRecord> cur) {
		if (cur != null) {
			return new ResponseEntity<Collection>(cur, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

}
