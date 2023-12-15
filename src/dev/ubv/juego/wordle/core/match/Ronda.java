package dev.ubv.juego.wordle.core.match;

import java.util.Arrays;

import dev.ubv.juego.wordle.core.util.Util;

public class Ronda {
	public static final int NO_ACERTADO = 0;
	public static final int ACERTADO = 1;
	public static final int POSICION_INCORRECTA = 2;
	
	private String palabra;
	private char[] caracteres;
	private int[] caracteresAcertados;

	public Ronda() {
		palabra = Util.generarPalabra();
		caracteres = palabra.toCharArray();		
		caracteresAcertados = new int[5];
		
		Arrays.fill(caracteresAcertados, NO_ACERTADO);
	}
	
	public Ronda(String palabra) {
		this.palabra = palabra;
		caracteres = palabra.toCharArray();
		caracteresAcertados = new int[5];
		
		Arrays.fill(caracteresAcertados, NO_ACERTADO);
	}
	
	public int[] comprobarLetras(char[] caracteresIntroducido) {
		int[] letrasAcertadas = new int[5];
		
		for(int posicionCaracter = 0; posicionCaracter < caracteres.length; posicionCaracter++) {
			char caracter = caracteresIntroducido[posicionCaracter];
						
			if(caracter == caracteres[posicionCaracter]) {
				letrasAcertadas[posicionCaracter] = ACERTADO;
			} else if(contieneCaracter(caracter)) {
				letrasAcertadas[posicionCaracter] = POSICION_INCORRECTA;
			} else {
				letrasAcertadas[posicionCaracter] = NO_ACERTADO;
			}
		}
		
		caracteresAcertados = letrasAcertadas;
		return letrasAcertadas;
	}
	
    public boolean contieneCaracter(char caracterBuscado) {
        for (char caracter : caracteres) {
            if (caracter == caracterBuscado) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean esPalabraCorrecta(char[] palabra) {
    	int[] resultadoComprobarLetras = comprobarLetras(palabra);
    	boolean esCorrecta = false;
    	
    	for(int comprobacionCaracter : resultadoComprobarLetras) {
    		if(comprobacionCaracter == ACERTADO) {
    			esCorrecta = true;
    		} else {
    			esCorrecta = false;
    			break;
    		}
    	}
    	
    	return esCorrecta;
    }
	
	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public char[] getCaracteres() {
		return caracteres;
	}

	public void setCaracteres(char[] caracteres) {
		this.caracteres = caracteres;
	}

	public int[] getCaracteresAcertados() {
		return caracteresAcertados;
	}

	public void setCaracteresAcertados(int[] caracteresAcertados) {
		this.caracteresAcertados = caracteresAcertados;
	}
}
