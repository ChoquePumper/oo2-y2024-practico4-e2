package oo2.practico4.ejercicio2.modelo;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestEmpleadoCumple {

	@Test
	void testCumple() {
		ProveedorFecha fecha = () -> LocalDate.of(2024, 12, 12);
		var empleados = new Empleados() {
			private final Empleado[] array = {
					new Empleado("Ab", "Cd", LocalDate.of(2000, 12, 12), new Email("primero@test.com")),
					new Empleado("Em", "Fg", LocalDate.of(2000, 12, 14), new Email("empleadob@test.com")),
					new Empleado("Em", "Fg", LocalDate.of(1997, 12, 12), new Email("otroempleado@test.com")),
			};

			@Override
			public List<Empleado> obtenerListaDeEmpleados() {
				return List.of(array);
			}
		};

		var notificador = new Notificador() {
			private final List<Email> emails = new ArrayList<>();

			@Override
			public void notificar(Email email, String saludo) {
				emails.add(email);
			}

			public boolean estaElEmailEnLaLista(Email email) {
				return emails.contains(email);
			}
		};

		new CumpleEmpleados(empleados, notificador, fecha).saludar();

		assertTrue(notificador.estaElEmailEnLaLista(new Email("primero@test.com")));
		assertFalse(notificador.estaElEmailEnLaLista(new Email("empleadob@test.com")));
		assertTrue(notificador.estaElEmailEnLaLista(new Email("otroempleado@test.com")));
	}

	@Test
	void testEmail() {
		assertThrows(RuntimeException.class, () -> new Email(""));
		assertThrows(RuntimeException.class, () -> new Email(null));
		assertThrows(RuntimeException.class, () -> new Email("example@domain.c"));
		assertDoesNotThrow(() -> new Email("example@domain.com"));
		assertDoesNotThrow(() -> new Email("a@v.co"));

	}
}
