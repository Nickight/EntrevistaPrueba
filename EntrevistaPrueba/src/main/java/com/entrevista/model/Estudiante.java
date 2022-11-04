package com.entrevista.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estudiantes")
public class Estudiante implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_estudiante")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nombre;
	private int edad;
	private String ciudad;
	@Column(name="zona_horaria")
	private String zona;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", ciudad=" + ciudad + ", zona="
				+ zona + "]";
	}

	
	

	
	
}
