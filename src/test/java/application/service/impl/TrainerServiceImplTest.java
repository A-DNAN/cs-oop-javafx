/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
class TrainerServiceImplTest {
	    @Deprecated
	    private TrainerServiceImpl trainerServiceImpl;
		public TrainerServiceImpl getTrainerServiceImpl() {return (trainerServiceImpl==null)?trainerServiceImpl=new TrainerServiceImpl():trainerServiceImpl;}
		
	@Test
	void findAllDietsOfATrainerTest() {
    assertDoesNotThrow(()-> getTrainerServiceImpl().findAllDietsOfATrainer(51));
	}
	@Test
	void findAllExercicePlansOfATrainerTest() {
		assertDoesNotThrow(()-> getTrainerServiceImpl().findAllExercicePlansOfATrainer(51));
	}
	@Test
	void findAllMyCustomersBySubscriptionTest() {
		assertDoesNotThrow(()-> getTrainerServiceImpl().findAllMyCustomersBySubscription(51));
	}
	@Test
	void findAllTest() {
		assertDoesNotThrow(()-> getTrainerServiceImpl().findAll());
	}

}
