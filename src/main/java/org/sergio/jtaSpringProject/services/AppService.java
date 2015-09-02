package org.sergio.jtaSpringProject.services;

import org.sergio.jtaSpringProject.entities.Animal;
import org.sergio.jtaSpringProject.entities.Client;
import org.sergio.jtaSpringProject.entities.Person;
import org.sergio.jtaSpringProject.entities.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppService {

	@Autowired
	private ClientService clientService;
	
	@Autowired
	private TransferService transferService;
	
	public AppService() {
		super();
	}
	
	@Transactional
	public void createClient(Client client){
		this.clientService.saveClient(client);
	}
	
	@Transactional
	public void makeTransfer(Transfer transfer) throws Exception{
		transfer.makeTransfer();
		this.transferService.saveTransfer(transfer);
	}
	
}
