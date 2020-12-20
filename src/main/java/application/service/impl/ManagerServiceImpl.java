/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.service.impl;

import application.bean.Manager;
import application.dao.ManagerRepository;
import application.service.IManagerService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public class ManagerServiceImpl implements IManagerService {

	@Deprecated
	private ManagerRepository managerRepository;
	public ManagerRepository getManagerRepository() {return (managerRepository==null)?managerRepository=new ManagerRepository():managerRepository;}

	
	@Override
	public ObservableList<Manager> findAll() {
		   ObservableList<Manager> managers = FXCollections.observableArrayList();
		   managers.addAll(getManagerRepository().findAll());return managers;}


	@Override
	public void addManager(Manager manager) {getManagerRepository().create(manager);}


	@Override
	public void updateManager(Manager manager) {getManagerRepository().edit(manager);}

}
