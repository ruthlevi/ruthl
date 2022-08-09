package app.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.School;
import app.core.repository.SchoolRepository;

@Service
@Transactional
public class MyService {

	@Autowired
	private SchoolRepository schoolRepository;
	
	//fetch school (will also fetch address)
	public School getSchool(int id) {
		return schoolRepository.findById(id)
				.orElseThrow(()->new RuntimeException("school not exists"));
	}
	
	//save school (will also save address)
	public int createSchool(School school) {
		//in this level "school" object is detoughed
		if(schoolRepository.existsById(school.getId())) {
			throw new RuntimeException("school alresdy exists");
		}
		school = schoolRepository.save(school);
		//in this level "school" object is persistence
		return school.getId();
	}
	
	//update school (will also update address)
	public void updateSchool(School school) {
		if(schoolRepository.existsById(school.getId())) {
			school = schoolRepository.save(school);
		} else {
			throw new RuntimeException("school not exists");
		}
	}
	
	//delete school (will also delete address)
	public void deleteSchool(int id) {
		schoolRepository.deleteById(id);
	}
	
}
