package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

public class Autobus extends Vehiculo {
	private static final int FACTOR_PLAZAS = 2;
	
	private int plazas;

	
	public Autobus (String marca,String modelo,int plazas,String matricula) {
		super(marca,modelo,matricula);
		setPlazas(plazas);
	}
	public int getPlazas() {
		return plazas;
	}
	public void setPlazas(int plazas) {
		if(plazas<10)
			throw new IllegalArgumentException("ERROR: El numero de plazas no puede ser menor a 10.");
		if(plazas>80)
			throw new IllegalArgumentException("ERROR: El numero de plazas no puede ser mayor a 80.");
		this.plazas = plazas;
	}
	public Autobus (Autobus autobus) {
		super(autobus.getMarca(),autobus.getModelo(),autobus.getMatricula());
		setPlazas(autobus.getPlazas());
		
	}


	@Override
	public String toString() {
		return   getMarca() +" "+ getModelo() + " (" + plazas + "plazas) - "
				+ getMatricula() ;
	}
	@Override
	public int hashCode() {
		return Objects.hash(getMatricula());
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	
	@Override
	protected int getFactorPrecio() {
	
		return plazas*FACTOR_PLAZAS;
	}
	
}
