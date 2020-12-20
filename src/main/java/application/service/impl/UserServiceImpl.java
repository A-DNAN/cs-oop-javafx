package application.service.impl;

import java.io.IOException;
import java.util.Optional;

import application.App;
import application.bean.User;
import application.bean.UserSession;
import application.dao.UserRepository;
import application.service.IUserService;

/**
 * @author ADNAN <ADNAN.E@TUTANOTA.DE>
 **/

public class UserServiceImpl implements IUserService{
    @Deprecated
	private UserRepository userRepository;
	public UserRepository getUserRepository(){return (userRepository==null)?userRepository=new UserRepository():userRepository;}
	
	@Override
	public Boolean isAuthorized(String username, String password) {
		Optional<User> user = Optional.ofNullable(getUserRepository().find(username.toLowerCase()));
		if(user.isPresent() && user.get().getPassword().equals(password)) {UserSession.setInstance(user.get(),null);return true;};
		return false;}

	@Override
	public void redirectUser(String from,String to) throws IOException {
		if(from.equalsIgnoreCase("SIGNIN") && to.equalsIgnoreCase("DASHBOARD")) {
			if(UserSession.getSessionId()!=null) {
		    	switch (UserSession.getUser().getUserType()) {
				case "MANAGER": {
					App.changeStageWOEvent("Dashboard", null, false, null, "Manager Dashboard", true,null);
					break;}
		           case "TRAINER": {
		        	 App.changeStageWOEvent("TrainerDashboard", null, false, null, "Trainer Dashboard", true,null);
					break;}
				default:
		        	App.changeStageWOEvent("CustomerDashboard", null, false, null, "Dashboard", true,null);
//					App.setRoot("CustomerDashboard","Dashboard");
					break;}}
		}
		
		if(from.equalsIgnoreCase("SIGNUP") && to.equalsIgnoreCase("SIGNIN")) {
			App.setRoot("Login","Sign in");
		}
		
		if(from.equalsIgnoreCase("SIGNIN") && to.equalsIgnoreCase("SIGNUP")) {
			App.setRoot("SignUp","Sign up");
		}
      
	}

	@Override
	public void addtUser(User user) {
           getUserRepository().create(user);
	}

	@Override
	public void updateUser(User user) {
        getUserRepository().edit(user);
		
	}

	
	
}
