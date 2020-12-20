/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.dao;

import application.bean.AvailabilityTimetable;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public class AvailabilityTimetableRepository extends AbstractFacade<AvailabilityTimetable>{

	/**
	 * @param entityClass
	 */
	public AvailabilityTimetableRepository() {
		super(AvailabilityTimetable.class);
	}

}
