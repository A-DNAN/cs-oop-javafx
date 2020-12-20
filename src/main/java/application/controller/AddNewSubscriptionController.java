/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.controller;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import org.controlsfx.control.CheckComboBox;
import application.bean.AvailabilityTimetable;
import application.bean.Customer;
import application.bean.ExercicePlan;
import application.bean.Hall;
import application.bean.Membership;
import application.bean.Subscription;
import application.bean.Trainer;
import application.bean.UserSession;
import application.dao.ExercicePlanRepository;
import application.dao.MembershipRepository;
import application.service.impl.AvailabilityTimetableServiceImpl;
import application.service.impl.ExercicePlanServiceImpl;
import application.service.impl.MembershipServiceImpl;
import application.service.impl.SubscriptionServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public class AddNewSubscriptionController implements Initializable{

	    @FXML
	    private ComboBox<Trainer> trainerCB;

	    @FXML
	    private CheckComboBox<ExercicePlan> exercicePlanCCB;

	    @FXML
	    private CheckComboBox<AvailabilityTimetable> timeSelectionCCB;
	    @Deprecated
		private AvailabilityTimetableServiceImpl availabilityTimetableServiceImpl;
		public AvailabilityTimetableServiceImpl getAvailabilityTimetableServiceImpl() {return (availabilityTimetableServiceImpl==null)?availabilityTimetableServiceImpl=new AvailabilityTimetableServiceImpl():availabilityTimetableServiceImpl;}
		@Deprecated
		private MembershipServiceImpl membershipServiceImpl;
		public MembershipServiceImpl getMembershipServiceImpl() {return (membershipServiceImpl==null)?membershipServiceImpl=new MembershipServiceImpl():membershipServiceImpl;}
		@Deprecated
		private ExercicePlanServiceImpl exercicePlanServiceImpl;
		public ExercicePlanServiceImpl getExercicePlanServiceImpl() {return (exercicePlanServiceImpl==null)?exercicePlanServiceImpl=new ExercicePlanServiceImpl():exercicePlanServiceImpl;}
		@Deprecated
		private SubscriptionServiceImpl subscriptionServiceImpl;
		public SubscriptionServiceImpl getSubscriptionServiceImpl() {return (subscriptionServiceImpl==null)?subscriptionServiceImpl=new SubscriptionServiceImpl():subscriptionServiceImpl;}

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		timeSelectionCCB.getItems().addAll(getAvailabilityTimetableServiceImpl().findAll());
		trainerCB.setDisable(true);
		exercicePlanCCB.setDisable(true);
	}
// continue from here
	
	@FXML
   private void saveIt(ActionEvent event) {
	if(trainerCB.getSelectionModel().getSelectedItem()!=null && !exercicePlanCCB.getCheckModel().getCheckedItems().isEmpty()) {
		Customer c = (Customer) UserSession.getUser().getProfile();
		if(c.getMembershipId()==null){
			Membership m = new Membership();
			m.setCustomerId(c);
			m.setStartDate(LocalDateTime.now().toString());
			getMembershipServiceImpl().addMembership(m);
			c.setMembershipId(m);
		}
		exercicePlanCCB.getCheckModel().getCheckedItems().forEach(ep->
		{
			if(!ep.getCustomers().stream().anyMatch(cu-> String.valueOf(c.getId()).equalsIgnoreCase(String.valueOf(cu.getId())))) {
				ep.getCustomers().add(c);
				ep.setCustomers(ep.getCustomers());
				getExercicePlanServiceImpl().updateExercicePlan(ep);
				
				Subscription subsc = new Subscription();
				subsc.setMembershipId(c.getMembershipId());
				subsc.setResponsibleTrainer(trainerCB.getSelectionModel().getSelectedItem());
				subsc.setStartDate(LocalDateTime.now().toString());
				getSubscriptionServiceImpl().addSubscription(subsc);
				CustomerDashboardController.subscriptions.add(subsc);
				if(!CustomerDashboardController.myTrainers.stream().anyMatch( tr-> String.valueOf(tr.getId()).equalsIgnoreCase(String.valueOf(trainerCB.getSelectionModel().getSelectedItem().getId())))){
					CustomerDashboardController.myTrainers.add(trainerCB.getSelectionModel().getSelectedItem());}
			}
		});
		((Stage)((Node)event.getSource()).getScene().getWindow()).close();
	}
	}
	
	
	
	@FXML
	void activateC(MouseEvent event) {
		if(!timeSelectionCCB.isDisable()) {
			if(getIsClosed() ) {
				 timeSelectionCCB.show(); setIsClosed(false);}else {
				 timeSelectionCCB.hide();
					var times =timeSelectionCCB.getCheckModel().getCheckedItems();
					   if(!times.isEmpty()){
						  var tr = trainerCB.getSelectionModel().getSelectedItem();
					   var aTrainers = new ArrayList<Trainer>();   
					   times.stream().map(AvailabilityTimetable::getTrainers).forEach(aTrainers::addAll);
					   trainerCB.getItems().clear();	   
					   trainerCB.getItems().addAll(aTrainers.stream().distinct().collect(Collectors.toList()));
					   timeSelectionCCB.setDisable(true);
					   if(aTrainers.contains(tr)) {
						   trainerCB.getSelectionModel().select(tr);
					 }else {trainerCB.getSelectionModel().clearSelection();}
					       trainerCB.setDisable(false);}else {
						   trainerCB.getItems().clear();trainerCB.setDisable(true);}
				 setIsClosed(true);
			 }
		}
	}
	
	 @FXML
	    void activateEP(ActionEvent event) {
		 exercicePlanCCB.getCheckModel().clearChecks();
		 exercicePlanCCB.getItems().clear();
		 exercicePlanCCB.setDisable(false);
		 if(trainerCB.getSelectionModel().getSelectedItem()!=null) {
			 exercicePlanCCB.getItems().addAll(trainerCB.getSelectionModel().getSelectedItem().getExercicePlans());}}
	 
	 
	 @FXML
	    void enableTimeSelection(MouseEvent event) {
		 timeSelectionCCB.setDisable(false);
		 trainerCB.getSelectionModel().clearSelection();
		 trainerCB.getItems().clear();
		 trainerCB.setDisable(true);
		 exercicePlanCCB.getCheckModel().clearChecks();
		 exercicePlanCCB.getItems().clear();
		 exercicePlanCCB.setDisable(true);
	    }
	 private Boolean isClosed = true;
	public Boolean getIsClosed() {
		return isClosed;
	}
	public void setIsClosed(Boolean isClosed) {
		this.isClosed = isClosed;}

}
