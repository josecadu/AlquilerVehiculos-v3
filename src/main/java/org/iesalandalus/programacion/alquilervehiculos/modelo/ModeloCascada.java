package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Autobus;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Furgoneta;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IFuenteDatos;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria.Vehiculos;

public class ModeloCascada extends Modelo {
	

	
	public ModeloCascada(IFuenteDatos fuenteDatos) {	
		clientes = fuenteDatos.crearClientes();
		vehiculos = fuenteDatos.crearVehiculos();
		alquileres = fuenteDatos.crearAlquileres();
	}
	public void comenzar() {
		clientes = new Clientes();
		vehiculos = new Vehiculos();
		alquileres = new Alquileres();

	}
	public void terminar() {
		System.out.println("El modelo ha terminado.");
	}


	public void insertar(Cliente cliente) throws OperationNotSupportedException {

		clientes.insertar(new Cliente(cliente));

	}
	public void insertar(Vehiculo vehiculo) throws OperationNotSupportedException {
		
		if (vehiculo  instanceof Turismo) {

			Turismo turismo=(Turismo) vehiculo;
			vehiculos.insertar(new Turismo(turismo));
		}
		if (vehiculo  instanceof Autobus){
			
			Autobus autobus =(Autobus) vehiculo;
			vehiculos.insertar(new Autobus(autobus));
		}
		if (vehiculo  instanceof Furgoneta){
			
			Furgoneta furgoneta=(Furgoneta) vehiculo;
			vehiculos.insertar(new Furgoneta(furgoneta));
		}
	}
	public void insertar(Alquiler alquiler)  throws OperationNotSupportedException {
		if (alquiler== null)
			throw new NullPointerException("ERROR: No se puede insertar unn alquiler nulo.");
		Cliente cliente = clientes.buscar(alquiler.getCliente());
		Vehiculo vehiculo = vehiculos.buscar(alquiler.getVehiculo());
		if (cliente== null || vehiculo==null)
			throw new OperationNotSupportedException("ERROR: No existe cliente del alquiler.");
		alquileres.insertar(new Alquiler(alquiler));
	}
	public Cliente buscar(Cliente cliente) {
		Cliente clienteB = clientes.buscar (cliente);
		
		if (clienteB==null)
			return null;
		else return new Cliente(clienteB.getNombre(),clienteB.getDni(),clienteB.getTelefono());
		

	}
	public Vehiculo buscar(Vehiculo vehiculo) {
		
		Vehiculo vehiculoB = vehiculos.buscar(vehiculo);
		
		if(vehiculoB!=null) {
			if (vehiculoB  instanceof Turismo) {
				
				Turismo turismo = (Turismo) vehiculoB;
				return new Turismo(turismo.getMarca(),turismo.getModelo(),turismo.getCilindrada(),turismo.getMatricula());
				
			}
			else if (vehiculoB  instanceof Autobus){
				
				Autobus autobus =(Autobus) vehiculoB;
				
				return new Autobus(autobus.getMarca(),autobus.getModelo(),autobus.getPlazas(),autobus.getMatricula());
			}
			else      {
				
				Furgoneta furgoneta=(Furgoneta) vehiculoB;
					
				return new Furgoneta(furgoneta.getMarca(),furgoneta.getModelo(),furgoneta.getPma(),furgoneta.getPlazas(),furgoneta.getMatricula());
			}
		}
		else return null;
		
		
		
	}
	public Alquiler buscar(Alquiler alquiler) {
		Alquiler alquilerB = alquileres.buscar(alquiler);
		if (alquilerB==null)
			return null;
		else return new Alquiler(alquilerB.getCliente(),alquilerB.getVehiculo(),alquilerB.getFechaAlquiler());
	}
	public void modificar(Cliente cliente,String nombre, String telefono) throws OperationNotSupportedException {
		if (cliente== null)
			throw new NullPointerException("ERROR: No hay un cliente con ese DNI.");
		clientes.modificar( cliente, nombre, telefono);
	}
	public void devolver(Alquiler alquiler , LocalDate fechaDevolucion) throws OperationNotSupportedException {
		if (alquiler==null)
			throw new NullPointerException("ERROR: Ese alquiler no existe.");
		alquileres.devolver(alquiler, fechaDevolucion);
	}

	public void borrar(Cliente cliente) throws OperationNotSupportedException {

		clientes.borrar(cliente);

	} 
	public void borrar(Vehiculo vehiculo) throws OperationNotSupportedException {

		vehiculos.borrar(vehiculo);
	}
	public void borrar(Alquiler alquiler) throws OperationNotSupportedException{
		
		alquileres.borrar(alquiler);
	}
	public List<Cliente> getClientes(){
		List<Cliente> getCli = new ArrayList<>();
		for (Cliente cojerCli : clientes.get())
			getCli.add(new Cliente(cojerCli.getNombre(),cojerCli.getDni(),cojerCli.getTelefono()));
		return getCli;
	}
	public List<Vehiculo> getVehiculos(){
		List<Vehiculo> getVe = new ArrayList<>();
		for (Vehiculo cojerVe : vehiculos.get())
			if(cojerVe!=null) {
				if (cojerVe  instanceof Turismo) {
					
					Turismo turismo = (Turismo) cojerVe;
					getVe.add(new Turismo(turismo.getMarca(),turismo.getModelo(),turismo.getCilindrada(),turismo.getMatricula()));
					
				}
				else if (cojerVe  instanceof Autobus){
					
					Autobus autobus =(Autobus) cojerVe;
					
					getVe.add( new Autobus(autobus.getMarca(),autobus.getModelo(),autobus.getPlazas(),autobus.getMatricula()));
				}
				else      {
					
					Furgoneta furgoneta=(Furgoneta) cojerVe;
						
					getVe.add( new Furgoneta(furgoneta.getMarca(),furgoneta.getModelo(),furgoneta.getPma(),furgoneta.getPlazas(),furgoneta.getMatricula()));
				}
			}
		return getVe;
	}
	public List<Alquiler> getAlquileres(){
		List<Alquiler> getAl = new ArrayList<>();
		for (Alquiler cojerAl : alquileres.get())
			getAl.add(new Alquiler(cojerAl.getCliente(),cojerAl.getVehiculo(),cojerAl.getFechaAlquiler()));
		return getAl;
	}
	public List<Alquiler> getAlquileres(Cliente cliente){
		List<Alquiler> getAl = new ArrayList<>();
		for (Alquiler cojerAl : alquileres.get(cliente))
			getAl.add(new Alquiler(cojerAl.getCliente(),cojerAl.getVehiculo(),cojerAl.getFechaAlquiler()));
		return getAl;
	}
	public List<Alquiler> getAlquileres(Vehiculo vehiculo){
		List<Alquiler> getAl = new ArrayList<>();
		for (Alquiler cojerAl : alquileres.get(vehiculo))
			getAl.add(new Alquiler(cojerAl.getCliente(),cojerAl.getVehiculo(),cojerAl.getFechaAlquiler()));
		return getAl;
	}
	
}
	

