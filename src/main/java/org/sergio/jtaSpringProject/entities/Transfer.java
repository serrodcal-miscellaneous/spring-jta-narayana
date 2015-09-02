package org.sergio.jtaSpringProject.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Transfer {

	private int id;
	
	private Date date;
	
	private String concept;
	
	private Double amount;
	
	private Client originClient;
	
	private Client targetClient;
	
	public Transfer(){
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(nullable = false)
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

	@ManyToOne
	public Client getOriginClient() {
		return originClient;
	}

	public void setOriginClient(Client originClient) {
		this.originClient = originClient;
	}

	@ManyToOne
	public Client getTargetClient() {
		return targetClient;
	}

	public void setTargetClient(Client targetClient) {
		this.targetClient = targetClient;
	}
	
	@PrePersist
	public void setTimeStamp(){
		this.date = new Date();
	}
	
	//Bussiness model method
	
	public void makeTransfer() throws Exception{
		this.originClient.subAmount(this.amount);
		this.targetClient.sumAmount(this.amount);

	}
	
}
