package com.apirest.main.controladores;

import org.springframework.http.ResponseEntity;

public interface ControladorObjetoCliente <T> {
	
	public T consultar(int cliente_id);
	public ResponseEntity guardar(T t);
	public ResponseEntity actualizar(T t, int cliente_id);
	public ResponseEntity eliminar(int cliente_id);

}
