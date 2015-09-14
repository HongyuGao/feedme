package org.foodie.server.entity;
/**
 * @author Danyang Li
 */
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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="dish_id")
	private long dish_id;
	
	@Column(name="shop_id",nullable=false)
	private long shop_id;
	
	@Column(name="type")
	private String type;
	
	@Column(name="name",nullable=false)
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="ingredient")
	private String ingredient;
	
	@Column(name="price", nullable=false)
	private String price;
	
	@Column(name="discount")
	private String discount;

	public long getDish_id() {
		return dish_id;
	}

	public void setDish_id(long dish_id) {
		this.dish_id = dish_id;
	}

	public long getShop_id() {
		return shop_id;
	}

	public void setShop_id(long shop_id) {
		this.shop_id = shop_id;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

}
