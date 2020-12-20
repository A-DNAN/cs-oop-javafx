/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import application.App;
import application.bean.Diet;
import application.bean.Hall;
import application.bean.Review;
import application.bean.Subscription;
import application.bean.Trainer;
import application.bean.UserSession;
import application.service.impl.CustomerServiceImpl;
import application.service.impl.TrainerServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public class CustomerDashboardController implements Initializable {

	@FXML
    private TableView<Subscription> mySubscriptionTable;

    @FXML
    private TableColumn<Subscription, String> subscriptionIdCL;

    @FXML
    private TableColumn<Subscription, String> subcriptionStartDateCL;

    @FXML
    private TableView<Trainer> myTrainersTable;

    @FXML
    private TableView<Diet> dietTable;

    @FXML
    private TableColumn<Diet, String> dietTypeCL;
    @FXML
    private TableColumn<Diet, String> dietDescriptionCL;

    
    @FXML
    private TableColumn<Trainer, String> trainerFirstNameCL;

    @FXML
    private TableColumn<Trainer, String> trainerLastNameCL;

    @FXML
    private TableView<Trainer> aTrainersTable;

    @FXML
    private TableColumn<Trainer, String> aTrainerFirstNameCL;

    @FXML
    private TableColumn<Trainer, String> aTrainerLastNameCL;

    @FXML
    private Label fullNameLabel;
    public static ObservableList<Subscription> subscriptions;
    public static ObservableList<Trainer> myTrainers;
    private ObservableList<Diet> diets;
    private ObservableList<Trainer> aTrainers;
    @Deprecated
	private CustomerServiceImpl customerServiceImpl;
	public CustomerServiceImpl getCustomerServiceImpl() {return (customerServiceImpl==null)?customerServiceImpl=new CustomerServiceImpl():customerServiceImpl;}
	@Deprecated
	private TrainerServiceImpl trainerServiceImpl;
	public TrainerServiceImpl getTrainerServiceImpl() {return (trainerServiceImpl==null)?trainerServiceImpl=new TrainerServiceImpl():trainerServiceImpl;}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		subscriptionLoad();myTrainersLoad();dietsLoad();aTrainersLoad();
		fullNameLabel.setText(UserSession.getUser().getProfile().getFirstName()+" "+UserSession.getUser().getProfile().getLastName());
	}

	private void subscriptionLoad(){
		subscriptions = getCustomerServiceImpl().findAllSubscriptionByCustomerID(UserSession.getUser().getProfile().getId());
		subscriptionIdCL.setCellValueFactory(new PropertyValueFactory<>("id"));
		subcriptionStartDateCL.setCellValueFactory(new PropertyValueFactory<>("startDate"));
		mySubscriptionTable.setItems(subscriptions);
		mySubscriptionTable.refresh();}
	
	private void myTrainersLoad(){
		myTrainers = getCustomerServiceImpl().findAllTrainerByCustomerID(UserSession.getUser().getProfile().getId());
		trainerFirstNameCL.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		trainerLastNameCL.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		myTrainersTable.setItems(myTrainers);
		mySubscriptionTable.refresh();}
	
	private void aTrainersLoad(){
		HashMap<Trainer, Double> hM= new HashMap<Trainer, Double>();
	   ObservableList<Trainer> rSortedList = FXCollections.observableArrayList();
		aTrainers = getTrainerServiceImpl().findAll();
		aTrainers.stream().forEach(trn -> {
			hM.put(trn, trn.getReviews().stream().map(Review::getStar).mapToDouble(s->s).sum());
		});
	  hM.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(t-> rSortedList.add(t.getKey()));
	  Collections.reverse(rSortedList);
		aTrainerFirstNameCL.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		aTrainerLastNameCL.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		aTrainersTable.setItems(rSortedList);
		}
	
	private void dietsLoad(){
		diets = getCustomerServiceImpl().findAllDietByCustomerID(UserSession.getUser().getProfile().getId());
		dietTypeCL.setCellValueFactory(new PropertyValueFactory<>("type"));
		dietDescriptionCL.setCellValueFactory(new PropertyValueFactory<>("description"));
		dietTable.setItems(diets);}  
	
	@FXML
    private void logout(MouseEvent event) throws IOException {
      UserSession.cleanUserSession();
      App.changeStage(null,event,"Login", null, false, null, "Sign in", true);}
	
	
	    @FXML
	    void openMyProfileFXML(ActionEvent event) throws IOException {
	    	App.changeStage(event,null,"Profile", null, false, null, "My Profile", false);}


	    @FXML
	    void openNewFeedbackFXML(ActionEvent event) throws IOException {
	    	App.changeStage(event,null,"SendFeedback", null, false, null, "New Feedback", false);}

	    @FXML
	    void openNewSubscriptionFXML(ActionEvent event) throws IOException {
	    	App.changeStage(event,null,"AddNewSubscription", null, false, null, "New Subscription", false);}
	    
	    @FXML
	    void openNewSubscriptionMCFXML(MouseEvent event) throws IOException {
	    	App.changeStage(null,event,"AddNewSubscription", null, false, null, "New Subscription", false);}

	    @FXML
	    public void viewProfileFXMLOfTrainer (MouseEvent event) throws IOException {
	    	Trainer tr = myTrainersTable.getSelectionModel().getSelectedItem();
	    	if(tr!=null) {
	    	FXMLLoader loader = new FXMLLoader(App.class.getResource("/view/Profile.fxml"));
	    	var root = loader.load();
	    	ProfileController profileController = loader.getController();
	    	profileController.changeIt(tr,"CustomerDahsboard");
	    	App.changeStageWOEvent("Profile", null, false, null, "Trainer Profile", false,(Parent) root );}
	    }

	
}
