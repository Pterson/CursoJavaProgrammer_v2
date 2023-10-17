package cap14.Lab02;

import cap14.Lab01.DoubleArrayUtils;

public class MaioresSalarios {

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

//        double[] arraySalarioTop = DoubleArrayUtils
//                .filtraValores(arraySalario, salario -> salario >= 10000);

        double[] arraySalarioTop = DoubleArrayUtils
                .filtraValores(arraySalario, salario -> {
                  if  (salario >= 10000){
                      return true;
                  } else {
                      return false;
                  }
                });

        for (int i = 0; i < arraySalarioTop.length; i++) {

            System.out.println(arraySalarioTop[i]);

        }

        DoubleArrayUtils.processaValores(arraySalarioTop, salario -> System.out.println(salario));

    }
}

