/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.control.CheckComboBox;

import application.bean.Customer;
import application.bean.Diet;
import application.bean.Trainer;
import application.bean.UserSession;
import application.dao.DietRepository;
import application.dao.TrainerRepository;
import application.service.impl.DietServiceImpl;
import application.service.impl.TrainerServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public class AssignDietController implements Initializable{


    @FXML
    private TextField dietTypeTF;

    @FXML
    private TextArea descriptionTA;

    @FXML
    private CheckComboBox<Customer> customerCCB;
    @Deprecated
	private TrainerServiceImpl trainerServiceImpl;
	public TrainerServiceImpl getTrainerServiceImpl() {return (trainerServiceImpl==null)?trainerServiceImpl=new TrainerServiceImpl():trainerServiceImpl;}
	@Deprecated
	private DietServiceImpl dietServiceImpl;
	public DietServiceImpl getDietServiceImpl() {return (dietServiceImpl==null)?dietServiceImpl=new DietServiceImpl():dietServiceImpl;}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		customerCCB.getItems().addAll(getTrainerServiceImpl().findAllMyCustomersBySubscription(UserSession.getUser().getProfile().getId()));
	
	}

	 @FXML
	 private void saveIt(ActionEvent event) {
		 if(!customerCCB.getCheckModel().getCheckedItems().isEmpty()&& !descriptionTA.getText().isEmpty()&&!dietTypeTF.getText().isEmpty()) {
			 Diet d = new Diet();
			 d.setAuthor((Trainer)UserSession.getUser().getProfile());
			 d.setCustomers(customerCCB.getCheckModel().getCheckedItems());
			 d.setType(dietTypeTF.getText());
			 d.setDescription(descriptionTA.getText());
			 getDietServiceImpl().addDiet(d);
			 TrainerDashboardController.diets.add(d);
			 ((Stage)((Node)event.getSource()).getScene().getWindow()).close();
		 }
	    }
	
}
