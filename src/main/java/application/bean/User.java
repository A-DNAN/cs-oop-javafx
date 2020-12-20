package application.bean;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author ADNAN <ADNAN.E@TUTANOTA.DE>
 **/

@Entity
@Cacheable(false)
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private String username;
	private String email;
	private String password;
	// Manager xor Trainer xor Customer || it may be removed
	private String userType;
	@OneToOne(cascade = CascadeType.PERSIST)
	private Profile profile;

	
	public User() {super();}
	public User(String username, String email, String password, String userType) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.userType = userType;}

	public String getUserType() {
		return userType;
	}

	public User(String username, String email, String password, String userType, Profile profile) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.userType = userType;
		this.profile = profile;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	
}
