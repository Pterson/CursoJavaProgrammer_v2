package cap13.MegaSena;

import java.util.Random;

public class MegaSenaUtilitario {

    public static int sortearNumero(int max) {


        Random sorteador = new Random();

        int numero = sorteador.nextInt(max);
        numero = sorteador.nextInt(max) + 1;

        return numero;
		
     /*	if (numero == 0) {
		    numero++;
	    }
	 */
    }

    //	TODO
    public static int[] numerosSorteados() {

        int[] jogoMegaSena = new int[6];

        for (int i = 0; i < jogoMegaSena.length; i++) {

            boolean validador = true;
            int numeroSorteado = sortearNumero(6); //10

            for (int j = 0; j < jogoMegaSena.length; j++) {

                if (jogoMegaSena[i] == numeroSorteado) {

                    validador = false;
                    i--;
                    break;
                }
            }

            if (validador) {
                jogoMegaSena[i] = numeroSorteado;
            }

        }
        return jogoMegaSena;
    }

}

