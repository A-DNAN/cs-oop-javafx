
module application {
    requires javafx.controls;
    requires javafx.graphics;
	requires javafx.media;
    requires javafx.fxml;
    requires java.persistence;
    requires java.instrument;
    requires java.sql;
	requires org.controlsfx.controls;
//    requires java.se;
//    opens application to javafx.fxml;
    opens application.bean;
    opens application.controller to javafx.fxml; 
    exports application;
//    exports bean;
    
}