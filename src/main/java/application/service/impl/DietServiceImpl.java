/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.service.impl;

import application.bean.Diet;
import application.dao.DietRepository;
import application.service.IDietService;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
public class DietServiceImpl implements IDietService {

	@Deprecated
	private DietRepository dietRepository;
	public DietRepository getDietRepository() {return (dietRepository==null)?dietRepository=new DietRepository():dietRepository;}

	
	@Override
	public void addDiet(Diet diet) {getDietRepository().create(diet);}

}
