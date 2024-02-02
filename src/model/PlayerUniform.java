package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**  
* Ezra DeCleene - ecdecleene  
* CIS171 22149
* Jan 30, 2024  
*/
@Entity
@Table(name="uniforms")
public class PlayerUniform {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="NUMBER")
	private String number;
	@Column(name="NAME")
	private String name;
	
	public PlayerUniform(){
		
	}
	
	/**
	 * @param number
	 * @param name
	 */
	public PlayerUniform(String number, String name) {
		super();
		this.number = number;
		this.name = name;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public String returnItemDetails() {
		return this.number + ": " + this.name;
	}
}
