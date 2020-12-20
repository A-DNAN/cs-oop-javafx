/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
class CustomerServiceImplTest {
	    @Deprecated
		private CustomerServiceImpl customerServiceImpl;
		public CustomerServiceImpl getCustomerServiceImpl() {return (customerServiceImpl==null)?customerServiceImpl=new CustomerServiceImpl():customerServiceImpl;}

	@Test
	void findAllSubscriptionByCustomerIDTest() {
		assertDoesNotThrow( ()-> getCustomerServiceImpl().findAllSubscriptionByCustomerID(101) );
	}
	@Test
	void findAllTrainerByCustomerIDTest() {
		assertDoesNotThrow( ()-> getCustomerServiceImpl().findAllTrainerByCustomerID(101) );
	}
	@Test
	void findAllDietByCustomerIDTest() {
		assertDoesNotThrow( ()-> getCustomerServiceImpl().findAllDietByCustomerID(101) );
	}

}
