package cap13.MegaSena;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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

    public static Set<Integer> numerosSorteados(int NumeroSorteado, int quantidade ) {

        Set<Integer> jogoMegaSena = new HashSet<>(quantidade);

        while (jogoMegaSena.size() < quantidade) {
            int numeroSorteado = sortearNumero(NumeroSorteado);


        }
        return jogoMegaSena;
    }

}

