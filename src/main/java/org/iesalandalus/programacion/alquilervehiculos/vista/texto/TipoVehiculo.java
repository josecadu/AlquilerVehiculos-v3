package org.iesalandalus.programacion.alquilervehiculos.vista.texto;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;

public enum TipoVehiculo {
TURISMO("Turismo"),AUTOBUS("Autobus"),FURGONETA("Furgoneta");
	private String nombre;
	private TipoVehiculo(String nombre) {
		this.nombre=nombre;
}
	private boolean esOrdinalValido(int ordinal) {
		TipoVehiculo[] opciones =values();
		
		return ordinal >= 0 && ordinal <= opciones.length; 
	}

	public static TipoVehiculo get(int ordinal) {
		TipoVehiculo opcion ;
		switch (ordinal) {
		case 0: 
			opcion =  TipoVehiculo.TURISMO;
            break;
		case 1: 
			opcion = TipoVehiculo.AUTOBUS;
            break;
		case 2: 
			opcion = TipoVehiculo.FURGONETA;
            break;
		default:
			throw new IllegalArgumentException("ERROR: Ese no es un tipo de vehiculo valido.");
		}
		
		return opcion;
	}
	public static TipoVehiculo get(Vehiculo vehiculo) {
		return get(vehiculo);
		
	}
	@Override
	public String toString() {
		return nombre;
	}
	}
