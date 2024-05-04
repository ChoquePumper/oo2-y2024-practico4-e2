package oo2.practico4.ejercicio2.persistencia;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import oo2.practico4.ejercicio2.modelo.Email;
import oo2.practico4.ejercicio2.modelo.Empleado;
import oo2.practico4.ejercicio2.modelo.Empleados;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class ArchivoCSV implements Empleados {
	private final CSVReader archivo;

	public ArchivoCSV(File archivo) {
		var parser = new CSVParserBuilder().withIgnoreLeadingWhiteSpace(true).build();
		try {
			this.archivo = new CSVReader(new FileReader(archivo), 0, parser);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

	}

	public LocalDate crearFecha(String fecha) {
		return LocalDate.parse(fecha, DateTimeFormatter.ofPattern("uuuu/MM/dd"));
	}

	@Override
	public List<Empleado> obtenerListaDeEmpleados() {
		try {
			// Descartar primera linea por ser el encabezado.
			archivo.readNext();

			// Linea: apellido, nombre, fecha de nacimiento, email
			return archivo.readAll().stream()
					.peek(linea -> Arrays.setAll(linea, i -> linea[i].trim()))
					.map(linea -> new Empleado(linea[1], linea[0], crearFecha(linea[2]), new Email(linea[3])))
					.toList();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
