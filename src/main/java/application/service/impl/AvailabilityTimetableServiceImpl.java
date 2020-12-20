/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.service.impl;

import application.bean.AvailabilityTimetable;
import application.bean.Equipment;
import application.dao.AvailabilityTimetableRepository;
import application.dao.EquipmentRepository;
import application.service.IAvailabilityTimetableService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public class AvailabilityTimetableServiceImpl implements IAvailabilityTimetableService{


	@Deprecated
	private AvailabilityTimetableRepository availabilityTimetableRepository;
	public AvailabilityTimetableRepository getAvailabilityTimetableRepository() {return (availabilityTimetableRepository==null)?availabilityTimetableRepository=new AvailabilityTimetableRepository():availabilityTimetableRepository;}

	
	
	@Override
	public ObservableList<AvailabilityTimetable> findAll() {
		 ObservableList<AvailabilityTimetable> equipments = FXCollections.observableArrayList();
		 equipments.addAll(getAvailabilityTimetableRepository().findAll());return equipments;}

	
}
