package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.App;
import application.bean.Trainer;
import application.bean.UserSession;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.TextFlow;

/**
 * @author ADNAN <ADNAN.E@TUTANOTA.DE>
 **/

public class ProfileController implements Initializable{

	
	@FXML
	MediaView videoMV;
	@FXML
	Label profileFlag;
	@FXML
	Label profileUsername;
	@FXML
	Label profileFullName;
	@FXML
	TabPane profileTabPane;
	@FXML
	TextArea descriptionFD;
	@FXML
	private Button editProfileButton;
	@FXML
	private Button reviewBN;
	
	private Trainer trainerToSend;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		reviewBN.setVisible(false);
		reviewBN.setDisable(true);
		initF();
	}
	
	   @FXML
	   private void playOrStop(MouseEvent event) {
		  
		   if(videoMV.getMediaPlayer().getMedia().getDuration().toString().equalsIgnoreCase(videoMV.getMediaPlayer().getCurrentTime().toString())) {
			   videoMV.getMediaPlayer().stop();
			   videoMV.getMediaPlayer().play();
			   videoMV.getMediaPlayer();
		   }else {
			   if(videoMV.getMediaPlayer().getStatus().toString().equalsIgnoreCase("PLAYING")) {
					  videoMV.getMediaPlayer().pause();  
				  }else {
					  videoMV.getMediaPlayer().play();
				  }
		   }
	    }

	   @FXML
	    void editProfile(ActionEvent event) throws Exception {
		   FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/EditProfile.fxml"));
		   var root = loader.load();
		   EditProfileController  editProfileController = loader.getController();
		   editProfileController.updateField(profileFullName, descriptionFD);
		   App.changeStageWOEvent("EditProfile", null, false, null, "Edit Profile", false,(Parent) root );
//		   App.changeStage(event,null, "EditProfile", null, false, null, "Edit Profile", false);
	    }
	   
	   private void initF() {
			if(UserSession.getUser().getProfile().getMoreDetails()!=null) {
		   descriptionFD.setText(UserSession.getUser().getProfile().getMoreDetails());}
//			to remove a tab : profileTabPane.getTabs().remove(0);
			profileFullName.setText(UserSession.getUser().getProfile().getFirstName());
		    profileUsername.setText("Username : "+UserSession.getUser().getUsername());
			profileFlag.setText(UserSession.getUser().getUserType());
			Media media = new Media(getClass().getResource("/image/4.mp4").toString());
			MediaPlayer md = new MediaPlayer(media);
			videoMV.setMediaPlayer(md);
			
	}	    
	   
	   public void changeIt(Trainer tr, String from) {
		   switch (from) {
		case "ManagerDahsboard":
			break;
		case "CustomerDahsboard":
			reviewBN.setVisible(true);
			reviewBN.setDisable(false);
			break;
		}
		   this.trainerToSend = tr;
		    editProfileButton.setVisible(false);
		    descriptionFD.setText(tr.getMoreDetails());
			profileFullName.setText(tr.getFirstName());
		    profileUsername.setText("Username : "+tr.getUser().getUsername());
			profileFlag.setText(tr.getUser().getUserType());
			Media media = new Media(getClass().getResource("/image/4.mp4").toString());
			MediaPlayer md = new MediaPlayer(media);
			videoMV.setMediaPlayer(md);
		   
		       }
	   

	    @FXML
	   private void openReviewFXML(ActionEvent event) throws IOException {
	    	if(trainerToSend!=null) {
	    	  FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Review.fxml"));
			   var root = loader.load();
			   ReviewController  reviewController = loader.getController();
			   reviewController.changeIt(trainerToSend);
			   App.changeStageWOEvent("Review", null, false, null, "Write review", false,(Parent) root );}}
	   
	   
}
