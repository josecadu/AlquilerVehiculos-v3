package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import javax.naming.OperationNotSupportedException;

public class Alquiler {
	public static DateTimeFormatter FORMATO_FECHA= DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final int PRECIO_DIA=20;
	private LocalDate fechaAlquiler;
	private LocalDate fechaDevolucion;
	private Cliente cliente;
	private Vehiculo vehiculo;
	
	public Alquiler(Cliente cliente, Vehiculo vehiculo, LocalDate fechaAlquiler) {
		setCliente(cliente);
		setVehiculo(vehiculo);
		setFechaAlquiler(fechaAlquiler);
		
	}
	public Alquiler(Alquiler alquiler) {
		if (alquiler == null)
			throw new NullPointerException("ERROR: No es posible copiar un alquiler nulo.");
		if (alquiler.getFechaDevolucion()==null) {
			throw new NullPointerException("ERROR: La fecha de devolución no puede ser nula");
		}
		setCliente(new Cliente (alquiler.getCliente()));
		
		if (alquiler.getVehiculo() instanceof Turismo) {
			setVehiculo(new Turismo((Turismo) alquiler.getVehiculo()));
		}
		if (alquiler.getVehiculo() instanceof Autobus) {
			setVehiculo (new Autobus((Autobus) alquiler.getVehiculo()));
			}
		if (alquiler.getVehiculo() instanceof Furgoneta) {
			setVehiculo (new Furgoneta((Furgoneta) alquiler.getVehiculo()));
			}
		setFechaAlquiler(alquiler.getFechaAlquiler());
		if (fechaDevolucion!=null)
		setFechaDevolucion(alquiler.getFechaDevolucion());
			
	}
	public LocalDate getFechaAlquiler() {
		return fechaAlquiler;
	}
	private void setFechaAlquiler(LocalDate fechaAlquiler) { 
		if (fechaAlquiler==null)
			throw new NullPointerException("ERROR: La fecha de alquiler no puede ser nula.");
		
		if (fechaAlquiler.isAfter(LocalDate.now()))
			throw new IllegalArgumentException("ERROR: La fecha de alquiler no puede ser futura.");
		this.fechaAlquiler = fechaAlquiler;
	}
	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}
	private void setFechaDevolucion(LocalDate fechaDevolucion) {
		if (fechaDevolucion==null)
			throw new NullPointerException("ERROR: La fecha de devolución no puede ser nula.");
		if (fechaDevolucion.isAfter(LocalDate.now()))
			throw new IllegalArgumentException("ERROR: La fecha de devolución no puede ser futura.");
		if (fechaDevolucion.equals(fechaAlquiler) || fechaDevolucion.isBefore(fechaAlquiler))
			throw new IllegalArgumentException("ERROR: La fecha de devolución debe ser posterior a la fecha de alquiler.");
		this.fechaDevolucion = fechaDevolucion;
		
	}
	public Cliente getCliente() {
		return cliente;
	}
	private void setCliente(Cliente cliente) {
		if (cliente==null)
			throw new NullPointerException("ERROR: El cliente no puede ser nulo.");
		this.cliente =cliente;
		
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	private void setVehiculo(Vehiculo vehiculo) {
		if (vehiculo==null)
			throw new NullPointerException("ERROR: El vehiculo no puede ser nulo.");
		this.vehiculo = vehiculo;
	
		
	}
	public void devolver(LocalDate fechaDevolucion) throws OperationNotSupportedException {
		if (fechaDevolucion==null)
			throw new NullPointerException("ERROR: La fecha de devolución no puede ser nula.");
		if (getFechaDevolucion()!=null)
			throw new OperationNotSupportedException("ERROR: La devolución ya estaba registrada.");
		setFechaDevolucion(fechaDevolucion);
	
	}
	public int getPrecio() {
		LocalDate fecha1 = getFechaAlquiler();
		
		LocalDate fecha2 = getFechaDevolucion();
		if (fecha2!=null)
		{
		
		int	factorPrecio= vehiculo.getFactorPrecio();
		int numDias = (int)ChronoUnit.DAYS.between(fecha1, fecha2);
		return (PRECIO_DIA+factorPrecio)*numDias;
		}
		else return 0;
		
	}
	@Override
	public int hashCode() {
		return Objects.hash(cliente, fechaAlquiler, vehiculo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alquiler other = (Alquiler) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(fechaAlquiler, other.fechaAlquiler)
				&& Objects.equals(vehiculo, other.vehiculo);
	}
	@Override
	public String toString() {
		if (fechaDevolucion == null)
		return cliente + " <---> " + vehiculo + ", " + fechaAlquiler.format(FORMATO_FECHA) + " - " + "Aún no devuelto (" + getPrecio() + "€)";
		else return cliente + " <---> " + vehiculo + ", " + fechaAlquiler.format(FORMATO_FECHA) + " - " + fechaDevolucion.format(FORMATO_FECHA) + " (" + getPrecio() + "€)";
	}
	}
