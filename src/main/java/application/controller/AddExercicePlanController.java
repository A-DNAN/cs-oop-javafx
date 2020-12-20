/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.bean.Exercice;
import application.bean.ExercicePlan;
import application.bean.Trainer;
import application.bean.UserSession;
import application.service.impl.ExercicePlanServiceImpl;
import application.service.impl.ExerciceServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public class AddExercicePlanController implements Initializable{

	
	    @FXML
	    private TextField titleTF;

	    @FXML
	    private TextArea descriptionTA;

	    @FXML
	    private ComboBox<Exercice> exerciceCB;
	    @Deprecated
		private ExerciceServiceImpl exerciceServiceImpl;
		public ExerciceServiceImpl getExerciceServiceImpl() {return (exerciceServiceImpl==null)?exerciceServiceImpl=new ExerciceServiceImpl():exerciceServiceImpl;}
		@Deprecated
		private ExercicePlanServiceImpl exercicePlanServiceImpl;
		public ExercicePlanServiceImpl getExercicePlanServiceImpl() {return (exercicePlanServiceImpl==null)?exercicePlanServiceImpl=new ExercicePlanServiceImpl():exercicePlanServiceImpl;}

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		exerciceCB.getItems().addAll(getExerciceServiceImpl().findAll());
	}

	
	@FXML
    void saveIt(ActionEvent event) {
		if(!titleTF.getText().isBlank()&& !descriptionTA.getText().isBlank()&&exerciceCB.getSelectionModel().getSelectedItem()!=null) {
			ExercicePlan ep = new ExercicePlan(titleTF.getText(),descriptionTA.getText(),exerciceCB.getSelectionModel().getSelectedItem(),(Trainer) UserSession.getUser().getProfile());
			getExercicePlanServiceImpl().addExercicePlan(ep);
			TrainerDashboardController.exercicePlans.add(ep);
			((Stage)((Node)event.getSource()).getScene().getWindow()).close();}
		
		
    }
	
}
