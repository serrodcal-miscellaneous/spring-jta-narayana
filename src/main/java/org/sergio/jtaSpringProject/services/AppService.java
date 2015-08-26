package org.sergio.jtaSpringProject.services;

import javax.transaction.Transactional;

import org.sergio.jtaSpringProject.entities.Animal;
import org.sergio.jtaSpringProject.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;

@Service
public class AppService {

	@Autowired
	private PersonService personService;
	
	@Autowired
	private AnimalService animalService;
	
	public AppService() {
		super();
	}
	
	@org.springframework.transaction.annotation.Transactional
	public void createPersonAndAnimal(Person person, Animal animal){
		this.personService.createPerson(person);
		this.animalService.createAnimal(animal);
	}
	
}
