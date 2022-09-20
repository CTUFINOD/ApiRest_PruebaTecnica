package com.apirest.main.servicios;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.apirest.main.dtos.MovimientoDTO;
import com.apirest.main.entidades.Movimientos;
import com.apirest.main.repositorios.RepositorioMovimientos;

@Service
public class ServicioMovimientos implements ServicioObjetoMovimientos<MovimientoDTO> {
	
	private RepositorioMovimientos repositorioMovimientos;

	//Constructor
	public ServicioMovimientos(RepositorioMovimientos repositorioMovimientos) {
		this.repositorioMovimientos = repositorioMovimientos;
	}

	@Override
	public MovimientoDTO consultar(int movimiento_Id) {
		Optional<Movimientos> cOptional = repositorioMovimientos.findById(movimiento_Id);
		MovimientoDTO aux = new MovimientoDTO();

		try {

			Movimientos movimientos = cOptional.get();
			aux.setMovimientoId(movimientos.getMovimientoId());
			aux.setNumeroCuenta(movimientos.getNumeroCuenta());
			aux.setTipoMovimiento(movimientos.getTipoMovimiento());
			aux.setFecha(movimientos.getFecha());
			aux.setSaldoInical(movimientos.getSaldoInical());
			aux.setEstado(movimientos.getEstado());
			aux.setValor(movimientos.getValor());
			aux.setMovimiento(movimientos.getMovimiento());
			aux.setSaldoDisponible(movimientos.getSaldoDisponible());
			aux.setTipoCuenta(movimientos.getTipoCuenta());

		} catch (Exception e) {

			System.out.println("No existe el id");
		}
		return aux;
	}

	@Override
	public MovimientoDTO guardar(MovimientoDTO t) {
		
		Movimientos movimientos = new Movimientos();

		try {
			movimientos.setMovimientoId(t.getMovimientoId());
			movimientos.setNumeroCuenta(t.getNumeroCuenta());
			movimientos.setTipoMovimiento(t.getTipoMovimiento());
			movimientos.setFecha(t.getFecha());
			movimientos.setSaldoInical(t.getSaldoInical());
			movimientos.setEstado(t.getEstado());
			movimientos.setSaldoDisponible(t.getSaldoDisponible());
			movimientos.setMovimiento(t.getMovimiento());
			movimientos.setValor(t.getValor());
			movimientos.setTipoCuenta(t.getTipoCuenta());
						
			repositorioMovimientos.save(movimientos);
			
		} catch (Exception e) {
			System.out.println("Bad Request");
		}
		
		t.setMovimientoId(movimientos.getMovimientoId());
		t.setSaldoDisponible(movimientos.getSaldoDisponible());
		t.setMovimiento(movimientos.getMovimiento());
		return t;
	}

	@Override
	public MovimientoDTO actualizar(MovimientoDTO t, int movimiento_Id) {
		Optional<Movimientos> aOptional = repositorioMovimientos.findById(movimiento_Id);
		Movimientos movimientos = new Movimientos();

		try 
		{
			movimientos = aOptional.get();
			
			movimientos.setNumeroCuenta(t.getNumeroCuenta());
			movimientos.setTipoMovimiento(t.getTipoMovimiento());
			movimientos.setFecha(t.getFecha());
			movimientos.setSaldoInical(t.getSaldoInical());
			movimientos.setEstado(t.getEstado());
			//movimientos.setSaldoDisponible(t.getSaldoDisponible());
			//movimientos.setMovimiento(t.getMovimiento());
			movimientos.setValor(t.getValor());
			movimientos.setTipoCuenta(t.getTipoCuenta());
								
			repositorioMovimientos.save(movimientos);
			t.setMovimientoId(movimientos.getMovimientoId());
			t.setSaldoDisponible(movimientos.getSaldoDisponible());
			t.setMovimiento(movimientos.getMovimiento());
			
		} catch (Exception e) {

			System.out.println("No existe");
		}
		
		return t;
	}

	@Override
	public boolean eliminar(int movimiento_Id) {
		try {
			
			repositorioMovimientos.deleteById(movimiento_Id);
			
		} catch (Exception e) {
			
			return false;
		}
		
		return true;
	}

}
