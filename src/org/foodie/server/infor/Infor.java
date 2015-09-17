package org.foodie.server.infor;

import java.io.Serializable;

/**
 * 
 * @author Danyang Li
 *
 */
public class Infor implements Serializable{
	private static final long serialVersionUID = 1L;
	private String errorInfo;
	private Integer statusCode = ErrorCode.NONE;
	
	public Infor() {
		
	}
	
	public Infor (final String errorInfo, final Integer statusCode) {
		this.errorInfo = errorInfo;
		this.statusCode = statusCode;
	}
	
	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
}
