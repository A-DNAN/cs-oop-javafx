package application.bean;

import java.io.Serializable;
import java.net.URL;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author ADNAN <ADNAN.E@TUTANOTA.DE>
 **/

@Entity
@Cacheable(false)
public class Picture implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;
	private URL picture;
	@ManyToOne
	private ProfileData ProfileDataId;
	public Picture(Integer id, URL picture, ProfileData profileDataId) {
		super();
		this.id = id;
		this.picture = picture;
		ProfileDataId = profileDataId;
	}
	public Picture() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public URL getPicture() {
		return picture;
	}
	public void setPicture(URL picture) {
		this.picture = picture;
	}
	public ProfileData getProfileDataId() {
		return ProfileDataId;
	}
	public void setProfileDataId(ProfileData profileDataId) {
		ProfileDataId = profileDataId;
	}
	
	
	
	
	
	
}
