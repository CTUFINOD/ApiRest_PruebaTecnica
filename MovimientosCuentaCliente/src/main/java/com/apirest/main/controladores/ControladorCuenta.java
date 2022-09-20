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

import com.apirest.main.dtos.ClienteDTO;
import com.apirest.main.dtos.CuentaDTO;
import com.apirest.main.excepciones.EstadoExcepciones;
import com.apirest.main.servicios.ServicioCuenta;

@Controller
@RestController
@RequestMapping(path = "api/cuentas")
public class ControladorCuenta implements ControladorObjetoCuenta<CuentaDTO> {

	private ServicioCuenta servicioCuenta;

	public ControladorCuenta(ServicioCuenta servicioCuenta) {
		this.servicioCuenta = servicioCuenta;
	}

	@Override
	@GetMapping("/{cuenta_id}")
	public CuentaDTO consultar(@PathVariable int cuenta_id) {
		
		return ResponseEntity.status(200).body(servicioCuenta.consultar(cuenta_id)).getBody();
	}

	@Override
	@PostMapping("/")
	public ResponseEntity guardar(@RequestBody CuentaDTO t) {

		CuentaDTO temp = servicioCuenta.guardar(t);
		
		try {
			
			if(temp.getCuentaId() != 0)
			{
				return ResponseEntity.status(201).body(temp);
			}else
			{
				throw new EstadoExcepciones("bad request", 400);
			}
			
		} catch (EstadoExcepciones e) {
			
			return e.ObtenerRespuestaEstado();
		}
	}

	@Override
	@PutMapping("/{cuenta_id}")
	public ResponseEntity actualizar(@RequestBody CuentaDTO t, @PathVariable int cuenta_id) {
		
		CuentaDTO temp = servicioCuenta.actualizar(t, cuenta_id);
		
		try {
			
			if(temp.getCuentaId() != 0)
			{
				return ResponseEntity.status(201).body(temp);
			}
			else
			{
				throw new EstadoExcepciones("bad request", 400);
			}		
			
		} catch (EstadoExcepciones e) {
			return e.ObtenerRespuestaEstado();
		}		
	}

	@Override
	@DeleteMapping("/{cuenta_id}")
	public ResponseEntity eliminar(@PathVariable int cuenta_id) {
		
		boolean iscuenta = servicioCuenta.eliminar(cuenta_id);
		
		try {
			
			if(iscuenta)
			{
				return ResponseEntity.status(200).body("{\"Exitoso\": \"Registro Borrado\"}");
				
			}
			else
			{
				throw new EstadoExcepciones("bad request", 400);
			}			
			
		} catch (EstadoExcepciones e) {
			return e.ObtenerRespuestaEstado();
		}
	}
}
