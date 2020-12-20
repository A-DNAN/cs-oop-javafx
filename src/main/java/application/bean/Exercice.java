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
public class Exercice implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String type;
	@OneToMany(mappedBy = "exerciceId")
	private List<ExercicePlan> exercicePlans;
	@ManyToMany(mappedBy = "exercices")
	private List<Equipment> equipments;
	public Exercice() {
		super();
	}
	public Exercice(Integer id, String type, List<ExercicePlan> exercicePlans, List<Equipment> equipments) {
		super();
		this.id = id;
		this.type = type;
		this.exercicePlans = exercicePlans;
		this.equipments = equipments;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<ExercicePlan> getExercicePlans() {
		return exercicePlans;
	}
	public void setExercicePlans(List<ExercicePlan> exercicePlans) {
		this.exercicePlans = exercicePlans;
	}
	public List<Equipment> getEquipments() {
		return equipments;
	}
	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}
	@Override
	public String toString() {
		return type ;
	}
	

	
	
}
