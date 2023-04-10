package org.iesalandalus.programacion.alquilervehiculos.vista.texto;

public enum Accion {
SALIR("SALIR"),INSERTAR_CLIENTE("INSERTAR_CLIENTE"),INSERTAR_VEHICULO("INSERTAR_VEHICULO"),INSERTAR_ALQUILER("INSERTAR_ALQUILER"),
BUSCAR_CLIENTE("BUSCAR_CLIENTE"),BUSCAR_VEHICULO("BUSCAR_VEHICULO"),BUSCAR_ALQUILER("BUSCAR_ALQUILER"),
MODIFICAR_CLIENTE("MODIFICAR_CLIENTE"),DEVOLVER_ALQUILER("DEVOLVER_ALQUILER"),BORRAR_CLIENTE("BORRAR_CLIENTE"),
BORRAR_VEHICULO("BORRAR_VEHICULO"),BORRAR_ALQUILER("BORRAR_ALQUILER"),LISTAR_CLIENTES("LISTAR_CLIENTES"),
LISTAR_VEHICULOS("LISTAR_VEHICULOS"),LISTAR_ALQUILERES("LISTAR_ALQUILERES"),
LISTAR_ALQUILERES_CLIENTE("LISTAR_ALQUILERES_CLIENTE"),LISTAR_ALQUILERES_VEHICULO("LISTAR_ALQUILERES_VEHICULO");

private String texto;
	
	private Accion(String texto) {
		
		this.texto=texto;
		
	}
	private boolean esOrdinalValido(int ordinal) {
		Accion[] opciones =values();
		
		return ordinal >= 0 && ordinal <= opciones.length; 
	}
	public static Accion get(int ordinal) {
		Accion accion;
		switch (ordinal) {
		case 0: 
			accion =  Accion.SALIR;
            break;
		case 1: 
			accion = Accion.INSERTAR_CLIENTE;
            break;
		case 2: 
			accion =  Accion.INSERTAR_VEHICULO;
            break;
		case 3: 
			accion = Accion.INSERTAR_ALQUILER;
            break;
		case 4: 
			accion =  Accion.BUSCAR_CLIENTE;
            break;
		case 5: 
			accion =  Accion.BUSCAR_VEHICULO;
            break;
		case 6: 
			accion =  Accion.BUSCAR_ALQUILER;
            break;
		case 7: 
			accion =  Accion.MODIFICAR_CLIENTE;
            break;
		case 8: 
			accion =  Accion.DEVOLVER_ALQUILER;
            break;
		case 9: 
			accion = Accion.BORRAR_CLIENTE;
            break;
		case 10: 
			accion = Accion.BORRAR_VEHICULO;
            break;
		case 11: 
			accion = Accion.BORRAR_ALQUILER;
            break;
		case 12: 
			accion =  Accion.LISTAR_CLIENTES;
            break;
		case 13: 
			accion =  Accion.LISTAR_VEHICULOS;
            break;
		case 14: 
			accion =  Accion.LISTAR_ALQUILERES;
            break;
		case 15: 
			accion =  Accion.LISTAR_ALQUILERES_CLIENTE;
            break;
		case 16: 
			accion = Accion.LISTAR_ALQUILERES_VEHICULO;
            break;
			
		
		default:
			throw new IllegalArgumentException("ERROR: Esa no es una opcion valida.");
		}
		return  accion;
	}
	@Override
	public String toString() {
		return texto;
	}
}
