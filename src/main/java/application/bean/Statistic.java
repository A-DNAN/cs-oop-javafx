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
public class Statistic implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	private Trainer trainerId;
    //Month/Year
	private String month;
    private Double workingHours;
	public Statistic() {
		super();
	}
	public Statistic(Integer id, Trainer trainerId, String month, Double workingHours) {
		super();
		this.id = id;
		this.trainerId = trainerId;
		this.month = month;
		this.workingHours = workingHours;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Trainer getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(Trainer trainerId) {
		this.trainerId = trainerId;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Double getWorkingHours() {
		return workingHours;
	}
	public void setWorkingHours(Double workingHours) {
		this.workingHours = workingHours;
	}
	
    
    
}
