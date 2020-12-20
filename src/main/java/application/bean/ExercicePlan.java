package application.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * @author ADNAN <ADNAN.E@TUTANOTA.DE>
 **/
@Entity
@Cacheable(false)
public class ExercicePlan implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String title;
	private String description;
	@ManyToOne
	private Exercice exerciceId;
	@ManyToOne
	private Trainer trainerId;
	@ManyToMany
	private List<Customer> customers;
	public ExercicePlan() {
		super();
	}
	public ExercicePlan( String title, String description, Exercice exerciceId, Trainer trainerId
			) {
		super();
		this.title = title;
		this.description = description;
		this.exerciceId = exerciceId;
		this.trainerId = trainerId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Exercice getExerciceId() {
		return exerciceId;
	}
	public void setExerciceId(Exercice exerciceId) {
		this.exerciceId = exerciceId;
	}
	public Trainer getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(Trainer trainerId) {
		this.trainerId = trainerId;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	@Override
	public String toString() {
		return title;
	}
	
	
	
}
