package org.sergio.jtaSpringProject.repositories;

import java.util.List;

import org.sergio.jtaSpringProject.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
}
