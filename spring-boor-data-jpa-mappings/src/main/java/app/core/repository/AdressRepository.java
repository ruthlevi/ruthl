package app.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Adress;
import app.core.entities.School;

public interface AdressRepository extends JpaRepository<Adress, Integer>{

}
