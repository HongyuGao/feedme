package org.foodie.server.infor;
/**
 * @author Danyang Li
 */
import java.util.Date;

import org.foodie.server.entity.User;

public class UserInfo extends Infor{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	
	private String firstname;
	
	private String lastname;
	
	private Date birthday;
	
	private String password;
	
	private Date register_time;
	
	private String preferedLanguage;
	 
	private String photo;
	 
	private String phoneNumber;
	 
	private String email;
	 
	private String title;
	
	public UserInfo(){
		
	}
	  
	public UserInfo(final long id){
		this.id=id;		
	}
	
	public UserInfo(final String email, final String password){
		this.email=email;
		this.password=password;
	}
	
	public UserInfo(final User user){
		this.id=user.getId();
		this.firstname=user.getFirstname();
		this.lastname=user.getLastname();
		this.birthday=user.getBirthday();
		this.password=user.getPassword();
		this.preferedLanguage=user.getPreferedLanguage();
		this.register_time=user.getRegister_time();
		this.phoneNumber=user.getPhoneNumber();
		this.photo=user.getPhoneNumber();
		this.title=user.getTitle();
	}
	
	public UserInfo(final String errorInfo, final Integer statusCode){
		super(errorInfo,statusCode);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegister_time() {
		return register_time;
	}

	public void setRegister_time(Date register_time) {
		this.register_time = register_time;
	}

	public String getPreferedLanguage() {
		return preferedLanguage;
	}

	public void setPreferedLanguage(String preferedLanguage) {
		this.preferedLanguage = preferedLanguage;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	} 
}
