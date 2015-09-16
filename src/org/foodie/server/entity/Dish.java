package org.foodie.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dish")
public class Dish {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dishId", nullable=false)
	private long id;
	
	@Column(name="shopId")
	private long shopId;
	
	@Column(name="type")
	private String type;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="photo")
	private String photo;
		
	@Column(name="ingredient")
	private String ingredient;
	
	@Column(name="price")
	private String price;
	
	@Column(name="discount")
	private String discount;
	
	public Dish(){
		
	}
	
	public Dish(long id){
		this.id=id;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getShopId() {
		return shopId;
	}

	public void setShopId(long shopId) {
		this.shopId = shopId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

}
