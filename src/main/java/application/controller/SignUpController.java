package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.App;
import application.bean.Customer;
import application.bean.Hall;
import application.bean.Trainer;
import application.bean.User;
import application.service.impl.UserServiceImpl;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * @author ADNAN <ADNAN.E@TUTANOTA.DE>
 **/

public class SignUpController implements Initializable{
	   @Deprecated
	   private UserServiceImpl userServiceImpl;
	   public UserServiceImpl getUserServiceImpl(){return (userServiceImpl==null)?userServiceImpl=new UserServiceImpl():userServiceImpl;}

		@FXML
	    private TextField firstNameTF;

	    @FXML
	    private TextField lastNameTF;

	    @FXML
	    private TextField phoneNumberTF;

	    private String switchIt = "CUSTOMER";
	    
	    @FXML
	    private TextField usernameTF;
	    @FXML
	    private TextField emailTF;
	    @FXML
	    private ImageView backIV;
	    @FXML
	    private Button signUbBT;


	    @FXML
	    private PasswordField passwordTF;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		
	}

	    @FXML
	    void signUp(ActionEvent event) throws Exception {
	    	if(!usernameTF.getText().isBlank() && !passwordTF.getText().isBlank()
	    		&& !firstNameTF.getText().isBlank() && !lastNameTF.getText().isBlank() && !emailTF.getText().isBlank()) {
	    		//every new user will be created as new Customer until the manager assign a new rule to the user
	    		User user;
	    		switch (switchIt) {
	    		case "CUSTOMER":
	    			user = new User(usernameTF.getText(), emailTF.getText(), passwordTF.getText(), "CUSTOMER", new Customer(firstNameTF.getText(),lastNameTF.getText(),(phoneNumberTF!=null)?phoneNumberTF.getText():null));
	    			getUserServiceImpl().addtUser(user);
	    			getUserServiceImpl().redirectUser("SIGNUP", "SIGNIN");
	    			break;
	    		case "TRAINER":
	    			Trainer trainer = new Trainer(firstNameTF.getText(),lastNameTF.getText(),(phoneNumberTF!=null)?phoneNumberTF.getText():null);
	    			user = new User(usernameTF.getText(), emailTF.getText(), passwordTF.getText(), "TRAINER", trainer);
	    			getUserServiceImpl().addtUser(user);
	    			DashboardController.trainers.add(trainer);
	    			((Stage)((Node)event.getSource()).getScene().getWindow()).close();
	    			break;
	    		}
	    	}
	    	
	    }
	   
	    @FXML
	    void back(MouseEvent event) throws IOException {
	    	getUserServiceImpl().redirectUser("SIGNUP", "SIGNIN");
	    }

	
	    
	    public void changeIt() {
	    	signUbBT.setText("Add Trainer");
	    	backIV.setVisible(false);
	    	switchIt = "TRAINER";
	    }
	    
}
