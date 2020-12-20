/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.dao;

import application.bean.Exercice;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public class ExerciceRepository extends AbstractFacade<Exercice>{

	/**
	 * @param entityClass
	 */
	public ExerciceRepository() {
		super(Exercice.class);
	}

}
