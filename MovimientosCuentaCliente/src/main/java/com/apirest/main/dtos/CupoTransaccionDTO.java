package com.apirest.main.dtos;

public class CupoTransaccionDTO {
	
	private int cupoTransaccionId;
	private float montoCupoDiario;
	
	public CupoTransaccionDTO(int cupoTransaccionId, float montoCupoDiario) {
		this.cupoTransaccionId = cupoTransaccionId;
		this.montoCupoDiario = montoCupoDiario;
	}
	
	public CupoTransaccionDTO() {}

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
