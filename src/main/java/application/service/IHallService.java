package application.service;

import application.bean.Hall;
import javafx.collections.ObservableList;

/**
 * @author ADNAN <ADNAN.E@TUTANOTA.DE>
 **/

public interface IHallService {

	
	public ObservableList<Hall> findAll();
	public void addHall(Hall hall);
	
	
}
