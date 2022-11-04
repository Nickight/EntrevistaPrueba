package com.entrevista.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notas")
public class Notas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_notas;
	
	@Column(name="nota1")
	private String nota1;
	private String nota2;
	private String nota3;
	private String nota4;
	
	

	

	public long getId_notas() {
		return id_notas;
	}





	public void setId_notas(long id_notas) {
		this.id_notas = id_notas;
	}





	public String getNota1() {
		return nota1;
	}





	public void setNota1(String nota1) {
		this.nota1 = nota1;
	}





	public String getNota2() {
		return nota2;
	}





	public void setNota2(String nota2) {
		this.nota2 = nota2;
	}





	public String getNota3() {
		return nota3;
	}





	public void setNota3(String nota3) {
		this.nota3 = nota3;
	}





	public String getNota4() {
		return nota4;
	}





	public void setNota4(String nota4) {
		this.nota4 = nota4;
	}





	@Override
	public String toString() {
		return "Notas [id_notas=" + id_notas + ", nota1=" + nota1 + ", nota2=" + nota2 + ", nota3=" + nota3 + ", nota4="
				+ nota4 + "]";
	}




	
	

}
