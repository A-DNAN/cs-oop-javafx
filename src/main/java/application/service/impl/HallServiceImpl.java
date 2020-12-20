package application.service.impl;

import application.bean.Hall;
import application.dao.HallReporsitory;
import application.service.IHallService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author ADNAN <ADNAN.E@TUTANOTA.DE>
 **/

public class HallServiceImpl implements IHallService{

	HallReporsitory hallReporsitory;
	public HallReporsitory getHallReporsitory() {return (hallReporsitory==null)?hallReporsitory=new HallReporsitory():hallReporsitory;}


	@Override
	public ObservableList<Hall> findAll() {
	    ObservableList<Hall> halls = FXCollections.observableArrayList();
	    halls.addAll(getHallReporsitory().findAll());return halls;}


	@Override
	public void addHall(Hall hall) {getHallReporsitory().create(hall);}

}
