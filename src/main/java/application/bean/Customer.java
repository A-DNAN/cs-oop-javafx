package application.bean;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author ADNAN <ADNAN.E@TUTANOTA.DE>
 **/

@Entity
@Cacheable(false)
public class Customer extends Profile {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    @OneToOne(mappedBy = "customerId")
	private Membership membershipId;
    @OneToMany(mappedBy = "customerId")
    private List<Review> postedReviews;
    @OneToMany(mappedBy = "customerId")
    private List<Feedback> postedFeedbacks;
    @ManyToMany(mappedBy = "customers")
    private List<Diet> diets;
    @ManyToMany(mappedBy = "customers")
    private List<ExercicePlan> exercicePlans;

    
    public Customer() {
		super();
	}
    
	public Customer(String firstName, String lastName, String phoneNumber) {
		super(firstName, lastName, phoneNumber);
	}

	public Customer(Membership membershipId, List<Review> postedReviews, List<Feedback> postedFeedbacks, Diet dietId,
			List<ExercicePlan> exercicePlans) {
		super();
		this.membershipId = membershipId;
		this.postedReviews = postedReviews;
		this.postedFeedbacks = postedFeedbacks;
		this.exercicePlans = exercicePlans;
	}
	public Membership getMembershipId() {
		return membershipId;
	}
	public void setMembershipId(Membership membershipId) {
		this.membershipId = membershipId;
	}
	public List<Review> getPostedReviews() {
		return postedReviews;
	}
	public void setPostedReviews(List<Review> postedReviews) {
		this.postedReviews = postedReviews;
	}
	public List<Feedback> getPostedFeedbacks() {
		return postedFeedbacks;
	}
	public void setPostedFeedbacks(List<Feedback> postedFeedbacks) {
		this.postedFeedbacks = postedFeedbacks;
	}

	public List<Diet> getDiets() {
		return diets;
	}
	public void setDiets(List<Diet> diets) {
		this.diets = diets;
	}

	public List<ExercicePlan> getExercicePlans() {
		return exercicePlans;
	}
	public void setExercicePlans(List<ExercicePlan> exercicePlans) {
		this.exercicePlans = exercicePlans;
	}
    
	
    
    

}
