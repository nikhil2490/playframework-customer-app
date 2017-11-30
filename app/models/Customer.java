/**
 * 
 */
/**
 * @author Nikhil
 *
 */
package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.avaje.ebean.Model;

@Entity
public class Customer extends Model{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Integer id;
	public String name;
	public String address;
	
	public static Finder<Integer,Customer> find = new Finder(Customer.class); 

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddres() {
		return address;
	}

	public void setAddres(String addres) {
		this.address = addres;
	}

}