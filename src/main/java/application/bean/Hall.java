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
import javax.persistence.OneToMany;

/**
 * @author ADNAN <ADNAN.E@TUTANOTA.DE>
 **/

@Entity
@Cacheable(false)
public class Hall implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	@OneToMany(mappedBy = "hallId")
	private List<Equipment> equipments; 
    @ManyToMany
	private List<AvailabilityTimetable> availabilityTimetables;
    @OneToMany(mappedBy = "hallId")
    private List<Subscription> subscriptions;
	
    public Hall() {
		super();
	}
	public Hall(Integer id, String name, List<Equipment> equipments, List<AvailabilityTimetable> availabilityTimetables,
			List<Subscription> subscriptions) {
		super();
		this.id = id;
		this.name = name;
		this.equipments = equipments;
		this.availabilityTimetables = availabilityTimetables;
		this.subscriptions = subscriptions;
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
	public List<Equipment> getEquipments() {
		return equipments;
	}
	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}
	
	public List<AvailabilityTimetable> getAvailabilityTimetables() {
		return availabilityTimetables;
	}
	public void setAvailabilityTimetables(List<AvailabilityTimetable> availabilityTimetables) {
		this.availabilityTimetables = availabilityTimetables;
	}
	public List<Subscription> getSubscriptions() {
		return subscriptions;
	}
	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}
	@Override
	public String toString() {
		return name;
	}
    
	
	
    
    
}
