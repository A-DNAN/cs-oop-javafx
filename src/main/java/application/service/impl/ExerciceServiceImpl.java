/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.service.impl;

import application.bean.Exercice;
import application.dao.ExerciceRepository;
import application.service.IExerciceService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public class ExerciceServiceImpl implements IExerciceService{

	@Deprecated
	private ExerciceRepository exerciceRepository;
	public ExerciceRepository getExerciceRepository() {return (exerciceRepository==null)?exerciceRepository=new ExerciceRepository():exerciceRepository;}

	
	@Override
	public ObservableList<Exercice> findAll() {
		    ObservableList<Exercice> exercices = FXCollections.observableArrayList();
		    exercices.addAll(getExerciceRepository().findAll());return exercices;}

	
}
