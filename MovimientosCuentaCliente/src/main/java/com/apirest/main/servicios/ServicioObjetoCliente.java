package com.apirest.main.servicios;

public interface ServicioObjetoCliente <T> {

	public T consultar(int cliente_id);
	public T guardar(T t);
	public T actualizar(T t, int cliente_id);
	public boolean eliminar(int cliente_id);
}
