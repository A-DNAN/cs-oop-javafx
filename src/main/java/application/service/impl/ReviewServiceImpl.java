/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.service.impl;

import application.bean.Review;
import application.dao.ReviewRepository;
import application.dao.SubscriptionRepository;
import application.service.IReviewService;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public class ReviewServiceImpl implements IReviewService {

	@Deprecated
	private ReviewRepository reviewRepository;
	public ReviewRepository getReviewRepository() {return (reviewRepository==null)?reviewRepository=new ReviewRepository():reviewRepository;}

	
	@Override
	public void addReview(Review review) {getReviewRepository().create(review);}

}
