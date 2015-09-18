package org.foodie.server.infor;
/**
 * @author Danyang Li
 */
public class DishInfo extends Infor{
	private static final long serialVersionUID = 1L;
	private long id;
	
	public DishInfo(){
		
	}
	
	public DishInfo(final long id){
		this.id=id;
	}
		
	public DishInfo(final String statusInfo, final Integer statusCode){
		super(statusInfo,statusCode);
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
}
