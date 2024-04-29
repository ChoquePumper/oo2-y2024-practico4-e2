package oo2.practico4.ejercicio2.modelo;

import java.time.LocalDate;

public class Empleado {
	private final String nombre, apellido;

	private final LocalDate fechaDeNacimiento;
	private final Email email;

	public Empleado(String nombre, String apellido, LocalDate fechaDeNacimiento, Email email) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public Email getEmail() {
		return email;
	}
}
