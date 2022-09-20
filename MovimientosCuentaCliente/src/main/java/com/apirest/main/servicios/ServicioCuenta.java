package com.apirest.main.servicios;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.apirest.main.dtos.CuentaDTO;
import com.apirest.main.entidades.Cuenta;
import com.apirest.main.repositorios.RepositorioCuenta;

@Service
public class ServicioCuenta implements ServicioObjetoCuenta<CuentaDTO> {

	private RepositorioCuenta repositorioCuenta;

	public ServicioCuenta(RepositorioCuenta repositorioCuenta) {
		this.repositorioCuenta = repositorioCuenta;
	}

	@Override
	public CuentaDTO consultar(int cuenta_Id) {
		Optional<Cuenta> cOptional = repositorioCuenta.findById(cuenta_Id);
		CuentaDTO aux = new CuentaDTO();

		try {

			Cuenta cuenta = cOptional.get();
			aux.setCuentaId(cuenta.getCuentaId());
			aux.setNumeroCuenta(cuenta.getNumeroCuenta());
			aux.setTipoCuenta(cuenta.getTipoCuenta());
			aux.setSaldoInicial(cuenta.getSaldoInicial());
			aux.setEstado(cuenta.getEstado());
			aux.setCliente(cuenta.getCliente());

		} catch (Exception e) {

			System.out.println("No existe el id");
		}
		return aux;
	}

	@Override
	public CuentaDTO guardar(CuentaDTO t) {

		Cuenta cuenta = new Cuenta();
		
		try {
			cuenta.setCuentaId(t.getCuentaId());
			cuenta.setNumeroCuenta(t.getNumeroCuenta());
			cuenta.setTipoCuenta(t.getTipoCuenta());
			cuenta.setSaldoInicial(t.getSaldoInicial());
			cuenta.setEstado(t.getEstado());
			cuenta.setCliente(t.getCliente());
			
			repositorioCuenta.save(cuenta);
			
		} catch (Exception e) {
			System.out.println("Bad Request");
		}
		t.setCuentaId(cuenta.getCuentaId());
		
		return t;
	}

	@Override
	public CuentaDTO actualizar(CuentaDTO t, int cuenta_Id) {
		Optional<Cuenta> aOptional = repositorioCuenta.findById(cuenta_Id);
		Cuenta cuenta = new Cuenta();

		try {

			cuenta = aOptional.get();
			
			cuenta.setNumeroCuenta(t.getNumeroCuenta());
			cuenta.setTipoCuenta(t.getTipoCuenta());
			cuenta.setSaldoInicial(t.getSaldoInicial());
			cuenta.setEstado(t.getEstado());
			cuenta.setCliente(t.getCliente());
			
			repositorioCuenta.save(cuenta);
			t.setCuentaId(cuenta.getCuentaId());
			
		} catch (Exception e) {

			System.out.println("No existe");
		}
		
		return t;
	}

	@Override
	public boolean eliminar(int cuenta_Id) {
		try {
			
			repositorioCuenta.deleteById(cuenta_Id);
			
		} catch (Exception e) {
			
			return false;
		}
		
		return true;
	}
}
