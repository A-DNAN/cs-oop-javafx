/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 */
package application.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import application.dao.EquipmentRepository;

/**
 * @Author ADNAN <ADNAN.E@TUTANTA.DE>
 *
 */
class EquipmentServiceImplTest {
	@Deprecated
	private EquipmentServiceImpl equipmentServiceImpl;
	public EquipmentServiceImpl getEquipmentServiceImpl() {return (equipmentServiceImpl==null)?equipmentServiceImpl=new EquipmentServiceImpl():equipmentServiceImpl;}

	
	@Test
	void findAllTest() {
		assertDoesNotThrow( ()->getEquipmentServiceImpl().findAll() );
	}

}
