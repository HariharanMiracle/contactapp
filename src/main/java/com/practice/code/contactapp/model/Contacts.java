package com.practice.code.contactapp.model;

import java.io.Serializable;

public class Contacts implements Serializable {
	
	private static final long serialVersionUID = -295422703255886286L;

	private String name;
	private String phone;
	
	public Contacts() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Contacts(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Contacts [name=" + name + ", phone=" + phone + "]";
	}
	
}
