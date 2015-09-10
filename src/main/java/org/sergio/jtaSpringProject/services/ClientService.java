package org.sergio.jtaSpringProject.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.sergio.jtaSpringProject.entities.Client;
import org.sergio.jtaSpringProject.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

	private static final Logger logger = Logger.getLogger(ClientService.class);
	
	@Autowired
	private ClientRepository clientRepository;
	
	public ClientService(){
		super();
	}
	
	public List<Client> getClients(){
		if(logger.isTraceEnabled()){
			logger.trace("getClients()");
		}
		return this.clientRepository.findAll();
	}
	
	public Client getClient(int id){
		if(logger.isTraceEnabled()){
			logger.trace("getClient()");
		}
		return this.clientRepository.findOne(id);
	}
	
	public void saveClient(Client client){
		if(logger.isTraceEnabled()){
			logger.trace("saveClient()");
		}
		this.clientRepository.save(client);
	}
	
	public void deleteClient(Client client){
		if(logger.isTraceEnabled()){
			logger.trace("deleteClient()");
		}
		this.clientRepository.delete(client);
	}
	
	public void deleteClientById(int id){
		if(logger.isTraceEnabled()){
			logger.trace("deleteClientById()");
		}
		this.clientRepository.delete(id);
	}
	
}
