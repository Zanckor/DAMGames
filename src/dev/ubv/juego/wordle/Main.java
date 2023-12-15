package dev.ubv.juego.wordle;

import java.util.Scanner;

import dev.ubv.juego.wordle.core.match.Ronda;

public class Main {

	public static void main(String[] args) {
		Ronda ronda = new Ronda();
		
		for(int i = 0; i < 5; i++) {
		Scanner scanner = new Scanner(System.in);
		
		// TODO: Esto se debe usar en la parte de la pantalla
        String underlineOn = "\033[4m";
        String underlineOff = "\033[0m";
        
		char[] palabraIntroducida = scanner.nextLine().toLowerCase().toCharArray();
		
		int[] resultadoComprobarLetras = ronda.comprobarLetras(palabraIntroducida);
		
		for(int index = 0; index < palabraIntroducida.length; index++) {
			switch(resultadoComprobarLetras[index]) {
			case Ronda.ACERTADO -> System.out.print(palabraIntroducida[index]);
			case Ronda.NO_ACERTADO -> System.out.print("-");
			case Ronda.POSICION_INCORRECTA -> System.out.print(underlineOn + palabraIntroducida[index] + underlineOff);
			}
		}
		
		System.out.println("\n\n");
		}
	}
}