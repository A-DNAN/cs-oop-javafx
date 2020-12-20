package application.bean;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
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
public class Subscription implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	private Membership membershipId;
	private String type;
	private String startDate;
	@ManyToOne
	private Trainer responsibleTrainer;
	
	@ManyToOne
	private Hall hallId;

	public Subscription() {
		super();
	}

	public Subscription(Integer id, Membership membershipId, String type, String startDate, Trainer responsibleTrainer,
			Hall hallId) {
		super();
		this.id = id;
		this.membershipId = membershipId;
		this.type = type;
		this.startDate = startDate;
		this.responsibleTrainer = responsibleTrainer;
		this.hallId = hallId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Membership getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(Membership membershipId) {
		this.membershipId = membershipId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public Trainer getResponsibleTrainer() {
		return responsibleTrainer;
	}

	public void setResponsibleTrainer(Trainer responsibleTrainer) {
		this.responsibleTrainer = responsibleTrainer;
	}

	public Hall getHallId() {
		return hallId;
	}

	public void setHallId(Hall hallId) {
		this.hallId = hallId;
	}
		
	
	
}
