package application.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author ADNAN <ADNAN.E@TUTANOTA.DE>
 **/
@Entity
@Cacheable(false)
public class Diet implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String type;
	private String description;
	@ManyToOne
	private Trainer author;
	@ManyToMany
	private List<Customer> customers;
	public Diet() {
		super();
	}
	public Diet(Integer id, String type, String description, Trainer author) {
		super();
		this.id = id;
		this.type = type;
		this.description = description;
		this.author = author;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Trainer getAuthor() {
		return author;
	}
	public void setAuthor(Trainer author) {
		this.author = author;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	
	
}
