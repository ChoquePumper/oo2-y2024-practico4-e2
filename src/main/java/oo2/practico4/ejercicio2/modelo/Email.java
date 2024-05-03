package oo2.practico4.ejercicio2.modelo;

import java.util.Objects;

public class Email {
	private final String email;

	public Email(String emailString) {
		// Cambiar null por un string vacío.
		emailString = Objects.requireNonNullElse(emailString, "").trim();

		// Tirar excepción si el string está en blanco.
		if (emailString.isBlank())
			throw new RuntimeException("No se ingresó un email.");

		// Validar formato de email
		if (!emailString.matches("[\\w\\-\\.]+@([\\w-]+\\.)+[\\w-]{2,}$"))
			throw new IllegalArgumentException("Formato de email incorrecto");

		this.email = emailString;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Email email1)) return false;
		return Objects.equals(email, email1.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

	@Override
	public String toString() {
		return this.email;
	}
}
