package com.apirest.main.controladores;

import org.springframework.http.ResponseEntity;

public interface ControladorObjetoCupoTransaccion <T> {

	public T consultar(int cupotransaccion_id);
	public ResponseEntity guardar(T t);
	public ResponseEntity actualizar(T t, int cupotransaccion_id);
}
