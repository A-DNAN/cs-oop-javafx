/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import application.bean.Customer;
import application.bean.Diet;
import application.bean.ExercicePlan;
import application.bean.Membership;
import application.bean.Subscription;
import application.bean.Trainer;
import application.dao.TrainerRepository;
import application.service.ITrainerService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public class TrainerServiceImpl implements ITrainerService {
    @Deprecated
	private TrainerRepository trainerRepository;
	public TrainerRepository getTrainerRepository() {return (trainerRepository==null)?trainerRepository=new TrainerRepository():trainerRepository;}
	
	@Override
	public ObservableList<Diet> findAllDietsOfATrainer(Integer trainerId) {
		ObservableList<Diet> diets = FXCollections.observableArrayList();
		diets.addAll(getTrainerRepository().find(trainerId).getDiets());return diets;}

	@Override
	public ObservableList<ExercicePlan> findAllExercicePlansOfATrainer(Integer trainerId) {
		ObservableList<ExercicePlan> exercicePlans = FXCollections.observableArrayList();
		exercicePlans.addAll(getTrainerRepository().find(trainerId).getExercicePlans());return exercicePlans;}

	@Override
	public ObservableList<Customer> findAllMyCustomersBySubscription(Integer trainerId) {
		List<Subscription> subscriptions = getTrainerRepository().find(trainerId).getManagedSubscriptions();
		ObservableList<Customer> customers = FXCollections.observableArrayList();
		customers.addAll(subscriptions.stream().map(Subscription::getMembershipId).collect(Collectors.toList()).stream()
				.map(Membership::getCustomerId).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList()));
		return customers;}

	@Override
	public ObservableList<Trainer> findAll() {
		ObservableList<Trainer> trainers = FXCollections.observableArrayList();
		trainers.addAll(getTrainerRepository().findAll());return trainers;}

	@Override
	public void addTrainer(Trainer trainer) {getTrainerRepository().create(trainer);}

	@Override
	public void updateTrainer(Trainer trainer) {
		getTrainerRepository().edit(trainer);
	}


    

	

}
