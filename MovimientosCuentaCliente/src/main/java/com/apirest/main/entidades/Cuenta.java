package com.apirest.main.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cuenta")
public class Cuenta {
	
	@Id
	@Column(name = "cuenta_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cuentaId;
	
	@Column(name = "cuenta_numeroCuenta")
	private String numeroCuenta;
	
	@Column(name = "cuenta_tipoCuenta")
	private String tipoCuenta;
	
	@Column(name = "cuenta_saldoInicial")
	private float saldoInicial;
	
	@Column(name = "cuenta_estado")
	private String estado;
	
	@Column(name = "cuenta_cliente")
	private String cliente;

	public Cuenta(int cuentaId, String numeroCuenta, String tipoCuenta, float saldoInicial, String estado, String cliente) {
		this.cuentaId = cuentaId;
		this.numeroCuenta = numeroCuenta;
		this.tipoCuenta = tipoCuenta;
		this.saldoInicial = saldoInicial;
		this.estado = estado;
		this.cliente = cliente;
	}
	
	public Cuenta() {}
	
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
