package org.sergio.jtaSpringProject.entities;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.apache.log4j.Logger;
import org.sergio.jtaSpringProject.App;

@Entity
public class Client {

	private static final Logger logger = Logger.getLogger(Client.class);
	
	private int id;
	
	private String name;
	
	private Double balance;
	
	private List<Transfer> transfers;
	
	public Client(){
		super();
		if(logger.isTraceEnabled()){
			logger.trace("Client()");
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		if(logger.isTraceEnabled()){
			logger.trace("getId()");
		}
		return id;
	}

	public void setId(int id) {
		if(logger.isTraceEnabled()){
			logger.trace("setId(int id)");
		}
		this.id = id;
	}

	@Column
	public String getName() {
		if(logger.isTraceEnabled()){
			logger.trace("getName()");
		}
		return name;
	}

	public void setName(String name) {
		if(logger.isTraceEnabled()){
			logger.trace("setName(String name)");
		}
		this.name = name;
	}

	@Column(precision=10, scale=2)
	public Double getBalance() {
		if(logger.isTraceEnabled()){
			logger.trace("getBalance()");
		}
		return balance;
	}
	
	public void setBalance(Double balance) {
		if(logger.isTraceEnabled()){
			logger.trace("setBalance(Double balance)");
		}
		this.balance = balance;
	}

	@ManyToMany(mappedBy = "clients")
	public List<Transfer> getTransfers() {
		if(logger.isTraceEnabled()){
			logger.trace("getTransfers()");
		}
		return transfers;
	}

	public void setTransfers(List<Transfer> transfers) {
		if(logger.isTraceEnabled()){
			logger.trace("setTransfers(List<Transfer> transfers)");
		}
		this.transfers = transfers;
	}
	
	//Bussines model methods
	
	public void sumAmount(Double amount) throws Exception{
		if(logger.isTraceEnabled())
			logger.trace("sumAmount(Double amount)");
		try{
			this.balance += amount;
		}catch(Exception e){
			logger.error("sumAmount Error");
			throw new Exception("Operation error: sum");
		}
	}
	
	public void subAmount(Double amount) throws Exception{
		if(logger.isTraceEnabled())
			logger.trace("subAmount(Double amount)");
		if(this.balance >= amount){
			this.balance -= amount;
		}else{
			logger.error("subAmount Error");
			throw new Exception("Operation error: sub");
		}
	}

	@Override
	public String toString() {
		if(logger.isTraceEnabled())
			logger.trace("toString()");
		return "Client [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((transfers == null) ? 0 : transfers.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (transfers == null) {
			if (other.transfers != null)
				return false;
		} else if (!transfers.equals(other.transfers))
			return false;
		return true;
	}
	
}
