package com.isil.web.selvamonos.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="turista")
public class Turista {

	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="id")
	 protected int id;
	 
	 @Column(name="name")
	 protected String name;
	 
	 @Column(name="apellido")
	 protected String apellido;
	 
	 @Column(name="documento")
	 protected String documento;
	 
	 @Column(name="nacimiento")
	 protected Date nacimiento;
	 
	 @Column(name="origen")
	 protected String origen;
	 
	 @Column(name="destino")
	 protected String destino;
	 
	 @Column(name="hotel")
	 protected String hotel;
	 
	 @Column(name="costo")
	 protected int costo;
	 
	 @Column(name="email")
	 protected String email;
	 
	 @Column(name="iniciotour")
	 protected Date iniciotour;
	 
	 @Column(name="fintour")
	 protected Date fintour;
	 
	 public Turista() {
	 }

	public Turista(String name, String apellido, String documento, Date nacimiento, String origen, String destino,
			String hotel, int costo, String email, Date iniciotour, Date fintour) {
		super();
		this.name = name;
		this.apellido = apellido;
		this.documento = documento;
		this.nacimiento = nacimiento;
		this.origen = origen;
		this.destino = destino;
		this.hotel = hotel;
		this.costo = costo;
		this.email = email;
		this.iniciotour = iniciotour;
		this.fintour = fintour;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getIniciotour() {
		return iniciotour;
	}

	public void setIniciotour(Date iniciotour) {
		this.iniciotour = iniciotour;
	}

	public Date getFintour() {
		return fintour;
	}

	public void setFintour(Date fintour) {
		this.fintour = fintour;
	}
	 
	 
	 
	 
	

	 
}
