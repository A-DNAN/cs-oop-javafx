package application.bean;

import java.io.File;
import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

/**
 * @author ADNAN <ADNAN.E@TUTANOTA.DE>
 **/

@Entity
@Cacheable(false)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Profile implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;
	private File picture;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String moreDetails;
	@OneToOne
	private ProfileData profileDataId;
	@OneToOne(mappedBy = "profile")
	private User user;
	public Profile() {
		super();
	}
	
	public Profile(String firstName, String lastName, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public File getPicture() {
		return picture;
	}
	public void setPicture(File picture) {
		this.picture = picture;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getMoreDetails() {
		return moreDetails;
	}
	public void setMoreDetails(String moreDetails) {
		this.moreDetails = moreDetails;
	}
	public ProfileData getProfileDataId() {
		return profileDataId;
	}
	public void setProfileDataId(ProfileData profileDataId) {
		this.profileDataId = profileDataId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return  firstName + " " + lastName ;
	}
	

	
}
