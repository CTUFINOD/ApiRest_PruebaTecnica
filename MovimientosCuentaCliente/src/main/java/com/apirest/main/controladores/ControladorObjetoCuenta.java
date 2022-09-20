package com.apirest.main.controladores;

import org.springframework.http.ResponseEntity;

public interface ControladorObjetoCuenta <T> {

	public T consultar(int cuenta_id);
	public ResponseEntity guardar(T t);
	public ResponseEntity actualizar(T t, int cuenta_id);
	public ResponseEntity eliminar(int cuenta_id);
}
