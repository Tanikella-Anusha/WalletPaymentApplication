//package com.paymentapp.beans;
//
//import java.util.Objects;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Inheritance;
//import javax.persistence.InheritanceType;
//import javax.persistence.Table;
//import javax.validation.constraints.Pattern;
//
//@Entity
//@Table(name = "user")
//@Inheritance(strategy = InheritanceType.JOINED)
//public class User {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "uid")
//	private int uId;
//
//	@Column(name = "username", nullable = false)
//	@Pattern(regexp = "^[a-zA-Z0-9.-_]{1,20}$", message = "Name must contain alphabets and  may contain (./-/_)  and length from 1 to 20 characters")
//	private String username;
//
//	@Column(name = "password", nullable = false)
//	@Pattern(regexp = "^[a-zA-Z0-9.-_]{1,20}$", message = "Password must contain alphabets and  may contain (./-/_)  and length from 1 to 20 characters")
//	private String password;
//
//	public User(int uId,
//			@Pattern(regexp = "^[a-zA-Z0-9.-_]{1,20}$", message = "Name must contain alphabets and  may contain (./-/_)  and length from 1 to 20 characters") String username,
//			@Pattern(regexp = "^[a-zA-Z0-9.-_]{1,20}$", message = "Password must contain alphabets and  may contain (./-/_)  and length from 1 to 20 characters") String password) {
//		super();
//		this.uId = uId;
//		this.username = username;
//		this.password = password;
//	}
//
//	
//	public User() {
//		super();
//	}
//
//
//	public int getuId() {
//		return uId;
//	}
//
//	public void setuId(int uId) {
//		this.uId = uId;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	@Override
//	public String toString() {
//		return "User [uId=" + uId + ", username=" + username + ", password=" + password + "]";
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(password, uId, username);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		User other = (User) obj;
//		return Objects.equals(password, other.password) && uId == other.uId && Objects.equals(username, other.username);
//	}
//
//
//	
//	
//	
//	
//	
//}