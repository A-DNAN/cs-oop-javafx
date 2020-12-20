/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.persistence.Temporal;

import org.controlsfx.control.CheckComboBox;

import application.bean.AvailabilityTimetable;
import application.bean.Equipment;
import application.bean.Hall;
import application.dao.EquipmentRepository;
import application.service.impl.AvailabilityTimetableServiceImpl;
import application.service.impl.EquipmentServiceImpl;
import application.service.impl.HallServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public class AddHallController implements Initializable{

	    @FXML
	    private TextField hallNameTF;
	    @FXML
	    private CheckComboBox<AvailabilityTimetable> availibilityCCB;
	    
		@Deprecated
		private AvailabilityTimetableServiceImpl availabilityTimetableServiceImpl;
		public AvailabilityTimetableServiceImpl getAvailabilityTimetableServiceImpl() {return (availabilityTimetableServiceImpl==null)?availabilityTimetableServiceImpl=new AvailabilityTimetableServiceImpl():availabilityTimetableServiceImpl;}
		@Deprecated
		private HallServiceImpl hallServiceImpl;
		public HallServiceImpl getHallServiceImpl() {return (hallServiceImpl==null)?hallServiceImpl=new HallServiceImpl():hallServiceImpl;}

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		availibilityCCB.getItems().addAll(getAvailabilityTimetableServiceImpl().findAll());
	}


    @FXML
    void saveIt(ActionEvent event) {
    	if(!hallNameTF.getText().isBlank() && !availibilityCCB.getCheckModel().getCheckedItems().isEmpty()) {
    		Hall hall = new Hall();
    		hall.setAvailabilityTimetables(availibilityCCB.getCheckModel().getCheckedItems());
    		hall.setName(hallNameTF.getText());
    		getHallServiceImpl().addHall(hall);
    		DashboardController.halls.add(hall);
    		((Stage)((Node)event.getSource()).getScene().getWindow()).close();
		}
    
    }

	
	
}
