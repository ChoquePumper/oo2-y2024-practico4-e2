package oo2.practico4.ejercicio2.mailservice;


import oo2.practico4.ejercicio2.modelo.Email;
import oo2.practico4.ejercicio2.modelo.Notificador;

public class NotificadorCumplePorMail extends NotificacionPorMail implements Notificador {
	public NotificadorCumplePorMail(ServicioEmail servicio) {
		super(servicio);
	}

	@Override
	public void notificar(Email email, String saludo) {
		notificar(armarMensaje(email, saludo));
	}

	// El armado del mensaje podría ir en otra clase.
	private Mensaje armarMensaje(Email email, String saludo) {
		return new MensajeSimple(
				"avisos.empleados@example.com",
				email.toString(),
				"Feliz cumpleaños",
				armarCuerpo(saludo));
	}

	private String armarCuerpo(String saludo) {
		return saludo;
	}

}
