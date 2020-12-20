package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import application.service.impl.UserServiceImpl;


/**
 * JavaFX App
 */
public class App extends Application {

	private static Scene scene;
	private static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
    	App.stage = stage;
    	scene = new Scene(loadFXML("Login","Sign in"));
        stage.setMinWidth(800);
        stage.setMinHeight(560);
        stage.setMaximized(false);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.getIcons().add(new Image(getClass().getResource("/image/logo.png").toString()));
//        stage.initStyle(Staga2eStyle.UNDECORATED);
        App.stage.show();
    }

    public static void setRoot(String fxml,String stageTitle) throws IOException {
        scene.setRoot(loadFXML(fxml,stageTitle));
    }

    private static Parent loadFXML(String fxml,String stageTitle) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/view/"+fxml + ".fxml"));
        stage.setTitle(stageTitle);
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
    	launch();
    }
    public static void changeStage(ActionEvent event,MouseEvent mEvent,String fxml , String cssUrl, boolean resizableProperty, String iconUrl , String stageTitle, Boolean closeOld) throws IOException  {
    	if(closeOld) {if(mEvent!=null) {((Stage)((Node)mEvent.getSource()).getScene().getWindow()).close();}
    		else if(event!=null) {((Stage)((Node)event.getSource()).getScene().getWindow()).close();}}
    	Parent Root = FXMLLoader.load(App.class.getResource("/view/"+fxml + ".fxml"));
    	stage = new Stage();
    	stage.centerOnScreen();
    	stage.getIcons().add(new Image(App.class.getResource("/image/logo.png").toString()));
    	scene = new Scene(Root);
    	// --- Wahlweise 
    	if (cssUrl != null && !cssUrl.equals("")){
    		scene.getStylesheets().add(cssUrl);}
    	stage.resizableProperty().setValue(resizableProperty);
    	if (iconUrl != null && !iconUrl.equals("")){
    		Image image = new Image(iconUrl);
    		stage.getIcons().add(image);
    	}
    	// -------------------------------
    	stage.setScene(scene);
    	stage.setTitle(stageTitle);
//    	stage.showAndWait();
    	stage.show();
    	
    }
    public static void changeStageWOEvent(String fxml , String cssUrl, boolean resizableProperty, String iconUrl , String stageTitle, Boolean closeOld, Parent sendedRoot) throws IOException {
    	if(closeOld) {stage.close();}
    	if(sendedRoot==null) {
    		Parent Root = FXMLLoader.load(App.class.getResource("/view/"+fxml + ".fxml"));
    		scene = new Scene(Root);}else {scene = new Scene(sendedRoot);}
    	stage = new Stage();
    	stage.centerOnScreen();
    	stage.getIcons().add(new Image(App.class.getResource("/image/logo.png").toString()));
    	if (cssUrl != null && !cssUrl.equals("")){
    		scene.getStylesheets().add(cssUrl);}
    	stage.resizableProperty().setValue(resizableProperty);
    	if (iconUrl != null && !iconUrl.equals("")){
    		Image image = new Image(iconUrl);
    		stage.getIcons().add(image);
    	}
    	stage.setScene(scene);
    	stage.setTitle(stageTitle);
    	stage.show();
    }

}