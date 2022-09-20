package com.apirest.main.controladores;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.main.dtos.CupoTransaccionDTO;
import com.apirest.main.excepciones.EstadoExcepciones;
import com.apirest.main.servicios.ServicioCupoTransaccion;

@Controller
@RestController
@RequestMapping(path = "api/cupodiario")
public class ControladorCupoTransaccion implements ControladorObjetoCupoTransaccion<CupoTransaccionDTO> {

	private ServicioCupoTransaccion servicioCupoTransaccion;

	public ControladorCupoTransaccion(ServicioCupoTransaccion servicioCupoTransaccion) {
		this.servicioCupoTransaccion = servicioCupoTransaccion;
	}

	@Override
	@GetMapping("/{cupotransaccion_id}")
	public CupoTransaccionDTO consultar(@PathVariable int cupotransaccion_id) {

		return ResponseEntity.status(200).body(servicioCupoTransaccion.consultar(cupotransaccion_id)).getBody();
	}

	@Override
	@PostMapping("/")
	public ResponseEntity guardar(@RequestBody CupoTransaccionDTO t) {

		CupoTransaccionDTO temp = servicioCupoTransaccion.guardar(t);

		try {

			if (temp.getCupoTransaccionId() != 0) {
				return ResponseEntity.status(201).body(temp);
			} else {
				throw new EstadoExcepciones("bad request", 400);
			}

		} catch (EstadoExcepciones e) {

			return e.ObtenerRespuestaEstado();
		}
	}

	@Override
	@PutMapping("/{cupotransaccion_id}")
	public ResponseEntity actualizar(@RequestBody CupoTransaccionDTO t, @PathVariable int cupotransaccion_id) {

		CupoTransaccionDTO temp = servicioCupoTransaccion.actualizar(t, cupotransaccion_id);

		try {

			if (temp.getCupoTransaccionId() != 0) {
				return ResponseEntity.status(201).body(temp);
			} else {
				throw new EstadoExcepciones("bad request", 400);
			}

		} catch (EstadoExcepciones e) {
			return e.ObtenerRespuestaEstado();
		}
	}

}
