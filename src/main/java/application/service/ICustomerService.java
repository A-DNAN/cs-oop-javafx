/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.service;

import application.bean.Customer;
import application.bean.Diet;
import application.bean.Subscription;
import application.bean.Trainer;
import javafx.collections.ObservableList;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public interface ICustomerService {

	
	public void updateTrainer(Customer customer);
	public void addTrainer(Customer customer);
    public ObservableList<Subscription> findAllSubscriptionByCustomerID(Integer id);
    public ObservableList<Trainer> findAllTrainerByCustomerID(Integer id);
    public ObservableList<Diet> findAllDietByCustomerID(Integer id);
	
}
