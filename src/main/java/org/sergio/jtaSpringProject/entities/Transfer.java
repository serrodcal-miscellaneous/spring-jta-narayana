package org.sergio.jtaSpringProject.entities;

import java.util.Date;

import javax.persistence.CascadeType;
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

	@ManyToOne(cascade = { CascadeType.ALL })
	public Client getOriginClient() {
		return originClient;
	}

	public void setOriginClient(Client originClient) {
		this.originClient = originClient;
	}

	@ManyToOne(cascade = { CascadeType.ALL })
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

	@Override
	public String toString() {
		return "Transfer [id=" + id + ", date=" + date + ", concept=" + concept + ", amount=" + amount
				+ ", originClient=" + originClient + ", targetClient=" + targetClient + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((concept == null) ? 0 : concept.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		result = prime * result + ((originClient == null) ? 0 : originClient.hashCode());
		result = prime * result + ((targetClient == null) ? 0 : targetClient.hashCode());
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
		if (originClient == null) {
			if (other.originClient != null)
				return false;
		} else if (!originClient.equals(other.originClient))
			return false;
		if (targetClient == null) {
			if (other.targetClient != null)
				return false;
		} else if (!targetClient.equals(other.targetClient))
			return false;
		return true;
	}
	
}
