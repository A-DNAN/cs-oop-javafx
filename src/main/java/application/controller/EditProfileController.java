/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.controller;

import java.net.URL;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.SQLTransientException;
import java.util.ResourceBundle;

import org.controlsfx.control.CheckComboBox;

import application.bean.AvailabilityTimetable;
import application.bean.Customer;
import application.bean.Manager;
import application.bean.Trainer;
import application.bean.User;
import application.bean.UserSession;
import application.service.impl.AvailabilityTimetableServiceImpl;
import application.service.impl.CustomerServiceImpl;
import application.service.impl.ManagerServiceImpl;
import application.service.impl.TrainerServiceImpl;
import application.service.impl.UserServiceImpl;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public class EditProfileController implements Initializable{

	    @FXML
	    private TextField firstNameTF;

	    @FXML
	    private TextField lastNameTF;

	    @FXML
	    private TextArea descriptionTF;

	    @FXML
	    private TextField emailTF;
	    @FXML
	    private PasswordField passwordTF;
	    @FXML
	    private TextField numberTF;
	    @Deprecated
		   private UserServiceImpl userServiceImpl;
		   public UserServiceImpl getUserServiceImpl(){return (userServiceImpl==null)?userServiceImpl=new UserServiceImpl():userServiceImpl;}

	    @FXML
	    private CheckComboBox<AvailabilityTimetable> availabilityCCB;
	    @Deprecated
		private AvailabilityTimetableServiceImpl availabilityTimetableServiceImpl;
		public AvailabilityTimetableServiceImpl getAvailabilityTimetableServiceImpl() {return (availabilityTimetableServiceImpl==null)?availabilityTimetableServiceImpl=new AvailabilityTimetableServiceImpl():availabilityTimetableServiceImpl;}

		@Deprecated
	    private TrainerServiceImpl trainerServiceImpl;
		public TrainerServiceImpl getTrainerServiceImpl(){return (trainerServiceImpl==null)?trainerServiceImpl=new TrainerServiceImpl():trainerServiceImpl;}
		@Deprecated
		private ManagerServiceImpl managerServiceImpl;
		public ManagerServiceImpl getManagerServiceImpl(){return (managerServiceImpl==null)?managerServiceImpl=new ManagerServiceImpl():managerServiceImpl;}
		@Deprecated
		private CustomerServiceImpl customerServiceImpl;
		public CustomerServiceImpl getCustomerServiceImpl(){return (customerServiceImpl==null)?customerServiceImpl=new CustomerServiceImpl():customerServiceImpl;}

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		if(UserSession.getUser().getProfile().getClass().getName().equalsIgnoreCase(Trainer.class.getName())) {
		availabilityCCB.getItems().addAll(getAvailabilityTimetableServiceImpl().findAll());
		}else {availabilityCCB.setDisable(true);availabilityCCB.setVisible(false);}
		initF();
		
	}
	
	
	    @FXML
	   private void save(ActionEvent event) {
			if(UserSession.getUser().getProfile().getClass().getName().equalsIgnoreCase(Trainer.class.getName())) {
				Trainer trainer = (Trainer) UserSession.getUser().getProfile();
				int cmp=0;
				if(availabilityCCB.getCheckModel().getCheckedItems()!=null && !availabilityCCB.getCheckModel().getCheckedItems().isEmpty()) {
					trainer.setAvailabilityTimetables(availabilityCCB.getCheckModel().getCheckedItems());
					cmp++;
				}
				if(!lastNameTF.getText().isBlank()) {
					trainer.setLastName(lastNameTF.getText());
					cmp++;
				}
				if(!passwordTF.getText().isBlank()) {
					trainer.getUser().setPassword(passwordTF.getText());
					cmp++;
				}
		    	if(!firstNameTF.getText().isBlank()) {
		    		trainer.setFirstName(firstNameTF.getText());
		    		cmp++;
		    	}
		    	if(!descriptionTF.getText().isBlank()) {
		    		trainer.setMoreDetails(descriptionTF.getText());
		    		cmp++;
		    	}
		    	if(!emailTF.getText().isBlank()) {
		    		trainer.getUser().setEmail(emailTF.getText());
		    		cmp++;
		    	}
		    	if(!numberTF.getText().isBlank()) {
		    		trainer.setPhoneNumber(numberTF.getText());
		    		cmp++;
		    	}
				if(cmp!=0) {
					try {
						getTrainerServiceImpl().updateTrainer(trainer);
					} catch (Exception e) {
						System.out.println("Data too long");
					}
				getUserServiceImpl().updateUser(trainer.getUser());
				((Stage)((Node)event.getSource()).getScene().getWindow()).close();
				}}
           if(UserSession.getUser().getProfile().getClass().getName().equalsIgnoreCase(Manager.class.getName())) {
        	   Manager manager = (Manager) UserSession.getUser().getProfile();
				int cmp=0;
				if(!lastNameTF.getText().isBlank()) {
					manager.setLastName(lastNameTF.getText());
					cmp++;
				}
				if(!passwordTF.getText().isBlank()) {
					manager.getUser().setPassword(passwordTF.getText());
					cmp++;
				}
		    	if(!firstNameTF.getText().isBlank()) {
		    		manager.setFirstName(firstNameTF.getText());
		    		cmp++;
		    	}
		    	if(!descriptionTF.getText().isBlank()) {
		    		manager.setMoreDetails(descriptionTF.getText());
		    		cmp++;
		    	}
		    	if(!emailTF.getText().isBlank()) {
		    		manager.getUser().setEmail(emailTF.getText());
		    		cmp++;
		    	}
		    	if(!numberTF.getText().isBlank()) {
		    		manager.setPhoneNumber(numberTF.getText());
		    		cmp++;
		    	}
				if(cmp!=0) {
					try {
						getManagerServiceImpl().updateManager(manager);
					} catch (Exception e) {
						System.out.println("Data too long");
					}
				getUserServiceImpl().updateUser(manager.getUser());
				((Stage)((Node)event.getSource()).getScene().getWindow()).close();
			}}
           if(UserSession.getUser().getProfile().getClass().getName().equalsIgnoreCase(Customer.class.getName())) {
        	   Customer customer = (Customer) UserSession.getUser().getProfile();
				int cmp=0;
				if(!lastNameTF.getText().isBlank()) {
					customer.setLastName(lastNameTF.getText());
					cmp++;
				}
				if(!passwordTF.getText().isBlank()) {
					customer.getUser().setPassword(passwordTF.getText());
					cmp++;
				}
		    	if(!firstNameTF.getText().isBlank()) {
		    		customer.setFirstName(firstNameTF.getText());
		    		cmp++;
		    	}
		    	if(!descriptionTF.getText().isBlank()) {
		    		customer.setMoreDetails(descriptionTF.getText());
		    		cmp++;
		    	}
		    	if(!emailTF.getText().isBlank()) {
		    		customer.getUser().setEmail(emailTF.getText());
		    		cmp++;
		    	}
		    	if(!numberTF.getText().isBlank()) {
		    		customer.setPhoneNumber(numberTF.getText());
		    		cmp++;
		    	}
				if(cmp!=0) {
					try {
						getCustomerServiceImpl().updateTrainer(customer);
					} catch (Exception e) {
						System.out.println("Data too long");
					}
				getUserServiceImpl().updateUser(customer.getUser());
				((Stage)((Node)event.getSource()).getScene().getWindow()).close();  
				}}

	    }
	    
	    public void updateField(Label firstNameB, TextArea descB) {
	  firstNameTF.textProperty().bindBidirectional(firstNameB.textProperty());
	  descriptionTF.textProperty().bindBidirectional(descB.textProperty());
		}

    private void initF() {
//    	if(availabilityCCB.getCheckModel().getCheckedItems()!=null) {
//		}
		if(UserSession.getUser().getProfile().getLastName()!=null) {
    	lastNameTF.setText(UserSession.getUser().getProfile().getLastName());}
		if(UserSession.getUser().getProfile().getPhoneNumber()!=null) {
			numberTF.setText(UserSession.getUser().getProfile().getPhoneNumber());}
		if(UserSession.getUser().getEmail()!=null) {
		emailTF.setText(UserSession.getUser().getEmail());}
}	    
}
