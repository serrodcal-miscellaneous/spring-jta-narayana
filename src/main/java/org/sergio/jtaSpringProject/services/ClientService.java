package org.sergio.jtaSpringProject.services;

import java.util.List;

import org.sergio.jtaSpringProject.entities.Client;
import org.sergio.jtaSpringProject.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	public ClientService(){
		super();
	}
	
	public List<Client> getClients(){
		return this.clientRepository.findAll();
	}
	
	public Client getClient(int id){
		return this.clientRepository.findOne(id);
	}
	
	public void saveClient(Client client){
		this.clientRepository.save(client);
	}
	
	public void deleteClient(Client client){
		this.clientRepository.delete(client);
	}
	
	public void deleteClientById(int id){
		this.clientRepository.delete(id);
	}
	
}
