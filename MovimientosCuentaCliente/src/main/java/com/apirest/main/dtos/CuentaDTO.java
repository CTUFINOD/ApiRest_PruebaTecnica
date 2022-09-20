package com.apirest.main.dtos;

public class CuentaDTO {
	
	private int cuentaId;
	private String numeroCuenta;
	private String tipoCuenta;
	private float saldoInicial;
	private String estado;
	private String cliente;
		
	public CuentaDTO(int cuentaId, String numeroCuenta, String tipoCuenta, float saldoInicial, String estado, String cliente) {
		this.cuentaId = cuentaId;
		this.numeroCuenta = numeroCuenta;
		this.tipoCuenta = tipoCuenta;
		this.saldoInicial = saldoInicial;
		this.estado = estado;
		this.cliente = cliente;
	}
	
	public CuentaDTO() {}
	
	public int getCuentaId() {
		return cuentaId;
	}
	public void setCuentaId(int cuentaId) {
		this.cuentaId = cuentaId;
	}
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public float getSaldoInicial() {
		return saldoInicial;
	}
	public void setSaldoInicial(float saldoInicial) {
		this.saldoInicial = saldoInicial;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
}
