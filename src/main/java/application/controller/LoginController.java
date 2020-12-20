package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import application.App;
import application.bean.UserSession;
import application.service.impl.UserServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * @author ADNAN <ADNAN.E@TUTANOTA.DE>
 **/

public class LoginController implements Initializable{

//	@FXML
//	ImageView iView;
	@FXML
    private TextField usernameTF;
    @FXML
    private PasswordField passwordTF;
    @Deprecated
    private UserServiceImpl userServiceImpl;
	public UserServiceImpl getUserServiceImpl(){return (userServiceImpl==null)?userServiceImpl=new UserServiceImpl():userServiceImpl;}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		iView.setImage(new Image(getClass().getResource("/image/gym.png").toString()));
	
	}
	
	    @FXML
	    void signIn(ActionEvent event) throws IOException  {
	    	if(!usernameTF.getText().isBlank() && !passwordTF.getText().isBlank()) {
		 if(getUserServiceImpl().isAuthorized(usernameTF.getText(), passwordTF.getText())) {
			 getUserServiceImpl().redirectUser("SIGNIN","DASHBOARD");}
//else login error		 
	    	}
	    }
	    @FXML
	    void signUp(MouseEvent event) throws IOException {
	    	getUserServiceImpl().redirectUser("SIGNIN","SIGNUP");
	    }
	
}
