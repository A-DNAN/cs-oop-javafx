/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
class ExerciceServiceImplTest {
	@Deprecated
    private ExerciceServiceImpl exerciceServiceImpl;
	public ExerciceServiceImpl getExerciceServiceImpl() {return (exerciceServiceImpl==null)?exerciceServiceImpl=new ExerciceServiceImpl():exerciceServiceImpl;}
	
	
	@Test
	void findAllTest() {
		assertDoesNotThrow(()->getExerciceServiceImpl().findAll() );
	}

}
