package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

public class Furgoneta extends Vehiculo {
	private static final int FACTOR_PMA = 100;
	private static final int FACTOR_PLAZAS = 1;
	private int plazas;
	private int pma;
	
	public Furgoneta (String marca,String modelo,int pma,int plazas,String matricula) {
		super(marca,modelo,matricula);
		setPlazas(plazas);
		setPma(pma);
		
	}
	public int getPlazas() {
		return plazas;
	}
	public void setPlazas(int plazas) {
		if (plazas<5)
			throw new IllegalArgumentException("ERROR: Una furgoneta no puede tener menos de 5 plazas");
		if (plazas>9)
			throw new IllegalArgumentException("ERROR: Eso no es una furgoneta es un autobus");
		this.plazas = plazas;
	}
	public int getPma() {
		return pma;
	}
	public void setPma(int pma) {
		if (pma<=0)
			throw new IllegalArgumentException("ERROR: El pma no puede ser inferior a 0");
		this.pma = pma;
	}
	public Furgoneta (Furgoneta furgoneta) {
		super(furgoneta.getMarca(),furgoneta.getModelo(),furgoneta.getMatricula());
		setPlazas(furgoneta.getPlazas());
		setPma(furgoneta.getPma());
		
	}
	


	@Override
	public String toString() {
		return   getMarca() +" "+ getModelo() +"("+ pma +"KG)"+ " (" + plazas + "CV) - "
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
		
		return (pma / FACTOR_PMA) + (plazas * FACTOR_PLAZAS);
	}
	
}
