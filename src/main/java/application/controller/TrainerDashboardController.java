/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.controller;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.control.CheckComboBox;

import application.App;
import application.bean.AvailabilityTimetable;
import application.bean.Customer;
import application.bean.Diet;
import application.bean.ExercicePlan;
import application.bean.Hall;
import application.bean.Manager;
import application.bean.Trainer;
import application.bean.UserSession;
import application.dao.TrainerRepository;
import application.service.impl.AvailabilityTimetableServiceImpl;
import application.service.impl.TrainerServiceImpl;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public class TrainerDashboardController implements Initializable{

	@FXML
    private VBox vBoxReview;
	@FXML
    private TableView<Customer> customersTable;

    @FXML
    private TableColumn<Customer, String> customerFirstNameCL;

    @FXML
    private TableColumn<Customer, String> customerLastNameCL;

    @FXML
    private TableView<Diet> dietTable;

    @FXML
    private TableColumn<Diet, String> dietTypeCL;
    @FXML
    private TableColumn<Diet, String> dietDescriptionCL;

    @FXML
    private TableView<ExercicePlan> exercicePlanTable;

    @FXML
    private TableColumn<ExercicePlan, String> exercicePlaneIDCl;

    @FXML
    private TableColumn<ExercicePlan, String> exercicePlanTitleCL;

    
    @FXML
    private Label fullNameLabel;
    public static ObservableList<Diet> diets;
    public static ObservableList<ExercicePlan> exercicePlans;
    private ObservableList<Customer> customers;
    @Deprecated
    private TrainerServiceImpl trainerServiceImpl;
	public TrainerServiceImpl getTrainerServiceImpl() {return (trainerServiceImpl==null)?trainerServiceImpl=new TrainerServiceImpl():trainerServiceImpl;}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		dietsLoad();exercicePlansLoad();customersLoad();
		fullNameLabel.setText(UserSession.getUser().getProfile().getFirstName()+" "+UserSession.getUser().getProfile().getLastName());
		addNewObjectToTheVbox();
	}
	
	@FXML
    private void logout(MouseEvent event) throws IOException {
      UserSession.cleanUserSession();
      App.changeStage(null,event,"Login", null, false, null, "Sign in", true);}
	private void dietsLoad(){
		diets = getTrainerServiceImpl().findAllDietsOfATrainer(UserSession.getUser().getProfile().getId());
		dietTypeCL.setCellValueFactory(new PropertyValueFactory<>("type"));
		dietDescriptionCL.setCellValueFactory(new PropertyValueFactory<>("description"));
		dietTable.setItems(diets);}
	
	private void exercicePlansLoad(){
		exercicePlans = getTrainerServiceImpl().findAllExercicePlansOfATrainer(UserSession.getUser().getProfile().getId());
		exercicePlaneIDCl.setCellValueFactory(new PropertyValueFactory<>("id"));
		exercicePlanTitleCL.setCellValueFactory(new PropertyValueFactory<>("title"));
		exercicePlanTable.setItems(exercicePlans);}
	
	private void customersLoad(){
		customers = getTrainerServiceImpl().findAllMyCustomersBySubscription(UserSession.getUser().getProfile().getId());
		customerFirstNameCL.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		customerLastNameCL.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		customersTable.setItems(customers);}


    @FXML
    void openAddEcervicePlanFXML(ActionEvent event) throws IOException {
    	App.changeStage(event,null,"AddExercicePlan", null, false, null, "Add new Exercice Plan", false);}

    @FXML
    void openAddEcervicePlanMFXML(MouseEvent event) throws IOException {
    	App.changeStage(null,event,"AddExercicePlan", null, false, null, "Add new Exercice Plan", false);}


    @FXML
    void openAssignDietFXML(ActionEvent event) throws IOException {
    	App.changeStage(event,null,"AssignDiet", null, false, null, "Assign Diet to a Customer", false);}
    
    @FXML
    void openAssignDietMCFXML(MouseEvent event) throws IOException {
    	App.changeStage(null,event,"AssignDiet", null, false, null, "Assign Diet to a Customer", false);}

    @FXML
    void openMyProfileFXML(ActionEvent event) throws IOException {
    	App.changeStage(event,null,"Profile", null, false, null, "My Profile", false);
    }

    
    public void addNewObjectToTheVbox() {
    	Trainer trainerReview =(Trainer) UserSession.getUser().getProfile();
    	trainerReview.getReviews().stream().forEach(r -> {
    		Pane p = new Pane();
	    	p.setMinHeight(128);
	    	p.setPrefHeight(521);
	    	p.setPrefWidth(128);
	    	p.setStyle("-fx-background-color: white; -fx-background-radius: 15px;");
	    	TextArea tA = new TextArea();
	    	tA.setFont(new Font("System Bold",14.0));
	    	tA.setPrefHeight(88);
	    	tA.setPrefWidth(522);
	    	tA.setLayoutX(0);
	    	tA.setLayoutY(30);
	    	tA.setText(r.getDescription());
	    	tA.setEditable(false);
	    	tA.setEffect(new DropShadow(4, Color.BLACK));
	    	Label lLeftSide = new Label();
	    	lLeftSide.setFont(new Font("System Bold",12.0));
	    	lLeftSide.setTextFill(Color.valueOf("0x16bf9fff"));
//	    	lRightSide.setPrefWidth(194);
//	    	lRightSide.setPrefHeight(20);
	    	lLeftSide.setLayoutX(22);
	    	lLeftSide.setLayoutY(5.5);
	    	lLeftSide.setText("Customer: " +r.getCustomerId().getFirstName()+" "+r.getCustomerId().getLastName());
	    	p.getChildren().add(tA);
	    	p.getChildren().add(lLeftSide);
	    	vBoxReview.getChildren().add(p);
    		
    	});
    	
    }
    

}
