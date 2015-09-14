package org.foodie.server.entity;
/**
 * @author Danyang Li
 */
import java.io.Serializable;
import javax.persistence.Column;

public class OrderUnionPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column
	private long userId;
	@Column
	private long shopId;
	@Column
	private long orderId;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getShopId() {
		return shopId;
	}
	public void setShopId(long shopId) {
		this.shopId = shopId;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof OrderUnionPK){
			OrderUnionPK pk = (OrderUnionPK)o;
			if(this.shopId==pk.shopId && this.userId==pk.userId && this.orderId==pk.orderId)
				return true;
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return super.hashCode();
	}

}
