/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import application.dao.UserRepository;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
class UserServiceImplTest {

	 @Deprecated
		private UserServiceImpl userServiceImpl;
		public UserServiceImpl getUserServiceImpl(){return (userServiceImpl==null)?userServiceImpl=new UserServiceImpl():userServiceImpl;}
		
	
	@Test
	void isAutorizedTest() {
		String username = "c1";
		String password = "123";
		assertTrue(getUserServiceImpl().isAuthorized(username, password));
	}
	@Test
	void redirectTest() {
		assertDoesNotThrow(()->getUserServiceImpl().redirectUser("SIGNIN", "DASHBOARD"));
	}
	
	

}
