package org.sergio.jtaSpringProject.repositories;

import org.sergio.jtaSpringProject.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
	
}
