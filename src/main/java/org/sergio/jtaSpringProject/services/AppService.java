package org.sergio.jtaSpringProject.services;

import org.apache.log4j.Logger;
import org.sergio.jtaSpringProject.entities.Client;
import org.sergio.jtaSpringProject.entities.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppService {

	private static final Logger logger = Logger.getLogger(AppService.class);
	
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
		if(logger.isDebugEnabled()){
			logger.debug("Begin transfer");
		}
		transfer.makeTransfer();
		this.transferService.saveTransfer(transfer);
		if(logger.isDebugEnabled()){
			logger.debug("Complete transfer");
		}
	}
	
}
