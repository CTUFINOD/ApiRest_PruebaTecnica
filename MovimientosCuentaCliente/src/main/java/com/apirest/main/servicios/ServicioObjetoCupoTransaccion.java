package com.apirest.main.servicios;

public interface ServicioObjetoCupoTransaccion <T> {
	
	public T consultar(int cupoTransaccionId);
	public T guardar(T t);
	public T actualizar(T t, int cupoTransaccionId);

}
