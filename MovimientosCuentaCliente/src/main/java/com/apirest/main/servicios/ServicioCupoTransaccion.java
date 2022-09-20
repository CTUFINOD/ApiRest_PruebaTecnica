package com.apirest.main.servicios;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.apirest.main.dtos.CupoTransaccionDTO;
import com.apirest.main.entidades.CupoTransaccion;
import com.apirest.main.repositorios.RepositorioCupoTransaccion;


@Service
public class ServicioCupoTransaccion implements ServicioObjetoCupoTransaccion<CupoTransaccionDTO> {

	private RepositorioCupoTransaccion repositorioCupoTransaccion;

	public ServicioCupoTransaccion(RepositorioCupoTransaccion repositorioCupoTransaccion) {
		this.repositorioCupoTransaccion = repositorioCupoTransaccion;
	}
	
	@Override
	public CupoTransaccionDTO consultar(int cupotransaccion_id) {
		Optional<CupoTransaccion> cOptional = repositorioCupoTransaccion.findById(cupotransaccion_id);
		CupoTransaccionDTO aux = new CupoTransaccionDTO();

		try {

			CupoTransaccion cupoTransaccion = cOptional.get();
			aux.setCupoTransaccionId(cupoTransaccion.getCupoTransaccionId());
			aux.setMontoCupoDiario(cupoTransaccion.getMontoCupoDiario());

		} catch (Exception e) {

			System.out.println("No existe el id");
		}
		return aux;
	}

	@Override
	public CupoTransaccionDTO guardar(CupoTransaccionDTO t) {

		CupoTransaccion cupoTransaccion = new CupoTransaccion();
		
		try {
			cupoTransaccion.setCupoTransaccionId(t.getCupoTransaccionId());
			cupoTransaccion.setMontoCupoDiario(t.getMontoCupoDiario());
			
			repositorioCupoTransaccion.save(cupoTransaccion);
			
		} catch (Exception e) {
			System.out.println("Bad Request");
		}
		t.setCupoTransaccionId(cupoTransaccion.getCupoTransaccionId());
		
		return t;
	}

	@Override
	public CupoTransaccionDTO actualizar(CupoTransaccionDTO t, int cupotransaccion_id) {
		Optional<CupoTransaccion> aOptional = repositorioCupoTransaccion.findById(cupotransaccion_id);
		
		CupoTransaccion cupoTransaccion = new CupoTransaccion();

		try {

			cupoTransaccion = aOptional.get();
			
			cupoTransaccion.setMontoCupoDiario(t.getMontoCupoDiario());
						
			repositorioCupoTransaccion.save(cupoTransaccion);
			t.setCupoTransaccionId(cupoTransaccion.getCupoTransaccionId());
			
		} catch (Exception e) {

			System.out.println("No existe");
		}
		
		return t;
	}
	
}
