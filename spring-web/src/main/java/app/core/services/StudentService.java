package app.core.services;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	public int addStudent() {
		return 1;
	}
	
	public String getStudent(int id) {
		return "student; " + id;
	}
	
	public String updateStudent() {
		return "student updated";
	}
	
	public String deleteStudent() {
		return "student deleted";
	}
}
