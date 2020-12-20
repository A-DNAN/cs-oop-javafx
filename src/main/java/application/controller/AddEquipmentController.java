/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.control.CheckComboBox;

import application.bean.AvailabilityTimetable;
import application.bean.Equipment;
import application.bean.Exercice;
import application.bean.Hall;
import application.service.impl.AvailabilityTimetableServiceImpl;
import application.service.impl.EquipmentServiceImpl;
import application.service.impl.ExerciceServiceImpl;
import application.service.impl.HallServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public class AddEquipmentController implements Initializable{

	     @FXML
	    private TextField equipmentNameTF;

	    @FXML
	    private CheckComboBox<Exercice> exerciceCCB;

	    @FXML
	    private CheckComboBox<AvailabilityTimetable> availibilityCCB;
	    @FXML
	    private ComboBox<Hall> hallCB;
	    @Deprecated
		private AvailabilityTimetableServiceImpl availabilityTimetableServiceImpl;
		public AvailabilityTimetableServiceImpl getAvailabilityTimetableServiceImpl() {return (availabilityTimetableServiceImpl==null)?availabilityTimetableServiceImpl=new AvailabilityTimetableServiceImpl():availabilityTimetableServiceImpl;}
		@Deprecated
		private ExerciceServiceImpl exerciceServiceImpl;
		public ExerciceServiceImpl getExerciceServiceImpl() {return (exerciceServiceImpl==null)?exerciceServiceImpl=new ExerciceServiceImpl():exerciceServiceImpl;}
		@Deprecated
		private HallServiceImpl hallServiceImpl;
		public HallServiceImpl getHallServiceImpl() {return (hallServiceImpl==null)?hallServiceImpl=new HallServiceImpl():hallServiceImpl;}
		@Deprecated
		private EquipmentServiceImpl equipmentServiceImpl;
		public EquipmentServiceImpl getEquipmentServiceImpl() {return (equipmentServiceImpl==null)?equipmentServiceImpl=new EquipmentServiceImpl():equipmentServiceImpl;}

	    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		availibilityCCB.getItems().addAll(getAvailabilityTimetableServiceImpl().findAll());
		exerciceCCB.getItems().addAll(getExerciceServiceImpl().findAll());
		hallCB.getItems().addAll(getHallServiceImpl().findAll());
	}

	  

    @FXML
    void saveIt(ActionEvent event) {
    	if(!equipmentNameTF.getText().isBlank() && !exerciceCCB.getCheckModel().getCheckedItems().isEmpty() && hallCB.getSelectionModel().getSelectedItem()!=null
    			&& !availibilityCCB.getCheckModel().getCheckedItems().isEmpty()) {
    		Equipment eq = new Equipment();
    		eq.setName(equipmentNameTF.getText());
    		eq.setExercices(exerciceCCB.getCheckModel().getCheckedItems());
    		eq.setHallId(hallCB.getSelectionModel().getSelectedItem());
    		eq.setAvailabilityTimetables(availibilityCCB.getCheckModel().getCheckedItems());
    		getEquipmentServiceImpl().addEquipment(eq);
    		DashboardController.equipments.add(eq);
    		((Stage)((Node)event.getSource()).getScene().getWindow()).close();
    	}
    	
    }
	
}
