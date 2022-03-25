package com.entity.cliente.entity;

import java.io.Serializable;

public class Cliente implements Serializable{

	/**
	 * @author fhp38
	 * 
	 */
	
	private static final long serialVersionUID = 6414051205733334254L;

	private Integer id;

	private String nombre;

	private String email;

	public Cliente() {
	}

	public Cliente(Integer id, String nombre, String email) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", email=" + email + "]";
	}
}
