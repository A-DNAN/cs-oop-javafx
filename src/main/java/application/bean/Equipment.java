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
public class Equipment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	@ManyToOne
	private Hall hallId; 
	@ManyToMany
	private List<Exercice> exercices;
	@ManyToMany
	private List<AvailabilityTimetable> availabilityTimetables;
	public Equipment() {
		super();
	}
	public Equipment(Integer id, String name, Hall hallId, List<Exercice> exercices,
			List<AvailabilityTimetable> availabilityTimetables) {
		super();
		this.id = id;
		this.name = name;
		this.hallId = hallId;
		this.exercices = exercices;
		this.availabilityTimetables = availabilityTimetables;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Hall getHallId() {
		return hallId;
	}
	public void setHallId(Hall hallId) {
		this.hallId = hallId;
	}
	public List<Exercice> getExercices() {
		return exercices;
	}
	public void setExercices(List<Exercice> exercices) {
		this.exercices = exercices;
	}
	public List<AvailabilityTimetable> getAvailabilityTimetables() {
		return availabilityTimetables;
	}
	public void setAvailabilityTimetables(List<AvailabilityTimetable> availabilityTimetables) {
		this.availabilityTimetables = availabilityTimetables;
	}
	@Override
	public String toString() {
		return name;}
	
    
    
    
    
    
}
