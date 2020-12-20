package application.bean;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author ADNAN <ADNAN.E@TUTANOTA.DE>
 **/
@Entity
@Cacheable(false)
public class Review implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;
	//the % will be calculated based on the stars for the user (1 - 5)
	private Double star;
	private String description;
	@ManyToOne
	private Trainer trainerId;
	@ManyToOne
	private Customer customerId;
	public Review() {
		super();
	}
	public Review(Integer id, Double star, String description, Trainer trainerId, Customer customerId) {
		super();
		this.id = id;
		this.star = star;
		this.description = description;
		this.trainerId = trainerId;
		this.customerId = customerId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getStar() {
		return star;
	}
	public void setStar(Double star) {
		this.star = star;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Trainer getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(Trainer trainerId) {
		this.trainerId = trainerId;
	}
	public Customer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}



}
