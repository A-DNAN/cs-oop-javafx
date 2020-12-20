/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.service.impl;

import application.bean.Subscription;
import application.dao.ManagerRepository;
import application.dao.SubscriptionRepository;
import application.service.ISubscriptionService;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public class SubscriptionServiceImpl implements ISubscriptionService{
	@Deprecated
	private SubscriptionRepository subscriptionRepository;
	public SubscriptionRepository getSubscriptionRepository() {return (subscriptionRepository==null)?subscriptionRepository=new SubscriptionRepository():subscriptionRepository;}

	
	@Override
	public void addSubscription(Subscription sub) {getSubscriptionRepository().create(sub);}

	@Override
	public void editSubscription(Subscription sub) {getSubscriptionRepository().edit(sub);}

}
