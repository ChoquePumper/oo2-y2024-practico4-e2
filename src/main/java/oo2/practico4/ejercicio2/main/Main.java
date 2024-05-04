package oo2.practico4.ejercicio2.main;

import oo2.practico4.ejercicio2.modelo.Empleado;
import oo2.practico4.ejercicio2.persistencia.ArchivoCSV;

import java.io.File;
import java.io.StringWriter;
import java.net.URISyntaxException;

public class Main {
	public static void main(String[] args) throws URISyntaxException {
		var csv = new File(Thread.currentThread().getContextClassLoader().getResource("empleados.csv").toURI());

		new ArchivoCSV(csv).obtenerListaDeEmpleados().forEach((e) -> System.out.println(verEmpleado(e)));
	}

	private static String verEmpleado(Empleado e) {
		StringWriter sw = new StringWriter();
		final var SEP = ", ";
		sw.append(verCampo("Nombre", e.getNombre())).append(SEP);
		sw.append(verCampo("Apellido", e.getApellido())).append(SEP);
		sw.append(verCampo("FechaDeCumpleaños", e.getFechaDeNacimiento())).append(SEP);
		sw.append(verCampo("Email", e.getEmail())).append(SEP);
		return sw.toString();
	}

	private static <T> String verCampo(String nombre, T obj) {
		return String.format("%s='%s'", nombre, obj.toString());
	}
}
