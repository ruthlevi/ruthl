package app.core.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.core.entities.Adress;
import app.core.entities.School;
import app.core.services.MyService;

//@Component
public class App1 implements CommandLineRunner{

	@Autowired
	private MyService service;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			//doCreateNewSchool();
			//doGetSchool(3);
			doUpdateSchool();
		} catch (Exception e) {
			System.out.println("===ERROR===: " + e.getMessage());
		}
		
	}

	private void doUpdateSchool() {
		School school = service.getSchool(1);
		school.setName("NewSchool");
		school.getAdress().setStreet("myStreet1");
		service.updateSchool(school);
		
	}

	private void doCreateNewSchool() {
		Adress adress = new Adress(0, 4, "myStreet2", "Jerusalem", "Israel", null);
		School school = new School(0, "mySchool2", adress);
		service.createSchool(school);
	}
	
	private void doGetSchool(int id) {
		School school = service.getSchool(id);
		System.out.println(school);
	}

	
}
