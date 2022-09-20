package com.apirest.main.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movimientos")
public class Movimientos {

	@Id
	@Column(name = "movimientos_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movimientoId;
	
	@Column(name = "movimientos_num_cuenta")
	private String numeroCuenta;
	
	@Column(name = "movimientos_tipoCuenta")
	private String tipoCuenta;
	
	@Column(name = "movimientos_tipoMovimiento")
	private String tipoMovimiento;
	
	@Column(name = "movimientos_fecha")
	private String fecha;
	
	@Column(name = "movimientos_saldo_inicial")
	private float saldoInical;
	
	@Column(name = "movimientos_estado")
	private String estado;
	
	@Column(name = "movimientos_valor")
	private float valor;
	
	@Column(name = "movimientos_movimiento")
	private float movimiento;
	
	@Column(name = "movimientos_saldo_disponible")
	private float saldoDisponible;

	
	public Movimientos(int movimientoId, String numeroCuenta, String tipoCuenta, String tipoMovimiento, String fecha, float saldoInical,
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

	public Movimientos() {}
	
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
