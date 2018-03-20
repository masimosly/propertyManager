package cn.com.fourwind.propertyManager.security;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AdminUser {
	@Id
	@GeneratedValue
	private Long  id;
	
	private String username;
	private String password;
	private String type;
	private String role;
	private String doorNumber;
	private String certificate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDoorNumber() {
		return doorNumber;
	}
	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public AdminUser() {
	}
	public AdminUser(String username, String password, String type, String role, String doorNumber,
			String certificate) {
		super();
		this.username = username;
		this.password = password;
		this.type = type;
		this.role = role;
		this.doorNumber = doorNumber;
		this.certificate = certificate;
	}
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\",\"username\":\"" + username + "\",\"password\":\"" + password + "\",\"type\":\""
				+ type + "\",\"role\":\"" + role + "\",\"doorNumber\":\"" + doorNumber + "\",\"certificate\":\""
				+ certificate + "\"} ";
	}
	
	
}
