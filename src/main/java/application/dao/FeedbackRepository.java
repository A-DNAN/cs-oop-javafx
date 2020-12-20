/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.dao;

import application.bean.Feedback;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public class FeedbackRepository extends AbstractFacade<Feedback>{

	/**
	 * @param entityClass
	 */
	public FeedbackRepository() {
		super(Feedback.class);
	}

}
