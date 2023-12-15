package dev.ubv.juego.wordle.core.util;

import dev.ubv.juego.wordle.core.data.Palabra;

public class Util {

	public static String generarPalabra() {
		int indexPalabra = (int) (Math.random() * (Palabra.palabras.length - 1));
		
		return Palabra.palabras[indexPalabra];
	}
}