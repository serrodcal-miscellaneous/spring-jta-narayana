package org.sergio.jtaSpringProject.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.sergio.jtaSpringProject.entities.Transfer;
import org.sergio.jtaSpringProject.repositories.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

	private static final Logger logger = Logger.getLogger(TransferService.class);
	
	@Autowired
	private TransferRepository transferRepository;
	
	public TransferService(){
		super();
	}
	
	public List<Transfer> getTransfers(){
		return this.transferRepository.findAll();
	}
	
	public Transfer getTransfer(int id){
		return this.transferRepository.findOne(id);
	}
	
	public void saveTransfer(Transfer transfer){
		this.transferRepository.save(transfer);
	}
	
	public void deleteTransfer(Transfer transfer){
		this.transferRepository.delete(transfer);
	}
	
	public void deleteTransferById(int id){
		this.transferRepository.delete(id);
	}
	
}
