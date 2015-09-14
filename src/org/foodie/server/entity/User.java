package org.foodie.server.entity;
/**
 * @author Danyang Li
 */
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents an User for this web application.
 */
@Entity
@Table(name = "user")
public class User {

  @Id
  @Column(nullable=false,unique=true)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  
  @Column(nullable=false)
  private String email;
  
  @Column(nullable=false)
  private String firstname;

  @Column(nullable=false)
  private String lastname;

  @Column
  private String title;
  
  @Column
  private Date birthday;
  
  @Column
  private String password;
 
  @Column
  private Date register_time;
  
  @Column
  private String prefer_langugae;
 
  @Column
  private String photo;
  
  @Column
  private String phoneNumber;

  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  public User(){
	  
  }
  
  public User(long id){
	  this.id=id;
  }
  
  public User(String email, String password, String firstname, String lastname, String title) {
    this.email = email;
    this.firstname = firstname;
    this.lastname = lastname;
    this.password = password;
    this.title = title;
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

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
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

public String getPrefer_langugae() {
	return prefer_langugae;
}

public void setPrefer_langugae(String prefer_langugae) {
	this.prefer_langugae = prefer_langugae;
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

  public long getId() {
    return id;
  }

  public void setId(long value) {
    this.id = value;
  }

  public String getEmail() {
    return email;
  }
  
  public void setEmail(String value) {
    this.email = value;
  }

  
} // class User
