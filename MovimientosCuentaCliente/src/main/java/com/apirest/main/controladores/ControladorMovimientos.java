package com.apirest.main.controladores;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.main.dtos.CupoTransaccionDTO;
import com.apirest.main.dtos.MovimientoDTO;
import com.apirest.main.excepciones.EstadoExcepciones;
import com.apirest.main.servicios.ServicioCupoTransaccion;
import com.apirest.main.servicios.ServicioMovimientos;

@Controller
@RestController
@RequestMapping(path = "api/movimientos")
public class ControladorMovimientos implements ControladorObjetoMovimientos<MovimientoDTO> {

	private ServicioMovimientos servicioMovimientos;
	private ServicioCupoTransaccion servicioCupoTransaccion;

	public ControladorMovimientos(ServicioMovimientos servicioMovimientos,
			ServicioCupoTransaccion servicioCupoTransaccion) {
		this.servicioMovimientos = servicioMovimientos;
		this.servicioCupoTransaccion = servicioCupoTransaccion;
	}

	@Override
	@GetMapping("/{movimiento_Id}")
	public MovimientoDTO consultar(@PathVariable int movimiento_Id) {

		return ResponseEntity.status(200).body(servicioMovimientos.consultar(movimiento_Id)).getBody();
	}

	@Override
	@PostMapping("/")
	public ResponseEntity guardar(@RequestBody MovimientoDTO t) {

		String tipoMovimiento = "";
		float saldoDisponible = 0;
		float saldoIncial = 0;
		int cupoDiarioId = 1;
		float cupoDiarioParametrizado = 0;
		float cupoDisponible = 0;

		try {

			tipoMovimiento = t.getTipoMovimiento();
			saldoIncial = t.getSaldoInical();

			cupoDiarioParametrizado = servicioCupoTransaccion.consultar(cupoDiarioId).getMontoCupoDiario();

			if (tipoMovimiento.equals("R")) {

				cupoDisponible = cupoDiarioParametrizado - t.getValor();

				CupoTransaccionDTO cupoTransaccion = new CupoTransaccionDTO();
				cupoTransaccion.setMontoCupoDiario(cupoDisponible);
				CupoTransaccionDTO temp = servicioCupoTransaccion.actualizar(cupoTransaccion, cupoDiarioId);

			}

			if ((cupoDisponible >= 0 && tipoMovimiento.equals("R")) || (tipoMovimiento.equals("D"))) {

				if ((saldoIncial >= 0 && tipoMovimiento.equals("D"))
						|| (saldoIncial > 0 && tipoMovimiento.equals("R"))) {

					if (tipoMovimiento.equals("R")) {
						t.setMovimiento(t.getValor() * -1);
						saldoDisponible = t.getSaldoInical() - t.getValor();
					}

					if (tipoMovimiento.equals("D")) {
						t.setMovimiento(t.getValor());
						saldoDisponible = t.getSaldoInical() + t.getValor();
					}
					t.setSaldoDisponible(saldoDisponible);

					MovimientoDTO temp = servicioMovimientos.guardar(t);

					if (temp.getMovimientoId() != 0) {

						return ResponseEntity.status(201).body(temp);
					} else {
						throw new EstadoExcepciones("bad request", 400);
					}
				} else {
					throw new EstadoExcepciones("Saldo no disponible", 200);
				}

			} else {
				
				throw new EstadoExcepciones("Cupo diario Excedido", 200);
			}

		} catch (EstadoExcepciones e) {

			return e.ObtenerRespuestaEstado();
		}
	}

	@Override
	@PutMapping("/{movimiento_Id}")
	public ResponseEntity actualizar(@RequestBody MovimientoDTO t, @PathVariable int movimiento_Id) {

		MovimientoDTO temp = servicioMovimientos.actualizar(t, movimiento_Id);

		try {

			if (temp.getMovimientoId() != 0) {
				return ResponseEntity.status(201).body(temp);
			} else {
				throw new EstadoExcepciones("bad request", 400);
			}

		} catch (EstadoExcepciones e) {
			return e.ObtenerRespuestaEstado();
		}
	}

	@Override
	@DeleteMapping("/{movimiento_Id}")
	public ResponseEntity eliminar(@PathVariable int movimiento_Id) {

		boolean ismovimientos = servicioMovimientos.eliminar(movimiento_Id);
		try {

			if (ismovimientos) {
				return ResponseEntity.status(200).body("{\"Exitoso\": \"Registro Borrado\"}");

			} else {
				throw new EstadoExcepciones("bad request", 400);
			}

		} catch (EstadoExcepciones e) {
			return e.ObtenerRespuestaEstado();
		}
	}

}
