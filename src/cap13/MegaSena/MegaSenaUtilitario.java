package cap13.MegaSena;

import java.util.Random;

public class MegaSenaUtilitario {

	public static int sortearNumero(int max) {
		
		
		Random sorteador = new Random ();
		
		int numero = sorteador.nextInt(max);
			
		numero = sorteador.nextInt(max) + 1; 		
		
		return numero;		
		
		
//		if (numero == 0) {
//		numero++;
//	}
		
	}

}
