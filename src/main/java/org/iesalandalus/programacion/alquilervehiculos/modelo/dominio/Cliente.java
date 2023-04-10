package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;





public class Cliente {
	
	private static String ER_DNI = "(\\d{8})([a-zA-Z])";
	private String ER_TELEFONO = "[967]\\d{8}";
	private String ER_NOMBRE = "^[A-Z][a-zñáéíóú]+([\\s][A-Z][a-zñáéíóú]+)*$";
	private String nombre;
	private String dni;
	private String telefono;
	
	public Cliente(String nombre, String dni, String telefono) {
		setNombre(nombre);
		setDni(dni);
		setTelefono(telefono);
		
	}
	public Cliente(Cliente cliente) {
		if (cliente == null)
			throw new NullPointerException("ERROR: No es posible copiar un cliente nulo.");
		setNombre(cliente.getNombre());
		setDni(cliente.getDni());
		setTelefono(cliente.getTelefono()); 
	}
	
	private boolean comprobarLetraDni(String dni) {

		boolean verificador = true;
		Pattern patron;
		Matcher comparador;

		patron = Pattern.compile(ER_DNI);

		comparador = patron.matcher(dni);

		if (!comparador.matches()) {
			throw new IllegalArgumentException("ERROR: El DNI no tiene un formato válido.");
		}

		System.out.printf("Numero: %s%n", comparador.group(1));
		System.out.printf("Letra NIF: %s%n", comparador.group(2));
		String[] letras = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V","H", "L", "C", "K", "E" };
		int dniNum = Integer.parseInt(comparador.group(1));
		

		String letraDni = comparador.group(2);
		System.out.println(letras[dniNum % 23]);
		if (letras[dniNum % 23].equals(letraDni) ) {

			
			System.out.println("dni es correcto");
			verificador = true;

		} else {
			

			verificador = false;
			System.out.println("dni es incorrecto");

		}
		return verificador;
	}
	public static Cliente getClienteConDni(String dni) {
		return new Cliente ("Jarri Popottas", dni,"666999666");	

		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) throws IllegalArgumentException {
		
		if (nombre!=null)
			this.nombre = nombre;
		else 
			throw new NullPointerException("ERROR: El nombre no puede ser nulo.");
		if ( !nombre.matches(ER_NOMBRE))
			throw new IllegalArgumentException("ERROR: El nombre no tiene un formato válido.");
		
		}
	public String getDni() {
		return dni;
	}
	private void setDni(String dni) {
		if (dni!=null)
			this.dni = dni;
		else 
			throw new NullPointerException("ERROR: El DNI no puede ser nulo.");
		
		if  ((comprobarLetraDni(dni)!=true))
			throw new IllegalArgumentException("ERROR: La letra del DNI no es correcta.");
		if	( !dni.matches(ER_DNI))
				throw new IllegalArgumentException("ERROR: El DNI no tiene un formato válido.");
	
	
		
	}
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni);
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono)  {
		if (telefono!=null)
			this.telefono = telefono;
		else 
			throw new NullPointerException("ERROR: El teléfono no puede ser nulo.");
		if ( !telefono.matches(ER_TELEFONO))
			throw new IllegalArgumentException("ERROR: El teléfono no tiene un formato válido.");
	}
	@Override
	public String toString() {
		return  nombre + " - " + dni + " (" + telefono +")" ;
	}
}
