package app.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.core.services.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public void addStudent() {
		int id = studentService.addStudent();
		System.out.println("student id: " + id);
	}
	
	@GetMapping
	public String getStudent() {
		return studentService.getStudent(1);
	}
	
	@PutMapping
	public void updateStudent() {
		studentService.updateStudent();
	}
	
	@DeleteMapping
	public void deleteStudent() {
		studentService.deleteStudent();
	}
	
}
