package com.travelmanagement.models;

import java.util.Date;

/*import java.util.Date;
*/

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Travel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String src;
	private String des;
	private Date st;
	private Date en;
	
	@ManyToOne
	private UserLogin userlogin;
	
	
	public Travel() {
		super();
	}
	
	

	public Travel(int id, String name, String src, String des, Date st, Date en,String uname) {
		super();
		this.id = id;
		this.name = name;
		this.src = src;
		this.des = des;
		this.st = st;
		this.en = en;
		this.userlogin = new UserLogin(uname,"");
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public Date getSt() {
		return st;
	}
	public void setSt(Date st) {
		this.st = st;
	}
	public Date getEn() {
		return en;
	}
	public void setEn(Date en) {
		this.en = en;
	}



	public UserLogin getUserlogin() {
		return userlogin;
	}



	public void setUserlogin(UserLogin userlogin) {
		this.userlogin = userlogin;
	}
	

	
	
	
	

}
