/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.control.Rating;

import application.bean.Customer;
import application.bean.Review;
import application.bean.Trainer;
import application.bean.UserSession;
import application.dao.ReviewRepository;
import application.service.impl.ReviewServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public class ReviewController implements Initializable{


    @FXML
    private TextArea descriptionTA;

    @FXML
    private Rating rating;
    @Deprecated
	private ReviewServiceImpl reviewServiceImpl;
	public ReviewServiceImpl getReviewServiceImpl() {return (reviewServiceImpl==null)?reviewServiceImpl=new ReviewServiceImpl():reviewServiceImpl;}
    private Trainer receivedTrainer;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	
	 @FXML
	  private void saveIt(ActionEvent event) {
		 if(!descriptionTA.getText().isBlank()) {
			 Review review = new Review();
			 review.setCustomerId((Customer)UserSession.getUser().getProfile());
			 review.setStar(rating.getRating());
			 review.setDescription(descriptionTA.getText());
			 review.setTrainerId(receivedTrainer);
			 getReviewServiceImpl().addReview(review);
			((Stage)((Node)event.getSource()).getScene().getWindow()).close();
		 }
	    }
	
	 public void changeIt(Trainer tr) {
		 this.receivedTrainer = tr;
	 }
	 
}
