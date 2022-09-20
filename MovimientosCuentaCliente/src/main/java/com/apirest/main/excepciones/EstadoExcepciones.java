package com.apirest.main.excepciones;

import org.springframework.http.ResponseEntity;

public class EstadoExcepciones extends Exception {

	private String mensaje;
	private int estado;
	public EstadoExcepciones(String mensaje, int estado) {
		super(mensaje);
		this.mensaje = mensaje;
		this.estado = estado;
	}
	
	public ResponseEntity ObtenerRespuestaEstado ()
	{
		return ResponseEntity.status(this.estado).body("{\"error\": \""+this.mensaje+".\"}");
	}
	
}
