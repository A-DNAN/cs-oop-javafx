package application.bean;

import java.io.Serializable;
import java.net.URL;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author ADNAN <ADNAN.E@TUTANOTA.DE>
 **/
@Entity
@Cacheable(false)
public class ProfileData implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;
	private URL profilePictureUrl;
	private URL videoUrl;
	@OneToMany(mappedBy = "ProfileDataId")
	List<Picture> pictures;
	public ProfileData() {
		super();
	}
	public ProfileData(Integer id, URL profilePictureUrl, URL videoUrl, List<Picture> pictures) {
		super();
		this.id = id;
		this.profilePictureUrl = profilePictureUrl;
		this.videoUrl = videoUrl;
		this.pictures = pictures;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public URL getProfilePictureUrl() {
		return profilePictureUrl;
	}
	public void setProfilePictureUrl(URL profilePictureUrl) {
		this.profilePictureUrl = profilePictureUrl;
	}
	public URL getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(URL videoUrl) {
		this.videoUrl = videoUrl;
	}
	public List<Picture> getPictures() {
		return pictures;
	}
	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}
	
	

}
