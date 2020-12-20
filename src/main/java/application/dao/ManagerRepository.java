/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.dao;

import application.bean.Manager;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public class ManagerRepository extends AbstractFacade<Manager> {

	/**
	 * @param entityClass
	 */
	public ManagerRepository() {
		super(Manager.class);
	}

}
