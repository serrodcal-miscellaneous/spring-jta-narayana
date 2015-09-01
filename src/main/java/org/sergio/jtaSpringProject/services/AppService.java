package org.sergio.jtaSpringProject.services;

import org.sergio.jtaSpringProject.entities.Animal;
import org.sergio.jtaSpringProject.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppService {

	@Autowired
	private PersonService personService;
	
	@Autowired
	private AnimalService animalService;
	
	public AppService() {
		super();
	}
	
	@Transactional
	public void createPersonAndAnimal(Person person, Animal animal){
		this.personService.createPerson(person);
		this.animalService.createAnimal(animal);
	}
	
}
