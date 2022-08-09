package app.core.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.core.entities.Employee;

@Component
public class EmployeeDAOImpl implements EmployeeDAO{

	@Autowired
	private EntityManagerFactory factory;
	
	@Override
	public int create(Employee employee) {
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin(); //start a transaction
			em.persist(employee); // employee is now persist (instead of detached)
			em.getTransaction().commit();
			return employee.getId();
		} catch (RuntimeException e) {
			em.getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public Employee find(int id) {
		EntityManager em = factory.createEntityManager();
		return em.find(Employee.class, id);
	}

	@Override
	public void update(Employee e) {
		EntityManager em = factory.createEntityManager(); 
		Employee employeeFromDB = em.find(Employee.class, e.getId());
		if(employeeFromDB != null) {
			em.getTransaction().begin();
			try {
//				employeeFromDB.setName(e.getName());
//				employeeFromDB.setBirthdate(e.getBirthdate());
				e = em.merge(e);
//				em.persist(e); //persist - will update the exiting entity (in case there is no such entity -> will create it)  
				em.getTransaction().commit();
			} catch (Exception ex) {
				em.getTransaction().rollback();
			}
		} else {
			throw new RuntimeException("update failed - not found");
		}
	}

	@Override
	public void delete(int id) {
		EntityManager em = factory.createEntityManager(); 
		Employee e = em.find(Employee.class, id);
		if(e != null) {
			em.getTransaction().begin();
			em.remove(e);
			em.getTransaction().commit();
		} else {
			throw new RuntimeException("remove failed - not found");
		}
		
	}

}
