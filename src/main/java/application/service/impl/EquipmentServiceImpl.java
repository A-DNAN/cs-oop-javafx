package application.service.impl;

import application.bean.Equipment;
import application.dao.EquipmentRepository;
import application.service.IEquipmentService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author ADNAN <ADNAN.E@TUTANOTA.DE>
 **/

public class EquipmentServiceImpl implements IEquipmentService{

	@Deprecated
	private EquipmentRepository equipmentRepository;
	public EquipmentRepository getEquipmentRepository() {return (equipmentRepository==null)?equipmentRepository=new EquipmentRepository():equipmentRepository;}

	
	@Override
	public ObservableList<Equipment> findAll() {
	    ObservableList<Equipment> equipments = FXCollections.observableArrayList();
	    equipments.addAll(getEquipmentRepository().findAll());return equipments;}


	@Override
	public void addEquipment(Equipment equipment) {getEquipmentRepository().create(equipment);}

	
}
