/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.dao;

import application.bean.Membership;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public class MembershipRepository extends AbstractFacade<Membership>{

	/**
	 * @param entityClass
	 */
	public MembershipRepository() {
		super(Membership.class);
	}

}
