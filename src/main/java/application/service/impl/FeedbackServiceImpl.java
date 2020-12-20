/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.service.impl;

import application.bean.Feedback;
import application.dao.FeedbackRepository;
import application.service.IFeedbackService;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public class FeedbackServiceImpl implements IFeedbackService{
    @Deprecated
	private FeedbackRepository feedbackRepository;
	public FeedbackRepository getFeedbackRepository() {if(feedbackRepository==null) {feedbackRepository= new FeedbackRepository();}return feedbackRepository;}

	@Override
	public void addFeedback(Feedback feedback) {getFeedbackRepository().create(feedback);}
		

	
	
}
