/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.service;

import application.bean.Manager;
import javafx.collections.ObservableList;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public interface IManagerService {

	public ObservableList<Manager> findAll();
	public void addManager(Manager manager);
	public void updateManager(Manager manager);
}
