package com.apirest.main.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cupotransacion")
public class CupoTransaccion {
	
	@Id
	@Column(name = "cupotransacion_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cupoTransaccionId;
	
	@Column(name = "cupotransacion_montoCupoDiario")
	private float montoCupoDiario;

	public CupoTransaccion(int cupoTransaccionId, float montoCupoDiario) {
		this.cupoTransaccionId = cupoTransaccionId;
		this.montoCupoDiario = montoCupoDiario;
	}
	
	public CupoTransaccion() {}

	public int getCupoTransaccionId() {
		return cupoTransaccionId;
	}

	public void setCupoTransaccionId(int cupoTransaccionId) {
		this.cupoTransaccionId = cupoTransaccionId;
	}

	public float getMontoCupoDiario() {
		return montoCupoDiario;
	}

	public void setMontoCupoDiario(float montoCupoDiario) {
		this.montoCupoDiario = montoCupoDiario;
	}

}
