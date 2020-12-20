/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import application.dao.ManagerRepository;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
class ManagerServiceImplTest {
	@Deprecated
	private ManagerServiceImpl managerServiceImpl;
	public ManagerServiceImpl getManagerServiceImpl() {return (managerServiceImpl==null)?managerServiceImpl=new ManagerServiceImpl():managerServiceImpl;}

	@Test
	void findAlltest() {
      assertDoesNotThrow( ()->getManagerServiceImpl().findAll() );
	}

}
