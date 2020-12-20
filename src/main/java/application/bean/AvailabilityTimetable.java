package application.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * @author ADNAN <ADNAN.E@TUTANOTA.DE>
 **/

@Entity
@Cacheable(false)
public class AvailabilityTimetable implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;
	private String startHour;
	private String endHour;
	@ManyToMany(mappedBy = "availabilityTimetables")
	private List<Trainer> trainers;
	@ManyToMany(mappedBy = "availabilityTimetables")
	private List<Equipment> equipments;
	@ManyToMany(mappedBy = "availabilityTimetables")
	private List<Hall> halls;
	
	
	public AvailabilityTimetable() {
		super();
	}
	public AvailabilityTimetable(Integer id, String startHour, String endHour, List<Trainer> trainers,
			List<Equipment> equipments, List<Hall> halls) {
		this.id = id;
		this.startHour = startHour;
		this.endHour = endHour;
		this.trainers = trainers;
		this.equipments = equipments;
		this.halls = halls;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getStartHour() {
		return startHour;
	}
	public void setStartHour(String startHour) {
		this.startHour = startHour;
	}
	public String getEndHour() {
		return endHour;
	}
	public void setEndHour(String endHour) {
		this.endHour = endHour;
	}
	public List<Trainer> getTrainers() {
		return trainers;
	}
	public void setTrainers(List<Trainer> trainers) {
		this.trainers = trainers;
	}
	public List<Equipment> getEquipments() {
		return equipments;
	}
	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}
	public List<Hall> getHalls() {
		return halls;
	}
	public void setHalls(List<Hall> halls) {
		this.halls = halls;
	}
	@Override
	public String toString() {
		return "From: " + startHour + " - To: " + endHour ;
	}

	
	
	
	
}
