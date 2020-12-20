/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.bean.Customer;
import application.bean.Feedback;
import application.bean.Manager;
import application.bean.Trainer;
import application.bean.UserSession;
import application.dao.FeedbackRepository;
import application.dao.TrainerRepository;
import application.service.impl.CustomerServiceImpl;
import application.service.impl.FeedbackServiceImpl;
import application.service.impl.ManagerServiceImpl;
import application.service.impl.TrainerServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public class SendFeedbackController implements Initializable{

    @FXML
    private TextArea descriptionTA;

    @FXML
    private ComboBox<Trainer> trainerCB;
    
    @FXML
    private ComboBox<Manager> managerCB;
    @Deprecated
  	private CustomerServiceImpl customerServiceImpl;
  	public CustomerServiceImpl getCustomerServiceImpl() {return (customerServiceImpl==null)?customerServiceImpl=new CustomerServiceImpl():customerServiceImpl;}
  	
	
    @Deprecated
	private TrainerServiceImpl trainerServiceImpl;
	public TrainerServiceImpl getTrainerServiceImpl() {return (trainerServiceImpl==null)?trainerServiceImpl=new TrainerServiceImpl():trainerServiceImpl;}
	@Deprecated
	private ManagerServiceImpl managerServiceImpl;
	public ManagerServiceImpl getManagerServiceImpl() {return (managerServiceImpl==null)?managerServiceImpl=new ManagerServiceImpl():managerServiceImpl;}
	@Deprecated
	private FeedbackServiceImpl feedbackServiceImpl;
	public FeedbackServiceImpl getFeedbackServiceImpl() {if(feedbackServiceImpl==null) {feedbackServiceImpl= new FeedbackServiceImpl();}return feedbackServiceImpl;}

    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		trainerCB.getItems().addAll(getCustomerServiceImpl().findAllTrainerByCustomerID(UserSession.getUser().getProfile().getId()));
		managerCB.getItems().addAll(getManagerServiceImpl().findAll());
		
	}

	

    @FXML
    void saveIt(ActionEvent event) {
    	if(!descriptionTA.getText().isBlank() && managerCB.getSelectionModel().getSelectedItem()!=null&&trainerCB.getSelectionModel().getSelectedItem()!=null) {
    	  Feedback feedback = new Feedback();
    	  feedback.setCustomerId((Customer)UserSession.getUser().getProfile());
          feedback.setMessage(descriptionTA.getText());
          feedback.setTrainerId(trainerCB.getSelectionModel().getSelectedItem());
          feedback.setManagerId(managerCB.getSelectionModel().getSelectedItem());
          getFeedbackServiceImpl().addFeedback(feedback);
  		 ((Stage)((Node)event.getSource()).getScene().getWindow()).close();
    	}
    	
    }
	
	
}
