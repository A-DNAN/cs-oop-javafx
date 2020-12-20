/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.service.impl;

import java.util.stream.Collectors;

import application.bean.Customer;
import application.bean.Diet;
import application.bean.Subscription;
import application.bean.Trainer;
import application.dao.CustomerRepository;
import application.dao.UserRepository;
import application.service.ICustomerService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public class CustomerServiceImpl implements ICustomerService{

	@Deprecated
	private CustomerRepository customerRepository;
	public CustomerRepository getCustomerRepository(){return (customerRepository==null)?customerRepository=new CustomerRepository():customerRepository;}
	
	
	@Override
	public ObservableList<Subscription> findAllSubscriptionByCustomerID(Integer id) {
		ObservableList<Subscription> subscriptions = FXCollections.observableArrayList();
		try {
			subscriptions.addAll(getCustomerRepository().find(id).getMembershipId().getSubscriptions());
		} catch (NullPointerException e) {
			return subscriptions;
		}
		
		return subscriptions;}


	@Override
	public ObservableList<Trainer> findAllTrainerByCustomerID(Integer id) {
		ObservableList<Trainer> trainers = FXCollections.observableArrayList();
		try {
		trainers.addAll(getCustomerRepository().find(id).getMembershipId().getSubscriptions().stream().map(Subscription::getResponsibleTrainer).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList()));
		
		} catch (NullPointerException e) {
		return trainers;
		}
		return trainers;
	}

	@Override
	public ObservableList<Diet> findAllDietByCustomerID(Integer id) {
		ObservableList<Diet> diets = FXCollections.observableArrayList();
		try {
			diets.addAll(getCustomerRepository().find(id).getDiets());
		} catch (NullPointerException e) {
			return diets;
		}
		
		return diets;
	}


	@Override
	public void updateTrainer(Customer customer) {getCustomerRepository().edit(customer);}


	@Override
	public void addTrainer(Customer customer) {getCustomerRepository().create(customer);}

}
