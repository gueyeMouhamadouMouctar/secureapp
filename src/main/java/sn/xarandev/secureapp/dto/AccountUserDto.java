package sn.xarandev.secureapp.dto;

import javax.persistence.Column;

public class AccountUserDto {
	
	private int id ;
	private String email ;
	private String password ;
	private boolean state ;
	private String firstname ;
	private String lastname ;
	private String profil ;
	
	
	
	
	public AccountUserDto(int id, String email, String firstname, String lastname,
			String profil, String password, boolean state) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.state = state;
		this.firstname = firstname;
		this.lastname = lastname;
		this.profil = profil;
	}
	public AccountUserDto() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getProfil() {
		return profil;
	}
	public void setProfil(String profil) {
		this.profil = profil;
	}
	
}
