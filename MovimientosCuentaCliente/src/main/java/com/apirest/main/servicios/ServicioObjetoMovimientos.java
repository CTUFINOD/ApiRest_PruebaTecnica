package com.apirest.main.servicios;

public interface ServicioObjetoMovimientos <T> {
	
	public T consultar(int movimientoId);
	public T guardar(T t);
	public T actualizar(T t, int movimientoId);
	public boolean eliminar(int movimientoId);

}
