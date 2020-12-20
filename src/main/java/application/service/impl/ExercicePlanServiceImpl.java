/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.service.impl;

import application.bean.ExercicePlan;
import application.dao.AvailabilityTimetableRepository;
import application.dao.ExercicePlanRepository;
import application.service.IExercicePlanService;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public class ExercicePlanServiceImpl implements IExercicePlanService{

	@Deprecated
	private ExercicePlanRepository exercicePlanRepository;
	public ExercicePlanRepository getExercicePlanRepository() {return (exercicePlanRepository==null)?exercicePlanRepository=new ExercicePlanRepository():exercicePlanRepository;}

	
	
	
	@Override
	public void addExercicePlan(ExercicePlan ep) {getExercicePlanRepository().create(ep);}

	@Override
	public void updateExercicePlan(ExercicePlan ep) {getExercicePlanRepository().edit(ep);}

}
