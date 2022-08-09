package app.core.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.core.entities.School;
import app.core.services.MyService;

@CrossOrigin
@RestController
@RequestMapping("/api/school")
public class MyController {

	@Autowired
	private MyService service;
	
	@PostMapping
	private int createSchool(@RequestBody School school) {
		return service.createSchool(school);
	}
	
	//http://localhost:8080/api/school?id=1
	@GetMapping
	private School getSchool(@RequestParam int id) {
		try {
			return service.getSchool(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
		
	}
	
	@PutMapping
	private void updateSchool(@RequestBody School school) {
		service.updateSchool(school);	
	}
	
	//http://localhost:8080/api/school/1
	@DeleteMapping("/{id}")
	private void deleteSchool(@PathVariable int id) {
		service.deleteSchool(id);
	}
}
