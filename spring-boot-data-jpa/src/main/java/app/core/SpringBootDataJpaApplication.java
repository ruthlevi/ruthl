package app.core;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.dao.EmployeeDAO;
import app.core.entities.Employee;

@SpringBootApplication
public class SpringBootDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootDataJpaApplication.class, args);
		
	}

}
