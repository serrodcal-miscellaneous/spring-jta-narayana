package org.sergio.jtaSpringProject.repositories;

import org.sergio.jtaSpringProject.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
	
}
