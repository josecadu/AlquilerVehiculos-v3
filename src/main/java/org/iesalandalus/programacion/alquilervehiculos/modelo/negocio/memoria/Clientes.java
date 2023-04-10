package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria;

import java.util.ArrayList;
import javax.naming.OperationNotSupportedException;
import java.util.*;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IClientes;


public class Clientes implements IClientes {
	private static List<Cliente> coleccionClientes;


	public Clientes(){
		coleccionClientes = new ArrayList<>();
	}


	
	@Override
	public List<Cliente> get() {
		List <Cliente> nuevaColeccion = new ArrayList<>();
		nuevaColeccion.addAll(coleccionClientes);
		return nuevaColeccion;
	}
	
	
	
	@Override
	public int getCantidad(){
		return coleccionClientes.size();
	}
	
	
	
	@Override
	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		int indice;
		indice = coleccionClientes.indexOf(cliente);
		if (indice !=-1 )
			throw new OperationNotSupportedException("ERROR: Ya existe un cliente con ese DNI.");
		if (cliente==null)
			throw new NullPointerException("ERROR: No se puede insertar un cliente nulo.");
		else
			coleccionClientes.add(cliente);	
	}



	@Override
	public Cliente buscar(Cliente cliente){
		int indice;
		indice = coleccionClientes.indexOf(cliente);
		if (cliente==null)
			throw new NullPointerException("ERROR: No se puede buscar un cliente nulo.");
		if (indice !=-1)
			return	coleccionClientes.get(indice);
		else
			return null;
	}



	@Override
	public void borrar(Cliente cliente) throws OperationNotSupportedException{
		int indice;
		indice = coleccionClientes.indexOf(cliente);
		if (cliente==null)
			throw new NullPointerException("ERROR: No se puede borrar un cliente nulo.");
		if (indice ==-1)
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		else
			coleccionClientes.remove(indice);
	}

	
	
	@Override
	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
	
		if (cliente==null)
			throw new NullPointerException("ERROR: No se puede modificar un cliente nulo.");
		if (!coleccionClientes.contains(cliente))
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		else {
		
			if (nombre!=null && !nombre.isBlank()) {
				
				cliente.setNombre(nombre);
			}
				if (telefono!=null && !telefono.isBlank()) {
					
				cliente.setTelefono(telefono);
				}
		}	
	}
}
  