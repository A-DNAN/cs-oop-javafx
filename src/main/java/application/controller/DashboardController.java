package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.App;
import application.bean.Equipment;
import application.bean.Hall;
import application.bean.Manager;
import application.bean.Trainer;
import application.bean.UserSession;
import application.service.impl.EquipmentServiceImpl;
import application.service.impl.HallServiceImpl;
import application.service.impl.TrainerServiceImpl;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

/**
 * @author ADNAN <ADNAN.E@TUTANOTA.DE>
 **/

public class DashboardController implements Initializable{

	    @FXML
	    private TableView<Hall> hallTable;
	    
	    @FXML
	    private TableColumn<Hall, String> hallId;

	    @FXML
	    private TableColumn<Hall, String> hallName;

	    @FXML
	    private TableView<Equipment> equipmentTable;

	    @FXML
	    private TableColumn<Equipment, String> equipmentName;

	    @FXML
	    private TableColumn<Equipment, String> equipmentHallId;
	
	    @FXML
	    private TableView<Trainer> trainerTable;

	    @FXML
	    private TableColumn<Trainer, String> trainerFirstNameCL;
	    @FXML
	    private TableColumn<Trainer, String> trainerIdCL;
	    @FXML
	    private TableColumn<Trainer, String> trainerLastNameCL;
	    @FXML
	    private Label fullNameLabel;
	    @FXML
	    private VBox vBoxFeedback;
	    
	    @Deprecated
	    private HallServiceImpl hallServiceImpl;
	    public HallServiceImpl getHallServiceImpl() {return (hallServiceImpl==null)?hallServiceImpl=new HallServiceImpl():hallServiceImpl;}
        @Deprecated
	    private EquipmentServiceImpl equipmentServiceImpl;
		public EquipmentServiceImpl getEquipmentServiceImpl() {return (equipmentServiceImpl==null)?equipmentServiceImpl=new EquipmentServiceImpl():equipmentServiceImpl;}
	    
		@Deprecated
		private TrainerServiceImpl trainerServiceImpl;
		public TrainerServiceImpl getTrainerServiceImpl() {return (trainerServiceImpl==null)?trainerServiceImpl=new TrainerServiceImpl():trainerServiceImpl;}
		
		
		public static ObservableList<Hall> halls;
		public static ObservableList<Equipment> equipments;
	    public static ObservableList<Trainer> trainers;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		hallsLoad();equipmentsLoad();trainersLoad();
		fullNameLabel.setText(UserSession.getUser().getProfile().getFirstName()+" "+UserSession.getUser().getProfile().getLastName());
		addNewObjectToTheVbox();
	}
	
	

	private void hallsLoad(){
		halls = getHallServiceImpl().findAll();
		hallId.setCellValueFactory(new PropertyValueFactory<>("id"));
		hallName.setCellValueFactory(new PropertyValueFactory<>("name"));
		hallTable.setItems(halls);}
	
	private void equipmentsLoad(){
		equipments = getEquipmentServiceImpl().findAll();
		equipmentName.setCellValueFactory(new PropertyValueFactory<>("name"));
		equipmentHallId.setCellValueFactory((TableColumn.CellDataFeatures<Equipment,String> e)->
		new SimpleStringProperty(e.getValue().getHallId().getName()));
		equipmentTable.setItems(equipments);}
	private void trainersLoad(){
		trainers = getTrainerServiceImpl().findAll();
		trainerIdCL.setCellValueFactory(new PropertyValueFactory<>("id"));
		trainerFirstNameCL.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		trainerLastNameCL.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		trainerTable.setItems(trainers);}
	
	@FXML
    private void logout(MouseEvent event) throws IOException {
      UserSession.cleanUserSession();
      App.changeStage(null,event,"Login", null, false, null, "Sign in", true);}
	
	   @FXML
	   public void openAddtrainerFXML(MouseEvent event) throws IOException {openAddtrainerFXMLX();}
	   @FXML
	   public void openAddtrainer(ActionEvent event) throws IOException {openAddtrainerFXMLX();}
	   public void openAddtrainerFXMLX() throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Signup.fxml"));
//	    	loader.setLocation(getClass().getResource("/view/Signup.fxml"));
	    	var root = loader.load();// return Parent root
	    	SignUpController signupController = loader.getController();
	    	signupController.changeIt();
	    	App.changeStageWOEvent("SignUp", null, false, null, "Add Trainer", false,(Parent) root );
	    }
	
	    @FXML
	    void openMyProfileFXML(ActionEvent event) throws IOException   {
	    	App.changeStage(event,null,"Profile", null, false, null, "My Profile", false);}
	    
	    
	    @FXML
	    void openAddEquipmentFXML(ActionEvent event) throws IOException {
	    	App.changeStage(event,null,"AddEquipment", null, false, null, "Add new Equipment", false);}


	    @FXML
	    void openAddEquipmentMCFXML(MouseEvent event) throws IOException {
	    	App.changeStage(null,event,"AddEquipment", null, false, null, "Add new Equipment", false);}

	    @FXML
	    void openAddHallFXML(ActionEvent event) throws IOException {
	    	App.changeStage(event,null,"AddHall", null, false, null, "Add new Hall", false);}

	    @FXML
	    void openAddHallMCFXML(MouseEvent event) throws IOException {
	    	App.changeStage(null,event,"AddHall", null, false, null, "Add new Hall", false);}


	    public void addNewObjectToTheVbox() {
	    	
	    	Manager manager =(Manager) UserSession.getUser().getProfile();
	    	manager.getFeedbacks().stream().forEach(f -> {
	    		
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
		    	tA.setText(f.getMessage());
		    	tA.setEditable(false);
		    	tA.setEffect(new DropShadow(4, Color.BLACK));
		    	Label lLeftSide = new Label();
		    	Label lRightSide = new Label();
		    	lLeftSide.setFont(new Font("System Bold",12.0));
		    	lRightSide.setFont(new Font("System Bold",12.0));
		    	lLeftSide.setTextFill(Color.valueOf("0x16bf9fff"));
		    	lRightSide.setTextFill(Color.valueOf("0x16bf9fff"));
//		    	lLeftSide.setPrefWidth(109);
//		    	lLeftSide.setPrefHeight(20);
		    	lLeftSide.setLayoutX(382);
		    	lLeftSide.setLayoutY(5.5);
//		    	lRightSide.setPrefWidth(194);
//		    	lRightSide.setPrefHeight(20);
		    	lRightSide.setLayoutX(22);
		    	lRightSide.setLayoutY(5.5);
		    	lRightSide.setText("Customer: " +f.getCustomerId().getFirstName()+" "+f.getCustomerId().getLastName());
		    	lLeftSide.setText("Trainer ID: "+f.getTrainerId().getId());
		    	p.getChildren().add(tA);
		    	p.getChildren().add(lLeftSide);
		    	p.getChildren().add(lRightSide);
		    	vBoxFeedback.getChildren().add(p);
	    		
	    	});
	    	
	    }
	    @FXML
	    public void viewProfileFXMLOfTrainer (MouseEvent event) throws IOException {
	    	Trainer tr = trainerTable.getSelectionModel().getSelectedItem();
	    	if(tr!=null) {
	    	FXMLLoader loader = new FXMLLoader(App.class.getResource("/view/Profile.fxml"));
	    	var root = loader.load();// return Parent root
	    	ProfileController profileController = loader.getController();
	    	profileController.changeIt(tr, "ManagerDahsboard");
	    	App.changeStageWOEvent("Profile", null, false, null, "Trainer Profile", false,(Parent) root );}
	    }
	
}
