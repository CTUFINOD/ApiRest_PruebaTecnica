package com.apirest.main.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(referencedColumnName = "persona_id")
public class Cliente extends Persona {
		
	@Column(name = "cliente_contrasena")
	private String contrasena;
	
	@Column(name = "cliente_estado")
	private String estado;

	public Cliente(String contrasena, String estado) {
		this.contrasena = contrasena;
		this.estado = estado;
	}
	
	public Cliente() {}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
		
}
