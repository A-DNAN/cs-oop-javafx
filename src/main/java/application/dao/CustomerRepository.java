/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.dao;

import application.bean.Customer;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public class CustomerRepository extends AbstractFacade<Customer>{

	public CustomerRepository() {
		super(Customer.class);
	}

}
