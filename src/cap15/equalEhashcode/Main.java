package cap15.equalEhashcode;

import cap07.Aluno;
import cap09.laboratorio.Pessoa;
import cap15.Lab02.cap15.Estudante;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        boolean validar = 10 == 10;

        boolean validarString = "texto" == "Texto";

        Aluno aluno1 = new Aluno("John", 30, 123);
        Aluno aluno2 = new Aluno("Jota", 30, 123);

        boolean objeto = aluno1 == aluno2;

        boolean equals = aluno1.equals(aluno2);

        boolean validarStringEquals = "texto".equals("texto");

        new HashMap<String, String>().put(null, null);
        System.out.println();
    }
}
