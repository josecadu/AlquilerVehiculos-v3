package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

public class Turismo extends Vehiculo {
	private static final int FACTOR_CILINDRADA = 10;
	private int cilindrada;
	
	
	public Turismo (String marca,String modelo,int cilindrada,String matricula) {
	super(marca,modelo,matricula);
		
		setCilindrada(cilindrada);
		
	}
	public Turismo (Turismo turismo) {
		super(turismo.getMarca(),turismo.getModelo(),turismo.getMatricula());
		setCilindrada(turismo.getCilindrada());
		
		
	}

	@Override
	public String toString() {
		return   getMarca() +" "+ getModelo() + " (" + cilindrada + "CV) - "
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
	public int getCilindrada() {
		return cilindrada;
	}

	private void setCilindrada(int cilindrada) {
		if (cilindrada<=0 ||cilindrada>5000)
			throw new IllegalArgumentException("ERROR: La cilindrada no es correcta.");
		this.cilindrada = cilindrada;
	}


	@Override
	protected int getFactorPrecio() {
		
		return cilindrada/FACTOR_CILINDRADA;
	}
	
}
