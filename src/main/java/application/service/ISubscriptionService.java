/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.service;

import application.bean.Subscription;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public interface ISubscriptionService {
	
	public void addSubscription(Subscription sub);
	public void editSubscription(Subscription sub);

}
