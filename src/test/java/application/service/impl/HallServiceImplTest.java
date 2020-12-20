/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import application.bean.Hall;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
class HallServiceImplTest {
	@Deprecated
	private HallServiceImpl hallServiceImpl;
	public HallServiceImpl getHallServiceImpl() {return (hallServiceImpl==null)?hallServiceImpl=new HallServiceImpl():hallServiceImpl;}

	@Test
	void addHallTest() {
//		Hall hl= new Hall();
//		hl.setName("Hall-99");
//		assertDoesNotThrow(()-> getHallServiceImpl().addHall(hl));
	}
	@Test
	void findAllTest() {
		assertDoesNotThrow(()-> getHallServiceImpl().findAll());
	}

}
