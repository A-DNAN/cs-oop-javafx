package application.service;

import application.bean.Equipment;
import javafx.collections.ObservableList;

/**
 * @author ADNAN <ADNAN.E@TUTANOTA.DE>
 **/

public interface IEquipmentService {
	public ObservableList<Equipment> findAll();
	public void addEquipment(Equipment equipment);
	
}
