package app.core.dao;

import app.core.entities.Employee;

public interface EmployeeDAO {

	int create(Employee employee);
	
	Employee find(int id);
	
	void update(Employee e);
	
	void delete(int id);
}
