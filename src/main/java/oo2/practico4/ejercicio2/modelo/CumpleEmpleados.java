package oo2.practico4.ejercicio2.modelo;

import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Objects;

public class CumpleEmpleados {

	private final Empleados empleados;
	private final Notificador notificador;
	private final ProveedorFecha proveedorFecha;

	public CumpleEmpleados(Empleados empleados, Notificador notificador) {
		this(empleados, notificador, LocalDate::now);
	}

	public CumpleEmpleados(Empleados empleados, Notificador notificador, ProveedorFecha proveedorFecha) {
		this.empleados = Objects.requireNonNull(empleados);
		this.notificador = Objects.requireNonNull(notificador);
		this.proveedorFecha = Objects.requireNonNull(proveedorFecha);
	}

	public void saludar() {
		empleados.obtenerListaDeEmpleados().stream().filter(this::hoyCumple).forEach(
				empleado -> {
					notificador.notificar(empleado.getEmail(), "Feliz cumpleaños, " + empleado.getNombre());
				}
		);
	}

	private boolean hoyCumple(Empleado empleado) {
		return MonthDay.from(proveedorFecha.hoy()).equals(MonthDay.from(empleado.getFechaDeNacimiento()));
	}

}
