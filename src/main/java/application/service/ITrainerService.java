/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.service;

import application.bean.Customer;
import application.bean.Diet;
import application.bean.ExercicePlan;
import application.bean.Trainer;
import javafx.collections.ObservableList;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public interface ITrainerService {
	
	public void addTrainer(Trainer trainer);
	public void updateTrainer(Trainer trainer);
	public ObservableList<Trainer> findAll();
	public ObservableList<Diet> findAllDietsOfATrainer(Integer trainerId);
	public ObservableList<ExercicePlan> findAllExercicePlansOfATrainer(Integer trainerId);
	//list of subscription - > list of membership - > list of customers
	public ObservableList<Customer> findAllMyCustomersBySubscription(Integer trainerId);
	
	
}
