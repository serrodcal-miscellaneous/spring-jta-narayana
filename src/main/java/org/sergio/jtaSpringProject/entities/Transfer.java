package org.sergio.jtaSpringProject.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Transfer {

	private int id;
	
	private Date date;
	
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

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
	
}
