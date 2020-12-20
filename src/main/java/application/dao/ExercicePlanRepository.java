/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.dao;

import application.bean.ExercicePlan;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public class ExercicePlanRepository extends AbstractFacade<ExercicePlan>{

	/**
	 * @param entityClass
	 */
	public ExercicePlanRepository() {
		super(ExercicePlan.class);
	}

}
