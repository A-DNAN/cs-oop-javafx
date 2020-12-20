/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.service;

import application.bean.AvailabilityTimetable;
import application.bean.Equipment;
import application.bean.Trainer;
import javafx.collections.ObservableList;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public interface IAvailabilityTimetableService {
	public ObservableList<AvailabilityTimetable> findAll();

}
