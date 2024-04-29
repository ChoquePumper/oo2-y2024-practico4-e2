package oo2.practico4.ejercicio2.modelo;

import java.util.Objects;

public class Email {
	public String email;

	public Email(String emailString) {
		// Cambiar null por un string vacío.
		emailString = Objects.requireNonNullElse(emailString, "").trim();

		// Tirar excepción si el string está en blanco.
		if (emailString.isBlank())
			throw new RuntimeException("No se ingresó un email.");

		// Validar formato de email
		if (!emailString.matches("/^[\\w\\-\\.]+@([\\w-]+\\.)+[\\w-]{2,}$/gm"))
			throw new IllegalArgumentException("Formato de email incorrecto");

		this.email = emailString;
	}

	@Override
	public String toString() {
		return this.email;
	}
}
