package org.sergio.jtaSpringProject.services;

import java.util.List;

import javax.transaction.Transactional;

import org.sergio.jtaSpringProject.entities.Animal;
import org.sergio.jtaSpringProject.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Service
public class AnimalService {

	@Autowired
	private AnimalRepository repository;

	public AnimalService() {
		super();
	}
	
	//@Transactional
	public Animal getAnimal(Long id){
		return this.repository.findOne(id);
	}
	
	//@Transactional
	public List<Animal> getAllAnimals(){
		return (List<Animal>) this.repository.findAll();
	}
	
	//@Transactional
	public Animal createAnimal(Animal animal){
		return this.repository.save(animal);
	}
	
	//@Transactional
	public void updateAnimal(Animal animal){
		this.createAnimal(animal);
	}
	
	//@Transactional
	public void deleteAnimal(Long id){
		this.repository.delete(id);
	}
	
}
