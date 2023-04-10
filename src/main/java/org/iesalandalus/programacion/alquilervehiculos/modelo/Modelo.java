package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IAlquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IClientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IFuenteDatos;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IVehiculos;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria.Vehiculos;

public abstract class Modelo {
	protected IClientes clientes;
	protected IVehiculos vehiculos;
	protected IAlquileres alquileres;
	protected IFuenteDatos fuenteDatos;
	
	
	protected void setFuenteDatos(IFuenteDatos fuenteDatos ) {
		if (fuenteDatos==null)
			throw new IllegalArgumentException("ERROR: La fuente de datos no es correcta.");
		this.fuenteDatos=fuenteDatos;
	}
	public void comenzar() {
		clientes = new Clientes();
		vehiculos = new Vehiculos();
		alquileres = new Alquileres();

	}
	public void terminar() {
		System.out.println("El modelo ha terminado.");
	}


	public abstract void insertar(Cliente cliente) throws OperationNotSupportedException;
	
	public abstract void insertar(Vehiculo vehiculo) throws OperationNotSupportedException;

	public abstract void insertar(Alquiler alquiler)  throws OperationNotSupportedException;
		
	public abstract Cliente buscar(Cliente cliente);
	
	public abstract Vehiculo buscar(Vehiculo vehiculo);
	
	public abstract Alquiler buscar(Alquiler alquiler);
	
	public abstract void modificar(Cliente cliente,String nombre, String telefono) throws OperationNotSupportedException;
	
	public abstract void devolver(Alquiler alquiler , LocalDate fechaDevolucion) throws OperationNotSupportedException;

	public abstract void borrar(Cliente cliente) throws OperationNotSupportedException;
	
	public abstract void borrar(Vehiculo vehiculo) throws OperationNotSupportedException;
	
	public abstract void borrar(Alquiler alquiler) throws OperationNotSupportedException;
	
	public abstract List<Cliente> getClientes();
	
	public abstract List<Vehiculo> getVehiculos();
	
	public abstract List<Alquiler> getAlquileres();
	
	public abstract List<Alquiler> getAlquileres(Cliente cliente);
	
	public abstract List<Alquiler> getAlquileres(Vehiculo vehiculo);
}
	

