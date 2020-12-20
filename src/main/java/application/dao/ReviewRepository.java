/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.dao;

import application.bean.Review;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public class ReviewRepository extends AbstractFacade<Review>{

	/**
	 * @param entityClass
	 */
	public ReviewRepository() {
		super(Review.class);
	}

}
