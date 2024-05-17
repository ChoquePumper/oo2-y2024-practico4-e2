package oo2.practico4.ejercicio2.main;

import oo2.practico4.ejercicio2.mailservice.Mailtrap;
import oo2.practico4.ejercicio2.mailservice.NotificadorCumplePorMail;
import oo2.practico4.ejercicio2.modelo.CumpleEmpleados;
import oo2.practico4.ejercicio2.modelo.Empleado;
import oo2.practico4.ejercicio2.modelo.Notificador;
import oo2.practico4.ejercicio2.modelo.ProveedorFecha;
import oo2.practico4.ejercicio2.persistencia.ArchivoCSV;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.Properties;

public class Main {
	public static void main(String[] args) throws URISyntaxException, IOException {
		Properties prop = new Properties();
		prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));

		// Archivo CSV
		var filecsv = new File(Thread.currentThread().getContextClassLoader().getResource("empleados.csv").toURI());
		var csv = new ArchivoCSV(filecsv);
		//csv.obtenerListaDeEmpleados().forEach((e) -> System.out.println(verEmpleado(e)));

		// Notificador
		Notificador notificador = new NotificadorCumplePorMail(
				new Mailtrap(prop.getProperty("mailtrap.username"), prop.getProperty("mailtrap.password")));

		// Fecha
		ProveedorFecha proveedorFecha = () -> LocalDate.of(1982, 10, 8);

		// Sistema
		var sistema = new CumpleEmpleados(csv, notificador, proveedorFecha);
		sistema.saludar();
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
