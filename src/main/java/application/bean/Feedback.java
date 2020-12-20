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
public class Feedback implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;
	private String message;
	@ManyToOne
	private Manager managerId;
	@ManyToOne
	private Trainer trainerId;
	@ManyToOne
	private Customer customerId;
	public Feedback() {
		super();
	}
	public Feedback(Integer id, String message, Manager managerId, Customer customerId) {
		super();
		this.id = id;
		this.message = message;
		this.managerId = managerId;
		this.customerId = customerId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Manager getManagerId() {
		return managerId;
	}
	public void setManagerId(Manager managerId) {
		this.managerId = managerId;
	}
	public Customer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}
	public Trainer getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(Trainer trainerId) {
		this.trainerId = trainerId;
	}
	
	
	
	
}
