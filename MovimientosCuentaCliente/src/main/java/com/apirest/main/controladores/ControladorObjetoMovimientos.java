package com.apirest.main.controladores;

import org.springframework.http.ResponseEntity;

public interface ControladorObjetoMovimientos <T> {

	public T consultar(int movimiento_Id);
	public ResponseEntity guardar(T t);
	public ResponseEntity actualizar(T t, int movimiento_Id);
	public ResponseEntity eliminar(int movimiento_Id);
}
