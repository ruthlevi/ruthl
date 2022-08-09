package app.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import app.core.dao.EmployeeDAO;
import app.core.entities.Employee;

//@Component
public class App1 implements CommandLineRunner {

	@Autowired
	EmployeeDAO dao;
	
	@Override
	public void run(String... args) throws Exception {
		
		{ //CREATE
//			Employee e = new Employee();
//			e.setName("Sara");
//			e.setBirthdate(LocalDate.of(1995, 10, 07));
//			int id = dao.create(e);
//			System.out.println("id is: " + e.getId());
//			System.out.println("added: " + e);
		}
		
		{ //FIND
//			Employee e2 = dao.find(1);
//			System.out.println("Employee: " + e2);
		}
		
		{ //UPDATE
			Employee e3 = dao.find(2);
			e3.setName("Moshe");
			dao.update(e3);
//			System.out.println("Employee: " + e2);
		}
	
		{//REMOVE
			dao.delete(2);
			
		}
		
	}

	
}
