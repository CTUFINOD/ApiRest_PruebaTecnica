package com.apirest.main.servicios;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.apirest.main.dtos.ClienteDTO;
import com.apirest.main.entidades.Cliente;
import com.apirest.main.repositorios.RepositorioCliente;

@Service
public class ServicioCliente implements ServicioObjetoCliente<ClienteDTO> {

	private RepositorioCliente repositorioCliente;

	public ServicioCliente(RepositorioCliente repositorioCliente) {
		this.repositorioCliente = repositorioCliente;
	}

	@Override
	public ClienteDTO consultar(int cliente_id) {
		Optional<Cliente> cOptional = repositorioCliente.findById(cliente_id);
		ClienteDTO aux = new ClienteDTO();

		try {

			Cliente cliente = cOptional.get();
			aux.setPersonaId(cliente.getPersonaId());
			aux.setContrasena(cliente.getContrasena());
			aux.setDireccion(cliente.getDireccion());
			aux.setEdad(cliente.getEdad());
			aux.setEstado(cliente.getEstado());
			aux.setGenero(cliente.getGenero());
			aux.setIdentificacion(cliente.getIdentificacion());
			aux.setNombre(cliente.getNombre());
			aux.setTelefono(cliente.getTelefono());

		} catch (Exception e) {

			System.out.println("No existe el id");
		}
		return aux;
	}

	@Override
	public ClienteDTO guardar(ClienteDTO t) {

		Cliente cliente = new Cliente();
		try {
			cliente.setPersonaId(t.getPersonaId());
			cliente.setContrasena(t.getContrasena());
			cliente.setEstado(t.getEstado());
			cliente.setNombre(t.getNombre());
			cliente.setGenero(t.getGenero());
			cliente.setEdad(t.getEdad());
			cliente.setIdentificacion(t.getIdentificacion());
			cliente.setDireccion(t.getDireccion());
			cliente.setTelefono(t.getTelefono());
			
			repositorioCliente.save(cliente);
			
		} catch (Exception e) {
			System.out.println("Bad Request");
		}
		t.setPersonaId(cliente.getPersonaId());

		return t;
	}

	@Override
	public ClienteDTO actualizar(ClienteDTO t, int cliente_id) {
		Optional<Cliente> aOptional = repositorioCliente.findById(cliente_id);
		Cliente cliente = new Cliente();

		try {

			cliente = aOptional.get();
			
			cliente.setContrasena(t.getContrasena());
			cliente.setDireccion(t.getDireccion());
			cliente.setEdad(t.getEdad());
			cliente.setEstado(t.getEstado());
			cliente.setGenero(t.getGenero());
			cliente.setIdentificacion(t.getIdentificacion());
			cliente.setNombre(t.getNombre());
			cliente.setTelefono(t.getTelefono());
			
			repositorioCliente.save(cliente);
			t.setPersonaId(cliente.getPersonaId());
			
		} catch (Exception e) {

			System.out.println("Bad Resquet");
			t.setPersonaId(0);
		}
		
		return t;
	}

	@Override
	public boolean eliminar(int cliente_id) {
		try {
			
			repositorioCliente.deleteById(cliente_id);
			
		} catch (Exception e) {
			
			return false;
		}
		
		return true;
	}
}
