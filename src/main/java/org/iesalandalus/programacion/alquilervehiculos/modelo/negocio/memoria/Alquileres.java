package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IAlquileres;



public class Alquileres implements IAlquileres {
	private static List<Alquiler> coleccionAlquileres;

	public Alquileres() {
		coleccionAlquileres=new ArrayList<>();
	}



	@Override
	public List<Alquiler> get() {
		List<Alquiler> nuevaColeccion = new ArrayList<>();
		nuevaColeccion.addAll(coleccionAlquileres);
		return nuevaColeccion;
	}



	@Override
	public List<Alquiler> get(Cliente cliente){

		List<Alquiler> coleccionParaCliente = new ArrayList<>();
		for (Alquiler alquilercliente : coleccionAlquileres)
			if (alquilercliente.getCliente().equals(cliente)) {
				coleccionParaCliente.add((Alquiler) coleccionAlquileres);
			}
		return coleccionParaCliente;
	}



	@Override
	public List<Alquiler> get(Vehiculo vehiculo){

		List<Alquiler> coleccionParaVehiculo = new ArrayList<>();
		for (Alquiler alquilervehiculo : coleccionAlquileres)
			if (alquilervehiculo.getVehiculo().equals(vehiculo)) {
				coleccionParaVehiculo.add( (Alquiler) coleccionAlquileres);
			}
		return coleccionParaVehiculo;
	}
	@Override
	public int getCantidad(){
		return coleccionAlquileres.size();


	}



	private void comprobarAlquiler(Cliente cliente, Vehiculo vehiculo, LocalDate fechaAlquiler) {
		if (cliente==null)
			throw new NullPointerException("ERROR: El cliente no puede ser nulo.");
		if (vehiculo==null)
			throw new NullPointerException("ERROR: El vehiculo no puede ser nulo.");

		for (Alquiler alq : get(cliente)) {
			if (alq.getFechaDevolucion()==null) {
				throw new NullPointerException("ERROR: El cliente tiene otro alquiler sin devolver.");
			}
			if (alq.getFechaDevolucion().isAfter(fechaAlquiler)|| alq.getFechaDevolucion().equals(fechaAlquiler)) {
				throw new IllegalArgumentException("ERROR: El cliente tiene un alquiler posterior.");
			}
		}

		for (Alquiler alq : get(vehiculo)) {
			if (alq.getFechaDevolucion()==null) {
				throw new NullPointerException("ERROR: El vehiculo actualmente esta alquilado. ");
			}
			if (alq.getFechaDevolucion().isAfter(fechaAlquiler)|| alq.getFechaDevolucion().equals(fechaAlquiler)) {
				throw new IllegalArgumentException("ERROR: El vehiculo tiene un alquiler posterior.");
			}
		}

	}



	@Override
	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
			
		if (alquiler==null) {
			throw new NullPointerException("ERROR: No se puede insertar un alquiler nulo.");
		}
		comprobarAlquiler(alquiler.getCliente(),alquiler.getVehiculo(),alquiler.getFechaAlquiler());
		coleccionAlquileres.add(alquiler);	
	}


	@Override
	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		if (alquiler ==null) 
			throw new NullPointerException("ERROR: No se puede devolver un alquiler nulo.");
		
		if (fechaDevolucion ==null) 
		
			throw new NullPointerException("ERROR: La fecha de devolución no puede ser nula.");
		
		if (coleccionAlquileres.contains(alquiler))
			throw new OperationNotSupportedException("ERROR: No existe ningun alquiler igual.");
		
		alquiler.devolver(fechaDevolucion);
		}
	
	
	
	
	@Override
	public Alquiler buscar(Alquiler alquiler){
		int indice;
		indice = coleccionAlquileres.indexOf(alquiler);
		if (alquiler==null)
			throw new NullPointerException("ERROR: No se puede buscar un alquiler nulo.");
		if (indice !=-1)
			return	coleccionAlquileres.get(indice);
		else
			return null;
	}



	@Override
	public void borrar(Alquiler alquiler) throws OperationNotSupportedException{
		int indice;
		indice = coleccionAlquileres.indexOf(alquiler);
		if (alquiler==null)
			throw new NullPointerException("ERROR: No se puede borrar un alquiler nulo.");
		if (indice ==-1)
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
		else
			coleccionAlquileres.remove(indice);
	}
}

