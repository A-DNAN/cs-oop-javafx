package application.bean;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * @author ADNAN <ADNAN.E@TUTANOTA.DE>
 **/
@Entity
@Cacheable(false)
public class Manager extends Profile{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy = "managerId")
	List<Feedback> feedbacks;
	public Manager() {
		super();
	}
	public Manager(List<Feedback> feedbacks) {
		super();
		this.feedbacks = feedbacks;
	}
	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}
	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}
	
	
	
	
}
