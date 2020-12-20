package application.bean;

import java.util.Set;

/**
 * @author ADNAN <ADNAN.E@TUTANOTA.DE>
 **/

public final class UserSession  {

	private static UserSession instance;
    private static User user;
    private static String sessionId;
    private static Set<String> privileges;

    private UserSession(User user, Set<String> privileges,String sessionId) {
        UserSession.user = user;
        UserSession.privileges = privileges;
        UserSession.sessionId = sessionId;
    }
    public static UserSession getInstance() {
		return instance;
	}
	public static void setInstance(User user, Set<String> privileges) {
    	 if(UserSession.instance == null && user!=null) {
//    		 user.setPassword(null);
    		 sessionId = user.getUsername()+"-"+System.currentTimeMillis();
    		 UserSession.instance = new UserSession(user, privileges, sessionId);
         }
	}


    public static Set<String> getPrivileges() {
        return privileges;
    }

	public static User getUser() {
		return user;
	}
	
	public static String getSessionId() {
		return sessionId;
	}

	public static void cleanUserSession() {
        user = null;
        privileges = null;
        sessionId =null;
        instance = null;
    }

    @Override
    public String toString() {
        return "UserSession : " + sessionId;
    }
	
}
