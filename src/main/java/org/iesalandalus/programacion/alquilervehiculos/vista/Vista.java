package org.iesalandalus.programacion.alquilervehiculos.vista;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;

public abstract class Vista {
	protected Controlador controlador;
	public void setControlador(Controlador c)
	{
		if(c==null) {
			throw new NullPointerException("ERROR: El controlador no puede ser nulo.");
		}
		this.controlador=c;
	}
	public abstract void comenzar();

	
	public abstract void terminar();
		
}