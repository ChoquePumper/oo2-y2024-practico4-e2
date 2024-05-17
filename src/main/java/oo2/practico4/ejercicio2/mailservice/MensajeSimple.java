package oo2.practico4.ejercicio2.mailservice;

public record MensajeSimple(String remitente, String destinatario, String asunto, String cuerpo) implements Mensaje {
}
