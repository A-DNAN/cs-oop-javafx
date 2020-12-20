package application.service;

import java.io.IOException;

import application.bean.User;

/**
 * @author ADNAN <ADNAN.E@TUTANOTA.DE>
 **/

public interface IUserService {

	public Boolean isAuthorized(String username, String password);
	public void redirectUser(String from, String to) throws IOException;
	public void addtUser(User user);
	public void updateUser(User user);
	
	
}
