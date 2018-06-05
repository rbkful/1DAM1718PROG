import java.io.IOException;
import java.util.Scanner;

import javax.xml.stream.util.EventReaderDelegate;

public class principal {
	Ahorcado ahorcado=new Ahorcado();
	
	public void run() throws IOException {
		int conFallos=0;
		ahorcado.leerPalabras("palabras.txt");
		ahorcado.iniciarJuego();
		System.out.println(ahorcado.palabraElegida);
		boolean finPartida = false;
		
		Scanner teclado=new Scanner(System.in);
		
		//MOTRAR TODOS LOS GUIONES
		//PIDE LETRA Y LA COLOCA
		//bulque while mientras que aceierta
		//o pierda
		while(finPartida==false) {
			System.out.println(ahorcado.mostrarPalabraJugador());
			System.out.println("Dime letra");
			char letra= teclado.next().charAt(0);
			
			if (ahorcado.comprobarCaracteres(letra)) {
				System.out.println("Bien");
			}else {
				conFallos++;
				System.out.println("Error");
			}
			if(conFallos>=ahorcado.palabraElegida.length())
			{
				ahorcado.ganarPartida();
				finPartida=true;
			}
			finPartida=ahorcado.ganarPartida();
			if(finPartida==true) {
				
				System.out.println("Has Ganado");
			}else if(conFallos>ahorcado.palabraJuegador.length){
				System.out.println("Has Perdido");
				finPartida=true;
			}
			System.out.println(conFallos);
		}		
	}
	
	
	public static void main(String[] args) throws IOException {
		principal p=new principal();
		p.run();
		
	}

}
