package com.apirest.main.servicios;

public interface ServicioObjetoCuenta <T> {

	public T consultar(int cuentaId);
	public T guardar(T t);
	public T actualizar(T t, int cuentaId);
	public boolean eliminar(int cuentaId);
}
