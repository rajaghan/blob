package com.jar.blob.model;

import java.io.Serializable;
import java.sql.Blob;

public class Company implements Serializable{
	/**
	 * Serializable domain model
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
//	private byte[] logo;
	private Blob logo;
	
	public Blob getLogo() {
		return logo;
	}
	public void setLogo(Blob logo) {
		this.logo = logo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}
