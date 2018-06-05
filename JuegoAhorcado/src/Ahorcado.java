import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ahorcado {
	int cont=0;
	ArrayList<String> palabras =new ArrayList<String>();
	String palabraElegida;
	char[] palabraJuegador;
	Random ran=new Random();
	
	//lee todo el fichero linea a linea mete array
	public void leerPalabras(String nFichero) throws IOException{
		
		BufferedReader encontrada=new BufferedReader 
				(new FileReader(nFichero));
		
		while (encontrada.ready()) {
			String liena=encontrada.readLine();
			palabras.add(liena);
		}		
	}
	
	//pone tantos guiones como caracteres tiene la
	//palabra elegida
	public void  iniciarJuego() {
		int pos=ran.nextInt(palabras.size());
		palabraElegida=palabras.get(pos);
		palabraJuegador= new char [palabraElegida.length()];
		
		for(int i=0; i<palabraJuegador.length; i++) {
			palabraJuegador[i]='-';
		}
	}
	
	// compara caracteres de la palabra elegicad
	// metida por el jugador
	public boolean comprobarCaracteres(char c) {
		boolean encontrada=false;
		for(int i=0; i<palabraElegida.length(); i++) {
			if(palabraElegida.charAt(i)==c){		
				palabraJuegador[i]=c;
				encontrada= true;
			}
		}	
		return encontrada;
	}
	
	public String mostrarPalabraJugador() {
		String cadena= "";
		for (int i=0; i<palabraJuegador.length; i++){
			cadena+=palabraJuegador[i];
		}
		return cadena;

	}
	
	public boolean ganarPartida() {
		int guiones=0;
		for(int i=0; i<palabraJuegador.length; i++) {
			if(palabraJuegador[i]=='-')
			guiones++;
		}
		if(guiones==0)
		{
			return true;
		} else {
			
		return false;
		}
	}
	
	public void dibujoAhorcado(){
		int fallos=0;
		
		
		
	}

}
