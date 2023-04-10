package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

public abstract  class  Vehiculo {
	private final static String ER_MARCA= "^[a-zA-Z0-9]{3,}([\\s-][a-zA-Z0-9]{3,})*$";
	private final static String ER_MATRICULA= "[0-9]{4}(?!.*(LL|CH))[BCDFGHJKLMNPRSTVWXYZ]{3}";
	private String marca;
	private String modelo;
	private String matricula;
	
	protected Vehiculo (String marca,String modelo,String matricula) {
		setMarca(marca);
		setModelo(modelo);
		setMatricula(matricula);
	}
	protected Vehiculo (Vehiculo vehiculo) {
		if (vehiculo == null)
		throw new NullPointerException("ERROR: No es posible copiar un turismo nulo.");
		setMarca(vehiculo.getMarca());
		setModelo(vehiculo.getModelo());
		setMatricula(vehiculo.getMatricula());
		
	}
	public static Vehiculo copiar (Vehiculo vehiculo) {
		if (vehiculo  instanceof Turismo) {

			Turismo turismo=(Turismo) vehiculo;
			return new Turismo(turismo);
		}
		else if (vehiculo  instanceof Autobus){
			
			Autobus autobus =(Autobus) vehiculo;
			return new Autobus(autobus);
		}
		else {
			
			Furgoneta furgoneta=(Furgoneta) vehiculo;
			return new Furgoneta(furgoneta);
		}
		
	}
	public static Vehiculo getVehiculoConMatricula(String matricula) {
		return new Turismo("Ford", "Focus",1600, matricula);
	}
	protected abstract int getFactorPrecio();

	public String getMarca() {
		return marca;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Vehiculo))
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(matricula, other.matricula);
	}
	protected void setMarca(String marca) throws IllegalArgumentException {
		if (marca!=null)
			this.marca = marca;
		else 
			throw new NullPointerException("ERROR: La marca no puede ser nula.");
		if ( !marca.matches(ER_MARCA)||marca.isEmpty()||marca.isBlank())
			throw new IllegalArgumentException("ERROR: La marca no tiene un formato válido.");
		
	}

	public String getModelo() {
		return modelo;
	}

	protected void setModelo(String modelo) throws IllegalArgumentException{
		if (modelo!=null)
			this.modelo = modelo;
		else 
			throw new NullPointerException("ERROR: El modelo no puede ser nulo.");
		if (modelo.isEmpty() || modelo.isBlank())
			throw new IllegalArgumentException("ERROR: El modelo no puede estar en blanco.");
		
	}


	public String getMatricula() {
		return matricula;
	}

	protected void setMatricula(String matricula) {
		if (matricula!=null)
			this.matricula = matricula;
		else 
			throw new NullPointerException("ERROR: La matrícula no puede ser nula.");
		if ( !matricula.matches(ER_MATRICULA))
			throw new IllegalArgumentException("ERROR: La matrícula no tiene un formato válido.");
	}
	
}
