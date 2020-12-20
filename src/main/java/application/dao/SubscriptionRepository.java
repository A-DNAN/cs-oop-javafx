/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.dao;

import application.bean.Subscription;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public class SubscriptionRepository extends AbstractFacade<Subscription>{

	/**
	 * @param entityClass
	 */
	public SubscriptionRepository() {
		super(Subscription.class);
	}

}
