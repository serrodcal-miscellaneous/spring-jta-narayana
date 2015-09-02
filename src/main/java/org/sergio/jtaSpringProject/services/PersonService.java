package org.sergio.jtaSpringProject.services;

import java.util.List;

import org.sergio.jtaSpringProject.entities.Person;
import org.sergio.jtaSpringProject.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;

	public PersonService() {
		super();
	}
	
	//@Transactional
	public Person getPerson(Long id){
		return this.repository.findOne(id);
	}
	
	//@Transactional
	public List<Person> getAllPersons(){
		return (List<Person>) this.repository.findAll();
	}
	
	//@Transactional
	public Person createPerson(Person person){
		return this.repository.save(person);
	}
	
	//@Transactional
	public void updatePerson(Person person){
		this.createPerson(person);
	}
	
	//@Transactional
	public void deletePerson(Long id){
		this.repository.delete(id);
	}
	
}
