package org.iesalandalus.programacion.alquilervehiculos.vista.texto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Autobus;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Furgoneta;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.utilidades.Entrada;


public class Consola {
private final static String PATRON_FECHA = "^([0-2][0-9]|3[0-1])\\/(0[1-9]|1[0-2])\\2(\\d{4})$";
private final static DateTimeFormatter FORMATO_FECHA= DateTimeFormatter.ofPattern("dd/MM/yyyy");
private Consola() {
	
}
public static void mostrarCabecera(String mensaje) {

	System.out.println(mensaje);
	System.out.println("_".repeat(mensaje.length()));
}
public static void mostrarMenuAcciones() {
	System.out.println("__________________BIENVENIDO__________________");
	System.out.println("_Este es el sistema de alquiler de vehiculos._");
	System.out.println("______________________________________________");
	System.out.println("___________________OPCIONES___________________");
	System.out.println("______________________________________________");
	System.out.println("____________1___INSERTAR_CLIENTE______________");
	System.out.println("____________2___INSERTAR_VEHICULO_____________");
	System.out.println("____________3___INSERTAR_ALQUILER_____________");
	System.out.println("____________4___BUSCAR_CLIENTE________________");
	System.out.println("____________5___BUSCAR_VEHICULO_______________");
	System.out.println("____________6___BUSCAR_ALQUILER_______________");
	System.out.println("____________7___MODIFICAR_CLIENTE_____________");
	System.out.println("____________8___DEVOLVER_ALQUILER_____________");
	System.out.println("____________9___BORRAR_CLIENTE________________");
	System.out.println("____________10__BORRAR_VEHICULO_______________");
	System.out.println("____________11__BORRAR_ALQUILER_______________");
	System.out.println("____________12__LISTAR_CLIENTES_______________");
	System.out.println("____________13__LISTAR_VEHICULOS______________");
	System.out.println("____________14__LISTAR_ALQUILERES_____________");
	System.out.println("____________15__LISTAR_ALQUILERES_CLIENTE_____");
	System.out.println("____________16__LISTAR_ALQUILERES_VEHICULO____");
	System.out.println("______________________________________________");
	System.out.println("____________0________SALIR____________________");
}
	private static String leerCadena(String mensaje) {
		System.out.println(mensaje);
		return Entrada.cadena();
	}
	private static Integer leerEntero(String mensaje) {
		System.out.println(mensaje);
		return Entrada.entero();
	}
	private static LocalDate leerFecha(String mensaje) {
		String fechaInt;
		do {
		System.out.println(mensaje);
		fechaInt=Entrada.cadena();
		}
		while (!fechaInt.matches(PATRON_FECHA));
		
		return LocalDate.parse(fechaInt ,FORMATO_FECHA);
			
	}
	public static Accion elegirAccion() {
		Accion accionElegida=null;
		boolean i=false;
		int opcion = leerEntero("Elija una opcion: ");
		  while (i == false) { 
	            try {
	                accionElegida = Accion.get(opcion);
	                i = true;
	            } catch (Exception E) {	        
	               opcion = leerEntero("Elija de nuevo, una opción correcta: ");
	            }
	        }
		return accionElegida;
	}
	public static Cliente leerCliente() {
		String nombre=leerCadena("Introduzca el nombre del cliente: ");
		String dni=leerCadena("Introduzaca el DNI del cliente: ");
		String telefono=leerCadena("introduzca el telefono del cliente: ");
		return new Cliente(nombre, dni, telefono);
	}
	public static Cliente leerClienteDni() {
		String dni=leerCadena("Introduzaca el DNI del cliente: ");
		return Cliente.getClienteConDni(dni);
	}
	public static String leerNombre() {
	return leerCadena("Introduzca un nombre: ");
		
	}
	public static String leerTelefono() {
	return leerCadena("introduzca un telefono: ");
	}
	private static void mostrarMenuTiposVehiculos() {
		System.out.println("___________Elije un tipo de vehiculo__________");
		System.out.println("______________________________________________");
		System.out.println("___________________OPCIONES___________________");
		System.out.println("______________________________________________");
		System.out.println("____________0______TURISMO____________________");
		System.out.println("____________1______AUTOBUS____________________");
		System.out.println("____________2______FURGONETA__________________");
	}
	private static TipoVehiculo elegirTipoVehiculo() {
		mostrarMenuTiposVehiculos();
		TipoVehiculo TipoElegido=null;
		boolean i=false;
		int opcion = leerEntero("Elija una opcion: ");
		  while (i == false) { 
	            try {
	                TipoElegido = TipoVehiculo.get(opcion);
	                i = true;
	            } catch (Exception E) {	        
	               opcion = leerEntero("Elija de nuevo, una opción correcta: ");
	            }
	        }
		return TipoElegido;
	}
	public static Vehiculo leerVehiculo() {
		Vehiculo vehiculo = null;
		String marca=leerCadena("Introduzca la marca del vehiculo: ");
		String modelo=leerCadena("Introduzca el modelo del vehiculo: ");
		String matricula=leerCadena("Introduzca la matricula del vehiculo: ");
		TipoVehiculo tipo =elegirTipoVehiculo();
		if (vehiculo  instanceof Turismo) {
			Turismo turismo = (Turismo) vehiculo;	
		int cilindrada=leerEntero("Introduzca la cilindrada del vehiculo: ");
		return new Turismo(marca,modelo,cilindrada,matricula);
		}
		else if(vehiculo instanceof Autobus) {
			Autobus autobus = (Autobus) vehiculo;	
			int plazas=leerEntero("Introduzca las plazas del autobus: ");
			return new Autobus(marca,modelo,plazas,matricula);
		}
		else  {
			Furgoneta furgoneta = (Furgoneta) vehiculo;	
			int pma=leerEntero("Introduzca el Pma de la furgoneta: ");
			int plazas=leerEntero("Introduzca las plazas de la furgoneta: ");
			return new Furgoneta(marca,modelo,pma,plazas,matricula);
		}
	}
	public static Vehiculo leerVehiculoMatricula() {
		String matricula=leerCadena("Introduzaca el la matricula del vehiculo: ");
		return Vehiculo.getVehiculoConMatricula(matricula);
	}
	public static Alquiler leerAlquiler() {
		Cliente cliente=leerClienteDni();
		Vehiculo vehiculo=leerVehiculoMatricula();
		LocalDate fechaAlquiler=leerFecha("Introduzca la fecha de alquiler: ");
		return new Alquiler(cliente,vehiculo,fechaAlquiler);
	}
	public static LocalDate leerFechaDevolucion() {
		LocalDate fechaDevolucion=leerFecha("Introduzca la fecha de devolución: ");
		return fechaDevolucion;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
