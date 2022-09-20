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
import com.apirest.main.excepciones.EstadoExcepciones;
import com.apirest.main.servicios.ServicioCliente;

@Controller
@RestController
@RequestMapping(path = "api/clientes")
public class ControladorCliente implements ControladorObjetoCliente<ClienteDTO> {

	private ServicioCliente servicioCliente;

	public ControladorCliente(ServicioCliente servicioCliente) {
		super();
		this.servicioCliente = servicioCliente;
	}

	@Override
	@GetMapping("/{cliente_id}")
	public ClienteDTO consultar(@PathVariable int cliente_id) {
		
		return ResponseEntity.status(200).body(servicioCliente.consultar(cliente_id)).getBody();
	}

	@Override
	@PostMapping("/")
	public ResponseEntity guardar(@RequestBody ClienteDTO t) {

		ClienteDTO temp = servicioCliente.guardar(t);
		
		try {
			
			if(temp.getPersonaId() != 0)
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
	@PutMapping("/{cliente_id}")
	public ResponseEntity actualizar(@RequestBody ClienteDTO t, @PathVariable int cliente_id) {

		ClienteDTO temp = servicioCliente.actualizar(t, cliente_id);
		
		try {
			
			if(temp.getPersonaId() != 0)
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
	@DeleteMapping("/{cliente_id}")
	public ResponseEntity eliminar(@PathVariable int cliente_id) {
		
		boolean eliminar = servicioCliente.eliminar(cliente_id);
		
		try {
			
			if(eliminar)
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
