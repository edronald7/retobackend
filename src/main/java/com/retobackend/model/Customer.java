package com.retobackend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String apellido;
	private Integer edad;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;
	private Date fechaMuerte;

	public Customer() {}
	
	public Customer(Long id, String nombre, String apellido, Integer edad, Date fechaNacimiento) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id 
				+ ", nombre=" + nombre 
				+ ", apellido=" + apellido 
				+ ", edad=" + edad
				+ ", fechaNacimiento=" + fechaNacimiento + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaMuerte() {
		return fechaMuerte;
	}

	public void setFechaMuerte(Date fechaMuerte) {
		this.fechaMuerte = fechaMuerte;
	}
	
}
