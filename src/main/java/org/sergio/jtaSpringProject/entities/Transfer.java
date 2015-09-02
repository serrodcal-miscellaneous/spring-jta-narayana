package org.sergio.jtaSpringProject.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.log4j.Logger;

@Entity
public class Transfer {

	private static final Logger logger = Logger.getLogger(Transfer.class);
	
	private int id;
	
	private Date date;
	
	private String concept;
	
	private Double amount;
	
	private List<Client> clients;
	
	public Transfer(){
		super();
		if(logger.isTraceEnabled())
			logger.trace("Create transfer");
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column
	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	@Column(precision=10, scale=2)
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	@PrePersist
	public void setTimeStamp(){
		this.date = new Date();
	}
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	//Bussiness model method
	
	public void makeTransfer() throws Exception{
		if(logger.isTraceEnabled())
			logger.trace("makeTransfer()");
		this.clients.get(0).subAmount(this.amount);
		this.clients.get(1).sumAmount(this.amount);
	}

	@Override
	public String toString() {
		return "Transfer [id=" + id + ", date=" + date + ", concept=" + concept + ", amount=" + amount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((clients == null) ? 0 : clients.hashCode());
		result = prime * result + ((concept == null) ? 0 : concept.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
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
		Transfer other = (Transfer) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (clients == null) {
			if (other.clients != null)
				return false;
		} else if (!clients.equals(other.clients))
			return false;
		if (concept == null) {
			if (other.concept != null)
				return false;
		} else if (!concept.equals(other.concept))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	
	
}
