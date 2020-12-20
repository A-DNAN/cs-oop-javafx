/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.service.impl;

import application.bean.Membership;
import application.dao.ManagerRepository;
import application.dao.MembershipRepository;
import application.service.IMembershipService;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public class MembershipServiceImpl implements IMembershipService{
	@Deprecated
	private MembershipRepository membershipRepository;
	public MembershipRepository getMembershipRepository() {return (membershipRepository==null)?membershipRepository=new MembershipRepository():membershipRepository;}

	
	@Override
	public void addMembership(Membership membership) {getMembershipRepository().create(membership);}
	@Override
	public void updateMembership(Membership membership) {getMembershipRepository().edit(membership);}

}
