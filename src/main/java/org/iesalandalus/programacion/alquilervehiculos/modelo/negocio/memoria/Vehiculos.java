package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria;

import java.util.ArrayList;
import java.util.List;
import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Autobus;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IVehiculos;

public class Vehiculos implements IVehiculos {
	private static List<Vehiculo> coleccionVehiculos;
	
	public Vehiculos() {
		coleccionVehiculos = new ArrayList<>();
	}
	
	
	
	@Override
	public List<Vehiculo> get(){
		List<Vehiculo> nuevaColeccion = new ArrayList<>();
		nuevaColeccion.addAll(coleccionVehiculos);
		return nuevaColeccion;	
	}
	
	
	
	@Override
	public int getCantidad() {
		return coleccionVehiculos.size();
	}
	
	
	
	@Override
	public void insertar(Vehiculo vehiculo) throws OperationNotSupportedException {
		int indice;
		indice = coleccionVehiculos.indexOf(vehiculo);
		if(vehiculo==null)
			throw new NullPointerException("ERROR: No se puede insertar un turismo nulo.");
		
		if (indice !=-1 && vehiculo!=null)
			throw new OperationNotSupportedException("ERROR: Ya existe un turismo con esa matrícula.");
		else
			coleccionVehiculos.add(vehiculo);	
		if (vehiculo instanceof Turismo)
		System.out.println("El Turismo ha sido añadido correctamente.");
		else if (vehiculo instanceof Autobus)
		System.out.println("El autobus ha sido añadido correctamente.");
		else {
		System.out.println("La furgoneta ha sido añadida correctamente.");
		}
	}

	
	
	@Override
	public Vehiculo buscar(Vehiculo vehiculo) {
	
	int indice;
	indice = coleccionVehiculos.indexOf(vehiculo);
	if(vehiculo==null)
		throw new NullPointerException("ERROR: No se puede buscar un turismo nulo.");
	
	if (indice !=-1)
		return	coleccionVehiculos.get(indice);
	else
		return null;
	}
	
	
	
	@Override
	public void borrar(Vehiculo vehiculo) throws OperationNotSupportedException{
		int indice;
		indice = coleccionVehiculos.indexOf(vehiculo);
		if(vehiculo==null)
			throw new NullPointerException("ERROR: No se puede borrar un turismo nulo.");
		
		if (indice ==-1)
			throw new OperationNotSupportedException("ERROR: No existe ningún turismo con esa matrícula.");
		else
			coleccionVehiculos.remove(indice);
	}
}
