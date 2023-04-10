package org.iesalandalus.programacion.alquilervehiculos.vista.texto;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class VistaTexto extends Vista {
	

	
	public  VistaTexto() {
	}
	public void comenzar() {
		Accion accion;
		do {
			Consola.mostrarMenuAcciones();
			accion=Consola.elegirAccion();
			ejecutar(accion);
		}
		while (accion!=Accion.SALIR);

	}
	public void terminar() {
		System.out.println("La vista ha finalizado");
	}
	
	public void ejecutar(Accion accion) {
		
		switch (accion) {
		case SALIR: 
			terminar();
            break;
		case INSERTAR_CLIENTE: 
			insertarCliente();
            break;
		case INSERTAR_VEHICULO: 
			insertarVehiculo();
            break;
		case INSERTAR_ALQUILER: 
			insertarAlquiler();
            break;
		case BUSCAR_CLIENTE: 
			buscarCliente();
            break;
		case BUSCAR_VEHICULO: 
			buscarVehiculo();
            break;
		case BUSCAR_ALQUILER: 
			buscarAlquiler();
            break;
		case MODIFICAR_CLIENTE: 
			modificarCliente();
            break;
		case DEVOLVER_ALQUILER: 
			devolverALquiler();
            break;
		case BORRAR_CLIENTE: 
			borrarCliente();
            break;
		case BORRAR_VEHICULO: 
			borrarVehiculo();
            break;
		case BORRAR_ALQUILER: 
			borrarAlquiler();
            break;
		case LISTAR_CLIENTES: 
			listarClientes();
            break;
		case LISTAR_VEHICULOS: 
			listarVehiculos();
            break;
		case LISTAR_ALQUILERES: 
			listarAlquileres();
            break;
		case LISTAR_ALQUILERES_CLIENTE: 
			listarAlquileresCliente();
            break;
		case LISTAR_ALQUILERES_VEHICULO: 
			listarAlquileresVehiculo();
            break;
		}
	}

	protected void insertarCliente(){
		 Consola.mostrarCabecera("Selecciono insertar cliente");
	        try {
	            controlador.insertar(Consola.leerCliente());
	        } catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
	}
    
	protected void insertarVehiculo() {
		 Consola.mostrarCabecera("Selecciono insertar vehiculo");
	        try {
	            controlador.insertar(Consola.leerVehiculo());
	        } catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
	}
    
	protected void insertarAlquiler() {
		 Consola.mostrarCabecera("Selecciono insertar alquiler");
	        try {
	            controlador.insertar(Consola.leerAlquiler());
	        } catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
	}
   
	protected void buscarCliente() {
		 Consola.mostrarCabecera("Selecciono buscar cliente");
	        try {
	            System.out.println(controlador.buscar(Consola.leerClienteDni()));
	        } catch (NullPointerException | IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
		
	}
   
	protected void buscarVehiculo() {
		 Consola.mostrarCabecera("Selecciono buscar turismo");
	        try {
	            System.out.println(controlador.buscar(Consola.leerVehiculoMatricula()));
	        } catch (NullPointerException | IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
		
	}
   
	protected void buscarAlquiler() {
		 Consola.mostrarCabecera("Selecciono buscar alquiler");
	        try {
	            System.out.println(controlador.buscar(Consola.leerAlquiler()));
	        } catch (NullPointerException | IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
		
	}
  
	protected void modificarCliente() {
		 Consola.mostrarCabecera("Selecciono modificar cliente");
	        try {
	            controlador.modificar(Consola.leerClienteDni(),Consola.leerNombre(),Consola.leerTelefono());
	        } catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
		
	}
  
	protected void devolverALquiler() {
		Consola.mostrarCabecera("Selecciono devolver alquiler");
        try {
            controlador.devolver(Consola.leerAlquiler(),Consola.leerFechaDevolucion());
        } catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
		
	}

	protected void borrarCliente() {
		 Consola.mostrarCabecera("Selecciono borrar cliente");
	        try {
	           controlador.borrar(Consola.leerCliente());
	        } catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
		
	}
 
	protected void borrarVehiculo() {
		 Consola.mostrarCabecera("Selecciono borrar vehiculo");
	        try {
	            controlador.borrar(Consola.leerVehiculo());
	        } catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
		
	}
  
	protected void borrarAlquiler() {
		 Consola.mostrarCabecera("Selecciono borrar alquiler");
	        try {
	            controlador.borrar(Consola.leerAlquiler());
	        } catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
		
	}

	protected void listarClientes() {
		 Consola.mostrarCabecera("Selecciono listar clientes");
	        try {
	            controlador.getClientes();
	        } catch (NullPointerException | IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
		
	}

	protected void listarVehiculos() {
		 Consola.mostrarCabecera("Selecciono listar vehiculos");
	        try {
	            controlador.getVehiculos();
	        } catch (NullPointerException | IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
		
	}
    
	protected void listarAlquileres() {
		 Consola.mostrarCabecera("Selecciono listar alquileres");
	        try {
	            controlador.getAlquileres();
	        } catch (NullPointerException | IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
	}
 
	protected void listarAlquileresCliente() {
		 Consola.mostrarCabecera("Selecciono listar alquileres cliente");
	        try {
	            controlador.getAlquileres(Consola.leerClienteDni());
	        } catch (NullPointerException | IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
		
	}
  
	protected void listarAlquileresVehiculo() {
		 Consola.mostrarCabecera("Selecciono listar alquileres vehiculo");
	        try {
	            controlador.getAlquileres(Consola.leerVehiculoMatricula());
	        } catch (NullPointerException | IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
		
	}
	
}