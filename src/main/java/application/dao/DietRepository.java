/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.dao;

import application.bean.Diet;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public class DietRepository extends AbstractFacade<Diet>{

	/**
	 * @param entityClass
	 */
	public DietRepository() {
		super(Diet.class);
	}

}
