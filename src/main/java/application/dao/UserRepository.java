package application.dao;

import application.bean.User;

/**
 * @author ADNAN <ADNAN.E@TUTANOTA.DE>
 **/

public class UserRepository extends AbstractFacade<User>{

	public UserRepository() {super(User.class);}
}
