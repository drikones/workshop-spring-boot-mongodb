package com.nelioalves.workshopmongo.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable {
	

   
	private static final long serialVersionUID = 1L;
	private long timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
    
    public StandardError() {}

	public StandardError(long timestamp, int status, String error, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
    
	
   

}
