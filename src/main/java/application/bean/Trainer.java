package application.bean;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import application.App;
import application.controller.DashboardController;
import application.controller.ProfileController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.control.Button;

/**
 * @author ADNAN <ADNAN.E@TUTANOTA.DE>
 **/
@Entity
@Cacheable(false)
//@DiscriminatorValue("Trainer")
public class Trainer extends Profile{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Transient
	private File video;
	@Transient
	private List<File> pictures;
//	@Transient
//	private Button button;
//	
	@OneToMany(mappedBy = "trainerId")
	private List<Review> reviews ;
	@OneToMany(mappedBy = "trainerId")
	private List<Statistic> statistics;
	@OneToMany(mappedBy = "trainerId")
	List<Feedback> feedbacks;
	@ManyToMany
	private List<AvailabilityTimetable> availabilityTimetables;
	@OneToMany(mappedBy = "trainerId")
	private List<ExercicePlan> exercicePlans;
	@OneToMany(mappedBy = "author")
	private List<Diet> diets;
	@OneToMany(mappedBy = "responsibleTrainer")
	private List<Subscription> managedSubscriptions;
	public Trainer() {
		super();
	}
	public Trainer(String firstName, String lastName, String phoneNumber) {
		super(firstName, lastName, phoneNumber);
	}
	public Trainer(File video, List<File> pictures, List<Review> reviews, List<Statistic> statistics,
			List<AvailabilityTimetable> availabilityTimetables, List<ExercicePlan> exercicePlans, List<Diet> diets,
			List<Subscription> managedSubscriptions) {
		super();
		this.video = video;
		this.pictures = pictures;
		this.reviews = reviews;
		this.statistics = statistics;
		this.availabilityTimetables = availabilityTimetables;
		this.exercicePlans = exercicePlans;
		this.diets = diets;
		this.managedSubscriptions = managedSubscriptions;
	}
	public File getVideo() {
		return video;
	}
	public void setVideo(File video) {
		this.video = video;
	}
	public List<File> getPictures() {
		return pictures;
	}
	public void setPictures(List<File> pictures) {
		this.pictures = pictures;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	public List<Statistic> getStatistics() {
		return statistics;
	}
	public void setStatistics(List<Statistic> statistics) {
		this.statistics = statistics;
	}
	public List<AvailabilityTimetable> getAvailabilityTimetables() {
		return availabilityTimetables;
	}
	public void setAvailabilityTimetables(List<AvailabilityTimetable> availabilityTimetables) {
		this.availabilityTimetables = availabilityTimetables;
	}
	public List<ExercicePlan> getExercicePlans() {
		return exercicePlans;
	}
	public void setExercicePlans(List<ExercicePlan> exercicePlans) {
		this.exercicePlans = exercicePlans;
	}
	public List<Diet> getDiets() {
		return diets;
	}
	public void setDiets(List<Diet> diets) {
		this.diets = diets;
	}
	public List<Subscription> getManagedSubscriptions() {
		return managedSubscriptions;
	}
	public void setManagedSubscriptions(List<Subscription> managedSubscriptions) {
		this.managedSubscriptions = managedSubscriptions;
	}
	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}
	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}
//	public Button getButton() {
//		if(button==null) {button= new Button();}
//		button.setText("Show");
//		button.setCursor(Cursor.HAND);
//		button.getStylesheets().add(getClass().getResource("/css/mainCss.css").toString());
//		button.getStyleClass().add("button_4");
//		button.setOnAction(e->{
//			try {
//				FXMLLoader loader = new FXMLLoader(App.class.getResource("/view/Dashboard.fxml"));
//				loader.load();// return Parent root
//		    	DashboardController dashboardController = loader.getController();
//		    	dashboardController.viewProfileFXMLOfTrainer(e);
//			} catch (IOException ee) {
//				ee.printStackTrace();
//			}
//		});
//		return button;
//	}
//	
//	public void setButton(Button button) {
//		this.button = button;
//	}
	

	
	
}
