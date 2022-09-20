package com.apirest.main.dtos;

public class MovimientoDTO {

	private int movimientoId;
	private String numeroCuenta;
	private String tipoCuenta;
	private String tipoMovimiento;
	private String fecha;
	private float saldoInical;
	private String estado;
	private float valor;
	private float movimiento;
	private float saldoDisponible;
	
	public MovimientoDTO(int movimientoId, String numeroCuenta, String tipoCuenta, String tipoMovimiento, String fecha, float saldoInical,
			String estado, float valor, float movimiento, float saldoDisponible) {
		this.movimientoId = movimientoId;
		this.numeroCuenta = numeroCuenta;
		this.tipoCuenta = tipoCuenta;
		this.tipoMovimiento = tipoMovimiento;
		this.fecha = fecha;
		this.saldoInical = saldoInical;
		this.estado = estado;
		this.valor = valor;
		this.movimiento = movimiento;
		this.saldoDisponible = saldoDisponible;
	}

	public MovimientoDTO() {}
	
	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public int getMovimientoId() {
		return movimientoId;
	}

	public void setMovimientoId(int movimientoId) {
		this.movimientoId = movimientoId;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public float getSaldoInical() {
		return saldoInical;
	}

	public void setSaldoInical(float saldoInical) {
		this.saldoInical = saldoInical;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public float getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(float movimiento) {
		this.movimiento = movimiento;
	}

	public float getSaldoDisponible() {
		return saldoDisponible;
	}

	public void setSaldoDisponible(float saldoDisponible) {
		this.saldoDisponible = saldoDisponible;
	}
	
}
