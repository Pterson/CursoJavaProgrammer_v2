package cap14.Lab01;

import java.time.Year;

public class Salarios {

    public static void main(String[] args) {

        double[] arraySalario = new double[8];
        arraySalario[0] = 1_350.00;
        arraySalario[1] = 4_320.15;
        arraySalario[2] = 8_235.25;
        arraySalario[3] = 2_500.55;
        arraySalario[4] = 1_830;
        arraySalario[5] = 850.26;
        arraySalario[6] = 3_614.29;
        arraySalario[7] = 12_500.00;

        double[] arraySalarioLiquido = DoubleArrayUtils
                .transformaValores(arraySalario, salario -> salario - (salario * 10/100) );
/*
        double[] arraySalarioLiquido = DoubleArrayUtils
                .transformaValores(arraySalario, salario -> salario * 0.90);
*/
        for (int i = 0; i <arraySalarioLiquido.length ; i++) {

            System.out.println(arraySalarioLiquido[i]);

        }
    }

}
